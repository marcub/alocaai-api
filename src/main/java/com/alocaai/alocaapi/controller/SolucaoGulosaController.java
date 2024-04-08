package com.alocaai.alocaapi.controller;

import com.alocaai.alocaapi.dto.CreateSolucaoDTO;
import com.alocaai.alocaapi.model.Turma;
import com.alocaai.alocaapi.service.SolucaoGulosaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class SolucaoGulosaController {

    @Autowired
    private SolucaoGulosaService solucaoGulosaService;

    @GetMapping("/solucaoGulosa")
    public ResponseEntity<List<Turma>> geraSolucao(@RequestBody CreateSolucaoDTO createSolucaoDTO) {

        List<Turma> turmasAlocadas = solucaoGulosaService.createSolucao(createSolucaoDTO);

        return new ResponseEntity<>(turmasAlocadas, HttpStatus.ACCEPTED);
    }
}
