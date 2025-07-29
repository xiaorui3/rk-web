package com.hd.alumni.payload.response;

import lombok.Data;

@Data
public class ApplicationResponse {
    
    private Long id;
    private String applicantName;
    private String studentId;
    private Integer graduationYear;
    private String major;
    private String purpose;
    private String visitDate;
    private String visitTime;
    private String duration;
    private String location;
    private String contactPerson;
    private String contactPhone;
    private String description;
    private String emergencyContact;
    private String emergencyPhone;
    private String status;
    private String statusText;
    private String submitDate;
    private String reviewDate;
    private String reviewer;
    private String feedback;
}