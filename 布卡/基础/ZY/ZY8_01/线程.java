package 布卡.基础.ZY.ZY8_01;

public class 线程 {
    public static void main(String[] args) {
        Thread t1=new Thread(new Student("小明"));
        Thread t2=new Thread(new Student("小王"));
        t1.start();
        t2.start();
    }

}
