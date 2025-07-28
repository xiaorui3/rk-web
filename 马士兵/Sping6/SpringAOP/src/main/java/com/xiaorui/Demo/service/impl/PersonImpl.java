package com.xiaorui.Demo.service.impl;

import com.xiaorui.Demo.service.Eat;
import com.xiaorui.Demo.service.Person;
import com.xiaorui.Demo.service.PersonSuper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service(value = "p")
@Qualifier("p")
public class PersonImpl extends PersonSuper implements Person {
    private String name;
    private int age;
    private String sex;
    @Autowired
    //@Qualifier("eatbeel")
    @Qualifier("eatber")
    private Eat e;

    @Override
    public void show() {
        System.out.println("子类的展示");
        System.out.println("PersonImpl.show");
    }

    @Override
    public void eat() {
        System.out.println("PersonImpl.eat");
    }

    @Override
    public void sleep() {
        System.out.println("PersonImpl.sleep");
    }

    public PersonImpl() {
    }

    public PersonImpl(String name, int age, Eat e, String sex) {
        this.name = name;
        this.age = age;
        this.e = e;
        this.sex = sex;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Eat getE() {
        //e.eat();
        return e;
    }
    public void setE(Eat e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "PersonImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", e=" + e +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonImpl person = (PersonImpl) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(sex, person.sex) && Objects.equals(e, person.e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, age, sex, e);
    }
}
