package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 定义查询方法
     */
    @Select("select * from roottest.user")
    public List<User> selectAllUser();

    @Select("select name from roottest.user where id=#{id}")
    public User selectUserNameById(int id);

}
