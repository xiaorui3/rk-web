package com.example.boot.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RkController {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("rk")
    private String dbUser;

    @Value("rk")
    private String dbPassword;

    @PostMapping("/join")
    public ResponseEntity<Map<String, Object>> handleJoinRequest(@RequestBody JoinRequest request) {
        // 验证必填字段
        if (request.getName() == null || request.getName().isEmpty() ||
                request.getStudentId() == null || request.getStudentId().isEmpty() ||
                request.getMajor() == null || request.getMajor().isEmpty() ||
                request.getPhone() == null || request.getPhone().isEmpty() ||
                request.getEmail() == null || request.getEmail().isEmpty() ||
                request.getInterest() == null || request.getInterest().isEmpty()) {

            return ResponseEntity.badRequest()
                    .body(createResponse(false, "所有必填字段不能为空"));
        }

        // 验证邮箱格式
        if (!request.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return ResponseEntity.badRequest()
                    .body(createResponse(false, "邮箱格式不正确"));
        }

        String sql = "INSERT INTO club_members (name, student_id, major, phone, email, interest, experience, submit_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, request.getName());
            stmt.setString(2, request.getStudentId());
            stmt.setString(3, request.getMajor());
            stmt.setString(4, request.getPhone());
            stmt.setString(5, request.getEmail());
            stmt.setString(6, request.getInterest());
            stmt.setString(7, request.getExperience());
            stmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long id = generatedKeys.getLong(1);
                        Map<String, Object> response = createResponse(true, "申请提交成功");
                        response.put("memberId", id);
                        return ResponseEntity.ok(response);
                    }
                }
                return ResponseEntity.ok(createResponse(true, "申请提交成功"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(createResponse(false, "申请提交失败"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("Duplicate entry")) {
                return ResponseEntity.badRequest()
                        .body(createResponse(false, "该学号已提交过申请"));
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createResponse(false, "数据库错误: " + e.getMessage()));
        }
    }

    private Map<String, Object> createResponse(boolean success, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", message);
        return response;
    }

    public static class JoinRequest {
        private String name;
        private String studentId;
        private String major;
        private String phone;
        private String email;
        private String interest;
        private String experience;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }
    }
}