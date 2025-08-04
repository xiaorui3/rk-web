package com.xiaorui.controller;


import com.xiaorui.pojo.user;
import com.xiaorui.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class userController {
    @Autowired
    private userService userService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public user userSelectOntController(@PathVariable  int id){
        return userService.selectUserOneService(id);
    }

    @PutMapping("/user")
    @ResponseBody
    public int updateUser(user user){
        return userService.updateUserService(user);
    }

    @PostMapping("/user")
    @ResponseBody
    public int insertUser(user user){
        return userService.insertUserService(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public int deleteUser(int id){
        return userService.deleteUserService(id);
    }
}
