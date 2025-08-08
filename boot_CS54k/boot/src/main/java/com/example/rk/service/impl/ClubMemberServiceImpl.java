// src/main/java/com/example/boot/service/impl/ClubMemberServiceImpl.java
package com.example.rk.service.impl;

import com.example.rk.mapper.ClubMemberMapper;
import com.example.rk.pojo.ClubMember;
import com.example.rk.pojo.JoinRequest;
import com.example.rk.pojo.ApiResponse;
import com.example.rk.pojo.MailUser;
import com.example.rk.service.ClubMemberService;
import com.example.rk.util.SendMailUtils;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

@Service
public class ClubMemberServiceImpl implements ClubMemberService {

    private static final String EMAIL_REGEX = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final ClubMemberMapper clubMemberMapper;


    //@Autowired
    //private MailUser mailUser;


    @Autowired
    private SendMailUtils sendMailUtils;

    @Autowired
    private ThreadPoolTaskExecutor emailTaskExecutor;


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
        //System.out.println("");

        return ApiResponse.success("申请提交成功 审核结果将在三日后发邮件通知").addData("memberId", member.getId());
    }

    @Override
    @Transactional
    public ApiResponse handleMail(JoinRequest request) throws MessagingException {
        /// 新用户发送

        String email = request.getEmail();
        String msg="";
        String subject="欢迎 "+request.getName()+" 同学加入软件项目开发社团";
        String fromAddress = "=?UTF-8?B?" + java.util.Base64.getEncoder().encodeToString("软件项目开发社团".getBytes(StandardCharsets.UTF_8)) + "?= <z13039811650@163.com>";

        sendMailUtils.sendText(subject, msg +"\n"+sendMailUtils.sendJoinRequestNoticeUser(request), fromAddress, email);

        ///  社团人员 发送
        msg="";
        subject="新社员入社提醒--软件项目开发社团";
        fromAddress = "=?UTF-8?B?" + java.util.Base64.getEncoder().encodeToString("软件项目开发社团".getBytes(StandardCharsets.UTF_8)) + "?= <z13039811650@163.com>";
        //ArrayList<String> arr=new ArrayList<>();
        HashMap<String,String> map=new HashMap<>();
        map.put("3505469466@qq.com","赵锐");
        map.put("ruimeilademaye@163.com","韩驰");
        map.put("2148906016@qq.com","马鹏博");
        map.put("lxy521521456@163.com","刘晓雨");
        map.put("w87027619332@163.com","郑志远");

        //arr.add("3505469466@qq.com");
        //arr.add("ruimeilademaye@163.com");
        //arr.add("2148906016@qq.com");
        //arr.add("lxy521521456@163.com");
        //arr.add("w87027619332@163.com");
        String finalSubject1 = subject;
        String finalMsg1 = msg;
        String finalFromAddress1 = fromAddress;
        map.forEach((s, e)->{
            emailTaskExecutor.execute(() -> {
                System.out.println(e+" 的邮箱"+s+"准备发送");
                try {
                    sendMailUtils.sendText(finalSubject1, finalMsg1 +"\n"+sendMailUtils.sendJoinRequestNotice(request,e), finalFromAddress1, s);
                } catch (MessagingException e1) {
                    throw new RuntimeException(e1);
                }
                System.out.println(e+" 的邮箱"+s+"发送完成");
            });
        });
        /*for (int i = 0; i < map.size(); i++) {
            int finalI = i;
            String finalSubject = subject;
            String finalMsg = msg;
            String finalFromAddress = fromAddress;
            emailTaskExecutor.execute(() -> {
                System.out.println(map.get(finalI)+" 准备发送");
                try {
                    sendMailUtils.sendText(finalSubject, finalMsg +"\n"+sendMailUtils.sendJoinRequestNotice(request), finalFromAddress, arr.get(finalI));
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(arr.get(finalI)+" 发送完成");
            });
        }*/
        //handleMail2(request,mail2);
        return ApiResponse.success("ok! 发送成功").addData("memberId", request.getStudentId());
    }

    //public void handleMail2(JoinRequest request,String mail) throws MessagingException {
    //    String msg="";
    //    String subject="新社员入社提醒--软件项目开发社团";
    //    System.out.println(mail+" 准备发送");
    //    String fromAddress = "=?UTF-8?B?" + java.util.Base64.getEncoder().encodeToString("软件项目开发社团".getBytes(StandardCharsets.UTF_8)) + "?= <z13039811650@163.com>";
    //    sendMailUtils.sendText(subject, msg+"\n"+sendMailUtils.sendJoinRequestNotice(request), fromAddress, mail);
    //    System.out.println(mail+" 发送完成");
    //}

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