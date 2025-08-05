package com.example.boot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_attendance")
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Enumerated(EnumType.STRING)  // 这个注解只保留在枚举字段上
    private AttendanceStatus status;

    @Column(name = "last_checkin_time")  // 移除了@Enumerated注解
    private LocalDateTime lastCheckinTime;

    @Column(name = "last_checkout_time") // 移除了@Enumerated注解
    private LocalDateTime lastCheckoutTime;

    @Getter
    public enum AttendanceStatus {
        CHECKED_IN("checked-in"),
        CHECKED_OUT("checked-out");

        private final String dbValue;

        AttendanceStatus(String dbValue) {
            this.dbValue = dbValue;
        }

        public static AttendanceStatus fromDbValue(String dbValue) {
            for (AttendanceStatus status : values()) {
                if (status.dbValue.equals(dbValue)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Unknown database value: " + dbValue);
        }
    }
}