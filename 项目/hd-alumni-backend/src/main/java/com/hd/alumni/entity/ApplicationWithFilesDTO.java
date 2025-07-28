package com.hd.alumni.entity;

import com.hd.alumni.entity.ApplicationFile;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class ApplicationWithFilesDTO {
    private Long id;
    private String purpose;
    private LocalDate visitDate;
    private LocalTime visitTime;
    private String duration;
    private String location;
    private String contactPerson;
    private String contactPhone;
    private String description;
    private String emergencyContact;
    private String emergencyPhone;
    private String status;
    private LocalDateTime submitDate;
    private LocalDateTime reviewDate;
    private String feedback;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ApplicationFile> files;
    
    // 用户信息
    private String applicantName;
    private String studentId;
    private Integer graduationYear;
    private String major;
    
    // 审核人信息
    private String reviewerName;
}