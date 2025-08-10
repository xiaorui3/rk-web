package com.example.rk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 有数据库表
 */
public class SuperMailSendUser {
    private int id;
    private String email;
    private String name;
}
