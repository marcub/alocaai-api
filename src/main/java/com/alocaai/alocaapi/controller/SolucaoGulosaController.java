package com.alocaai.alocaapi.controller;

import com.alocaai.alocaapi.dto.CreateSolucaoDTO;
import com.alocaai.alocaapi.model.Turma;
import com.alocaai.alocaapi.service.SolucaoGulosaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "${front.url}")
public class SolucaoGulosaController {

    @Autowired
    private SolucaoGulosaService solucaoGulosaService;

    @PostMapping("/solucaoGulosa")
    public ResponseEntity<List<Turma>> geraSolucao(@RequestBody CreateSolucaoDTO createSolucaoDTO) {

        List<Turma> turmasAlocadas = solucaoGulosaService.createSolucao(createSolucaoDTO);

        return new ResponseEntity<>(turmasAlocadas, HttpStatus.ACCEPTED);
    }
}
