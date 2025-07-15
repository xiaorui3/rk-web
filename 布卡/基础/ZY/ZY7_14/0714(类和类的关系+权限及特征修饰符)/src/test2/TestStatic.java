package test2;

public class TestStatic extends SuperStatic{

    //属性
    public String field = "field";
    public static String staticField = "staticField";

    //构造方法
    public TestStatic(){
        //super();
        System.out.println("TestStatic默认无参数构造方法");
    }
    //代码块
    static{
        System.out.println("TestStatic静态代码块"+TestStatic.staticField);
    }
    {
        System.out.println("TestStatic普通代码块"+this.field);
    }
    //方法

    public void method(){
        System.out.println("TestStatic普通方法");
    }
    public static void staticMethod(){
        System.out.println("TestStatic静态方法");
    }

}
