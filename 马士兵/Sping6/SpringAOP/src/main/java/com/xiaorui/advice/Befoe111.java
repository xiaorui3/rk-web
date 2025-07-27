package com.xiaorui.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Befoe111 implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("====================前置通知=================");
    }
}
