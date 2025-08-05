package com.xiaorui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaorui.mapper.UserMapper;
import com.xiaorui.pojo.User;
import com.xiaorui.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
