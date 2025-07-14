package test;

import test2.Person;

public class Student extends Person {
    //Student is-a Person

    //有学校，学号
    public int number;

    //能吃饭
//    public void eat(){
//        System.out.println("学生长身体，得好好吃饭");
//    }

    //能学习
    public void study(){
        System.out.println("good good study");
    }
}
