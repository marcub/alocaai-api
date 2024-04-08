package com.alocaai.alocaapi.dto;

import com.alocaai.alocaapi.model.Sala;
import com.alocaai.alocaapi.model.Turma;

import java.util.List;

public class CreateSolucaoDTO {

    private List<Turma> turmas;
    private List<Sala> salas;

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
