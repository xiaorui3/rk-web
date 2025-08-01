package 布卡.基础.ZY.ZY8_01.抢红包;

public class WxUser implements Runnable{
    private String name;
    private int id;
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
        Double v = WxQun.doubles.get(this.id);
        System.out.println(("王"+(this.id+1))+"  抢到了"+ "  "+v+" 元");

    }
}
