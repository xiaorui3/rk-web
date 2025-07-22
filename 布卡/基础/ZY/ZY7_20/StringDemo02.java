package 布卡.基础.ZY.ZY7_20;

import java.util.Arrays;

public class StringDemo02 {
    public static void main(String[] args) {
        String str1="Hello World! Hello World! String str Hello";
        System.out.println(str1.charAt(1));
        System.out.println(str1.codePointAt(1));
        String[] s = str1.split(" ");
        System.out.println(Arrays.toString(s));
        System.out.println(str1.substring(0, 5));
        char[] charArray = str1.toCharArray();
        System.out.println(Arrays.toString(charArray));
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(str1.startsWith("hello")?"是以hello开头":"不是以hello开头");
        System.out.println(str1.startsWith("Hello")?"是以Hello开头":"不是以Hello开头");
        System.out.println(str1.endsWith("hello")?"是以hello结尾":"不是以hello结尾");
        System.out.println(str1.endsWith("Hello")?"是以Hello结尾":"不是以Hello结尾");
        System.out.println(str1.toUpperCase());
        System.out.println(str1.toLowerCase());
        String str2="       "+ str1+"       ";
        System.out.println(str2);
        System.out.println(str2.trim());
        System.out.println(str1.replace("hello", "world").replace("Hello", "World"));


        System.out.println("==================work=====================");
        System.out.println("1.");
        System.out.println("使用第一种方法，StringBuffer "+re("ok", 1, 2));
        System.out.println("使用第二种方法，concat "+re("ok",1));
        System.out.println("2.");
        System.out.println("输入ok---->使用re(str,1,2)方法 "+reBuff("ok"));
        System.out.println("3.");
        System.out.println("输入abccba 判断是否是回文数字 "+(reHui("abccba")?"是":"不是"));
        System.out.println("输入abcba 判断是否是回文数字 "+(reHui("abcba")?"是":"不是"));
        System.out.println("4.");
        System.out.println("给定特定的字符右移x位置 "+vmString("helloworld",2));
        System.out.println("5.");
        System.out.println("寻找诺干字符串最长的那一个 "+maxString("ab,abc,abcd"));
        System.out.println("6.");
        System.out.println("统计字母在字符串中出现的次数 "+indexString("Hello World! Hello World! String str Hello",'H'));
        System.out.println("7.");
        System.out.println("首字母大写this is a test of java "+fastIndexString("this is a test of java"));
        System.out.println("8.");
        System.out.println("提取全部数字 "+useSumString("z00a1od23456789wdfhjsahdjfkjads2132sjkhd3w4uy13ujdj32u4u"));

    }
    public static String re(String str,int use1){
        //int tmp=0;
        String string1=new String("");
        for (int i = 0; i < str.length(); i++) {
            string1 = string1.concat(String.valueOf(str.charAt(str.length() - 1 - i)));
            //tmp=str.charAt(i);
            //str.charAt(i) = str.charAt(str.length()-1-i);
        }
        return string1;
    }
    public static String re(String str,int use1,int use2){
        StringBuffer sb=new StringBuffer(str);
        StringBuffer reverse = sb.reverse();
        //System.out.println(reverse);
        return reverse.toString();
    }
    public static String reBuff(String str){
        return str+re(str,1,2);
    }
    public static Boolean reHui(String str){
        boolean b=true;
        for (int i = 0; i < str.length()/2; i++) {
            //System.out.println(str.charAt(i));
            //System.out.println(str.charAt((str.length())-i-1));
            if (!(str.charAt(i)==str.charAt((str.length())-i-1))){
                b=false;
                break;
            }
        }
        return b;
    }
    public static String vmString(String str,int x){
        if (x>str.length()-1){
            return null;
        }
        //System.out.println(str.substring(str.length()-x));
        String[] split = str.split(str.substring(str.length()-x));
        return str.substring(str.length()-x)+split[0];
    }
    public static String maxString(String str){
        String[] split = str.split(",");
        int len=0;
        int index=0;
        for (int i = 0; i < split.length; i++) {
            if (len<split[i].length()){
                len=split[i].length();
                index=i;
            }
        }
        return split[index];
    }
    public static int indexString(String str,char index){
        char[] charArray = str.toCharArray();
        int p=0;
        System.out.println(str+"   "+ index);

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]==index){
                p++;
            }
        }
        return p;
    }
    public static String fastIndexString(String str){
        String[] split = str.split(" ");
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            char[] charArray = split[i].toCharArray();
            charArray[0]=Character.toUpperCase(charArray[0]);
            if (i+1<split.length){
                sb.append(charArray).append(" ");
            }else{
                sb.append(charArray);
            }
        }
        return sb.toString();
    }
    public static String useSumString(String str){
        char[] charArray = str.toCharArray();
        StringBuffer sb =new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (charArray[i]>=48&&charArray[i]<=57){
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
}
