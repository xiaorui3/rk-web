package kill;

public class TestMain {

    public static void main(String[] args) {
        //1.创建农夫对象
        Farmer farmer = new Farmer("隔壁老王");
        //2.做事      农夫养猪
        Pig pig = farmer.yangPig(5);
        //3.创建屠夫对象
        Butcher butcher = new Butcher();
        //4.屠夫杀猪
        butcher.killPig(pig);
    }
}
