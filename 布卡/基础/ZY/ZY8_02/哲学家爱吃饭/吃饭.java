package 布卡.基础.ZY.ZY8_02.哲学家爱吃饭;

public class 吃饭 {
    public static void main(String[] args) throws InterruptedException {
        筷子 k1 =new 筷子("A");
        筷子 k2 =new 筷子("B");
        筷子 k3 =new 筷子("C");
        筷子 k4 =new 筷子("D");

        哲学家 z1=new 哲学家("A",k1,k2);
        哲学家 z2=new 哲学家("B",k2,k3);
        哲学家 z3=new 哲学家("C",k3,k4);
        哲学家 z4=new 哲学家("D",k4,k1);

        new Thread(z1).start();
        Thread.sleep(200);
        new Thread(z2).start();

        new Thread(z3).start();
        Thread.sleep(200);
        new Thread(z4).start();
    }
}
