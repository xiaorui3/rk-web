package com.xiaorui.Demo.service.impl;

import com.xiaorui.Demo.service.Eat;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
@Service
public class NotEat implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("不吃");
    }
}
