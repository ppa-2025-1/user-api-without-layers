package com.example.demo.dto;

import java.util.List;

public record Notification(
    String recipient,
    String title,
    String body,
    List<String> media) {}
