package com.hd.alumni.controller;

import com.hd.alumni.entity.User;
import com.hd.alumni.payload.request.LoginRequest;
import com.hd.alumni.payload.request.RegisterRequest;
import com.hd.alumni.payload.response.ApiResponse;
import com.hd.alumni.payload.response.JwtAuthResponse;
import com.hd.alumni.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("loginRequest: " + loginRequest.getPassword());
        System.out.println("loginRequest: " + loginRequest.getPhone());
        String jwt = authService.authenticateUser(loginRequest.getPhone(), loginRequest.getPassword());
        User user = authService.getUserByPhone(loginRequest.getPhone());
        return ResponseEntity.ok(new JwtAuthResponse(jwt, user));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPhone(registerRequest.getPhone());
        user.setPassword(registerRequest.getPassword());
        user.setStudentId(registerRequest.getStudentId());
        user.setGraduationYear(registerRequest.getGraduationYear());
        user.setMajor(registerRequest.getMajor());
        
        User result = authService.registerUser(user);
        
        return ResponseEntity.ok(new ApiResponse(true, "用户注册成功"));
    }
}