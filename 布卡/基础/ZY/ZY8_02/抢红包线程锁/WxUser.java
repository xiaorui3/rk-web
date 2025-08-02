package 布卡.基础.ZY.ZY8_02.抢红包线程锁;


public class WxUser implements Runnable{
    private String name;
    private int id;
    // 锁对象，使用类对象作为全局锁
    private static final Object lock = new Object();

    public WxUser(String name,int id) {
        this.name = name;
        this.id = id;
    }
    public WxUser() {}

    @Override
    public String toString() {
        return "WxUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (!WxQun.doubles.isEmpty()) {
                int index = (int) (Math.random() * WxQun.doubles.size());
                Double money = WxQun.doubles.remove(index);
                System.out.println(name + " 抢到了 " + money + " 元");
            } else {
                System.out.println(name + " 来晚了，没抢到红包~");
            }
        }
    }
}