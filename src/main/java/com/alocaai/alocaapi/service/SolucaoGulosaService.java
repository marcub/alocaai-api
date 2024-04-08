package com.alocaai.alocaapi.service;

import com.alocaai.alocaapi.dto.CreateSolucaoDTO;
import com.alocaai.alocaapi.model.Turma;

import java.util.List;

public interface SolucaoGulosaService {

    public List<Turma> createSolucao(CreateSolucaoDTO createSolucaoDTO);

}
