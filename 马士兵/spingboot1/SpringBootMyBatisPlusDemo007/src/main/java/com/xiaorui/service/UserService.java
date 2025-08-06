package com.xiaorui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaorui.pojo.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService extends IService<User> {
    int a();

    default int b() {
        return 0;
    }
}
