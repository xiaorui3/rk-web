package com.xiaorui.springbootdemo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-29
 * @Description: Index
 * @Version: 1.0
 */

@Controller("/")
public class Index {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "index";
    }
}
