package com.example.demo.domain.out;

public interface IPasswordEncoder {
    String encode(CharSequence rawPassword);
    boolean matches(CharSequence rawPassword, String encodedPassword);

    // boolean upgradeEncoding(String encodedPassword);
}
