package java代码.字符串;

public class String分割 {
    public static void main(String[] args) {
        String Colors = "Red,Black,White,Yellow,Blue";
        String[] arr1 = Colors.split(","); // 不限制元素个数
        String[] arr2 = Colors.split(",", 3); // 限制元素个数为3
        System.out.println("所有颜色为：");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.println("前三个颜色为：");
        for (int j = 0; j < arr2.length; j++) {
            System.out.println(arr2[j]);
        }
/**
 * String 类的 split() 方法可以按指定的分割符对目标字符串进行分割，分割后的内容存放在字符串数组中。
 *         该方法主要有如下两种重载形式：
 *         str.split(String sign)
 *         str.split(String sign,int limit)
 *         其中它们的含义如下：
 *         str 为需要分割的目标字符串。
 *         sign 为指定的分割符，可以是任意字符串。
 *         limit 表示分割后生成的字符串的限制个数，如果不指定，则表示不限制，直到将整个目标字符串完全分割为止。
 *
 *         使用分隔符注意如下：
 *
 *         1）“.”和“|”都是转义字符，必须得加“\\”。
 *         如果用“.”作为分隔的话，必须写成String.split("\\.")，这样才能正确的分隔开，不能用String.split(".")。
 *         如果用“|”作为分隔的话，必须写成String.split("\\|")，这样才能正确的分隔开，不能用String.split("|")。
 *
 *         2）如果在一个字符串中有多个分隔符，可以用“|”作为连字符，比如：“acount=? and uu =? or n=?”，
 *         把三个都分隔出来，可以用String.split("and|or")。
 */
    }
}
