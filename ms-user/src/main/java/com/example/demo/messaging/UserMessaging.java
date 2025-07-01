package com.example.demo.messaging;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// ELETRONIC DATA INTERCHANGE (EDI)
// ARQUIVOS DE COLUNA FIXA
// codigo 8 nome 30 caracteres conta 5
// 00000002Marcio Josue Ramos Torres     34455-2

@Component
public class UserMessaging {

    private final RabbitTemplate rabbitTemplate;
    private final Exchange exchange;
    private final ObjectMapper mapper;
    
    // injeção de dependência
    public UserMessaging(RabbitTemplate rabbitTemplate,
                         Exchange exchange,
                         ObjectMapper mapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.mapper = mapper;
    }


    public void sendNotification( // defensive programming
        final Notification notification) {

        final MessageProperties messageProperties =
            new MessageProperties();
        messageProperties.setContentType("application/json");

        try {
            final Message msg = new Message(
                    mapper.writeValueAsString(notification).getBytes(),
                    messageProperties);

            rabbitTemplate.send(exchange.getName(),
                    "usuario.criado",
                    msg);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e); // rethrow
        }
        
    }
}
