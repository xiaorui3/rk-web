package com.xiaorui.controller;


import com.github.pagehelper.PageInfo;
import com.xiaorui.pojo.xiaorui;
import com.xiaorui.service.XiaoruiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@Controller
@Tag(name="用户管理控制层 " ,description = "用户控制层")
public class XiaoruiController {
    @Autowired
    private XiaoruiService xiaoruiService;


    @Operation(summary = "根据用户 id 查询 用户所有信息")
    @GetMapping("/user/{id}")
    @ResponseBody
    @Parameter(name="查询 Get",description = "管理层 查询 用户 单条 信息 返回xiaorui对象 查询条件 输入 id")
    public xiaorui selectController(@PathVariable Integer id){
        return xiaoruiService.selectOne(id);
    }

    @PutMapping("/user")
    @ResponseBody
    @Operation(summary = "根据用户 xiaorui对象 更改 xiaorui属性")
    @Parameter(name = "更改 PUT",description = "管理层 更改 用户 单条 信息 返回 int 更改条件 输入 xiaorui对象")
    public int updataController(@RequestBody xiaorui xiaorui){
        return xiaoruiService.update(xiaorui);
    }

    @PostMapping("/user")
    @ResponseBody
    @Operation(summary = "添加一个用户 ")
    @Parameter(name = "添加用户 POST",description = "添加一个用户 选择存入数据库 返回int")
    public int saveController(@RequestBody xiaorui xiaorui){
        return xiaoruiService.save(xiaorui);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    @Operation(summary = "删除一个用户 ")
    @Parameter(name = "删除用户 Delete",description = "删除一个用户 返回一个int 需要在地址栏输入id")
    public int deleteController(@PathVariable Integer id){
        return  xiaoruiService.delete(id);
    }

    @GetMapping("/users/All")
    @ResponseBody//http://localhost:8888/users/All?pageNum=2&pageSize=3
    @Operation(summary = "查询所有用户信息")
    @Parameter(name = "查询 Get",description = "查询所有用户信息 不需要传入任何参数！！！！！")
    public PageInfo<xiaorui> selectAll(int pageNum, int pageSize){
        System.out.println("查询数据库的Controller层");
        return xiaoruiService.selectAll(pageNum, pageSize);
    }

    @RequestMapping("/show2")
    public String show2(HttpServletRequest request){
        request.setAttribute("msg3",xiaoruiService.selectAllUserTable());
        return "test01";
    }






}
