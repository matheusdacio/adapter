# Documentação dos Padrões de Projeto Aplicados

## 1. Padrão Adapter

### Problema Resolvido
A aplicação espera uma interface `LeitorDados` com o método `lerDados()`, mas existe uma classe legada `LeitorXMLAntigo` que tem uma interface incompatível com métodos como `lerXML()` e `processarXML()`.

### Solução Implementada
O `LeitorXMLAdapter` atua como um adaptador que:
- Implementa a interface `LeitorDados` esperada pela aplicação
- Encapsula uma instância da classe legada `LeitorXMLAntigo`
- Converte as chamadas da interface esperada para a interface da classe legada
- Transforma os dados XML em formato JSON para manter consistência

### Estrutura do Padrão
```
Cliente (Controller) → Interface Esperada (LeitorDados) ← Adapter (LeitorXMLAdapter) → Classe Legada (LeitorXMLAntigo)
```

### Benefícios
- **Reutilização de código**: Permite usar classes legadas sem modificá-las
- **Flexibilidade**: Facilita a integração de sistemas com interfaces incompatíveis
- **Manutenibilidade**: Isola as mudanças de interface em uma única classe

## 2. Padrão MVC (Model-View-Controller)

### Problema Resolvido
Organizar o código de forma que as responsabilidades sejam claramente separadas, facilitando manutenção e extensão do sistema.

### Solução Implementada

#### Model (Model.java)
- **Responsabilidade**: Representar os dados da aplicação
- **Funcionalidades**:
  - Armazenar dados lidos pelos leitores
  - Manter informações sobre o tipo de leitor usado
  - Fornecer métodos para acessar e modificar dados
  - Formatar dados para exibição

#### View (View.java)
- **Responsabilidade**: Exibir dados para o usuário
- **Funcionalidades**:
  - Mostrar dados formatados no console
  - Exibir mensagens informativas
  - Criar separadores visuais

#### Controller (Controller.java)
- **Responsabilidade**: Coordenar a lógica de negócio
- **Funcionalidades**:
  - Decidir qual leitor usar (JSON ou XML via Adapter)
  - Atualizar o Model com dados lidos
  - Solicitar à View que exiba os dados
  - Gerenciar o fluxo da aplicação

### Estrutura do Padrão
```
View ←→ Controller ←→ Model
```

### Benefícios
- **Separação de responsabilidades**: Cada componente tem uma função específica
- **Manutenibilidade**: Mudanças em um componente não afetam os outros
- **Testabilidade**: Cada componente pode ser testado independentemente
- **Reutilização**: Componentes podem ser reutilizados em outras partes do sistema

## 3. Relacionamentos entre Classes

### Relacionamentos de Herança/Implementação
1. `LeitorJSON implements LeitorDados`
2. `LeitorXMLAdapter implements LeitorDados`

### Relacionamentos de Composição
1. `Controller` contém `Model` e `View`
2. `LeitorXMLAdapter` contém `LeitorXMLAntigo`
3. `Controller` contém `LeitorJSON` e `LeitorXMLAdapter`

### Relacionamentos de Dependência
1. `Controller` usa `LeitorDados` (polimorfismo)
2. `Main` cria instâncias de `Model`, `View` e `Controller`

## 4. Fluxo de Execução

1. **Inicialização**: `Main` cria as instâncias do MVC
2. **Processamento JSON**: Controller usa `LeitorJSON` diretamente
3. **Processamento XML**: Controller usa `LeitorXMLAdapter` que:
   - Chama `LeitorXMLAntigo.lerXML()`
   - Converte XML para JSON
   - Retorna dados no formato esperado
4. **Exibição**: View mostra os dados formatados

## 5. Pontos de Extensão

### Novos Tipos de Leitor
Para adicionar um novo tipo de leitor (ex: CSV), basta:
1. Criar uma classe que implemente `LeitorDados`
2. Adicionar a instância no Controller
3. Criar método para processar com o novo leitor

### Novas Interfaces de Usuário
Para adicionar uma nova interface (ex: GUI), basta:
1. Criar uma nova View que implemente a interface desejada
2. Manter o mesmo Controller e Model
3. A lógica de negócio permanece inalterada

## 6. Conclusão

Este sistema demonstra como os padrões Adapter e MVC podem ser combinados para criar soluções elegantes e manuteníveis. O Adapter resolve problemas de compatibilidade, enquanto o MVC organiza o código de forma clara e modular. 