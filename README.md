# Sistema de Leitura de Dados - Padrões Adapter e MVC

## Descrição do Problema

Este sistema resolve o problema de compatibilidade entre uma aplicação que só entende dados no formato JSON e uma classe legada que lê dados no formato XML. Utilizando o padrão **Adapter**, conseguimos fazer com que a classe legada funcione com nossa aplicação sem modificar seu código original.

## Padrões de Projeto Aplicados

### 1. Padrão Adapter
- **Problema**: A classe `LeitorXMLAntigo` tem uma interface incompatível com a interface `LeitorDados` esperada pela aplicação
- **Solução**: O `LeitorXMLAdapter` converte a interface da classe legada para a interface esperada
- **Benefícios**: Permite reutilizar código legado sem modificá-lo

### 2. Padrão MVC (Model-View-Controller)
- **Model**: Representa os dados da aplicação (`Model.java`)
- **View**: Responsável pela exibição dos dados (`View.java`)
- **Controller**: Coordena a lógica de negócio (`Controller.java`)
- **Benefícios**: Separação clara de responsabilidades e facilita manutenção

## Estrutura do Projeto

```
src/
├── LeitorDados.java          # Interface esperada pela aplicação
├── LeitorJSON.java           # Implementação nativa para JSON
├── LeitorXMLAntigo.java      # Classe legada (incompatível)
├── LeitorXMLAdapter.java     # Adapter para XML
├── Model.java                # Model do MVC
├── View.java                 # View do MVC
├── Controller.java           # Controller do MVC
└── Main.java                 # Classe principal
```

## Como Executar

1. Compile todos os arquivos Java:
```bash
javac src/*.java
```

2. Execute a aplicação:
```bash
java -cp src Main
```

## Funcionalidades

- **Leitura JSON**: Usa o `LeitorJSON` nativo
- **Leitura XML**: Usa o `LeitorXMLAdapter` para converter dados XML
- **Exibição**: Mostra os dados formatados no console
- **Demonstração**: Executa ambos os leitores para comparação

## Relacionamentos entre Classes

1. **Controller** → **Model**: O controller atualiza o model
2. **Controller** → **View**: O controller chama a view para exibir dados
3. **Controller** → **LeitorDados**: O controller usa leitores de dados
4. **LeitorXMLAdapter** → **LeitorXMLAntigo**: O adapter usa a classe legada
5. **LeitorJSON** → **LeitorDados**: Implementa a interface
6. **LeitorXMLAdapter** → **LeitorDados**: Implementa a interface

## Requisitos Atendidos

✅ **3 classes de domínio**: Model, View, Controller  
✅ **2 relacionamentos**: Controller-Model, Controller-View  
✅ **2 padrões de projeto**: Adapter e MVC  
✅ **Implementação em Java**: Código funcional e didático  
✅ **Código claro**: Comentários explicativos e estrutura organizada 