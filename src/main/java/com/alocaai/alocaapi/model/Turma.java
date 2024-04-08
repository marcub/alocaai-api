package com.alocaai.alocaapi.model;

public class Turma {

    private Integer qtdAlunos;
    private Integer periodo;

    private Disciplina disciplina;

    private Horario horario;

    private Curso curso;

    private Sala sala;

    public Turma(Integer qtdAlunos, Integer periodo, Disciplina disciplina, Horario horario, Curso curso) {
        this.qtdAlunos = qtdAlunos;
        this.periodo = periodo;
        this.disciplina = disciplina;
        this.horario = horario;
        this.curso = curso;
    }

    public Integer getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(Integer qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "qtdAlunos=" + qtdAlunos +
                ", periodo=" + periodo +
                ", disciplina=" + disciplina +
                ", horario=" + horario +
                ", curso=" + curso +
                ", sala=" + sala +
                '}';
    }
}
