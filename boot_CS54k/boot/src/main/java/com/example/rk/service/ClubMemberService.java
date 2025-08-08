// src/main/java/com/example/boot/service/ClubMemberService.java
package com.example.rk.service;

import com.example.rk.pojo.JoinRequest;
import com.example.rk.pojo.ApiResponse;
import jakarta.mail.MessagingException;

public interface ClubMemberService {
    ApiResponse handleJoinRequest(JoinRequest request);

    String selectOneServiceId(String STU_ID);


    JoinRequest selectOneServiceJoinRequest(String STU_ID);

    ApiResponse handleMail(JoinRequest request) throws MessagingException;
}