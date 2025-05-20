package com.example.demo.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chamados")
public class Chamado extends BaseEntity {
    private String acao;
    private String objeto;
    private String detalhamento;
    private String situacao; // novo, andamento, resolvido, cancelado

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }

    public String getObjeto() { return objeto; }
    public void setObjeto(String objeto) { this.objeto = objeto; }

    public String getDetalhamento() { return detalhamento; }
    public void setDetalhamento(String detalhamento) { this.detalhamento = detalhamento; }

    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }

    public User getUsuario() { return usuario; }
    public void setUsuario(User usuario) { this.usuario = usuario; }
} 