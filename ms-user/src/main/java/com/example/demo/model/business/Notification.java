package com.example.demo.model.business;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// COREOGRAFIA DE SERVIÇOS (service choreography)

@Component
public class Notification implements INotification {
    // https://docs.spring.io/spring-boot/reference/io/rest-client.html

    private final RestTemplate rest;

    public Notification(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    @Override
    public void send(String email, String title, String body) {
        System.out.println("Enviando email para " + email + " - " + title + " - " + body);
        rest.postForEntity("http://localhost:8082/api/v1/notification", new NotificationRequest(email, title, body, List.of("email")), Void.class);
    }
    
    static record NotificationRequest (
        String recipient,
        String title,
        String body,
        List<String> media
    ) {

    }
}
