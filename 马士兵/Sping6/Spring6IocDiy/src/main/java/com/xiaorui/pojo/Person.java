package com.xiaorui.pojo;

public class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("Person 空参构造");
    }

    public Person(int age, String name) {
        System.out.println("Person 有参构造");
        this.age = age;
        this.name = name;
    }
    public void eat(){
        System.out.println(this.name+" 在吃饭-使用eat方法");
    }
}
