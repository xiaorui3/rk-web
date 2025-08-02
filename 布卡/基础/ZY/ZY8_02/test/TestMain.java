package 布卡.基础.ZY.ZY8_02.test;

public class TestMain {

    public static void main(String[] args) {
        Warehouse house = new Warehouse();

        Producer p1 = new Producer(house);
        p1.setPriority(Thread.MAX_PRIORITY);

        Consumer c1 = new Consumer(house);
        Consumer c2 = new Consumer(house);

        p1.start();
        c1.start();
        c2.start();

        //两个消费者同时访问仓库，只有一个元素啦
    }
}
