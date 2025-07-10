package 布卡.基础.ZY.ZY7_10;

public class zy01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int sum = a++ + ++b - --a + --b + a-- - --b;
        System.out.println( sum);
    }
}
