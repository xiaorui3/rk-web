package 布卡.基础.ZY.ZY7_13;

public class TestThis {

    public static void main(String[] args) {
        new TestThis();
    }

    //属性
    public String name;
    public String sex;

    //构造方法
    public TestThis(){
        this("abc");//调用构造方法(省略了构造方法名)
        System.out.println("默认无参数构造方法");
    }
    public TestThis(String name){
        System.out.println("带参数的构造方法");
    }


    {
        System.out.println("普通的代码块");

    }

    //方法
    public void testOne(int a){
        System.out.println("testOne"+this.name);
    }
    public String testTwo(){
        System.out.println("testTwo");
        return "haha";
    }


}
