package org.example;

public class LeitorXMLAdapter implements LeitorDados {
    
    private LeitorXMLAntigo leitorXMLAntigo;

    public LeitorXMLAdapter(LeitorXMLAntigo leitorXMLAntigo) {
        this.leitorXMLAntigo = leitorXMLAntigo;
    }
    
    @Override
    public String lerDados() {
        String xmlData = leitorXMLAntigo.lerXML();
        return converterXMLParaJSON(xmlData);
    }

    private String converterXMLParaJSON(String xmlData) {
        String json = xmlData
            .replace("<pessoa>", "")
            .replace("</pessoa>", "")
            .replace("<nome>", "\"nome\": \"")
            .replace("</nome>", "\"")
            .replace("<idade>", "\"idade\": ")
            .replace("</idade>", "")
            .replace("<cidade>", "\"cidade\": \"")
            .replace("</cidade>", "\"");
        return "{" + json + "}";
    }
} 