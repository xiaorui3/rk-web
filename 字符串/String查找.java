package java代码.字符串;

public class String查找 {
    public static void main(String[] args) {
        String words = "today,monday,sunday";
        System.out.println("原始字符串是'"+words+"'");
        System.out.println("indexOf(\"day\")结果："+words.indexOf("day"));
        System.out.println("indexOf(\"day\",5)结果："+words.indexOf("day",5));
        System.out.println("indexOf(\"o\")结果："+words.indexOf("o"));
        System.out.println("indexOf(\"o\",6)结果："+words.indexOf("o",6));
        String words2="today,monday,Sunday";
        System.out.println("原始字符串是'"+words2+"'");
        System.out.println("lastIndexOf(\"day\")结果："+words2.lastIndexOf("day"));
        System.out.println("lastIndexOf(\"day\",5)结果："+words2.lastIndexOf("day",5));
        System.out.println("lastIndexOf(\"o\")结果："+words2.lastIndexOf("o"));
        System.out.println("lastlndexOf(\"o\",6)结果："+words2.lastIndexOf("o",6));
    }
/**
 * String 类的 indexOf() 方法和 lastlndexOf() 方法用于在字符串中获取匹配字符（串）的索引值。
 *             1. indexOf() 方法
 *     indexOf() 方法用于返回字符（串）在指定字符串中首次出现的索引位置，如果能找到，则返回索引值，
 *     否则返回 -1。该方法主要有两种重载形式：
 *             str.indexOf(value)
 *             str.indexOf(value,int fromIndex)
 *
 *     其中，str 表示指定字符串；value 表示待查找的字符（串）；fromIndex 表示查找时的起始索引，
 *     如果不指定 fromIndex，则默认从指定字符串中的开始位置（即 fromIndex 默认为 0）开始查找。
 *
 *     例如，下列代码在字符串“Hello Java”中查找字母 v 的索引位置。
 *     String s = "Hello Java";
 *     int size = s.indexOf('v');    // size的结果为8
 *
 *     lastIndexOf() 方法用于返回字符（串）在指定字符串中最后一次出现的索引位置，如果能找到则返回索引值，否则返回 -1。该方法也有两种重载形式：
 * str.lastIndexOf(value)
 * str.lastlndexOf(value, int fromIndex)
 *
 * 注意：lastIndexOf() 方法的查找策略是从右往左查找，如果不指定起始索引，则默认从字符串的末尾开始查找。
 */
}
