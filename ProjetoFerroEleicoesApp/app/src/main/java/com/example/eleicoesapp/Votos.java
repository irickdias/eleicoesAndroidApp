package com.example.eleicoesapp;

public class Votos {
    private int id;
    private int total;
    private Candidato candidato;
    private Eleicao eleicao;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }


    public Eleicao getEleicao() {
        return eleicao;
    }

    public void setEleicao(Eleicao eleicao) {
        this.eleicao = eleicao;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Candidato getCandidato() {
        return candidato;
    }
}
