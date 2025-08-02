package 布卡.基础.ZY.ZY8_02.生产者消费者模型;

import 布卡.基础.ZY.ZY8_02.test.Warehouse;

public class ShengChan implements Runnable{
    private CangKu ck;
    public ShengChan(CangKu ck){
        this.ck = ck;
    }

    @Override
    public void run() {
        while(true){
            ck.add();
            System.out.println("生产者加入了！");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
