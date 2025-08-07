// src/main/java/com/example/boot/controller/RkController.java
package com.example.rk.controller;

import com.example.rk.pojo.ApiResponse;
import com.example.rk.pojo.JoinRequest;
import com.example.rk.pojo.MailUser;
import com.example.rk.service.ClubMemberService;
import com.example.rk.util.SendMailUtils;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/api")
public class RkController {

    private final ClubMemberService clubMemberService;
    @Autowired
    private SpringbootJakartamailApplicationTests springbootJakartamailApplicationTests;

    @Autowired
    public RkController(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }

    @PostMapping("/join")
    public ResponseEntity<ApiResponse> handleJoinRequest(@RequestBody JoinRequest request) {
        System.out.println("request:   "+request);
        ApiResponse response = clubMemberService.handleJoinRequest(request);

        System.out.println("response:   "+response);
        if (response.isSuccess()) {
            System.out.println("response:   "+response);
            System.out.println("ResponseEntity.ok(response):   "+ResponseEntity.ok(response));
            return ResponseEntity.ok(response);
        } else {
            System.out.println("response:   "+response);
            System.out.println("ResponseEntity.badRequest().body(response):   "+ResponseEntity.badRequest().body(response));
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/mail")
    @ResponseBody
    public void MailUserTest(@RequestBody MailUser mailUser) throws jakarta.mail.MessagingException {
        System.out.println("进来了吗？？？");
        springbootJakartamailApplicationTests.testMailB(mailUser);
    }


    @Autowired
    SendMailUtils sendMailUtils;

    @GetMapping("/sendMail")
    public String sendMail(@RequestBody MailUser mailUser) throws UnsupportedEncodingException {
        System.out.println(mailUser);
        if (mailUser.getMess().isEmpty()) {
            String msg = "无告警信息";
        }
        System.out.println("准备发送");

        // 添加发件人姓名（使用RFC 2047编码支持中文）
        String fromAddress = "=?UTF-8?B?" + java.util.Base64.getEncoder().encodeToString("软件项目开发社团".getBytes(StandardCharsets.UTF_8)) + "?= <z13039811650@163.com>";
        sendMailUtils.sendText(mailUser.getSubject(), mailUser.getMess()+"\n"+sendJoinRequestNotice(clubMemberService.selectOneServiceJoinRequest(mailUser.getStuid())), fromAddress, mailUser.getMail());

        System.out.println("发送完成");
        return "ok";
    }


    @GetMapping("/sendMails")
    public String sendMails(@RequestBody MailUser mailUser) throws UnsupportedEncodingException {
        String fromAddress = "=?UTF-8?B?" + java.util.Base64.getEncoder().encodeToString("软件项目开发社团".getBytes(StandardCharsets.UTF_8)) + "?= <z13039811650@163.com>";
        try {
            sendMailUtils.sendTexts("发送带页面格式加文件邮件测试","<p style='color:red;'>红</p>",true, fromAddress,
                    mailUser.getMail(),"软开logo","E:\\code\\boot_CS54k\\boot\\src\\main\\java\\com\\example\\rk\\controller\\logo.png");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }

    public String sendJoinRequestNotice(JoinRequest request) {
        System.out.println(request);
        // 构建HTML邮件内容（使用JoinRequest的get方法获取属性）
        String htmlContent = "" +
                "<html lang='zh-CN'>" +
                "<head>" +
                "   <meta charset='UTF-8'>" +
                "   <title>社团成员新申请通知</title>" +
                "</head>" +
                "<body style='background: #0f1722; font-family: \"Microsoft YaHei\", Arial, sans-serif; color: #fff; padding: 20px;'>" +
                "   <div style='max-width: 640px; margin: 0 auto; background: #1a2636; padding: 30px; border-radius: 12px;'>" +
                "       <h1 style='color: #00ffff; text-align: center;'>新成员申请通知</h1>" +
                "       <div style='border: 1px solid #00ccff; padding: 20px; border-radius: 8px; margin: 20px 0;'>" +
                "           <p style='color: #b3d9ff;'>申请人信息如下：</p>" +
                "           <ul style='list-style: none; padding: 0;'>" +
                "               <li style='margin: 10px 0;'>" +
                "                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>姓名：</span>" +
                "                   <span>" + request.getName() + "</span>" +  // 调用getName()
                "               </li>" +
                "               <li style='margin: 10px 0;'>" +
                "                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>学号：</span>" +
                "                   <span>" + request.getStudentId() + "</span>" +  // 调用getStudentId()
                "               </li>" +
                "               <li style='margin: 10px 0;'>" +
                "                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>专业：</span>" +
                "                   <span>" + request.getMajor() + "</span>" +  // 调用getMajor()
                "               </li>" +
                "               <li style='margin: 10px 0;'>" +
                "                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>电话：</span>" +
                "                   <span>" + request.getPhone() + "</span>" +  // 调用getPhone()
                "               </li>" +
                "               <li style='margin: 10px 0;'>" +
                "                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>邮箱：</span>" +
                "                   <span>" + request.getEmail() + "</span>" +  // 调用getEmail()
                "               </li>" +
                "               <li style='margin: 10px 0;'>" +
                "                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>兴趣：</span>" +
                "                   <span>" + request.getInterest() + "</span>" +  // 调用getInterest()
                "               </li>" +
                "               <li style='margin: 10px 0;'>" +
                "                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>经验：</span>" +
                "                   <span style='white-space: pre-line;'>" + request.getExperience() + "</span>" +  // 调用getExperience()
                "               </li>" +
                "           </ul>" +
                "       </div>" +
                "       <div style='text-align: center; color: #999;'>" +
                "           <p>社团申请服务组 · " + new SimpleDateFormat("yyyy年MM月dd日").format(new Date()) + "</p>" +
                "       </div>" +
                "   </div>" +
                "</body>" +
                "</html>";

        return htmlContent;

        // 假设使用messageHelper设置邮件内容（第二个参数true表示HTML格式）
        // messageHelper.setText(htmlContent, true);
    }
}