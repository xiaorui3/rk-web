package 布卡.基础.ZY.ZY7_13;

import java.util.ArrayList;

public class TestArr {
    public static void main(String[] args) throws Exception {
        ArrayBox<Integer> ab=new ArrayBox<Integer>();
        ab.add(1213);
        ab.add(1213);
        ab.add(5);
        ab.add(1213);
        ab.add(1213);
        ab.add(1213);
        ab.add(1213);
        ab.add(1213);
        ab.add(1213);
        ab.add(1213);
        ab.add(1213);
        System.out.println(ab.get(3));
        ab.show();
        ab.show_max();
        System.out.println();
        System.out.println(ab.length);
        System.out.println(ab.sum);
        ab.re(11);
        ab.show();
        ab.show_max();
        System.out.println();
        System.out.println(ab.length);
        System.out.println(ab.sum);
    }
}
