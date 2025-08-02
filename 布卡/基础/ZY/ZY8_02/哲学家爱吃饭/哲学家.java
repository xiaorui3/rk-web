package 布卡.基础.ZY.ZY8_02.哲学家爱吃饭;

public class 哲学家 implements Runnable{
    private String name;


    private 筷子 k1;
    private 筷子 k2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public 哲学家(String name,筷子 k1,筷子 k2) {
        this.name = name;
        //k1.setName("A");
        //k2.setName("B");
        this.k1 = k1;
        this.k2 = k2;
    }

    @Override
    public void run() {
        synchronized (k1){
            System.out.println(this.name+"拿到了自己左边的筷子："+k1.getName());
            synchronized (k2){
                System.out.println(this.name+"拿到了自己右边的筷子："+k2.getName());
                System.out.println(this.name+"也是吃上饭了");
                System.out.println();
            }
        }
    }
}
