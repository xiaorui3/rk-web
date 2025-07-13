package 爬虫;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlExtractor {
    // 存储所有去重后的URL
    private static final Set<String> allUrls = new LinkedHashSet<>();
    // 已处理的URL，避免重复请求
    private static final Set<String> processedUrls = new HashSet<>();
    // 过滤带(数字)的URL模式
    private static final Pattern BRACKET_PATTERN = Pattern.compile("\\(\\d+\\)");
    // 递归深度限制，防止无限递归
    private static final int MAX_DEPTH = 10;

    public static void main(String[] args) {
        String startUrl = "http://www.hhhxy.cn/"; // 起始URL
        try {
            // 开始递归提取
            extractRecursively(startUrl, 0);

            // 输出到终端
            System.out.println("最终去重后的URL列表（共" + allUrls.size() + "个）：");
            for (String url : allUrls) {
                System.out.println(url);
            }

            // 输出到文件
            writeToFile(allUrls);
            System.out.println("\nURL已成功写入到url.txt文件");

        } catch (Exception e) {
            System.err.println("处理过程出错：" + e.getMessage());
        }
    }

    // 递归提取URL的方法
    private static void extractRecursively(String url, int depth) {
        // 终止条件：达到最大深度或已处理过该URL
        if (depth >= MAX_DEPTH || !processedUrls.add(url)) {
            return;
        }

        System.out.println("正在处理第" + (depth + 1) + "层URL：" + url);

        try {
            // 提取当前页面的所有URL
            Set<String> currentUrls = extractUrlsFromPage(url);

            // 处理提取到的URL
            for (String newUrl : currentUrls) {
                // 过滤带(数字)的URL
                if (BRACKET_PATTERN.matcher(newUrl).find()) {
                    continue;
                }

                // 验证URL有效性
                if (isValidUrl(newUrl) && allUrls.add(newUrl)) {
                    // 递归处理下一层
                    extractRecursively(newUrl, depth + 1);
                }
            }

        } catch (Exception e) {
            System.err.println("处理URL时出错：" + url + "，错误信息：" + e.getMessage());
        }
    }

    // 从指定页面提取URL
    public static Set<String> extractUrlsFromPage(String pageUrl) throws IOException {
        Set<String> urls = new HashSet<>();
        URL url = new URL(pageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            urls = extractUrls(content.toString(), pageUrl);
        }
        return urls;
    }

    // 从HTML内容中提取URL
    private static Set<String> extractUrls(String htmlContent, String baseUrl) {
        Set<String> urls = new HashSet<>();
        Pattern pattern = Pattern.compile("href\\s*=\\s*['\"]([^'\"]+)['\"]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);

        while (matcher.find()) {
            String href = matcher.group(1).trim();
            // 处理相对URL
            try {
                URL base = new URL(baseUrl);
                URL absoluteUrl = new URL(base, href);
                urls.add(absoluteUrl.toString());
            } catch (MalformedURLException e) {
                continue;
            }
        }
        return urls;
    }

    // URL有效性验证
    private static boolean isValidUrl(String url) {
        try {
            URL u = new URL(url);
            return "http".equals(u.getProtocol()) || "https".equals(u.getProtocol());
        } catch (MalformedURLException e) {
            return false;
        }
    }

    // 将URL写入文件
    private static void writeToFile(Set<String> urls) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("./url.txt"), StandardCharsets.UTF_8))) {

            for (String url : urls) {
                writer.write(url);
                writer.newLine();
            }
        }
    }
}
