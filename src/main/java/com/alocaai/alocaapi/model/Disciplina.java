package com.alocaai.alocaapi.model;

import java.util.List;

public class Disciplina {

    private String nome;
    private List<String> recursos;
    private String ambienteSalaAdequado;

    public Disciplina(String nome, List<String> recursos, String ambienteSalaAdequado) {
        this.nome = nome;
        this.recursos = recursos;
        this.ambienteSalaAdequado = ambienteSalaAdequado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<String> recursos) {
        this.recursos = recursos;
    }

    public String getAmbienteSalaAdequado() {
        return ambienteSalaAdequado;
    }

    public void setAmbienteSalaAdequado(String ambienteSalaAdequado) {
        this.ambienteSalaAdequado = ambienteSalaAdequado;
    }
}
