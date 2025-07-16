package 马士兵.Lambda;

public class TestDemo01 {
    public static void main(String[] args) {
        Test t=(int a,int b)-> a+b;
        System.out.println(t.hello(1,2));
    }
}
