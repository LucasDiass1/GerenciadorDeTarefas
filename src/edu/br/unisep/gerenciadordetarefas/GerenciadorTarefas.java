package edu.br.unisep.gerenciadordetarefas;

import javax.swing.*;

public class GerenciadorTarefas {

    private static TarefaController controladorTarefas = new TarefaController();

    public static void main(String[] args) {
        while (true) {
            String menu = "Selecione uma opção:\n" +
                    "1. Adicionar tarefa\n" +
                    "2. Marcar tarefa como concluída\n" +
                    "3. Remover tarefa\n" +
                    "4. Exibir todas as tarefas\n" +
                    "5. Sair";

            String opcaoEscolhida = JOptionPane.showInputDialog(menu);
            int opcao = Integer.parseInt(opcaoEscolhida);

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    marcarTarefaConcluida();
                    break;
                case 3:
                    removerTarefa();
                    break;
                case 4:
                    exibirTarefas();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        }
    }

    private static void adicionarTarefa() {
        String descricao = JOptionPane.showInputDialog("Digite a tarefa a ser adicionada:");
        if (descricao != null && !descricao.trim().isEmpty()) {
            controladorTarefas.adicionarTarefa(descricao);
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa não pode ser vazia.");
        }
    }

    private static void marcarTarefaConcluida() {
        String listaTarefas = controladorTarefas.listarTarefas();
        if (listaTarefas.equals("Não há tarefas cadastradas.")) {
            JOptionPane.showMessageDialog(null, listaTarefas);
            return;
        }

        String tarefaEscolhida = JOptionPane.showInputDialog("Selecione o número da tarefa para marcar como concluída:\n" + listaTarefas);
        int index = Integer.parseInt(tarefaEscolhida) - 1;

        controladorTarefas.marcarTarefaConcluida(index);
        JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída.");
    }

    private static void removerTarefa() {
        String listaTarefas = controladorTarefas.listarTarefas();
        if (listaTarefas.equals("Não há tarefas cadastradas.")) {
            JOptionPane.showMessageDialog(null, listaTarefas);
            return;
        }

        String tarefaEscolhida = JOptionPane.showInputDialog("Selecione o número da tarefa a ser removida:\n" + listaTarefas);
        int index = Integer.parseInt(tarefaEscolhida) - 1;

        controladorTarefas.removerTarefa(index);
        JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso.");
    }

    private static void exibirTarefas() {
        String listaTarefas = controladorTarefas.listarTarefas();
        JOptionPane.showMessageDialog(null, "Tarefas atuais:\n" + listaTarefas);
    }
}