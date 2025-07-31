package com.xiaorui.controller;


import com.xiaorui.pojo.User;
import com.xiaorui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/user/{id}")
    @ResponseBody
    public User select(@PathVariable Integer id){
        return userService.select(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public int save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/user")
    @ResponseBody
    public int update(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public User delete(@PathVariable Integer id){
        return userService.select(id);
    }
}
