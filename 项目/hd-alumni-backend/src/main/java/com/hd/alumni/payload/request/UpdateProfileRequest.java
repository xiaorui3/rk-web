package com.hd.alumni.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateProfileRequest {
    
    @NotBlank(message = "姓名不能为空")
    private String name;
    
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;
    
    private String currentJob;

    private String studentId;
    
    private String company;
    
    private String address;
    
    private String bio;
}