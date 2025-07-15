package test2;

//一个类，用来描述普通人类的特点
public class People {

    //属性
    public String name;
    public static int age;      //整个类中就这么一份，单独的静态元素区域里

    //提供一个操作age属性的方法？？？
    //  条件  年龄的值        返回值 void
//    public void cunAge(int age){                //setAge
//        if(age<0){
//            System.out.println("别闹，你还没出生呢");
//            this.age = -1;
//        }else if(age>130){
//            System.out.println("别闹，老妖怪");
//            this.age = -1;
//        }else {
//            this.age = age;
//        }
//    }

    //设计一个方法，可以获取属性值
        //条件没有  返回值，属性age的值
//    public int quAge(){                         //getAge
//        //if    如果你不是zzt，不让你取
//        return this.age;
//    }



    //展示--方法
//    public void show(){
//        System.out.println("我叫"+this.name+"，今年"+this.age+"岁");
//    }

}
