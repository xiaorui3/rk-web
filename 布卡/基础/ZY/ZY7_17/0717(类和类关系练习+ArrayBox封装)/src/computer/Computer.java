package computer;

public class Computer {

    //属性
    private int number;//电脑编号
    private boolean used = false;//电脑是否是开着的状态   true开着  false关着

    //私有属性
    //          无参数构造方法+set方法       有参数的构造方法
    //          get                         get

    public Computer(){}
    public Computer(int number){
        this.number = number;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public int getNumber(){
        return this.number;
    }
    public void setUsed(boolean used){
        this.used = used;
    }
    public boolean isUsed(){
        return this.used;
    }

    //方法
    public void beOpen(){
        System.out.println(this.number+"号电脑被打开啦");
        this.used = true;
    }
    public void beUsing(){
        System.out.println(this.number+"号电脑正在被使用中。。。。");
    }
    public void beClose(){
        System.out.println(this.number+"号电脑被关闭啦");
        this.used = false;
    }

}
