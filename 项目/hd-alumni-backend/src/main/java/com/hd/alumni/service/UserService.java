package com.hd.alumni.service;

import com.hd.alumni.entity.User;
import com.hd.alumni.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String avatarUploadPath;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.avatarUploadPath = "./uploads/avatars/";
        
        // 确保上传目录存在
        try {
            Files.createDirectories(Paths.get(avatarUploadPath));
        } catch (IOException e) {
            throw new RuntimeException("无法创建头像上传目录", e);
        }
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + email));
    }
    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户: " + phone));
    }

    public User updateUserProfile(String phone, User updatedUser) {
        User user = getUserByPhone(phone);
        
        // 更新基本信息
        user.setName(updatedUser.getName());
        user.setPhone(updatedUser.getPhone());
        user.setCurrentJob(updatedUser.getCurrentJob());
        user.setStudentId(updatedUser.getStudentId());
        user.setCompany(updatedUser.getCompany());
        user.setAddress(updatedUser.getAddress());
        user.setBio(updatedUser.getBio());
        
        // 保存更新
        return userRepository.save(user);
    }

    public User updateUserAvatar(String phone, MultipartFile avatarFile) {
        User user = getUserByPhone(phone);
        
        try {
            // 生成唯一文件名
            String fileName = UUID.randomUUID().toString() + "_" + avatarFile.getOriginalFilename();
            Path targetLocation = Paths.get(avatarUploadPath + fileName);
            
            // 保存文件
            Files.copy(avatarFile.getInputStream(), targetLocation);
            
            // 更新用户头像URL
            user.setAvatarUrl("/uploads/avatars/" + fileName);
            
            // 保存更新
            return userRepository.save(user);
        } catch (IOException e) {
            throw new RuntimeException("头像上传失败", e);
        }
    }

    public void changePassword(String phone, String currentPassword, String newPassword) {
        User user = getUserByPhone(phone);
        
        // 验证当前密码
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new RuntimeException("当前密码不正确");
        }
        
        // 更新密码
        user.setPassword(passwordEncoder.encode(newPassword));
        
        // 保存更新
        userRepository.save(user);
    }
}