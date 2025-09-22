# 🚀 Desafio de Prática – Agenda Inteligente em Kotlin

## 🎯 Desafio Proposto

> 🚀 **Desafio de Prática – Agenda Inteligente em Kotlin**  
> Proposto por Steffeson Wesley Lira

Implemente um mini-sistema de agenda inteligente em Kotlin, praticando os seguintes conceitos:

- **Funções de expressão única**
- **Parâmetros padrão**
- **Listas mutáveis**
- **Funções de ordem superior**

### 📌 O que implementar?

1. **Adicionar Contato**  
   Função para cadastrar um contato com:
    - Nome (**Obrigatório**)
    - Favorito (**Boolean, Obrigatório**)
    - Telefone (**Opcional**, padrão = "Sem número")

2. **Listar Favoritos**  
   Função de expressão única que retorna apenas os nomes dos contatos favoritos, organizados em ordem alfabética.

3. **Buscar Contato por Nome**  
   Função usando `filter` (ordem superior) que retorna o(s) contato(s) cujo nome corresponda ao termo pesquisado.

4. **Enviar Mensagem**  
   Função para enviar mensagens com:
    - Mensagem (**Obrigatório**)
    - Remetente (**Opcional**, padrão = "Sistema")

### 💡 Dicas

- Use `mutableListOf` para armazenar os contatos.
- Aproveite parâmetros padrão para evitar sobrecarga.
- Experimente funções de ordem superior para um código idiomático.
- Treine funções de expressão única.

**Objetivo:**  
Colocar em prática funções simples e avançadas, com callbacks e filtros, consolidando o aprendizado.

---

## 📌 Funcionalidades Implementadas

O sistema de agenda inteligente implementa as seguintes funcionalidades, conforme solicitado no desafio:

### 1. Adicionar Contato
-   **Função:** `AgendaManager.addContact(name: String, isFavorite: Boolean, phoneNumber: String = "Sem número")`
-   **Descrição:** Permite cadastrar um contato com os seguintes parâmetros:
    -   `Nome` (String, Obrigatório)
    -   `Favorito` (Boolean, Obrigatório)
    -   `Telefone` (String, Opcional, com valor padrão "Sem número")
-   **Observações da Implementação:**
    -   Impede a adição de contatos com nome em branco.
    -   Verifica se um contato com o mesmo nome (ignorando maiúsculas/minúsculas) já existe para evitar duplicidade.

### 2. Listar Favoritos
-   **Função:** `AgendaManager.listFavoriteNames(): List<String>`
-   **Descrição:** Uma função de expressão única que retorna uma lista contendo apenas os **nomes** dos contatos marcados como favoritos.
-   **Organização:** Os nomes são retornados em ordem alfabética.

### 3. Buscar Contato por Nome
-   **Função:** `AgendaManager.findContactByName(searchTerm: String): List<Contact>`
-   **Descrição:** Implementa uma busca utilizando a função de ordem superior `filter`.
-   **Comportamento:** Retorna uma lista contendo o(s) contato(s) cujo nome corresponda parcial ou totalmente ao `searchTerm`. A busca não diferencia maiúsculas de minúsculas (case-insensitive).
-   **Observação da Implementação:** Impede buscas com termo de pesquisa vazio.

### 4. Enviar Mensagem
-   **Função:** `AgendaManager.sendMessage(message: String, sender: String = "Sistema")`
-   **Descrição:** Permite simular o envio de uma mensagem com os seguintes parâmetros:
    -   `Mensagem` (String, Obrigatório)
    -   `Remetente` (String, Opcional, com valor padrão "Sistema")
-   **Implementação Atual:** A função imprime a mensagem formatada no console, indicando o remetente e a mensagem.

### Funcionalidade Adicional (Para Demonstração)
Além dos requisitos principais do desafio, foi implementada a seguinte função auxiliar para facilitar a visualização e teste:

-   **Listar Todos os Contatos Detalhadamente:**
    -   **Função:** `AgendaManager.listAllContactsDetails()`
    -   **Descrição:** Lista todos os contatos presentes na agenda, exibindo seus nomes, números de telefone e o status de favorito (ex: "🌟 Favorito" ou "😐 Comum"). Útil para verificar o estado completo da agenda durante os testes.

## 🛠️ Tecnologias e Conceitos Kotlin Utilizados

