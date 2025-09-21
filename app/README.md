# Smart Agenda App - Lógica de Console

Este projeto implementa a lógica principal de uma "Agenda Inteligente" em Kotlin, focada em operações de console. Ele serve como base para gerenciar contatos, incluindo adição, listagem, busca e marcação de favoritos.

## Funcionalidades Implementadas

A lógica central da agenda (`AgendaCore.kt`) atualmente suporta as seguintes operações:

*   **Estrutura de Contato:**
    *   Definição de um contato com:
        *   Nome (obrigatório)
        *   Número de Telefone (opcional, com valor padrão "Sem número")
        *   Status de Favorito (booleano, padrão `false`)
*   **Gerenciamento de Contatos (`AgendaManager`):**
    *   **Adicionar Contatos:**
        *   Permite adicionar novos contatos com nome, status de favorito e número de telefone.
        *   Impede a adição de contatos com nome em branco.
        *   Verifica e impede a adição de contatos duplicados (baseado no nome, ignorando maiúsculas/minúsculas).
        *   Fornece feedback no console sobre o sucesso ou falha da operação.
    *   **Listar Todos os Contatos:**
        *   Exibe uma lista formatada de todos os contatos na agenda, incluindo nome, telefone e se é favorito.
        *   Informa se a agenda está vazia.
    *   **Listar Nomes dos Favoritos:**
        *   Retorna uma lista contendo apenas os nomes dos contatos marcados como favoritos, ordenados alfabeticamente.
    *   **Buscar Contato por Nome:**
        *   Permite buscar contatos por uma parte do nome (busca parcial).
        *   A busca ignora diferenças entre maiúsculas e minúsculas (case-insensitive).
        *   Retorna uma lista de contatos que correspondem ao termo de busca.
        *   Impede buscas com termo vazio.
    *   **Enviar Mensagem (Simulado):**
        *   Uma função utilitária para simular o envio de uma mensagem, exibindo-a no console com um remetente.

## Como Executar (Testes via Console)

O arquivo `AgendaCore.kt` contém uma função `main` que demonstra e testa todas as funcionalidades listadas acima. Para executar:

1.  Certifique-se de ter um ambiente Kotlin configurado.
2.  Compile e execute o arquivo `AgendaCore.kt`.
3.  As operações e seus resultados serão exibidos no console.

## Demonstração dos Testes na `main()`

A função `main` realiza as seguintes operações de teste:

*   Adição de múltiplos contatos, incluindo:
    *   Contatos com e sem número de telefone.
    *   Contatos marcados como favoritos e não favoritos.
*   Tentativa de adicionar um contato com nome duplicado (case-insensitive) para verificar a lógica de prevenção.
*   Tentativa de adicionar um contato com nome vazio.
*   Listagem detalhada de todos os contatos adicionados.
*   Listagem dos nomes dos contatos favoritos (ordenados).
*   Busca por um nome de contato existente (ex: "Alice").
*   Busca por um nome de contato não existente (ex: "xyz").

## Estrutura do Código

*   **`Contact.kt` (data class):** Define a estrutura de um contato.
*   **`AgendaManager.kt` (object):** Singleton que gerencia a lista de contatos e implementa as operações da agenda.
*   **`main()` function (em `AgendaCore.kt`):** Ponto de entrada para os testes de console.


## Possíveis Evoluções Futuras (Não implementado no escopo atual)

*   Edição de contatos existentes.
*   Remoção de contatos.
*   Persistência de dados (salvar/carregar contatos de um arquivo).
*   Uma interface de usuário mais interativa no console (menu de opções).
*   Migração para um aplicativo Android com interface gráfica.

---

*Este README foi gerado com base na análise do arquivo `AgendaCore.kt`.*