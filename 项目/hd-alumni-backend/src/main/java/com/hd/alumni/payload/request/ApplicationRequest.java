package com.hd.alumni.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApplicationRequest {
    
    @NotBlank(message = "访问目的不能为空")
    private String purpose;
    
    @NotBlank(message = "访问日期不能为空")
    private String visitDate;
    
    @NotBlank(message = "访问时间不能为空")
    private String visitTime;
    
    @NotBlank(message = "停留时长不能为空")
    private String duration;
    
    @NotBlank(message = "访问地点不能为空")
    private String location;
    
    private String contactPerson;
    
    private String contactPhone;
    
    private String description;
    
    @NotBlank(message = "紧急联系人不能为空")
    private String emergencyContact;
    
    @NotBlank(message = "紧急联系电话不能为空")
    private String emergencyPhone;
}