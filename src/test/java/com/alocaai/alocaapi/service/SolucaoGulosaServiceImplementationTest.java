package com.alocaai.alocaapi.service;

import com.alocaai.alocaapi.dto.CreateSolucaoDTO;
import com.alocaai.alocaapi.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Sala sala1 = new Sala("sala1", "Sala Comum", 1, 0, 30, 0, 0, "Bloco A");
        Sala sala2 = new Sala("sala2", "Sala Comum", 1, 0, 25, 0, 0, "Bloco A");
        Sala sala3 = new Sala("sala3", "Sala Comum", 1, 0, 27, 0, 0, "Bloco A");

        Horario horario = new Horario(LocalTime.of(8,0), LocalTime.of(10,0), "Segunda", "Manhã");
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

    @Test
    public void testJaAlocado() {

        Sala sala1 = new Sala("sala1", "Sala Comum", 1, 0, 30, 0, 0, "Bloco A");
        Sala sala2 = new Sala("sala2", "Sala Comum", 1, 0, 25, 0, 0, "Bloco A");

        Horario horario1 = new Horario(LocalTime.of(8,0), LocalTime.of(10,0), "Segunda", "Manhã");
        Horario horario2 = new Horario(LocalTime.of(8,0), LocalTime.of(10,0), "Terça", "Manhã");

        List<String> recursos = new ArrayList<>();
        recursos.add("ar");
        recursos.add("quadroVidro");
        Disciplina disciplina = new Disciplina("Disciplina1", recursos,"Ambiente1");
        Curso curso = new Curso("Ciência da Computação");

        Turma turma1 = new Turma(25, 5, disciplina, horario1, curso);
        turma1.setSala(sala1);

        Turma turma2 = new Turma(25, 5, disciplina, horario2, curso);
        turma2.setSala(sala1);

        Set<Turma> turmas = new HashSet<Turma>();
        turmas.add(turma1);
        turmas.add(turma2);

        Boolean result1 = solucaoGulosaServiceImplementation.jaAlocado(turmas, horario1, sala2);
        Boolean result2 = solucaoGulosaServiceImplementation.jaAlocado(turmas, horario1, sala1);

        assertNotNull(result1);
        assertNotNull(result2);
        assertEquals(result1, false);
        assertEquals(result2, true);
    }

    @Test
    public void testCreateSolucao() {

        Sala sala1 = new Sala("sala1", "Sala Comum", 1, 0, 30, 0, 0, "Bloco A");
        Sala sala2 = new Sala("sala2", "Laboratório", 1, 0, 25, 0, 0, "Bloco A");

        List<Sala> salas = new ArrayList<>();
        salas.add(sala1);
        salas.add(sala2);

        Horario horario1 = new Horario(LocalTime.of(8,0), LocalTime.of(10,0), "Segunda", "Manhã");
        Horario horario2 = new Horario(LocalTime.of(8,0), LocalTime.of(10,0), "Terça", "Manhã");
        List<String> recursos = new ArrayList<>();
        recursos.add("ar");
        recursos.add("quadroVidro");
        Disciplina disciplina1 = new Disciplina("Disciplina1", recursos,"Laboratório");
        Disciplina disciplina2 = new Disciplina("Disciplina2", recursos, "Sala Comum");
        Curso curso = new Curso("Ciência da Computação");

        Turma turma1 = new Turma(25, 5, disciplina1, horario1, curso);
        Turma turma2 = new Turma(25, 5, disciplina2, horario2, curso);

        List<Turma> turmas = new ArrayList<Turma>();
        turmas.add(turma1);
        turmas.add(turma2);

        CreateSolucaoDTO createSolucaoDTO = new CreateSolucaoDTO();
        createSolucaoDTO.setSalas(salas);
        createSolucaoDTO.setTurmas(turmas);

        List<Turma> alocacoes = solucaoGulosaServiceImplementation.createSolucao(createSolucaoDTO);

        String nomeSala1 = alocacoes.get(0).getSala().getNome();
        String nomeSala2 = alocacoes.get(1).getSala().getNome();

        assertNotNull(nomeSala1);
        assertNotNull(nomeSala2);
        assertEquals(nomeSala1, "sala2");
        assertEquals(nomeSala2, "sala1");
    }
}
