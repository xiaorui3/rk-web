package test;

import test2.Person;

//子类    extends(扩展)     Teacher is-a Person
public class Teacher extends Person {

    //职称
    public String zhiCheng;
//
//    {
//        System.out.println("teacher的代码块");
//    }
//    public Teacher(){
//        //执行了一个super();?? 父类int 父类无参
//        this(10);
//        System.out.println("Teacher默认无参数的构造方法");
//    }
//    public Teacher(int a){
//        //super()????       super(10)???
//        System.out.println("Teacher带参数的构造方法");
//
//    }

    //能吃饭
    @Override
    public void eat(){
        System.out.println("老师是神仙，讲课不吃饭");
    }

    //能讲课
//    public void teach(){
//        this.eat();//???????    tea--1      per--2
//        System.out.println("讲课");
//    }

}
