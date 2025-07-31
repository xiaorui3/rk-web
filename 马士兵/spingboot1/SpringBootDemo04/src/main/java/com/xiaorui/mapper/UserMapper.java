package com.xiaorui.mapper;

import com.xiaorui.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    //增删改查
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
    User selectUser(Integer id);
}
