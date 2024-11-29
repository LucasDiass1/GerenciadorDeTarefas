package edu.br.unisep.gerenciadordetarefas;

import java.util.ArrayList;

public class TarefaController {
    private ArrayList<Tarefa> tarefas;

    public TarefaController() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
    }

    public void marcarTarefaConcluida(int index) {
        if (index >= 0 && index < tarefas.size()) {
            tarefas.get(index).concluir();
        }
    }

    public void removerTarefa(int index) {
        if (index >= 0 && index < tarefas.size()) {
            tarefas.remove(index);
        }
    }

    public String listarTarefas() {
        if (tarefas.isEmpty()) {
            return "Não há tarefas cadastradas.";
        }
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            lista.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }
        return lista.toString();
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
}