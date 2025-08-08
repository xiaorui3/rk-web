package com.example.rk.util;


import com.example.rk.pojo.JoinRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SendMailUtils {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Autowired
    private JavaMailSender mailSender;

    public  void sendText(String Subject, String Text, String setFrom, String setTo) throws MessagingException {
        //SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //simpleMailMessage.setSubject(Subject);//标题
        //simpleMailMessage.setText(Text);//内容
        //simpleMailMessage.setFrom(setFrom);//发送人邮箱
        //simpleMailMessage.setTo(setTo);//发送目的地邮箱
        ////message.setContent(htmlContent, "text/html; charset=utf-8");
        //javaMailSender.send(simpleMailMessage);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom("z13039811650@163.com");
        messageHelper.setTo(setTo);
        messageHelper.setSubject(Subject);
        messageHelper.setText(Text,true);
        mailSender.send(mimeMessage);
    }

    public  void sendTextRk(String Subject, String Text, String setFrom, String setTo, JoinRequest request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(Subject);//标题
        simpleMailMessage.setText(Text);//内容
        simpleMailMessage.setFrom(setFrom);//发送人邮箱
        simpleMailMessage.setTo(setTo);//发送目的地邮箱
        javaMailSender.send(simpleMailMessage);
    }

    //发送带页面格式加文件邮件
    public  void sendTexts(String Subject, String Text,Boolean t, String setFrom, String setTo
            ,String attachmentFilename,String filePathName) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setSubject(Subject);//标题
        helper.setText(Text,t);//内容
        helper.setFrom(setFrom);//发送人邮箱
        helper.setTo(setTo);//目的地邮箱
        helper.addAttachment(attachmentFilename,new File(filePathName));  //图片路径
        javaMailSender.send(mimeMessage);
    }

    public String sendJoinRequestNotice(JoinRequest request) {
        //System.out.println(request);

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
