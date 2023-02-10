package com.example.eleicoesapp;

import java.util.List;

public class Candidato {
    private Long id;
    private Long num;
    private String nome;
    private Partido partido;
    private List<Cargo> cargos;
    private List<Votos> votos;

    public Candidato() {
    }

    public List<Cargo> getCargos() {

        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {

        this.cargos = cargos;
    }

    public List<Votos> getVotos() {

        return votos;
    }

    public void setVotos(List<Votos> votos) {

        this.votos = votos;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }


    public Long getNum() {

        return num;
    }

    public void setNum(Long num) {

        this.num = num;
    }


    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }


    public Partido getPartido() {

        return partido;
    }

    public void setPartido(Partido partido) {

        this.partido = partido;
    }
}
