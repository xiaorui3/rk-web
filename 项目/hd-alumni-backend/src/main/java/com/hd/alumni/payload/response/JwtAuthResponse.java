package com.hd.alumni.payload.response;

import com.hd.alumni.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthResponse {
    private String token;
    private User user;
    private String tokenType = "Bearer";
    
    public JwtAuthResponse(String accessToken) {
        this.token = accessToken;
    }
    
    public JwtAuthResponse(String accessToken, User user) {
        this.token = accessToken;
        this.user = user;
    }
}