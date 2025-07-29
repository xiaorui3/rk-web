package com.hd.alumni.service;

import com.hd.alumni.entity.Notification;
import com.hd.alumni.entity.User;
import com.hd.alumni.repository.NotificationRepository;
import com.hd.alumni.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public Page<Notification> getUserNotifications(String userPhone, Pageable pageable) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        return notificationRepository.findByUser(user, pageable);
    }

    public Page<Notification> getUnreadNotifications(String userPhone, Pageable pageable) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        return notificationRepository.findByUserAndIsRead(user, false, pageable);
    }

    public long countUnreadNotifications(String userPhone) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        return notificationRepository.countByUserAndIsRead(user, false);
    }

    @Transactional
    public Notification markAsRead(Long notificationId, String userPhone) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("未找到ID为 " + notificationId + " 的通知"));
        
        // 检查通知是否属于当前用户
        if (!notification.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("无权访问此通知");
        }
        
        notification.setIsRead(true);
        return notificationRepository.save(notification);
    }

    @Transactional
    public void markAllAsRead(String userPhone) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        Page<Notification> unreadNotifications = notificationRepository.findByUserAndIsRead(user, false, Pageable.unpaged());
        
        unreadNotifications.forEach(notification -> {
            notification.setIsRead(true);
            notificationRepository.save(notification);
        });
    }

    @Transactional
    public Notification createNotification(String userPhone, String title, String content, Notification.Type type) {
        User user = userRepository.findByPhone(userPhone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + userPhone));
        
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setTitle(title);
        notification.setContent(content);
        notification.setType(type);
        
        return notificationRepository.save(notification);
    }
}