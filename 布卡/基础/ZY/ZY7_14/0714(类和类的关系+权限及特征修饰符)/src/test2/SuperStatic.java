package test2;

//当作TestStatic类的父类来使用
public class SuperStatic {

    //属性
    public String field = "Superfield";
    public static String staticField = "SuperStaticField";

    //构造方法
    public SuperStatic(){
        System.out.println("SuperStatic默认无参数构造方法");
    }
    //代码块
    static{
        System.out.println("SuperStatic静态代码块"+SuperStatic.staticField);
    }
    {
        System.out.println("SuperStatic普通代码块"+this.field);
    }
    //方法

    public void method(){
        System.out.println("SuperStatic普通方法");
    }
    public static void staticMethod(){
        System.out.println("SuperStatic静态方法");
    }

}
