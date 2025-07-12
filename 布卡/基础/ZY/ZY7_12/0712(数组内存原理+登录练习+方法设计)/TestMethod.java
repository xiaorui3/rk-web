package test;

public class TestMethod {

    //设计方法

    //无参数无返回值           描述
    public static void eat(){
        System.out.println("吃饭");
    }

    //有参数无返回值
    //  参数做事情之前提供的条件        变量
    public static void eatTwo(int count,String something){
        System.out.println("吃"+count+"份"+something);
    }

    //无参数有返回值
    public static String tellName(){
        System.out.println("你问我叫啥呀？");
        return "zzt";
    }


    public static void main(String[] args) {
        //调用
        //  方式1，如果你设计的方法是有特征的(static)，类名字直接调用
        TestMethod.eat();
        TestMethod.eat();
        TestMethod.eatTwo(1,"面条");
        String result = TestMethod.tellName();
        System.out.println(result);
        //  方式2，如果方法没有特征，只能创建方法所在类的对象，对象调用
//        TestMethod tm = new TestMethod();
//        tm.eat();
    }

}
