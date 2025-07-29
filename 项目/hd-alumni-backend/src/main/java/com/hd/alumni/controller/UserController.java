package com.hd.alumni.controller;

import com.hd.alumni.entity.User;
import com.hd.alumni.payload.request.ChangePasswordRequest;
import com.hd.alumni.payload.request.UpdateProfileRequest;
import com.hd.alumni.payload.response.ApiResponse;
import com.hd.alumni.payload.response.UserProfileResponse;
import com.hd.alumni.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.getUserByPhone(userDetails.getUsername());
        return ResponseEntity.ok(convertToUserProfileResponse(user));
    }

    @PutMapping("/profile")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') ")
    public ResponseEntity<?> updateProfile(
            @Valid @RequestBody UpdateProfileRequest updateProfileRequest,
            @AuthenticationPrincipal UserDetails userDetails) {
        
        User updatedUser = new User();
        updatedUser.setName(updateProfileRequest.getName());
        updatedUser.setPhone(updateProfileRequest.getPhone());
        updatedUser.setStudentId(updateProfileRequest.getStudentId());
        updatedUser.setCurrentJob(updateProfileRequest.getCurrentJob());
        updatedUser.setCompany(updateProfileRequest.getCompany());
        updatedUser.setAddress(updateProfileRequest.getAddress());
        updatedUser.setBio(updateProfileRequest.getBio());
        
        User result = userService.updateUserProfile(userDetails.getUsername(), updatedUser);
        System.out.println( result);
        return ResponseEntity.ok(new ApiResponse(true, "个人信息更新成功"));
    }

    @PostMapping("/me/avatar")
    public ResponseEntity<?> updateAvatar(
            @RequestParam("avatar") MultipartFile avatarFile,
            @AuthenticationPrincipal UserDetails userDetails) {
        
        User result = userService.updateUserAvatar(userDetails.getUsername(), avatarFile);
        
        return ResponseEntity.ok(new ApiResponse(true, "头像更新成功"));
    }

    @PostMapping("/change-password")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') ")
    public ResponseEntity<?> changePassword(
            @Valid @RequestBody ChangePasswordRequest changePasswordRequest,
            @AuthenticationPrincipal UserDetails userDetails) {

//        System.out.println("ud"+userDetails);
//        System.out.println("cpr"+changePasswordRequest);

//        System.out.println(changePasswordRequest.getOldPassword());
//        System.out.println(changePasswordRequest.getNewPassword());
        userService.changePassword(
                userDetails.getUsername(),
                changePasswordRequest.getOldPassword(),
                changePasswordRequest.getNewPassword()
        );
        
        return ResponseEntity.ok(new ApiResponse(true, "密码修改成功"));
    }

    private UserProfileResponse convertToUserProfileResponse(User user) {
        UserProfileResponse response = new UserProfileResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setStudentId(user.getStudentId());
        response.setGraduationYear(user.getGraduationYear());
        response.setMajor(user.getMajor());
        response.setCurrentJob(user.getCurrentJob());
        response.setCompany(user.getCompany());
        response.setAddress(user.getAddress());
        response.setBio(user.getBio());
        response.setAvatarUrl(user.getAvatarUrl());
        response.setRole(user.getRole().name());
        response.setEmailVerified(user.getEmailVerified());
        response.setPhoneVerified(user.getPhoneVerified());
        return response;
    }
}