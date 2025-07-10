package java代码.字符串;

public class String字符串截取 {
    public static void main(String[] args) {
        String day = "Today is Monday";    //原始字符串
        System.out.println("substring(0)结果："+day.substring(0));
        System.out.println("substring(2)结果："+day.substring(2));
        System.out.println("substring(10)结果："+day.substring(10));
        System.out.println("substring(2,10)结果："+day.substring(2,10));
        System.out.println("substring(0,5)结果："+day.substring(0,5));
    }
/**
 * substring(int beginIndex) 形式
 *     此方式用于提取从索引位置开始至结尾处的字符串部分。调用时，括号中是需要提取字符串的开始位置，方法的返回值是提取的字符串。例如：
 *     纯文本复制
 *     String str = "我爱 Java 编程";
 *     String result = str.substring(3);
 * System.out.println(result);    // 输出：Java 编程
 */
}
