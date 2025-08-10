// src/main/java/com/example/boot/pojo/ApiResponse.java
package com.example.rk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public static ApiResponse success(String message) {
        return new ApiResponse(true, message, new HashMap<>());
    }

    public static ApiResponse error(String message) {
        return new ApiResponse(false, message, new HashMap<>());
    }

    public ApiResponse addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}