package com.example.demo.model.business;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component("email-notification")
public class MailNotificationBusiness implements NotificationBusiness {
    
    private final MailSender mailSender;

    public MailNotificationBusiness(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendNotification(
        String destination, 
        String title, 
        String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(title);
        message.setTo(destination);
        message.setText(body);

        mailSender.send(message);

    }
}
