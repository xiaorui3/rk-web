package 布卡.基础.ZY.ZY7_20;

public class StringDemo01 {
    public static void main(String[] args) {
        String s1="abc";
        String s2=new String("abc");
        String s3="abc";
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s2));

        String s4 = "abcde we sdwa df";
        String s5=s4;
        s4=s4.replace("a","11");
        System.out.println(s4);
        s5=s5.replaceAll("a","11");
        System.out.println(s5);
    }
}
