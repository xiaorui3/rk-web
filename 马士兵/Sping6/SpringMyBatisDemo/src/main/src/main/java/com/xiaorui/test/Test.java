package com.xiaorui.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        Person Person = ac.getBean("aaa", Person.class);
        System.out.println(Person.toString());
    }
}
