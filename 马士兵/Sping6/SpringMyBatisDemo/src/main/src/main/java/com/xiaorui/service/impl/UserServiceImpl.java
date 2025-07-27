package com.xiaorui.service.impl;

import com.xiaorui.mapper.UserMapper;
import com.xiaorui.pojo.user;
import com.xiaorui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService  {
    @Autowired
    @Qualifier("um1")
    private UserMapper userMapper;
    @Override
    public user selectOneUser(String name, String pwd) {
        return null;
    }

    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
