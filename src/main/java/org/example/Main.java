package org.example;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE LEITURA DE DADOS ===");
        System.out.println("Demonstrando Padrões Adapter e MVC");
        System.out.println("===================================\n");
        
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        
        controller.processarTodos();
        
        System.out.println("\n=== RESUMO DOS PADRÕES APLICADOS ===");
        System.out.println("1. PADRÃO ADAPTER:");
        System.out.println("   - LeitorXMLAntigo (classe legada)");
        System.out.println("   - LeitorXMLAdapter (converte interface)");
        System.out.println("   - LeitorDados (interface esperada)");
        System.out.println();
        System.out.println("2. PADRÃO MVC:");
        System.out.println("   - Model: representa os dados");
        System.out.println("   - View: exibe os dados no console");
        System.out.println("   - Controller: coordena a lógica de negócio");
        System.out.println("=====================================");
    }
}