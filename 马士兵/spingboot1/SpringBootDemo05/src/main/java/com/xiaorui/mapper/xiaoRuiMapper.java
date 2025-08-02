package com.xiaorui.mapper;


import com.xiaorui.pojo.xiaorui;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
@Tag(name = "XiaoRui 数据库的 Mapper类")
public interface xiaoRuiMapper {

    @Select("select * from xiaorui where id=#{id}")
    @Parameter(description = "输入用户的id 进行查询 返回一个 xiaorui 对象 ")
    xiaorui selectOneUser(int id);


    @Insert("insert xiaorui ( id, name, age, sex)  value (#{id},#{name},#{age},#{sex})")
    @Parameter(description = "输入用户的一个用户的所有信息 添加进数据库中 ")
    int saveUser(xiaorui xiaorui);


    @Update("update xiaorui set id=#{id},name=#{name},age=#{age},sex=#{sex} where id=#{id}")
    @Parameter(description = "输入用户的所有信息 更改其信息添加进数据库中 ")
    int updateUser(xiaorui xiaorui);


    @Delete("delete from xiaorui where id=#{id}")
    @Parameter(description = "输入用户的id 进行进行删除 放回一个删除后的结果 ")
    int deleteUser(int id);


    @Select("select * from xiaorui")
    @Parameter(description = "查询所有用户数据 ")
    List<xiaorui> selectAllUser();


    @Select("select * from xiaorui")
    @Parameter(description = "查询所有，以table形式展示")
    List<xiaorui> selectAllUserTable();

}
