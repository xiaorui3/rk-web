package com.xiaorui;

import com.xiaorui.factory.factory;
import com.xiaorui.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = ac.getBean("p", Person.class);
        factory cat = ac.getBean("cat", factory.class);


    }
}
