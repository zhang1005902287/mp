package com.zsq.mp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void sendSimpleMessage(){
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setSubject("通知 - 今晚开会");
        simpleMessage.setText("哈哈哈");
        simpleMessage.setTo("1178572568@qq.com");
        simpleMessage.setFrom("1005902287@qq.com");
        javaMailSender.send(simpleMessage);
    }

    public void sendMimeMessage() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //第二个参数为Boolean mulipart ,是否能够发文件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("你好啊");
        helper.setText("<b style='color:red;'>我是你爸爸</b>",true);
        helper.setTo("1228638181@qq.com");
        helper.setFrom("1005902287@qq.com");
        helper.addAttachment("帅照", new File("C:\\Users\\10059\\Desktop\\1.png"));
        javaMailSender.send(mimeMessage);
    }
}
