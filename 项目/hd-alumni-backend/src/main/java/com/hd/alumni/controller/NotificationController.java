package com.hd.alumni.controller;

import com.hd.alumni.entity.Notification;
import com.hd.alumni.payload.response.ApiResponse;
import com.hd.alumni.payload.response.NotificationResponse;
import com.hd.alumni.payload.response.PagedResponse;
import com.hd.alumni.service.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<?> getUserNotifications(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "unreadOnly", defaultValue = "false") boolean unreadOnly,
            @AuthenticationPrincipal UserDetails userDetails) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Notification> notifications;
        
        if (unreadOnly) {
            notifications = notificationService.getUnreadNotifications(userDetails.getUsername(), pageable);
        } else {
            notifications = notificationService.getUserNotifications(userDetails.getUsername(), pageable);
        }
        
        List<NotificationResponse> content = notifications.getContent().stream()
                .map(this::convertToNotificationResponse)
                .collect(Collectors.toList());
        
        PagedResponse<NotificationResponse> response = new PagedResponse<>(
                content,
                notifications.getNumber(),
                notifications.getSize(),
                notifications.getTotalElements(),
                notifications.getTotalPages(),
                notifications.isLast()
        );
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getUnreadCount(@AuthenticationPrincipal UserDetails userDetails) {
        long count = notificationService.countUnreadNotifications(userDetails.getUsername());
        return ResponseEntity.ok(count);
    }

    @PostMapping("/{id}/read")
    public ResponseEntity<?> markAsRead(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        notificationService.markAsRead(id, userDetails.getUsername());
        return ResponseEntity.ok(new ApiResponse(true, "通知已标记为已读"));
    }

    @PostMapping("/read-all")
    public ResponseEntity<?> markAllAsRead(@AuthenticationPrincipal UserDetails userDetails) {
        notificationService.markAllAsRead(userDetails.getUsername());
        return ResponseEntity.ok(new ApiResponse(true, "所有通知已标记为已读"));
    }

    private NotificationResponse convertToNotificationResponse(Notification notification) {
        NotificationResponse response = new NotificationResponse();
        response.setId(notification.getId());
        response.setTitle(notification.getTitle());
        response.setContent(notification.getContent());
        response.setType(notification.getType().name());
        response.setRead(notification.getIsRead());
        response.setCreatedAt(notification.getCreatedAt().toString());
        return response;
    }
}