package com.xiaorui.test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "aaa")
public class Person {
    @Value("18")
    private int age;
    @Value("lili")
    private String name;

    @Override
    public String toString() {
        return "TestPr{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
