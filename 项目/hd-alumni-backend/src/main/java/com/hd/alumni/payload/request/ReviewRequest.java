package com.hd.alumni.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRequest {
    
    @NotBlank(message = "审核状态不能为空")
    private String status;
    
    private String feedback;
}