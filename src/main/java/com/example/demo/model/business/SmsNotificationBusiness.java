package com.example.demo.model.business;

import org.springframework.stereotype.Component;

@Component("sms-notification")
public class SmsNotificationBusiness implements NotificationBusiness {
    
    @Override
    public void sendNotification(
        String destination, 
        String title, 
        String body) {

        System.out.println("Enviando SMS ...");
        System.out.println(destination);
        System.out.println(title);
        System.out.println(body);

    }
}
