package com.hd.alumni.payload.response;

import lombok.Data;

@Data
public class UserProfileResponse {
    
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String studentId;
    private Integer graduationYear;
    private String major;
    private String currentJob;
    private String company;
    private String address;
    private String bio;
    private String avatarUrl;
    private String role;
    private Boolean emailVerified;
    private Boolean phoneVerified;
}