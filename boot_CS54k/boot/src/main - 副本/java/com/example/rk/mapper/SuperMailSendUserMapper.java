package com.example.rk.mapper;


import com.example.rk.pojo.SuperMailSendUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SuperMailSendUserMapper {

    @Insert("insert into rkst.super_mail_send_user (email,name) value (#{email},#{name})")
    int insert(SuperMailSendUser superMailSendUser);

    @Select("select  max(rkst.super_mail_send_user.id) from rkst.super_mail_send_user")
    int maxSize();

    @Select("select * from rkst.super_mail_send_user")
    List<SuperMailSendUser> getSuperMailSendUsers();

}
