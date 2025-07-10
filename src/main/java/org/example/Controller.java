package org.example;

public class Controller {
    
    private Model model;
    private View view;
    private LeitorDados leitorJSON;
    private LeitorDados leitorXMLAdapter;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.leitorJSON = new LeitorJSON();
        this.leitorXMLAdapter = new LeitorXMLAdapter(new LeitorXMLAntigo());
    }

    public void processarComJSON() {
        view.exibirMensagem("Usando leitor JSON nativo");
        String dados = leitorJSON.lerDados();
        model.setDados(dados);
        model.setTipoLeitor("JSON");
        view.exibirDados(model);
    }

    public void processarComXML() {
        view.exibirMensagem("Usando leitor XML através do Adapter");
        
        String dados = leitorXMLAdapter.lerDados();
        model.setDados(dados);
        model.setTipoLeitor("XML (via Adapter)");
        
        view.exibirDados(model);
    }

    public void processarTodos() {
        view.exibirMensagem("Demonstrando ambos os leitores");
        processarComJSON();
        view.exibirSeparador();
        processarComXML();
    }
} 