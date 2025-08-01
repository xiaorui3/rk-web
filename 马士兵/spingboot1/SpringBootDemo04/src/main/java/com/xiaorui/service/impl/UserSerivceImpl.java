package com.xiaorui.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaorui.mapper.UserMapper;
import com.xiaorui.pojo.User;
import com.xiaorui.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier
public class UserSerivceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int save(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int delete(Integer id) {
        System.out.println("第二个执行了吗");
        return userMapper.deleteUser(id);
    }

    @Override
    public User select(Integer id) {
        return userMapper.selectUser(id);
    }

    @Override
    public PageInfo<User> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUser();
        PageInfo<User> p =new PageInfo<>(users);
        return p;
    }

/*    @Override
    public List<User> selectAll() {
        return userMapper.selectAllUser();
    }*/

}
