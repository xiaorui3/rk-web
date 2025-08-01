package com.xiaorui.controller;


import com.github.pagehelper.PageInfo;
import com.xiaorui.pojo.User;
import com.xiaorui.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="用户管理模块",description = "用户模块一些接口的定义")
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @Operation(summary = "用户模块-根据用户id查询用户信息")
    @Parameter(name="id",description = "查询参数--用户id",required = true)
    @GetMapping("/user/{id}")
    @ResponseBody
    public User select(@PathVariable Integer id){
        return userService.select(id);
    }


    @Parameter(name="user",description = "保存用户信息 User类 在pojo包下",required = true)
    @Operation(summary = "用户模块-保存用户信息")
    @PostMapping("/user")
    @ResponseBody
    public int save(@RequestBody User user){
        return userService.save(user);
    }

    @Operation(summary = "用户模块-更改用户信息")
    @PutMapping("/user")
    @ResponseBody
    public int update(@RequestBody User user){
        return userService.update(user);
    }

    @Operation(summary = "用户模块-根据用户id删除用户信息")
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
        System.out.println("查询数据库的Controller层");
        return userService.selectAll(pageNum, pageSize);
    }

}
