package com.example.demo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.domain.out.IPasswordEncoder;

public class BcryptPasswordEncoderAdapter // Padrão de Projeto
    implements IPasswordEncoder {
        
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @Override
    public String encode(CharSequence rawPassword) {
        return bcrypt.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return bcrypt.matches(rawPassword, encodedPassword);
    }


}
