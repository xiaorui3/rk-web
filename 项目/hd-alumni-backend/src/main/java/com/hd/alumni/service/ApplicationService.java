package com.hd.alumni.service;

import com.hd.alumni.entity.Application;
import com.hd.alumni.entity.ApplicationFile;
import com.hd.alumni.entity.Notification;
import com.hd.alumni.entity.User;
import com.hd.alumni.repository.ApplicationFileRepository;
import com.hd.alumni.repository.ApplicationRepository;
import com.hd.alumni.repository.NotificationRepository;
import com.hd.alumni.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationFileRepository applicationFileRepository;
    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;
    private final String fileUploadPath;

    public ApplicationService(ApplicationRepository applicationRepository,
                             ApplicationFileRepository applicationFileRepository,
                             UserRepository userRepository,
                             NotificationRepository notificationRepository) {
        this.applicationRepository = applicationRepository;
        this.applicationFileRepository = applicationFileRepository;
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
        this.fileUploadPath = "./uploads/";
        
        // 确保上传目录存在
        try {
            Files.createDirectories(Paths.get(fileUploadPath));
        } catch (IOException e) {
            throw new RuntimeException("无法创建文件上传目录", e);
        }
    }

    @Transactional
    public Application createApplication(Application application, String userPhone, List<MultipartFile> files) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        application.setUser(user);
        application.setStatus(Application.Status.PENDING);
        
        Application savedApplication = applicationRepository.save(application);
        
        // 处理文件上传
        if (files != null && !files.isEmpty()) {
            List<ApplicationFile> applicationFiles = new ArrayList<>();
            
            for (MultipartFile file : files) {
                try {
                    String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                    Path targetLocation = Paths.get(fileUploadPath + fileName);
                    Files.copy(file.getInputStream(), targetLocation);
                    
                    ApplicationFile applicationFile = new ApplicationFile();
                    applicationFile.setApplication(savedApplication);
                    applicationFile.setFileName(file.getOriginalFilename());
                    applicationFile.setFilePath(fileName);
                    applicationFile.setFileSize(file.getSize());
                    applicationFile.setFileType(file.getContentType());
                    
                    applicationFiles.add(applicationFile);
                } catch (IOException e) {
                    throw new RuntimeException("文件上传失败", e);
                }
            }
            
            applicationFileRepository.saveAll(applicationFiles);
        }
        
        // 创建通知
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setTitle("申请已提交");
        notification.setContent("您的进校园申请已成功提交，请等待审核。");
        notification.setType(Notification.Type.APPLICATION);
        
        notificationRepository.save(notification);
        
        return savedApplication;
    }

    @Transactional
    public Page<Application> getUserApplications(String userPhone, Pageable pageable) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        return applicationRepository.findByUser(user, pageable);
    }

    @Transactional
    public Page<Application> getUserApplicationsByStatus(String userPhone, Application.Status status, Pageable pageable) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        return applicationRepository.findByUserAndStatus(user, status, pageable);
    }

    @Transactional
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("未找到ID为 " + id + " 的申请"));
    }

    @Transactional
    public Application reviewApplication(Long id, Application.Status status, String feedback, String reviewerPhone) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("未找到ID为 " + id + " 的申请"));
        
        User reviewer = userRepository.findByPhone(reviewerPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + reviewerPhone));
        
        application.setStatus(status);
        application.setFeedback(feedback);
        application.setReviewer(reviewer);
        application.setReviewDate(LocalDateTime.now());
        
        Application updatedApplication = applicationRepository.save(application);
        
        // 创建通知
        Notification notification = new Notification();
        notification.setUser(application.getUser());
        notification.setTitle("申请状态更新");
        
        if (status == Application.Status.APPROVED) {
            notification.setContent("您的进校园申请已通过审核。" + (feedback != null ? "审核意见: " + feedback : ""));
        } else if (status == Application.Status.REJECTED) {
            notification.setContent("您的进校园申请未通过审核。" + (feedback != null ? "审核意见: " + feedback : ""));
        }
        
        notification.setType(Notification.Type.REVIEW);
        
        notificationRepository.save(notification);
        
        return updatedApplication;
    }
    @Transactional
    public void cancelApplication(Long id, String userPhone) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("未找到ID为 " + id + " 的申请"));
        
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        if (!application.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("无权取消此申请");
        }
        
        if (application.getStatus() != Application.Status.PENDING) {
            throw new RuntimeException("只能取消待审核的申请");
        }
        
        application.setStatus(Application.Status.CANCELLED);
        applicationRepository.save(application);
    }
    @Transactional
    public List<ApplicationFile> getApplicationFiles(Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("未找到ID为 " + applicationId + " 的申请"));
        
        return applicationFileRepository.findByApplication(application);
    }

    /*@Transactional(readOnly = true)
    public Page<Application> getAllApplications(Pageable pageable) {
        return applicationRepository.findAll(pageable);
    }
    public Page<Application> getApplicationsByStatus(Application.Status status, Pageable pageable) {
        return applicationRepository.findByStatus(status, pageable);
    }*/




    // 确保事务管理
    @Transactional
    public Page<Application> getAllApplications(Pageable pageable) {
        return applicationRepository.findAllWithFilesAndUsers(pageable);
    }

    @Transactional
    public Page<Application> getApplicationsByStatus(Application.Status status, Pageable pageable) {
        return applicationRepository.findByStatusWithFilesAndUsers(status, pageable);
    }

//    @Transactional(readOnly = true)
//    public Page<Application> getAllApplications(Pageable pageable) {
//        return applicationRepository.findAllWithUser(pageable);
//    }


}