package com.xiaorui.excep;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class XiaoruiControllerExcep {
    @ExceptionHandler(java.lang.ArithmeticException.class)
    public String handleException(){
        System.out.println("异常处理逻辑....");
        System.out.println("异常处理逻辑....");
        System.out.println("异常处理逻辑....");
        System.out.println("异常处理逻辑....");
        return "myerror";
    }
}
