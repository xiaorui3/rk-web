package 布卡.基础.ZY.ZY8_02.生产者消费者模型;

public class XiaoFei implements Runnable {
    @Override
    public void run() {
        ck.get();
        System.out.println("消费者拿到了！");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private CangKu ck;
    public XiaoFei(CangKu ck) {
        this.ck = ck;
    }

}
