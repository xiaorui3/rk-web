package 布卡.基础;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int a=1;
        int b=2;
        int sum=a++ + ++b - a-- - --b +a-- - --b;

        System.out.println(sum);
    }
}


