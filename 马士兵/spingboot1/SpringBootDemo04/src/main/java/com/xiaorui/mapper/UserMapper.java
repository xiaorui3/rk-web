package com.xiaorui.mapper;

import com.xiaorui.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    //增删改查
    int saveUser(User user);
    int updateUser(User user);
    //@Delete("delete from user where id=#{id}")
    int deleteUser(Integer id);
    User selectUser(Integer id);
    List<User> selectAllUser();
}
