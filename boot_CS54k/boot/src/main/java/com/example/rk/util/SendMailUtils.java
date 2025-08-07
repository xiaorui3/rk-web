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




}
