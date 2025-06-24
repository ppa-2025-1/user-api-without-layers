package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * EXCHANGE (portaria do evento)
 * ROUTING KEY (endereço)
 * QUEUE (fila --> recipient)
 * 
 * BINDING: estabelece uma ligação entre uma
 * Exchange para uma Queue através de uma Routing Key
 * 
 * Exchange X: (fanout: todas as filas)
 *             (direct: envia para uma fila específica)
 *             (topic: mais de uma fila)
 *    Queue A
 *    Queue B
 *    Queue C
 * 
 * Exchange usuario-exchange -> usuario.criado -> usuario-queue
 */



@Configuration
public class MensageriaConfig {

    @Bean
    Exchange exchange() {
        return ExchangeBuilder
            .directExchange("usuario-exchange")
            .durable(true)
            .build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder
            .durable("usuario-queue")
            .build();
    }

    @Bean
    Binding binding(Exchange exchange, Queue queue) {
        return BindingBuilder
            .bind(queue)
            .to(exchange)
            .with("usuario.criado")
            .noargs();
    }
    
}
