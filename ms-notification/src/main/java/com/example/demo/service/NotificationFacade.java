package com.example.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.NotificationDTO;

@Service
public class NotificationFacade {

    private final 
    Map<String, NotificationService> notificationServices;

    public NotificationFacade(
        Map<String, NotificationService> notificationServices) {
        this.notificationServices = notificationServices;
    }

    public void sendNotification(NotificationDTO notification) {
        
        notification.media().stream()
            .map(media -> media + "-notification")
            .forEach(service -> {
                if (notificationServices.containsKey(service)) {
                    notificationServices.get(service)
                        .sendNotification(
                            notification.recipient(), notification.title(), 
                            notification.body());
                }
            });

    }
    
}
