// src/main/java/com/example/boot/pojo/ClubMember.java
package com.example.rk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 *
 * 输入数据库的类
 * 有数据库表
 */
public class ClubMember {
    private Long id;
    private String name;
    private String studentId;
    private String major;
    private String phone;
    private String email;
    private String interest;
    private String experience;
    private LocalDateTime submitTime;
}