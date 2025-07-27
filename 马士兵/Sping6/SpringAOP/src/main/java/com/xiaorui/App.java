package com.xiaorui;

import com.xiaorui.service.UserService;
import com.xiaorui.service.impl.UserServiceImpl;
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

        UserService us = ac.getBean("userServiceImpl", UserService.class);

        us.a();
        us.b(18);

    }
}
