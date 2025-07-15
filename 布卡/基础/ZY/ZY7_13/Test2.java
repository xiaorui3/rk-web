package 布卡.基础.ZY.ZY7_13;

public class Test2 {
    public static void main(String[] args) {
        computer c1 = new computer("windows", "i5", "8G", "1T", "GTX1060", "45W", 5000);
        computer c2 = new computer("windows", "i7", "16G", "2T", "GTX1080", "65W", 8000);
        computer c3 = new computer("windows", "i9", "32G", "4T", "GTX1080TI", "80W", 10000);
        c1.show();
        c2.show();
        c3.show();

        int[] a={1,2,3};
        DemoTest01 dt=new DemoTest01();
        dt.arrayTest(a);
        System.out.println(a[0]);
    }

}
