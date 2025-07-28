package com.hd.alumni.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterRequest {
    
    @NotBlank(message = "姓名不能为空")
    private String name;
    
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;
    
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
    
    @NotBlank(message = "密码不能为空")
    private String password;
    
    @NotBlank(message = "学号不能为空")
    private String studentId;
    
    @NotNull(message = "毕业年份不能为空")
    private Integer graduationYear;
    
    @NotBlank(message = "专业不能为空")
    private String major;
    
    private String currentJob;
    
    private String company;
    
    private String address;
    
    private String bio;
}