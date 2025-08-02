package 布卡.基础.ZY.ZY8_02.test;

//生产者-----添加元素
public class Producer extends Thread{

    //为了保证两组线程用到的是同一个仓库对象
    //属性，构造方法传参数
    private Warehouse house;
    public Producer(Warehouse house){
        this.house = house;
    }

    //生产者真正运行起来做事的方法run
    public void run(){
        while(true){
            house.add();
            System.out.println("生产者存入了一件货物");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
