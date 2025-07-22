package com.xiaorui.Spring6Demo02.pojo;

public class Person {
    private int age;
    private String name;
    private double height;



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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public Person() {
        System.out.println("无参构造器");
    }

    public Person(int age, String name, double height) {
        System.out.println("有参构造器");
        this.age = age;
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
