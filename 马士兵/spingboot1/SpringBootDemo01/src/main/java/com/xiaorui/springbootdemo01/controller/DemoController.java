package com.xiaorui.springbootdemo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-29
 * @Description: DemoController
 * @Version: 1.0
 */


@Controller
public class DemoController {
    @RequestMapping("/show")
    @ResponseBody
    public String show(){
        return "Hello World SpringBoot!";
    }
}
