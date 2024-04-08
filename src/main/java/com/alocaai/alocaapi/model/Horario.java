package com.alocaai.alocaapi.model;

public class Horario {

    private String horario;
    private String diaSemana;
    private String turno;

    public Horario(String horario, String diaSemana, String turno) {
        this.horario = horario;
        this.diaSemana = diaSemana;
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
}
