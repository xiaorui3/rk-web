package com.xiaorui.service.impl;

import com.xiaorui.mapper.UserMapper;
import com.xiaorui.pojo.User;
import com.xiaorui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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
        return userMapper.deleteUser(id);
    }

    @Override
    public User select(Integer id) {
        return userMapper.selectUser(id);
    }
}
