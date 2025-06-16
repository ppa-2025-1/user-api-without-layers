package com.example.demo.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component("mail-notification")
class MailNotificationService implements NotificationService {
    
    private final MailSender mailSender;

    public MailNotificationService(MailSender mailSender) {
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
        System.out.println("Sending mail to " + destination + " with title: " + title + " and body: " + body);
        mailSender.send(message);

    }
}
