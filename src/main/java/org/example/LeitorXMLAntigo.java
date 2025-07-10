package org.example;

public class LeitorXMLAntigo {

    public String lerXML() {
        return "<pessoa><nome>Maria Santos</nome><idade>30</idade><cidade>São Paulo</cidade></pessoa>";
    }

    public String processarXML() {
        return "Dados XML processados: " + lerXML();
    }
} 