package com.alocaai.alocaapi.service;

import com.alocaai.alocaapi.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SolucaoGulosaServiceImplementationTest {

    private SolucaoGulosaServiceImplementation solucaoGulosaServiceImplementation;

    @BeforeEach
    public void setUp() {
        solucaoGulosaServiceImplementation = new SolucaoGulosaServiceImplementation();
    }

    @Test
    public void testDefineValor() {
        Sala sala1 = new Sala("sala1", "Sala Comum", 1, 0, 30, 0, 0, 1, "Bloco A");
        Sala sala2 = new Sala("sala2", "Sala Comum", 1, 0, 25, 0, 0, 1, "Bloco A");
        Sala sala3 = new Sala("sala3", "Sala Comum", 1, 0, 27, 0, 0, 1, "Bloco A");

        Horario horario = new Horario("Segunda", "Manhã", "08:00-10:00");
        List<String> recursos = new ArrayList<>();
        recursos.add("ar");
        recursos.add("quadroVidro");
        Disciplina disciplina = new Disciplina("Disciplina1", recursos,"Ambiente1");
        Curso curso = new Curso("Ciência da Computação");

        Turma solucao1 = new Turma(25, 5, disciplina, horario, curso);
        solucao1.setSala(sala1);

        Turma solucao2 = new Turma(25, 5, disciplina, horario, curso);
        solucao2.setSala(sala2);

        Turma solucao3 = new Turma(25, 5, disciplina, horario, curso);
        solucao3.setSala(sala3);

        List<Turma> solucoesGulosas = new ArrayList<>();
        solucoesGulosas.add(solucao1);
        solucoesGulosas.add(solucao2);
        solucoesGulosas.add(solucao3);

        Sala result = solucaoGulosaServiceImplementation.definePesoValor(solucoesGulosas);

        assertNotNull(result);
        assertEquals(sala2, result);
    }
}
