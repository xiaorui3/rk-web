package com.xiaorui.Spring6Demo02;

import com.xiaorui.Spring6Demo02.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {
    // 这叫做Ioc DI
    public static void main(String[] args) {
        //解析xml
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");

        Person p = ac.getBean("p", Person.class);
        Person p1 = (Person) ac.getBean("p");
        System.out.println(p==p1);
        System.out.println(p);
        System.out.println(p1);


        //Person person = new Person();
    }
}
