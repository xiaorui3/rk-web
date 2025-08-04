package com.xiaorui.service.impl;


import com.xiaorui.mapper.userMapper;
import com.xiaorui.pojo.user;
import com.xiaorui.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;


    @Override
    public user selectUserOneService(int id) {
        return userMapper.selectUserOne(id);
    }

    @Override
    public int deleteUserService(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int insertUserService(user user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUserService(user user) {
        return userMapper.updateUser(user);
    }
}
