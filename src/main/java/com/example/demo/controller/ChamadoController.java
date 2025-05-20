package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.NovoChamadoDTO;
import com.example.demo.repository.ChamadoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.Chamado;
import com.example.demo.repository.entity.User;

@RestController
@RequestMapping("/api/v1/chamados")
public class ChamadoController {
    private final ChamadoRepository chamadoRepository;
    private final UserRepository userRepository;
    

    public ChamadoController(ChamadoRepository chamadoRepository, UserRepository userRepository) {
        this.chamadoRepository = chamadoRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void abrirChamado(@RequestBody NovoChamadoDTO dto) {
        Chamado chamado = new Chamado();
        chamado.setAcao(dto.acao());
        chamado.setObjeto(dto.objeto());
        chamado.setDetalhamento(dto.detalhamento());
        chamado.setSituacao("NOVO");
        User user = userRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        chamado.setUsuario(user);
        chamadoRepository.save(chamado);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chamado>> getChamados() {
        return ResponseEntity.ok(chamadoRepository.findAll());
    }

} 