-   **Linguagem:** Kotlin
-   **Estrutura de Dados Primária:** `mutableListOf<Contact>` para armazenar e gerenciar a lista de contatos.
-   **Modelagem de Dados:** `data class Contact(val name: String, val phoneNumber: String, val isFavorite: Boolean)` para representar a estrutura de um contato.
-   **Organização da Lógica:** `object AgendaManager` (Singleton) para encapsular todas as funções de gerenciamento da agenda.
-   **Conceitos de Funções Kotlin Praticados (Conforme Desafio):**
    -   Funções com parâmetros obrigatórios e opcionais (utilizando parâmetros padrão).
    -   Funções de expressão única (aplicada em `listFavoriteNames`).
    -   Funções de ordem superior (como `filter` para busca, e internamente `map`, `sortedBy`, `forEachIndexed` para outras operações).
    -   Uso de Lambdas.
-   **Outros Recursos Kotlin:**
    -   Interpolação de Strings para formatação dinâmica da saída no console.
    -   Controle de fluxo com `if/else`.
    -   Coleções e suas operações (ex: `any`, `filter`, `map`, `sortedBy`).

## 🚀 Como Executar o Projeto

1.  **Pré-requisitos:**
    *   JDK (Java Development Kit) instalado.
    *   IntelliJ IDEA com o plugin Kotlin ou Android Studio.

2.  **Passos para Execução:**
    a. Clone este repositório para sua máquina local:

    ```
    git clone https://github.com/Andrehlb/SmartAgendaApp.git
    ```

    b. Abra o projeto `SmartAgendaApp` no IntelliJ IDEA ou Android Studio.

    c. Navegue até o arquivo que contém a lógica principal e a função de demonstração:
    `app/src/main/java/com/andrehlb/smartagendaapp/AgendaCore.kt`

    d. Localize a função `main()` dentro do arquivo `AgendaCore.kt`.

    e. Execute a função `main()`:
    - Clique no ícone de "play" verde que aparece ao lado da declaração da função `main` na margem esquerda do editor.
    - Alternativamente, clique com o botão direito dentro da função `main` e selecione "Run 'AgendaCoreKt'".

    f. A saída do programa, demonstrando todas as funcionalidades da agenda inteligente, será exibida no painel "Run" (ou "Console") do seu IDE.

## 🧪 Demonstração na Função `main()`

A função `main()` no arquivo `AgendaCore.kt` serve como um ponto de entrada para testar e demonstrar todas as funcionalidades implementadas:
- Adiciona múltiplos contatos, variando entre favoritos e não favoritos, e com ou sem números de telefone customizados.
- Tenta adicionar um contato com nome duplicado (a verificação é case-insensitive).
- Tenta adicionar um contato com nome vazio para testar a validação.
- Lista todos os contatos cadastrados com seus detalhes.
- Lista apenas os nomes dos contatos favoritos, ordenados alfabeticamente.
- Realiza buscas por nome: uma para um contato existente (ex: "Alice") e outra para um contato que não existe (ex: "xyz"), demonstrando a busca case-insensitive e parcial.
- Demonstra o envio de mensagens com remetente padrão e customizado.

## 💡 Pontos de Destaque da Implementação

-   **Validações Robustas:** Implementação de verificações para nomes de contato em branco e termos de busca vazios, além da prevenção de duplicidade de contatos pelo nome (case-insensitive).
-   **Uso Idiomático de Kotlin:** Aplicação de funções de coleções como `any`, `filter`, `map`, `sortedBy`, `forEachIndexed` para um código mais conciso e expressivo.
-   **Feedback Claro ao Usuário:** Mensagens informativas no console para cada operação realizada, indicando sucesso, avisos ou erros.
-   **Design Simples e Coeso:** Uso de um `data class` para `Contact` e um `object` (Singleton) para `AgendaManager` mantém a estrutura organizada e a lógica centralizada.

---

## 🔮 Evolução e Possibilidades Futuras

Este projeto foi pensado como base para uma agenda realmente inteligente, que pode evoluir para:

- Permitir interações mais naturais com o usuário, respondendo perguntas e sugerindo ações.
- Implementar notificações automáticas e lembretes inteligentes.
- Integrar com assistentes virtuais ou APIs de IA para respostas automáticas.
- Aprender preferências do usuário e sugerir contatos ou mensagens frequentes.
- Adicionar interface gráfica ou integração com aplicativos móveis.

O objetivo é que a agenda seja cada vez mais proativa, útil e personalizada para o usuário.
