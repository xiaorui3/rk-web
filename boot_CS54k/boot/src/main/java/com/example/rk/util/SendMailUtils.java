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

    public String sendJoinRequestNotice(JoinRequest request,String name) {
        //System.out.println(request);

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
                .append("           <p style='color: #4a5568; font-size: 16px; margin-top: 0;'>尊敬的负责人 ").append(escapeHtml(name)).append(" ，您好：</p>")
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
                .append("           <p style='margin: 5px 0;'>软件项目开发人力资源部(啥时候能创建一个[旺柴])</p>")
                .append("           <p style='margin: 5px 0;'>").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append("</p>")
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


    public String sendJoinRequestNoticeUser(JoinRequest request) {
        System.out.println("生成用户欢迎邮件: " + request);

        // 使用StringBuilder构建HTML内容
        StringBuilder htmlContent = new StringBuilder();

        // 构建HTML邮件内容 - 友好、积极的风格
        htmlContent.append("<html lang='zh-CN'>")
                .append("<head>")
                .append("   <meta charset='UTF-8'>")
                .append("   <meta name='viewport' content='width=device-width, initial-scale=1.0'>")
                .append("   <title>欢迎加入软件项目开发社团</title>")
                .append("</head>")
                .append("<body style='background: #f9f9f9; font-family: \"Microsoft YaHei\", Arial, sans-serif; color: #333; padding: 20px; line-height: 1.8;'>")
                .append("   <div style='max-width: 680px; margin: 0 auto; background: #ffffff; padding: 40px; border-radius: 10px; box-shadow: 0 3px 15px rgba(0,0,0,0.05);'>")
                // 标题区域
                .append("       <div style='text-align: center; margin-bottom: 30px;'>")
                .append("           <h1 style='color: #28a745; margin: 0; font-size: 26px;'>欢迎加入软件项目开发社团！</h1>")
                .append("           <div style='width: 80px; height: 3px; background: #28a745; margin: 15px auto 0;'></div>")
                .append("       </div>")
                // 主要内容区域
                .append("       <div style='padding: 10px 0;'>")
                .append("           <p style='font-size: 16px; margin: 0 0 15px;'>亲爱的 <span style='font-weight: bold; color: #2d3748;'>").append(escapeHtml(request.getName())).append("</span> 同学：</p>")
                .append("           <p style='font-size: 16px; margin: 0 0 15px;'>您好！非常高兴地通知您，您的软件项目开发社团加入申请已收到，我们会尽快进行审核。</p>")
                .append("           <p style='font-size: 16px; margin: 0 0 20px;'>以下是您的申请信息，请确认：</p>")
                // 申请信息摘要
                .append("           <div style='background: #f8fff8; border-left: 4px solid #28a745; padding: 15px; margin: 20px 0; border-radius: 0 4px 4px 0;'>")
                .append("               <p style='margin: 0 0 10px;'><span style='font-weight: bold;'>学号：</span>").append(escapeHtml(request.getStudentId())).append("</p>")
                .append("               <p style='margin: 0 0 10px;'><span style='font-weight: bold;'>专业：</span>").append(escapeHtml(request.getMajor())).append("</p>")
                .append("               <p style='margin: 0;'><span style='font-weight: bold;'>联系邮箱：</span>").append(escapeHtml(request.getEmail())).append("</p>")
                .append("           </div>")
                // 后续流程说明
                .append("           <p style='font-size: 16px; margin: 0 0 15px;'>审核结果将在3个工作日内通过邮件通知您，请留意查收。</p>")
                .append("           <p style='font-size: 16px; margin: 0 0 15px;'>如有任何疑问，欢迎联系我们：</p>")
                .append("           <p style='font-size: 16px; margin: 0 0 25px;'><span style='font-weight: bold;'>社长韩驰邮箱：</span>ruimeilademaye@163.com</p>")
                .append("           <p style='font-size: 16px; margin: 0;'>期待您的加入，一起在软件项目开发的世界里探索与成长！</p>")

/*                // 邮箱由谁收到
                .append("           <div style='background: #f8fff8; border-left: 4px solid #28a745; padding: 15px; margin: 20px 0; border-radius: 0 4px 4px 0;'>")
                .append("           <p style='font-size: 16px; margin: 0 0 15px;'>您的邮箱由他们收到并进行审核</p>")
                .append("               <p style='margin: 0 0 10px;'><span style='font-weight: bold;'>学号：</span>").append(escapeHtml(request.getStudentId())).append("</p>")
                .append("               <p style='margin: 0 0 10px;'><span style='font-weight: bold;'>专业：</span>").append(escapeHtml(request.getMajor())).append("</p>")
                .append("               <p style='margin: 0;'><span style='font-weight: bold;'>联系邮箱：</span>").append(escapeHtml(request.getEmail())).append("</p>")
                .append("           </div>")*/
                .append("       </div>")
                // 页脚信息
                .append("       <div style='text-align: center; color: #6c757d; padding-top: 30px; margin-top: 30px; border-top: 1px dashed #e9ecef;'>")
                .append("           <p style='margin: 0 0 5px;'>软件项目开发社团 敬上</p>")
                .append("           <p style='margin: 0 0 5px;'>软件项目开发社团地址：探知楼B419</p>")
                .append("           <p style='margin: 0;'>").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append("</p>")
                .append("       </div>")
                .append("   </div>")
                .append("</body>")
                .append("</html>");

        return htmlContent.toString();
    }



}
