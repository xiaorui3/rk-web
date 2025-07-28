package com.hd.alumni.controller;

import com.hd.alumni.entity.Application;
import com.hd.alumni.entity.ApplicationFile;
import com.hd.alumni.entity.ApplicationWithFilesDTO;
import com.hd.alumni.payload.request.ApplicationRequest;
import com.hd.alumni.payload.request.ReviewRequest;
import com.hd.alumni.payload.response.ApiResponse;
import com.hd.alumni.payload.response.ApplicationResponse;
import com.hd.alumni.payload.response.PagedResponse;
import com.hd.alumni.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    //============================================


    @GetMapping("/all-with-files")
//    @PreAuthorize("hasRole('ADMIN')")
    @Transactional(readOnly = true) // 添加事务管理
    public ResponseEntity<?> getAllApplicationsWithFiles(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "status", required = false) String status) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("submitDate").descending());
        Page<Application> applications;

        if (status != null && !status.equals("all")) {
            Application.Status statusEnum = Application.Status.valueOf(status.toUpperCase());
            applications = applicationService.getApplicationsByStatus(statusEnum, pageable);
        } else {
            applications = applicationService.getAllApplications(pageable);
        }

        List<ApplicationWithFilesDTO> content = applications.getContent().stream()
                .map(this::convertToApplicationWithFilesDTO)
                .collect(Collectors.toList());

        PagedResponse<ApplicationWithFilesDTO> response = new PagedResponse<>(
                content,
                applications.getNumber(),
                applications.getSize(),
                applications.getTotalElements(),
                applications.getTotalPages(),
                applications.isLast()
        );

        return ResponseEntity.ok(response);
    }

    private ApplicationWithFilesDTO convertToApplicationWithFilesDTO(Application application) {
        ApplicationWithFilesDTO dto = new ApplicationWithFilesDTO();

        // 基础信息
        dto.setId(application.getId());
        dto.setPurpose(application.getPurpose());
        dto.setVisitDate(application.getVisitDate());
        dto.setVisitTime(application.getVisitTime());
        dto.setDuration(application.getDuration());
        dto.setLocation(application.getLocation());
        dto.setContactPerson(application.getContactPerson());
        dto.setContactPhone(application.getContactPhone());
        dto.setDescription(application.getDescription());
        dto.setEmergencyContact(application.getEmergencyContact());
        dto.setEmergencyPhone(application.getEmergencyPhone());
        dto.setStatus(application.getStatus().name());
        dto.setSubmitDate(application.getSubmitDate());
        dto.setReviewDate(application.getReviewDate());
        dto.setFeedback(application.getFeedback());
        dto.setCreatedAt(application.getCreatedAt());
        dto.setUpdatedAt(application.getUpdatedAt());

        // 文件信息
        dto.setFiles(application.getFiles());

        // 申请人信息 - 现在已预先加载
        if (application.getUser() != null) {
            dto.setApplicantName(application.getUser().getName());
            dto.setStudentId(application.getUser().getStudentId());
            dto.setGraduationYear(application.getUser().getGraduationYear());
            dto.setMajor(application.getUser().getMajor());
        }

        // 审核人信息 - 现在已预先加载
        if (application.getReviewer() != null) {
            dto.setReviewerName(application.getReviewer().getName());
        }

        return dto;
    }


    //============================================

    @PostMapping
    public ResponseEntity<?> createApplication(
            @Valid @RequestPart("application") ApplicationRequest applicationRequest,
            @RequestPart(value = "files", required = false) List<MultipartFile> files,
            @AuthenticationPrincipal UserDetails userDetails) {
        
        Application application = new Application();
        application.setPurpose(applicationRequest.getPurpose());
        application.setVisitDate(LocalDate.parse(applicationRequest.getVisitDate()));
        application.setVisitTime(LocalTime.parse(applicationRequest.getVisitTime()));
        application.setDuration(applicationRequest.getDuration());
        application.setLocation(applicationRequest.getLocation());
        application.setContactPerson(applicationRequest.getContactPerson());
        application.setContactPhone(applicationRequest.getContactPhone());
        application.setDescription(applicationRequest.getDescription());
        application.setEmergencyContact(applicationRequest.getEmergencyContact());
        application.setEmergencyPhone(applicationRequest.getEmergencyPhone());
        
        Application result = applicationService.createApplication(application, userDetails.getUsername(), files);
        
        return ResponseEntity.ok(new ApiResponse(true, "申请提交成功"));
    }

    @GetMapping
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserApplications(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "status", required = false) String status,
            @AuthenticationPrincipal UserDetails userDetails) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by("submitDate").descending());
        Page<Application> applications;
        
        if (status != null && !status.equals("all")) {
            Application.Status statusEnum = Application.Status.valueOf(status.toUpperCase());
            applications = applicationService.getUserApplicationsByStatus(userDetails.getUsername(), statusEnum, pageable);
        } else {
            applications = applicationService.getUserApplications(userDetails.getUsername(), pageable);
        }
        
        List<ApplicationResponse> content = applications.getContent().stream()
                .map(this::convertToApplicationResponse)
                .collect(Collectors.toList());
        
        PagedResponse<ApplicationResponse> response = new PagedResponse<>(
                content,
                applications.getNumber(),
                applications.getSize(),
                applications.getTotalElements(),
                applications.getTotalPages(),
                applications.isLast()
        );
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicationById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Application application = applicationService.getApplicationById(id);
        
        // 检查是否是申请人本人或管理员
        if (!application.getUser().getPhone().equals(userDetails.getUsername()) &&
                !userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).body(new ApiResponse(false, "无权访问此申请"));
        }
        
        ApplicationResponse applicationResponse = convertToApplicationResponse(application);
        
        return ResponseEntity.ok(applicationResponse);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancelApplication(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        applicationService.cancelApplication(id, userDetails.getUsername());
        return ResponseEntity.ok(new ApiResponse(true, "申请已取消"));
    }

    @GetMapping("/{id}/files")
    public ResponseEntity<?> getApplicationFiles(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Application application = applicationService.getApplicationById(id);
        
        // 检查是否是申请人本人或管理员
        if (!application.getUser().getPhone().equals(userDetails.getUsername()) &&
                !userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).body(new ApiResponse(false, "无权访问此申请"));
        }
        
        List<ApplicationFile> files = applicationService.getApplicationFiles(id);
        
        return ResponseEntity.ok(files);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllApplications(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "status", required = false) String status) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by("submitDate").descending());
        Page<Application> applications;
        
        if (status != null && !status.equals("all")) {
            Application.Status statusEnum = Application.Status.valueOf(status.toUpperCase());
            applications = applicationService.getApplicationsByStatus(statusEnum, pageable);
        } else {
            applications = applicationService.getAllApplications(pageable);
        }
        
        List<ApplicationResponse> content = applications.getContent().stream()
                .map(this::convertToApplicationResponse)
                .collect(Collectors.toList());
        
        PagedResponse<ApplicationResponse> response = new PagedResponse<>(
                content,
                applications.getNumber(),
                applications.getSize(),
                applications.getTotalElements(),
                applications.getTotalPages(),
                applications.isLast()
        );
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/review")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> reviewApplication(
            @PathVariable Long id,
            @Valid @RequestBody ReviewRequest reviewRequest,
            @AuthenticationPrincipal UserDetails userDetails) {
        
        Application.Status status = Application.Status.valueOf(reviewRequest.getStatus().toUpperCase());
        
        Application result = applicationService.reviewApplication(id, status, reviewRequest.getFeedback(), userDetails.getUsername());
        
        return ResponseEntity.ok(new ApiResponse(true, "申请审核完成"));
    }

    private ApplicationResponse convertToApplicationResponse(Application application) {
        ApplicationResponse response = new ApplicationResponse();
        response.setId(application.getId());
        response.setApplicantName(application.getUser().getName());
        response.setStudentId(application.getUser().getStudentId());
        response.setGraduationYear(application.getUser().getGraduationYear());
        response.setMajor(application.getUser().getMajor());
        response.setPurpose(application.getPurpose());
        response.setVisitDate(application.getVisitDate().toString());
        response.setVisitTime(application.getVisitTime().toString());
        response.setDuration(application.getDuration());
        response.setLocation(application.getLocation());
        response.setContactPerson(application.getContactPerson());
        response.setContactPhone(application.getContactPhone());
        response.setDescription(application.getDescription());
        response.setEmergencyContact(application.getEmergencyContact());
        response.setEmergencyPhone(application.getEmergencyPhone());
        response.setStatus(application.getStatus().name());
        response.setStatusText(getStatusText(application.getStatus()));
        response.setSubmitDate(application.getSubmitDate().toString());
        
        if (application.getReviewDate() != null) {
            response.setReviewDate(application.getReviewDate().toString());
        }
        
        if (application.getReviewer() != null) {
            response.setReviewer(application.getReviewer().getName());
        }
        
        response.setFeedback(application.getFeedback());
        
        return response;
    }



    private String getStatusText(Application.Status status) {
        switch (status) {
            case PENDING:
                return "待审核";
            case APPROVED:
                return "已通过";
            case REJECTED:
                return "已拒绝";
            case CANCELLED:
                return "已取消";
            default:
                return "未知状态";
        }
    }
}