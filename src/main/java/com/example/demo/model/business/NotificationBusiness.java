package com.example.demo.model.business;

public interface NotificationBusiness {
    
    void sendNotification(String destination,
                          String title,
                          String body);
}
