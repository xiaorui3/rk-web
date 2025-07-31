package org.example.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTML_TEST {
    @Autowired
    private UserService userService;
    @RequestMapping("/show1")
    public String show1(HttpServletRequest request){
        request.setAttribute("msg1",111);
        request.setAttribute("msg2",userService.selectUserByName(1));
        return "test01";
    }

    @RequestMapping("/show2")
    public String show2(HttpServletRequest request){
        request.setAttribute("msg1",111);
        request.setAttribute("msg2",userService.selectUserByName(1));
        request.setAttribute("msg3",userService.selectAllUser());
        return "test01";
    }

    @RequestMapping("/show3")
    public String show3(int id){
        System.out.println("------------------------id；"+id);
        return "xxx";
    }
}
