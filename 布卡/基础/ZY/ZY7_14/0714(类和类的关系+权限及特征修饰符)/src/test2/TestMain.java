package test2;

import java.util.Scanner;

public class TestMain {

    public final String name = "aaaa";

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner input = new Scanner(System.in);
        input.next();

//        People p = new People();
//        System.out.println(p);  //     test2.People @ 34e12af
//        p.name = "zzt";
//        //p.age = 18000;      //本质上来说，age属性是公有的
//        p.cunAge(-180);
//        p.show();


        ///////////////////////////////////////

//        People p = new People();
//        p.name = "zhangsan";
//        People.age = 18;
//
//        People p2 = new People();
//        p2.name = "lisi";
//        People.age = 20;
//
//        System.out.println(p.name+"--"+p.age);
//        System.out.println(p2.name+"--"+p2.age);


        ///////////////////////////////////
        //new TestStatic();
        //Reflect反射技术
//        Class clazz1 = Class.forName("test2.SuperStatic");
//        System.out.println("==============");
//        Class clazz2 = Class.forName("test2.TestStatic");
//        //反射的技术再创建对象
//        System.out.println("==============");
//        System.out.println("==============");
//        clazz2.newInstance();   //new TestStatic();
//        System.out.println("---------");
//        clazz2.newInstance();   //new TestStatic();
//        new TestStatic();



        //////////////////////////////////////////
        //final

//        final int a;//变量的定义，声明
//        a = 10;//最终的--不让改
//        System.out.println(a);//10
//        //a = 100;
//        System.out.println(a);//100
//
//
//        final int[] array = new int[]{10,20,30};
//        array[0] = 100;
//
//        //array = new int[4];
//
//        for(int v:array){
//            System.out.println(v);
//        }

    }


}
