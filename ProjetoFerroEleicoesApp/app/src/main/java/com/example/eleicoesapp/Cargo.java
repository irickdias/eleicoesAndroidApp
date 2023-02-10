package com.example.eleicoesapp;

public class Cargo {
    private Long id;
    private String desc;
    private Candidato candidato;

    public Cargo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
