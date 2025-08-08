package com.example.rk.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Mapper
public class MailUser {
    private String mail;
    private String mess;
    //设置邮件主题
    private String subject;
    private String stuid;
}
