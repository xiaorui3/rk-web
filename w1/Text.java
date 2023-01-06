public class Text {
    public static void main(String[] args) {
        dver a_1=new dver();
        a_1.eat1();

    }
}
class pr {
    public void eat(){
        System.out.println("吃米饭");
    }
    public void he(){
        System.out.println("喝水");
    }
}
class dver extends pr {
    public void eat1(){
        this.eat();
        this.he();
        super.eat();
        super.he();
    }
    @Override
    public void eat(){
        System.out.println("吃意大利面");
    }
    @Override
    public void he(){
        System.out.println("喝牛奶");
    }
}
class zg extends pr{
    @Override
    public void eat(){
        System.out.println("吃菜");
    }
    @Override
    public void he(){
        System.out.println("喝开水");
    }
}

