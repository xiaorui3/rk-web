package test2;

//写这个类的目的，是为了将Teacher和Student中的重复代码拿过来的
//减少其他类的重复代码(提高复用性，减少代码冗余)
//父类
public class Person {
    //有名字
    public String name;    //只能在本类中访问
//    //有年龄
//    public int age;
//
//    {
//        System.out.println("person的代码块");
//    }

//    public Person(){
//        this(10);
//        System.out.println("person无参数的构造方法");
//    }
//    public Person(int a){
//        System.out.println("person带int参数的构造方法");
//    }

//    //能吃饭
    public void eat(){          //被子类重写的方法
        System.out.println("人都要吃饭");
    }

    public void teach(){        //父类独有方法
        this.eat();//???????    tea--1      per--2
            //t.eat();
        System.out.println("父类讲课");
    }

}
