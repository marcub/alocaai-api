package com.alocaai.alocaapi.model;

public class Sala {

    private String nome;
    private String ambiente;
    private Integer ar;
    private Integer ventilador;
    private Integer capacidade;
    private Integer quadroVidro;
    private Integer projetor;
    private String bloco;

    public Sala(String nome, String ambiente, Integer ar, Integer ventilador, Integer capacidade, Integer quadroVidro, Integer projetor, String bloco) {
        this.nome = nome;
        this.ambiente = ambiente;
        this.ar = ar;
        this.ventilador = ventilador;
        this.capacidade = capacidade;
        this.quadroVidro = quadroVidro;
        this.projetor = projetor;
        this.bloco = bloco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = Sala.this.ambiente;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public Integer getVentilador() {
        return ventilador;
    }

    public void setVentilador(Integer ventilador) {
        this.ventilador = ventilador;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getQuadroVidro() {
        return quadroVidro;
    }

    public void setQuadroVidro(Integer quadroVidro) {
        this.quadroVidro = quadroVidro;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Integer getProjetor() {
        return projetor;
    }

    public void setProjetor(Integer projetor) {
        this.projetor = projetor;
    }
}
