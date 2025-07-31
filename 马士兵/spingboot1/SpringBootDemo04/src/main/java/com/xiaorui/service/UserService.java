package com.xiaorui.service;

import com.xiaorui.pojo.User;

public interface UserService {
    int save(User user);
    int update(User user);
    int delete(Integer id);
    User select(Integer id);
}
