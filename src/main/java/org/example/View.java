package org.example;

public class View {

    public void exibirDados(Model model) {
        System.out.println("=== SISTEMA DE LEITURA DE DADOS ===");
        System.out.println(model.getDadosFormatados());
        System.out.println("===================================");
    }

    public void exibirSeparador() {
        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println("INFO: " + mensagem);
    }
} 