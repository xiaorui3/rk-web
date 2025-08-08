package com.example.rk.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailUser {
    private String mail;
    private String mess;
    //设置邮件主题
    private String subject;
    private String stuid;
}
