package com.xiaorui.Demo;

import com.xiaorui.Demo.service.Eat;
import com.xiaorui.Demo.service.impl.PersonImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContextDemo.xml");
        PersonImpl p = ac.getBean("p", PersonImpl.class);
        p.eat();
        Eat e = p.getE();
        e.eat();
    }
}
