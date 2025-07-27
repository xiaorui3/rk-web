package com.xiaorui;

import com.xiaorui.pojo.Porson;
import com.xiaorui.pojo.Porson2;
import com.xiaorui.pojo.Student;
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
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        Porson p = ac.getBean("p", Porson.class);
        System.out.println(p);
        Student student = p.getStudent();
        System.out.println(student.toString());


        System.out.println("=========================");
        Student s = ac.getBean("s", Student.class);
        s.setAge(98);
        s.setName("name");
        System.out.println(s.toString());
        System.out.println("============================");
        Student s1 = ac.getBean("s", Student.class);
        s1.setName("小王八");
        s1.setAge(212);
        System.out.println(s1);
        System.out.println(s1==s);


        Porson2 porson2 = ac.getBean("porson2", Porson2.class);
        System.out.println(porson2);
    }
}



