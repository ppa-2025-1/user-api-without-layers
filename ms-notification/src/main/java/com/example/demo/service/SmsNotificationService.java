package com.example.demo.service;

import org.springframework.stereotype.Component;

// sem visibilidade, package private (default)
// privado do pacote
@Component("sms-notification")
class SmsNotificationService
    implements NotificationService {
    
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
