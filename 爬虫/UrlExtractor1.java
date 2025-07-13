package 爬虫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlExtractor1 {

    public static void main(String[] args) {
        String targetUrl = "http://www.hhhxy.cn/"; // 目标URL
        try {
            Set<String> urls = extractUrlsFromPage(targetUrl);
            System.out.println("当前页面URL: " + targetUrl);
            System.out.println("页面内发现的原始URL数量: " + urls.size());

            // 过滤处理URL
            Set<String> filteredUrls = filterUrls(urls);

            System.out.println("过滤后有效且唯一的URL数量: " + filteredUrls.size());
            System.out.println("\n最终URL列表:");
            int count = 1;
            for (String url : filteredUrls) {
                System.out.println(count + ". " + url);
                count++;
            }

        } catch (IOException e) {
            System.err.println("处理URL时发生错误: " + e.getMessage());
        }
    }

    public static Set<String> extractUrlsFromPage(String pageUrl) throws IOException {
        URL url = new URL(pageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return extractUrls(content.toString(), pageUrl);
        }
    }

    private static Set<String> extractUrls(String htmlContent, String baseUrl) {
        Set<String> urls = new HashSet<>();
        Pattern pattern = Pattern.compile("href\\s*=\\s*['\"]([^'\"]+)['\"]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);

        while (matcher.find()) {
            String href = matcher.group(1);
            // 处理相对URL
            if (href.startsWith("/")) {
                href = baseUrl + href;
            } else if (!href.startsWith("http") && !href.startsWith("https")) {
                int lastSlash = baseUrl.lastIndexOf('/');
                if (lastSlash != -1) {
                    href = baseUrl.substring(0, lastSlash + 1) + href;
                } else {
                    href = baseUrl + "/" + href;
                }
            }
            urls.add(href);
        }
        return urls;
    }

    private static Set<String> filterUrls(Set<String> urls) {
        Set<String> validUrls = new LinkedHashSet<>();
        // 匹配任意位置的(数字)模式，如xxx(1).htm、xxx.htm?a=(2)等
        Pattern bracketPattern = Pattern.compile("\\(\\d+\\)");
        // 用于完全去重的标准化URL存储
        Set<String> normalizedSet = new HashSet<>();

        for (String url : urls) {
            // 过滤带括号数字的URL
            if (bracketPattern.matcher(url).find()) {
                System.out.println("过滤404风险URL: " + url);
                continue;
            }

            // 过滤无效格式
            if (url.startsWith("javascript:") || url.trim().isEmpty()) {
                System.out.println("过滤无效格式URL: " + url);
                continue;
            }

            // 验证URL格式
            if (!isValidUrlFormat(url)) {
                System.out.println("过滤格式错误URL: " + url);
                continue;
            }

            // 标准化URL用于去重（去除锚点和参数）
            String normalizedUrl = normalizeUrl(url);
            if (normalizedSet.add(normalizedUrl)) {
                validUrls.add(url);
            } else {
                System.out.println("过滤重复URL: " + url);
            }
        }

        return validUrls;
    }

    // 标准化URL：去除锚点和参数，用于精确去重
    private static String normalizeUrl(String url) {
        try {
            URL parsedUrl = new URL(url);
            String protocol = parsedUrl.getProtocol();
            String host = parsedUrl.getHost();
            String path = parsedUrl.getPath();
            return protocol + "://" + host + path;
        } catch (MalformedURLException e) {
            return url;
        }
    }

    private static boolean isValidUrlFormat(String url) {
        try {
            new URL(url);
            return url.startsWith("http://") || url.startsWith("https://");
        } catch (MalformedURLException e) {
            return false;
        }
    }
}