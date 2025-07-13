package java代码.爬虫;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式复习 {
    public static void main(String[] args) {
        //Pattern: 表示正则表达式
        //Matcher: 文本匹配器，作用按照正则表达式的规则去读取字符串,从头开始读取
        //         在大串中去寻找符合匹配规则的子串

        String str="Java lsdawdawdaw Java wkdawkJava2fnal JAva2";
        //获取正则表达式的对象
        Pattern p = Pattern.compile("Java\\d{0,2}");
        /**
         * 获取文本匹配器的对象
         * m:文本匹配器对象
         * str：大串
         * p：规则
         * m要在str中去找符合p规则的小串
         */
        Matcher m = p.matcher(str);


        /**
         * 拿着文本匹配器从头开始读取，寻找是否有满足规则的子串
         * 如果没有 返回false
         * 如果有 返回true，在底层纪录子串的起始索引和结束索引+1
         */
        //    boolean b = m.find();
        //根据底层方法find记录的索引进行字符串的截取
        //subString (起始索引，结束索引)；包头不包尾
        //（0,4）不包含4索引
        //   String s1 = m.group();

        while(m.find()){
            String s1 = m.group();
            System.out.println(s1);
        }

    }
}
