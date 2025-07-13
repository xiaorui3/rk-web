package java代码.字符串;

public class String替换 {
    public static void main(String[] args) {
        String words = "hello java,hello php";
        System.out.println("原始字符串是'"+words+"'");
        System.out.println("replace(\"l\",\"D\")结果："+words.replace("l","D"));
        System.out.println("replace(\"hello\",\"你好\")结果："+words.replace("hello","你好 "));
        words = "hr's dog";
        System.out.println("原始字符串是'"+words+"'");
        System.out.println("replace(\"r's\",\"is\")结果："+words.replace("r's","is"));
    }
/**
 * replace() 方法
 *     replace() 方法用于将目标字符串中的指定字符（串）替换成新的字符（串），其语法格式如下：
 *             字符串.replace(String oldChar, String newChar)
 *     其中，oldChar 表示被替换的字符串；newChar 表示用于替换的字符串。replace()
 *     方法会将字符串中所有 oldChar 替换成 newChar。
 *
 *     replaceFirst() 方法
 * replaceFirst() 方法用于将目标字符串中匹配某正则表达式的第一个子字符串替换成新的字符串，其语法形式如下：
 * 字符串.replaceFirst(String regex, String replacement)
 * 其中，regex 表示正则表达式；replacement 表示用于替换的字符串。例如：
 * String words = "hello java，hello php";
 * String newStr = words.replaceFirst("hello","你好 ");
 * System.out.println(newStr);    // 输出：你好 java,hello php
 *
 * 字符串.replaceAll(String regex, String replacement)
 * 其中，regex 表示正则表达式，replacement 表示用于替换的字符串。例如：
 * String words = "hello java，hello php";
 * String newStr = words.replaceAll("hello","你好 ");
 * System.out.println(newStr);    // 输出：你好 java,你好 php
 */
}
