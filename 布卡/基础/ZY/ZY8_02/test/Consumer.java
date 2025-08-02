package 布卡.基础.ZY.ZY8_02.test;

//消费者-----从仓库里拿数据
public class Consumer extends Thread{

    private Warehouse house;

    public Consumer(Warehouse house){
        this.house = house;
    }

    public void run(){
        while(true){
            house.get();
            System.out.println("消费者拿走了一件货物");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
