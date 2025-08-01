package com.xiaorui.service;

import com.github.pagehelper.PageInfo;
import com.xiaorui.pojo.User;

import java.util.List;

public interface UserService {
    int save(User user);
    int update(User user);
    int delete(Integer id);
    User select(Integer id);

    //查询
    //List<User> selectAll();

    PageInfo<User> selectAll(int pageNum, int pageSize);
}
