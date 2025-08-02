package 布卡.基础.ZY.ZY8_02.生产者消费者模型;

public class MyMain {
    public static void main(String[] args) {
        System.out.println(new CangKu().list.toString());


        CangKu cangKu = new CangKu();
        ShengChan shengChan = new ShengChan(cangKu);
        XiaoFei xiaoFei = new XiaoFei(cangKu);

        new Thread(shengChan).start();
        new Thread(xiaoFei).start();
    }
}
