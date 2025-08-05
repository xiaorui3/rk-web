package com.example.boot.controller;

import com.example.boot.entity.Member;
import com.example.boot.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(attendanceService.getAllMembers());
    }

    @GetMapping("/members/search")
    public ResponseEntity<List<Member>> searchMembers(@RequestParam String keyword) {
        return ResponseEntity.ok(attendanceService.searchMembers(keyword));
    }

    @PostMapping("/checkin")
    public ResponseEntity<Void> checkInMembers(@RequestBody List<Integer> memberIds) {
        attendanceService.checkInMembers(memberIds);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/checkout")
    public ResponseEntity<Void> checkOutMembers(@RequestBody List<Integer> memberIds) {
        attendanceService.checkOutMembers(memberIds);
        return ResponseEntity.ok().build();
    }

    public class CheckRequest {
        private List<Long> userIds;
        private Member.AttendanceStatus status; // 直接映射枚举

        public List<Long> getUserIds() {
            return userIds;
        }

        public void setUserIds(List<Long> userIds) {
            this.userIds = userIds;
        }

        public Member.AttendanceStatus getStatus() {
            return status;
        }

        public void setStatus(Member.AttendanceStatus status) {
            this.status = status;
        }
        // getters/setters
    }
}