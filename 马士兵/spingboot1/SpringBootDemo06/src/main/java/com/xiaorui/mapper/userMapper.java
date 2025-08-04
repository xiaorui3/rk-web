package com.xiaorui.mapper;

import com.xiaorui.pojo.user;
import org.apache.ibatis.annotations.*;


@Mapper
public interface userMapper {

    @Select("select * from user where id = #{id}")
    user selectUserOne(int id);
    @Delete("DELETE from user where id=#{id}")
    int deleteUser(int id);
    @Update("update user set age=#{age},name=#{name} where id=#{id}")
    int updateUser(user user);
    @Insert("insert user (id, age, name) value (#{id},#{age},#{name} )")
    int insertUser(user user);
}
