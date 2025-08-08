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
    public ResponseEntity<ApiResponse> handleJoinRequest(@RequestBody JoinRequest request) throws MessagingException, UnsupportedEncodingException {
        System.out.println("request:   "+request);
        ApiResponse response = clubMemberService.handleJoinRequest(request);
        sendMailPost(request);
        //System.out.println("response:   "+response);
        if (response.isSuccess()) {
            //System.out.println("response:   "+response);
            //System.out.println("ResponseEntity.ok(response):   "+ResponseEntity.ok(response));


            return ResponseEntity.ok(response);
        } else {
            //System.out.println("response:   "+response);
            //System.out.println("ResponseEntity.badRequest().body(response):   "+ResponseEntity.badRequest().body(response));
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
    public String sendMail(@RequestBody MailUser mailUser) throws UnsupportedEncodingException, MessagingException {
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

    @PostMapping("/sendMail")
    public ResponseEntity<ApiResponse> sendMailPost(@RequestBody JoinRequest request) throws UnsupportedEncodingException, MessagingException {
        //System.out.println(mailUser);

        ApiResponse response = clubMemberService.handleMail(request);

        //System.out.println("response:   "+response);
        if (response.isSuccess()) {
            //System.out.println("response:   "+response);
            //System.out.println("ResponseEntity.ok(response):   "+ResponseEntity.ok(response));
            return ResponseEntity.ok(response);
        } else {
            //System.out.println("response:   "+response);
            //System.out.println("ResponseEntity.badRequest().body(response):   "+ResponseEntity.badRequest().body(response));
            return ResponseEntity.badRequest().body(response);
        }


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

        // 使用StringBuilder更高效地构建HTML内容
        StringBuilder htmlContent = new StringBuilder();

        // 构建HTML邮件内容
        htmlContent.append("<html lang='zh-CN'>")
                .append("<head>")
                .append("   <meta charset='UTF-8'>")
                .append("   <title>社团成员新申请通知</title>")
                .append("</head>")
                .append("<body style='background: #0f1722; font-family: \"Microsoft YaHei\", Arial, sans-serif; color: #fff; padding: 20px;'>")
                .append("   <div style='max-width: 640px; margin: 0 auto; background: #1a2636; padding: 30px; border-radius: 12px;'>")
                .append("       <h1 style='color: #00ffff; text-align: center;'>新成员申请通知</h1>")
                .append("       <div style='border: 1px solid #00ccff; padding: 20px; border-radius: 8px; margin: 20px 0;'>")
                .append("           <p style='color: #b3d9ff;'>申请人信息如下：</p>")
                .append("           <ul style='list-style: none; padding: 0;'>")
                .append("               <li style='margin: 10px 0;'>")
                .append("                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>姓名：</span>")
                .append("                   <span>").append(escapeHtml(request.getName())).append("</span>")
                .append("               </li>")
                .append("               <li style='margin: 10px 0;'>")
                .append("                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>学号：</span>")
                .append("                   <span>").append(escapeHtml(request.getStudentId())).append("</span>")
                .append("               </li>")
                .append("               <li style='margin: 10px 0;'>")
                .append("                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>专业：</span>")
                .append("                   <span>").append(escapeHtml(request.getMajor())).append("</span>")
                .append("               </li>")
                .append("               <li style='margin: 10px 0;'>")
                .append("                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>电话：</span>")
                .append("                   <span>").append(escapeHtml(request.getPhone())).append("</span>")
                .append("               </li>")
                .append("               <li style='margin: 10px 0;'>")
                .append("                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>邮箱：</span>")
                .append("                   <span>").append(escapeHtml(request.getEmail())).append("</span>")
                .append("               </li>")
                .append("               <li style='margin: 10px 0;'>")
                .append("                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>兴趣：</span>")
                .append("                   <span>").append(escapeHtml(request.getInterest())).append("</span>")
                .append("               </li>")
                .append("               <li style='margin: 10px 0;'>")
                .append("                   <span style='display: inline-block; width: 80px; color: #66ccff; font-weight: bold;'>经验：</span>")
                .append("                   <span style='white-space: pre-line;'>").append(escapeHtml(request.getExperience())).append("</span>")
                .append("               </li>")
                .append("           </ul>")
                .append("       </div>")
                .append("       <div style='text-align: center; color: #999;'>")
                .append("           <p>社团申请服务组 · ").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append("</p>")
                .append("       </div>")
                .append("   </div>")
                .append("</body>")
                .append("</html>");

        return htmlContent.toString();
    }

    // 添加HTML特殊字符转义方法，防止XSS攻击和HTML解析错误
    private String escapeHtml(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

}