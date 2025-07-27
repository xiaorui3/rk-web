package com.xiaorui.mapper;

import com.xiaorui.pojo.user;
import org.apache.ibatis.annotations.Select;
public interface UserMapper {
    public abstract user selectOneUser(String uname, String pwd);
}
