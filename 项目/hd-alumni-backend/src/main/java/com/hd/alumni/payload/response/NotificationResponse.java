package com.hd.alumni.payload.response;

import lombok.Data;

@Data
public class NotificationResponse {
    
    private Long id;
    private String title;
    private String content;
    private String type;
    private Boolean read;
    private String createdAt;
}