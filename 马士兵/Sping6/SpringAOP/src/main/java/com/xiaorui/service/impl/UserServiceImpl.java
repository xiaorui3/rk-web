package com.xiaorui.service.impl;

import com.xiaorui.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void a() {
        System.out.println("UserServiceImpl.a");
    }

    @Override
    // 重写父类方法
    public void b(int sum) {
        System.out.println("UserServiceImpl.b"+"   "+sum);
    }
}
