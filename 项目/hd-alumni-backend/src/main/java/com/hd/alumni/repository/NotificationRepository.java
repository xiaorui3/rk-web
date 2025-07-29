package com.hd.alumni.repository;

import com.hd.alumni.entity.Notification;
import com.hd.alumni.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    Page<Notification> findByUser(User user, Pageable pageable);
    
    Page<Notification> findByUserAndIsRead(User user, boolean isRead, Pageable pageable);
    
    long countByUserAndIsRead(User user, boolean isRead);
}