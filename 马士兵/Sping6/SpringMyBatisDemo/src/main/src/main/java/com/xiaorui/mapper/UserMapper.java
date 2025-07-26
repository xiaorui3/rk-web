package com.xiaorui.mapper;

import com.xiaorui.pojo.user;

public interface UserMapper {
    public abstract user selectOneUser(String uname, String pwd);

}
