package com.example.rk.controller;

import com.example.rk.pojo.MailUser;
import jakarta.mail.internet.MimeMessage;
import org.junit.Test;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.io.*;


@Component
public class SpringbootJakartamailApplicationTests {

    //注入邮件发送对象
    @Autowired
    private JavaMailSender mailSender;

    private static final Long IDENTIFICATION_TIMEOUT = 5L;
    //private final Logger logger = LoggerFactory.getLogger(ResponseTimeManager.class);

    boolean testMailB(MailUser mailUser) throws  jakarta.mail.MessagingException {
        //创建复杂有限发送对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom("3505469466@qq.com");           // 设置发件人邮箱（若配置默认邮箱则不用再设置）
        messageHelper.setTo(mailUser.getMail());            // 设置收件人邮箱
        //messageHelper.setCc("xiaofeng500@qq.com");            // 设置抄报人邮箱（可以不填写）
        //messageHelper.setBcc("575814158@qq.com");             // 设置密送人邮箱（可以不填写）
        messageHelper.setSubject(mailUser.getSubject());                  // 设置邮件主题

        //获取项目资源根目录 resources/file  并准备资源
        //String rootPath = Objects.requireNonNull(SpringbootJakartamailApplicationTests.class.getClassLoader().getResource("file")).getFile();
        //FileSystemResource png = new FileSystemResource(new File(rootPath + "/ab.png"));
        //FileSystemResource xls = new FileSystemResource(new File(rootPath + "/student.xls"));
        //FileSystemResource mp3 = new FileSystemResource(new File(rootPath + "/mu.mp3"));
        //FileSystemResource zip = new FileSystemResource(new File(rootPath + "/redis.zip"));
//
        //关于附件  资源  HTML 文本的设置
        //设置附件
        //设置一个 图片附件
        //messageHelper.addAttachment(Objects.requireNonNull(png.getFilename()), png);
        ////设置一个 excel附件
        //messageHelper.addAttachment(Objects.requireNonNull(xls.getFilename()), xls);
        ////设置一个 mp3附件
        //messageHelper.addAttachment(Objects.requireNonNull(mp3.getFilename()), mp3);
        ////设置一个 zip附件  不过发送垃圾附件可能会被识别 554 HL:IHU 发信IP因发送垃圾邮件或存在异常的连接行为
        //messageHelper.addAttachment(Objects.requireNonNull(zip.getFilename()), zip);

        //设置邮件内容   cid:资源id     在内容中引用资源    后面true代表是html内容
        messageHelper.setText("<h2 style='color:#f00;'>欠费通知：您已欠费200元<img src='cid:p01' alt='' style='width:200px;height:50px;'></h2>", true);

        //设置资源
        //FileSystemResource resPng = new FileSystemResource(new File(rootPath + "/b.png"));
        //messageHelper.addInline("p01",resPng);
//
        //发送
        try{

            mailSender.send(mimeMessage);
            System.out.println("发送成功");
            return true;
        }catch (Exception e){
            return false;
        }
    }
}