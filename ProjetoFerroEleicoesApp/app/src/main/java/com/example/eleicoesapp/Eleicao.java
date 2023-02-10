package com.example.eleicoesapp;

import java.util.List;

public class Eleicao {

    private Long id;
    private String tipo;
    private Long ano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    @Override
    public String toString()
    {
        return tipo;
    }
}
