package com.alocaai.alocaapi.service;

import com.alocaai.alocaapi.dto.CreateSolucaoDTO;
import com.alocaai.alocaapi.model.*;
import com.sun.source.tree.Tree;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class SolucaoGulosaServiceImplementation  implements  SolucaoGulosaService {

    @Override
    public List<Turma> createSolucao(CreateSolucaoDTO createSolucaoDTO) {

        Set<Turma> turmas = new HashSet<Turma>(createSolucaoDTO.getTurmas());
        Set<Sala> salas = new HashSet<Sala>(createSolucaoDTO.getSalas());

        List<Turma> turmasAlocadas = new ArrayList<Turma>();
        List<Turma> turmasNaoAlocadas = new ArrayList<Turma>();

        for (Turma turma : turmas) {
            List<Turma> turmasSolucaoGulosa = new ArrayList<Turma>();
            int contadorSala = 0;
            for (Sala sala : salas) {
                contadorSala++;

                if (turma.getDisciplina().getAmbienteSalaAdequado() != null && turma.getDisciplina().getRecursos() != null) {
                    if (turma.getDisciplina().getAmbienteSalaAdequado().equals(sala.getAmbiente())) {
                        if (turma.getQtdAlunos() <= sala.getCapacidade()) {
                            if (!jaAlocado(turmas, turma.getHorario(), sala)) {
                                if (turma.getSala() == null) {
                                    Turma t = new Turma(turma.getQtdAlunos(), turma.getPeriodo(), turma.getDisciplina(), turma.getHorario(), turma.getCurso());
                                    t.setSala(sala);
                                    turmasSolucaoGulosa.add(t);
                                } else {
                                    turma.setSala(sala);
                                }
                            }
                        }
                    }
                } else if (turma.getDisciplina().getAmbienteSalaAdequado() != null && turma.getDisciplina().getRecursos() == null) {
                    if (turma.getDisciplina().getAmbienteSalaAdequado().equals(sala.getAmbiente())) {
                        if (turma.getQtdAlunos() <= sala.getCapacidade()) {
                            if (!jaAlocado(turmas, turma.getHorario(), sala)) {
                                if (turma.getSala() == null) {
                                    Turma t = new Turma(turma.getQtdAlunos(), turma.getPeriodo(), turma.getDisciplina(), turma.getHorario(), turma.getCurso());
                                    t.setSala(sala);
                                    turmasSolucaoGulosa.add(t);
                                } else {
                                    turma.setSala(sala);
                                }
                            }
                        }
                    }
                } else if (turma.getDisciplina().getAmbienteSalaAdequado() == null && turma.getDisciplina().getRecursos() != null) {
                    if (turma.getQtdAlunos() <= sala.getCapacidade()) {
                        if (!jaAlocado(turmas, turma.getHorario(), sala)) {
                            if (turma.getSala() == null) {
                                Turma t = new Turma(turma.getQtdAlunos(), turma.getPeriodo(), turma.getDisciplina(), turma.getHorario(), turma.getCurso());
                                t.setSala(sala);
                                turmasSolucaoGulosa.add(t);
                            } else {
                                turma.setSala(sala);
                            }
                        }
                    }
                }
                if (contadorSala == salas.size() && !turmasSolucaoGulosa.isEmpty()) {
                    Sala salaSolucaoGulosa = definePesoValor(turmasSolucaoGulosa);
                    turma.setSala(salaSolucaoGulosa);
                }
            }
        }

        turmas.forEach(t -> {
            if (t.getSala() == null) {
                turmasNaoAlocadas.add(t);
            } else {
                turmasAlocadas.add(t);
            }
        });

        //verificaSalaComPrioridade(turmasNaoAlocadas, turmasAlocadas);

        return turmasAlocadas;
    }

    public boolean jaAlocado(Set<Turma> turmas, Horario horario, Sala sala) {

        for (Turma t : turmas) {
            if (t.getSala() != null) {
                if (t.getSala().getNome().equals(sala.getNome())) {
                    if (t.getHorario().getDiaSemana().equals(horario.getDiaSemana()) && t.getHorario().getTurno().equals(horario.getTurno()) && t.getHorario().getHorario().equals(horario.getHorario())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public Sala definePesoValor(List<Turma> turmasSolucaoGulosa) {

        BinarySearchTree solucaoGulosas = new BinarySearchTree(null);

        for (Turma t : turmasSolucaoGulosa) {
            SolucaoGulosa solucaoGulosa = new SolucaoGulosa();
            solucaoGulosa.setTurma(t);
            solucaoGulosa.setPeso(t.getSala().getCapacidade() - t.getQtdAlunos() + 1);
            solucaoGulosa.setValor(t.getSala().getAr() + t.getSala().getVentilador() + 1);

            Double razao = Double.valueOf(solucaoGulosa.getValor()) / Double.valueOf(solucaoGulosa.getPeso());
            BigDecimal razaoBd = BigDecimal.valueOf(razao);
            razaoBd = razaoBd.setScale(2, RoundingMode.HALF_UP);
            razao = razaoBd.doubleValue();

            solucaoGulosa.setRazao(razao);

            TreeNode nodeTree = new TreeNode(razao, solucaoGulosa);
            solucaoGulosas.insert(nodeTree);
        }

        return solucaoGulosas.getMaxNode().getSolucaoGulosa().getTurma().getSala();
    }
}
