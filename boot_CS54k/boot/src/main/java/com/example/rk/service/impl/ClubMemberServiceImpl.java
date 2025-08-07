// src/main/java/com/example/boot/service/impl/ClubMemberServiceImpl.java
package com.example.rk.service.impl;

import com.example.rk.mapper.ClubMemberMapper;
import com.example.rk.pojo.ClubMember;
import com.example.rk.pojo.JoinRequest;
import com.example.rk.pojo.ApiResponse;
import com.example.rk.service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Service
public class ClubMemberServiceImpl implements ClubMemberService {

    private static final String EMAIL_REGEX = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final ClubMemberMapper clubMemberMapper;

    @Autowired
    public ClubMemberServiceImpl(ClubMemberMapper clubMemberMapper) {
        this.clubMemberMapper = clubMemberMapper;
    }

    @Override
    @Transactional
    public ApiResponse handleJoinRequest(JoinRequest request) {
        // 验证必填字段
        if (isNullOrEmpty(request.getName()) || isNullOrEmpty(request.getStudentId()) ||
                isNullOrEmpty(request.getMajor()) || isNullOrEmpty(request.getPhone()) ||
                isNullOrEmpty(request.getEmail()) || isNullOrEmpty(request.getInterest())) {
            return ApiResponse.error("所有必填字段不能为空");
        }

        // 验证邮箱格式
        if (!Pattern.matches(EMAIL_REGEX, request.getEmail())) {
            return ApiResponse.error("邮箱格式不正确");
        }

        // 检查学号是否已存在
        int count = clubMemberMapper.countByStudentId(request.getStudentId());
        if (count > 0) {
            return ApiResponse.error("该学号已提交过申请");
        }

        String s=selectOneServiceId(request.getStudentId());
        System.out.println(s);
        if (!s.equals("学号未注册-审核通过")){
            return ApiResponse.error(s);
        }

        // 转换为实体对象并保存
        ClubMember member = new ClubMember();
        member.setName(request.getName());
        member.setStudentId(request.getStudentId());
        member.setMajor(request.getMajor());
        member.setPhone(request.getPhone());
        member.setEmail(request.getEmail());
        member.setInterest(request.getInterest());
        member.setExperience(request.getExperience());
        member.setSubmitTime(LocalDateTime.now());

        clubMemberMapper.insert(member);
        System.out.println("");

        return ApiResponse.success("申请提交成功").addData("memberId", member.getId());
    }

    @Override
    public String selectOneServiceId(String STU_ID) {
        JoinRequest joinRequest = clubMemberMapper.selectOneIdJR(STU_ID);
        if (joinRequest!=null){
            return "该学号已经被 "+joinRequest.getName()+" 学生注册 请重新输入学号!";
        }
        return "学号未注册-审核通过";
    }

    @Override
    public JoinRequest selectOneServiceJoinRequest(String STU_ID) {
        System.out.println("STU_ID:   "+STU_ID);
        JoinRequest joinRequest = clubMemberMapper.selectOneIdJR(STU_ID);
        System.out.println(joinRequest);
        return joinRequest;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}