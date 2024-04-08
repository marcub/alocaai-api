package com.alocaai.alocaapi.model;

public class SolucaoGulosa {

    private Integer peso;
    private Integer valor;
    private Double razao;
    private Integer index;
    private Turma turma;

    public SolucaoGulosa() {
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Double getRazao() {
        return razao;
    }

    public void setRazao(Double razao) {
        this.razao = razao;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
