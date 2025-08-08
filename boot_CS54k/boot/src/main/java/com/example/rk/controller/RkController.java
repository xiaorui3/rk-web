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

        // 构建HTML邮件内容 - 学术风格，明亮大气
        htmlContent.append("<html lang='zh-CN'>")
                .append("<head>")
                .append("   <meta charset='UTF-8'>")
                .append("   <meta name='viewport' content='width=device-width, initial-scale=1.0'>")
                .append("   <title>社团成员新申请通知</title>")
                .append("</head>")
                .append("<body style='background: #f5f7fa; font-family: \"Times New Roman\", Georgia, serif; color: #333; padding: 20px; line-height: 1.6;'>")
                .append("   <div style='max-width: 720px; margin: 0 auto; background: #ffffff; padding: 40px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);'>")
                // 学术风格标题栏
                .append("       <div style='border-bottom: 3px solid #2c5282; padding-bottom: 15px; margin-bottom: 30px;'>")
                .append("           <h1 style='color: #2c5282; text-align: center; margin: 0; font-size: 24px;'>新成员申请通知</h1>")
                .append("       </div>")
                // 主要内容区域
                .append("       <div style='border: 1px solid #e2e8f0; padding: 30px; border-radius: 6px; margin-bottom: 30px; background-color: #f8fafc;'>")
                .append("           <p style='color: #4a5568; font-size: 16px; margin-top: 0;'>尊敬的负责人，您好：</p>")
                .append("           <p style='color: #4a5568; font-size: 16px;'>有新成员申请加入社团，申请人信息如下：</p>")
                .append("           <table style='width: 100%; border-collapse: collapse; margin-top: 20px;'>")
                // 申请人信息表格 - 学术风格常用表格布局
                .append("               <tr style='border-bottom: 1px solid #e2e8f0;'>")
                .append("                   <td style='padding: 12px 10px; width: 25%; font-weight: bold; color: #2d3748; background-color: #edf2f7;'>姓名：</td>")
                .append("                   <td style='padding: 12px 10px; color: #4a5568;'>").append(escapeHtml(request.getName())).append("</td>")
                .append("               </tr>")
                .append("               <tr style='border-bottom: 1px solid #e2e8f0;'>")
                .append("                   <td style='padding: 12px 10px; width: 25%; font-weight: bold; color: #2d3748; background-color: #edf2f7;'>学号：</td>")
                .append("                   <td style='padding: 12px 10px; color: #4a5568;'>").append(escapeHtml(request.getStudentId())).append("</td>")
                .append("               </tr>")
                .append("               <tr style='border-bottom: 1px solid #e2e8f0;'>")
                .append("                   <td style='padding: 12px 10px; width: 25%; font-weight: bold; color: #2d3748; background-color: #edf2f7;'>专业：</td>")
                .append("                   <td style='padding: 12px 10px; color: #4a5568;'>").append(escapeHtml(request.getMajor())).append("</td>")
                .append("               </tr>")
                .append("               <tr style='border-bottom: 1px solid #e2e8f0;'>")
                .append("                   <td style='padding: 12px 10px; width: 25%; font-weight: bold; color: #2d3748; background-color: #edf2f7;'>电话：</td>")
                .append("                   <td style='padding: 12px 10px; color: #4a5568;'>").append(escapeHtml(request.getPhone())).append("</td>")
                .append("               </tr>")
                .append("               <tr style='border-bottom: 1px solid #e2e8f0;'>")
                .append("                   <td style='padding: 12px 10px; width: 25%; font-weight: bold; color: #2d3748; background-color: #edf2f7;'>邮箱：</td>")
                .append("                   <td style='padding: 12px 10px; color: #4a5568;'>").append(escapeHtml(request.getEmail())).append("</td>")
                .append("               </tr>")
                .append("               <tr style='border-bottom: 1px solid #e2e8f0;'>")
                .append("                   <td style='padding: 12px 10px; width: 25%; font-weight: bold; color: #2d3748; background-color: #edf2f7;'>兴趣：</td>")
                .append("                   <td style='padding: 12px 10px; color: #4a5568;'>").append(escapeHtml(request.getInterest())).append("</td>")
                .append("               </tr>")
                .append("               <tr>")
                .append("                   <td style='padding: 12px 10px; width: 25%; font-weight: bold; color: #2d3748; background-color: #edf2f7; vertical-align: top;'>经验：</td>")
                .append("                   <td style='padding: 12px 10px; color: #4a5568; white-space: pre-line;'>").append(escapeHtml(request.getExperience())).append("</td>")
                .append("               </tr>")
                .append("           </table>")
                .append("       </div>")
                // 页脚信息
                .append("       <div style='text-align: center; color: #718096; padding-top: 20px; border-top: 1px solid #e2e8f0;'>")
                .append("           <p style='margin: 5px 0;'>软件项目开发社团人力资源部(啥时候创建一个这个[旺柴])</p>")
                .append("           <p style='margin: 5px 0;'>").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append("</p>")
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