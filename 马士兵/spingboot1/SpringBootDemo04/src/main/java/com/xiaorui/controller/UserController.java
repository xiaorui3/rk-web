package com.xiaorui.controller;


import com.github.pagehelper.PageInfo;
import com.xiaorui.pojo.User;
import com.xiaorui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public int delete(@PathVariable Integer id){
        System.out.println("执行了删除了吗");
        return userService.delete(id);
    }

/*    @GetMapping("/user/All")
    @ResponseBody
    public List<User> selectAll(){
        return userService.selectAll();
    }*/
    @GetMapping("/users/All")
    @ResponseBody//http://localhost:8888/users/All?pageNum=2&pageSize=3
    public PageInfo<User> selectAll(int pageNum, int pageSize){
        return userService.selectAll(pageNum, pageSize);
    }

}
