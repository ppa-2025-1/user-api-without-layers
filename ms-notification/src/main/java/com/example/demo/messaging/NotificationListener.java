package com.example.demo.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.service.NotificationFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Qual a diferença de um Listener e um Observer?
// Conceitualmente, NENHUMA.

@Component
public class NotificationListener {
    
    private static final Logger logger =
        LoggerFactory.getLogger(NotificationListener.class.getName());

    private final ObjectMapper mapper;
    private final NotificationFacade notificationFacade;
// vibe coding
    public NotificationListener(
        ObjectMapper mapper,
        NotificationFacade notificationFacade) {
        this.mapper = mapper;
        this.notificationFacade = notificationFacade;
    }

    @RabbitListener(queues = { "usuario-queue" })
    public void newNotification(String payload) {
        
        final NotificationDTO notification;
        try {
            notification = mapper.readValue(payload, NotificationDTO.class);
            
            logger.info(
                "Notificação Recebida",
                notification);

            notificationFacade
                .sendNotification(notification);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

}
