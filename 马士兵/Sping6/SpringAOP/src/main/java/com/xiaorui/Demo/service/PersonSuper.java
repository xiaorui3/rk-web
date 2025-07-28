package com.xiaorui.Demo.service;

import java.util.Objects;

public class PersonSuper implements Person{
    private String name;
    private int age;
    private String sex;
    @Override
    public void show() {
        System.out.println("父类的展示");
        System.out.println(this.toString());
    }

    @Override
    public void eat() {
        System.out.println("父类的吃东西");
    }

    @Override
    public void sleep() {
        System.out.println("父类的睡觉");
    }

    public PersonSuper() {
    }

    public PersonSuper(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonSuper{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonSuper that = (PersonSuper) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(sex, that.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
