package org.example;

public class Model {
    
    private String dados;
    private String tipoLeitor;

    public Model() {
        this.dados = "";
        this.tipoLeitor = "";
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public void setTipoLeitor(String tipoLeitor) {
        this.tipoLeitor = tipoLeitor;
    }

    public String getDados() {
        return dados;
    }

    public String getTipoLeitor() {
        return tipoLeitor;
    }

    public String getDadosFormatados() {
        return "Tipo de Leitor: " + tipoLeitor + "\nDados: " + dados;
    }
} 