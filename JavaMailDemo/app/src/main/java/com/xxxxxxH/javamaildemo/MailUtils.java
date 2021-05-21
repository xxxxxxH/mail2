package com.xxxxxxH.javamaildemo;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Copyright (C) 2021,2021/5/21, a Tencent company. All rights reserved.
 *
 * User : v_xhangxie
 *
 * Desc :
 */
public class MailUtils {
    private static MailUtils instance = null;

    private String host = "smtp.qq.com";
    private String from = "425270071@qq.com";
    private String myPwd = "jyocovmnqqwsbhda";
    private String to = "15680609620@163.com";

    private MailUtils(){

    }

    public static MailUtils getInstance() {
        if (instance == null){
            instance = new MailUtils();
        }
        return instance;
    }

    public void setUpServerAndSelfInfo() throws MessagingException {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, null);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(from);
        msg.setRecipients(Message.RecipientType.TO, to);
        msg.setSubject("标题");
        msg.setSentDate(new Date());
        msg.setText("你好!\n这里是来自ubt的信息");
        Transport.send(msg, from, myPwd);
    }
}
