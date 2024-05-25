package com.alocaai.alocaapi.model;

import java.util.List;

public class BubbleSort {

    public static void bubbleSort(List<Turma> list) {

        int n = list.size();
        boolean trocado;

        for (int i = 0; i < n - 1; i++) {
            trocado = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).getSala().getNome().compareTo(list.get(j + 1).getSala().getNome()) > 0) {
                    Turma temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    trocado = true;
                }
            }
            if (!trocado) break;
        }
    }
}
