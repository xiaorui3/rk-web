// src/main/java/com/example/boot/pojo/JoinRequest.java
package com.example.rk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinRequest {
    private String name;
    private String studentId;
    private String major;
    private String phone;
    private String email;
    private String interest;
    private String experience;
}