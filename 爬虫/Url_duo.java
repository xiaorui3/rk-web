package 爬虫;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url_duo {
    // 线程安全的集合存储所有去重后的URL
    private static final Set<String> allUrls = Collections.synchronizedSet(new LinkedHashSet<>());
    // 线程安全的集合记录已处理的URL，避免重复请求
    private static final Set<String> processedUrls = Collections.synchronizedSet(new HashSet<>());
    // 过滤带(数字)的URL模式
    private static final Pattern BRACKET_PATTERN = Pattern.compile("\\(\\d+\\)");
    // 递归深度限制
    private static final int MAX_DEPTH = 3;  // 暂时降低深度，避免请求过多
    // 线程池（修正参数设置）
    private static final ExecutorService executor;

    // 静态初始化线程池，确保参数合法
    static {
        int corePoolSize = Math.max(2, Runtime.getRuntime().availableProcessors()); // 至少2个核心线程
        int maxPoolSize = Math.max(4, corePoolSize); // 最大线程数至少4个
        System.out.println(corePoolSize);
        System.out.println(maxPoolSize);
        executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), // 限制队列大小
                new ThreadFactory() {
                    private int count = 0;
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("url-crawler-" + (++count));
                        thread.setDaemon(false);
                        return thread;
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy() // 当队列满时，让提交者自己执行
        );
    }

    // 用于等待所有任务完成的计数器
    private static final CountDownLatch mainLatch = new CountDownLatch(1);
    // 跟踪活跃任务数
    private static final AtomicInteger activeTasks = new AtomicInteger(0);

    public static void main(String[] args) {
        String startUrl = "http://www.hhhxy.cn/";
        long startTime = System.currentTimeMillis();

        try {
            // 提交初始任务
            activeTasks.incrementAndGet();
            executor.submit(() -> processUrl(startUrl, 0));

            // 等待所有任务完成
            mainLatch.await();
            // 关闭线程池
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES); // 等待线程池终止

            // 输出结果
            System.out.println("\n最终去重后的URL列表（共" + allUrls.size() + "个）：");
            allUrls.forEach(System.out::println);

            // 写入文件
            writeToFile(allUrls);
            System.out.println("\nURL已写入到url.txt文件");
            System.out.println("总耗时: " + (System.currentTimeMillis() - startTime) + "ms");

        } catch (Exception e) {
            System.err.println("处理过程出错：" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }

    private static void processUrl(String url, int depth) {
        try {
            // 检查终止条件
            if (depth >= MAX_DEPTH || !processedUrls.add(url)) {
                return;
            }

            System.out.println("线程[" + Thread.currentThread().getName() +
                    "] 处理第" + depth + "层: " + url);

            // 提取当前页面的URL
            Set<String> currentUrls = extractUrlsFromPage(url);

            // 处理提取到的URL
            for (String newUrl : currentUrls) {
                // 过滤带数字括号的URL
                if (BRACKET_PATTERN.matcher(newUrl).find()) {
                    continue;
                }

                // 验证URL并添加到结果集
                if (isValidUrl(newUrl) && allUrls.add(newUrl)) {
                    activeTasks.incrementAndGet();
                    executor.submit(() -> {
                        try {
                            processUrl(newUrl, depth + 1);
                        } finally {
                            if (activeTasks.decrementAndGet() == 0) {
                                mainLatch.countDown(); // 最后一个任务完成时释放主线程
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            System.err.println("处理URL[" + url + "]出错: " + e.getMessage());
        } finally {
            if (activeTasks.decrementAndGet() == 0) {
                mainLatch.countDown(); // 最后一个任务完成时释放主线程
            }
        }
    }

    // 从页面提取URL的方法（保持不变）
    public static Set<String> extractUrlsFromPage(String pageUrl) throws IOException {
        Set<String> urls = new HashSet<>();
        try {
            URL url = new URL(pageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求头
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setInstanceFollowRedirects(true);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("URL[" + pageUrl + "] 响应码: " + responseCode);
                return urls;
            }

            // 读取页面内容
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                urls = extractUrls(content.toString(), pageUrl);
            }
        } catch (Exception e) {
            System.err.println("提取URL时出错[" + pageUrl + "]: " + e.getMessage());
        }
        return urls;
    }

    // 从HTML内容中提取URL（保持不变）
    private static Set<String> extractUrls(String htmlContent, String baseUrl) {
        Set<String> urls = new HashSet<>();
        Pattern pattern = Pattern.compile("href\\s*=\\s*['\"]([^'\"]+)['\"]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);

        while (matcher.find()) {
            String href = matcher.group(1).trim();
            try {
                URL base = new URL(baseUrl);
                URL absoluteUrl = new URL(base, href);
                urls.add(absoluteUrl.toString());
            } catch (MalformedURLException e) {
                // 忽略无效URL
            }
        }
        return urls;
    }

    // 验证URL有效性（保持不变）
    private static boolean isValidUrl(String url) {
        try {
            URL u = new URL(url);
            String protocol = u.getProtocol();
            return "http".equals(protocol) || "https".equals(protocol);
        } catch (MalformedURLException e) {
            return false;
        }
    }

    // 写入文件（保持不变）
    private static void writeToFile(Set<String> urls) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("./url.txt"), StandardCharsets.UTF_8))) {
            for (String u : urls) {
                writer.write(u);
                writer.newLine();
            }
        }
    }
}