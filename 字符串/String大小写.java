package java代码.字符串;

public class String大小写 {
    public static void main(String[] args) {
        String en = "The Day You Went Away";    // 定义原始字符串
        System.out.println("原始字符串："+en);
        System.out.println("使用 toLowerCase() 方法之后为："+en.toLowerCase());
        System.out.println("使用 toUpperCase() 方法之后为："+en.toUpperCase());

        en = "sun sun 是太阳，圆圆挂在 SKY 上";    // 定义原始字符串
        System.out.println("原始字符串："+en);
        System.out.println("使用 toLowerCase() 方法之后为："+en.toLowerCase());
        System.out.println("使用 toUpperCase() 方法之后为："+en.toUpperCase());

        en = "select id,name,sex,address,birthday from students";
        System.out.println("原始字符串："+en);    // 定义原始字符串
        System.out.println("使用 toLowerCase() 方法之后为："+en.toLowerCase());
        System.out.println("使用 toUpperCase() 方法之后为："+en.toUpperCase());
/**
 * 字符串名.toLowerCase()    // 将字符串中的字母全部转换为小写，非字母不受影响
 *         toUpperCase() 则将字符串中的所有字符全部转换成大写，而非字母的字符不受影响。语法格式如下：
 *         字符串名.toUpperCase()    // 将字符串中的字母全部转换为大写，非字母不受影响
 *         例如：
 *         String str="abcdef 我 ghijklmn";
 *         System.out.println(str.toLowerCase());    // 输出：abcdef 我 ghijklmn
 *         System.out.println(str.toUpperCase());    // 输出：ABCDEF 我 GHIJKLMN
 */
    }
}
