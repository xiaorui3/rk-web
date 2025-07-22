package test;

public class TestFinal {
    public static void main(String[] args) {
        System.out.println(A.i);//10
        //1.加载A类，静态属性，静态块
        //2.自动执行    静态代码块   自动调用静态块     haha
        //3.主动调用了一下静态属性i                    10
    }
}
class A{
    static final int i;
    static{
        i = 10;
        System.out.println("haha");
    }
}
