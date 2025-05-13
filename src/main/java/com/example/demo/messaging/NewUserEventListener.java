package com.example.demo.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.domain.CriarUsuarioUserCase;
import com.example.demo.domain.dto.NewUser;

@Component
public class NewUserEventListener {

    private final CriarUsuarioUserCase userBusiness;

    public NewUserEventListener(CriarUsuarioUserCase userBusiness) {
        this.userBusiness = userBusiness;
    }


    @RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
    public void newUser(NewUser event) {
        userBusiness.criarUsuario(event);
    }
}