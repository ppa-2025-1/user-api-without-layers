package com.example.demo.domain.dto;

public record NovoChamadoDTO(
    String acao,
    String objeto,
    String detalhamento,
    Integer usuarioId
) {} 