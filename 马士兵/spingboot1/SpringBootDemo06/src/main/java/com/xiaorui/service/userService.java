package com.xiaorui.service;


import com.xiaorui.pojo.user;

public interface userService {
    public user selectUserOneService(int id);
    public int deleteUserService(int id);
    public int insertUserService(user user);
    public int updateUserService(user user);
}
