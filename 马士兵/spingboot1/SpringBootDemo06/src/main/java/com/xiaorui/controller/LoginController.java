package com.xiaorui.controller;


import com.xiaorui.pojo.user;
import com.xiaorui.service.userService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private userController userController;

    @RequestMapping("/login")
    public String Login(String username, String password, HttpServletRequest request) {
        System.out.println(username);
        System.out.println(password);
        int i = Integer.parseInt(password);
        user user = userController.userSelectOntController(i);
        System.out.println(user);
        if (user.getName().equals(username)){
            System.out.println("过了");
            request.getSession().setAttribute("user",user);
            return "test";
        }
        return "redirect:/login.html";
    }
}
