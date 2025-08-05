package com.xiaorui;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaorui.pojo.User;
import com.xiaorui.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMyBatisPlusDemo007ApplicationTests {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService us;
    @Test
    void contextLoads() {
        // 查询全部数据
        List<User> list = us.list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        //list.forEach(System.out::println);
    }

    @Test
    void contextLoads1() {
        // 查询


        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("id", 3333);
        List<User> list = us.list(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        //list.forEach(System.out::println);
    }

    @Test
    void contextLoads2() {
        // 查询

        //boolean save = us.save(new User("1",3333, "xiaorui", 16, "男"));
        //System.out.println(save);
        //QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
       //queryWrapper.eq("id", 1);
       //List<User> list = us.list(queryWrapper);
       //for (int i = 0; i < list.size(); i++) {
       //    System.out.println(list.get(i).toString());
       //}
        //list.forEach(System.out::println);
    }

    @Test
    void contextLoads3() {
        // 分页
        QueryWrapper<User>  q =new QueryWrapper<>();
        q.lt("id", 20);

        Page<User> page = us.page(new Page<>(1, 10), q);
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println("每页几条数据"+page.getSize());
        System.out.println("当前页码"+page.getCurrent());
        System.out.println("总记录数"+page.getTotal());
        System.out.println("总页数"+page.getPages());
    }

}
