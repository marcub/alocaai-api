package com.alocaai.alocaapi.model;

import java.time.LocalTime;

public class Horario {

    private LocalTime inicio;
    private LocalTime fim;
    private String diaSemana;
    private String turno;

    public Horario(LocalTime inicio, LocalTime fim, String diaSemana, String turno) {
        this.inicio = inicio;
        this.fim = fim;
        this.diaSemana = diaSemana;
        this.turno = turno;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "inicio=" + inicio +
                ", fim=" + fim +
                ", diaSemana='" + diaSemana + '\'' +
                ", turno='" + turno + '\'' +
                '}';
    }
}
