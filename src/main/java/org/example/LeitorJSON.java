package org.example;

public class LeitorJSON implements LeitorDados {
    
    @Override
    public String lerDados() {
        return "{\"nome\": \"João Silva\", \"idade\": 25, \"cidade\": \"Florianópolis\"}";
    }
} 