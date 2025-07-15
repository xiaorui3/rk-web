package 布卡.基础.ZY.ZY7_13;

//目的没有类的目的，类的出现就是为了装一个主方法
public class TestMain {

    public static void main(String[] args) {

        //以前写的方法，想要调用，第一步需要创建对象
        //构造方法他的作用就是为了创建对象的？执行之前，没有对象？
        //  构造方法的调用通过new关键字

        Person p = new Person("zzt",18,'男');
        //本质上是通过new关键字，调用了Person类中的构造方法，返回一个对象，接收返回值
        //构造方法，默认就存在
        System.out.println(p.name+"--"+p.age+"--"+p.sex);

        System.out.println("===================");

        Person p1 = new Person();
        p1.name = "lisi";














//        Person p = new Person();
        //p.test('我');    //int
        //  参数数据类型转化的问题
            //  char--->int     char--->String
        //       基本 基本           基本 引用
        //  char a = '我';
        //  int b = a;      32bit   Unicode 97-a
        //  调用方法的时候，'我'--->里面的参数接收
        //==============================

//        p.test();




//        int[] array = new int[3];
//        Person p = new Person();
//        p.testOne(10);
//
//        System.out.println("hello");
//        System.out.println(10);
//        System.out.println(10.9);
//        System.out.println(true);
//        System.out.println(array);  //  [I @ 154617c
//        System.out.println(p);      //  test.Person @ a14482        toString();
            //println();
            //有好多个名字都叫println的方法，参数类型都不相同



//        //1.描述类
//        //2.根据描述的类，创建对象
//        Person p = new Person();
//        //3.对象调用属性，给属性赋值的过程
//        p.name = "zhangsan";
//        p.age = 10;
//        p.sex = '男';
//        //4.验证看一看   对象.属性  取值
//        System.out.println(p.name+"--"+p.age+"--"+p.sex);
//        p.study();
//        p.study();
//
//        //==============================================
//
//        int a = 10;
//        int b = a;
//
//        int[] arr = new int[2];
//        int[] brr = arr;
//        brr[0] = 100;
//
//        Person p2 = p;
//        p2.name="zzt";
//        System.out.println(p2.name+"--"+p2.age+"--"+p2.sex);
//        System.out.println(p.name+"--"+p.age+"--"+p.sex);


        //=======================
//        Person p = new Person();
//        int a = 1;
//        a = p.testOne(a);
//            //方法调用          存储/调用--执行(栈 临时的空间)
//            //方法外的这个a------->方法内部
//            //方法执行完毕，临时的栈空间就会消亡
//        System.out.println("方法调用完毕最终："+a);//1000
//
//
//        int[] array = new int[]{1,2,3};
//        p.testTwo(array);
//            //临时的方法执行空间
//            //array----->方法内部array
//        System.out.println("方法调用完毕最终："+array[0]);

    }

}
