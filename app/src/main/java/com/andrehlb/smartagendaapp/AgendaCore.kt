package com.andrehlb.smartagendaapp

// import androidx.compose.ui.geometry.isEmpty

// Lógica principal da Agenda Inteligente (sem interface de usuário)
data class Contact(
    val name: String,
    val phoneNumber: String = "Sem número", // var para me permitir alterar o número depois
    var isFavorite: Boolean = false,

)

// Classe ou objeto que vai gerenciar os contatos da agenda
object AgendaManager { // usando um object (singleton) para simplificar o acesso
     private val contacts = mutableListOf<Contact>()

    fun addContact(name: String, isFavorite: Boolean, phoneNumber: String = "Sem número") {
        if (name.isBlank()) { // é para verificar se o nome está vazio, em branco ou só com espaços
            println("Ops! O nome do contato não pode ficar vazio. Contato não adicionado, tente de novo.")
            // println("Aviso: Este contato '$name' já existe. Fique tranquilo, não será adicionado de novo.")
            return // Sai da função sem adicionar o contato
        }
        val existingContact = contacts.find { it.name.equals(name, ignoreCase = true) }
        if (existingContact != null) {
            println("Aviso: Este contato '$name' já existe. Fique tranquilo, não será adicionado de novo.")
        } else {
            val newContact = Contact(name = name, phoneNumber = phoneNumber, isFavorite = isFavorite)
            contacts.add(newContact)
            println("Muito bem! O contato '$name' foi adicionado com sucesso!")
        }
    }
    fun listAllContactsDetails() {
        if (contacts.isEmpty()) {
            println("A agenda está sem contato ainda.")
            return
        }
        println("\n--- Lista de Todos os Contatos ---")
        contacts.forEachIndexed { index, contact ->
            val favStatus = if (contact.isFavorite) "Favorito" else " Comum"
            println("${index + 1}. Nome: ${contact.name}, Tel: ${contact.phoneNumber}, Status: $favStatus")
        }
    }

    // Função para listar apenas os contatos favoritos (ordenados)
    fun listFavoriteNames(): List<String> = contacts
        .filter { it.isFavorite }
        .map { it.name }
        .sorted() // Ordena alfabeticamente

    // Função para buscar um contato pelo nome (parcial, e ignora maiúsculas/minúsculas (case insensitive))
    fun findContactByName(searchTerm: String): List<Contact> {
        if (searchTerm.isBlank()) {
            println("Ué, o termo de busca está vazio. Não vai achar nada.")
            return emptyList()
        }
        return contacts.filter {
            it.name.contains(searchTerm, ignoreCase = true)
        }
    }

    // Função com parâmetro padrão para enviar mensagem
    fun sendMessage(message: String, sender: String = "Sistema") {
        println("----------------------------------------")
        println("Esta mensagem veio de [$sender]:")
        println("\"$message\"")
        println("----------------------------------------")
    }
}

// Testando a lógica no console, usando a função main
fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))
    println("===================================================")
    println(" TESTES DA AGENDA INTELIGENTE (CONSOLE) INICIADO ")
    println("===================================================")

    // Usando o AgendaManager para adicionar contatos
    AgendaManager.addContact("Alice Wonderland", true, "111-2222")
    AgendaManager.addContact("Bob The Builder", false)
    AgendaManager.addContact("Carol Danvers", true, "333-4444")
    AgendaManager.addContact("David Copperfield", true, "555-NO-NUM")
    AgendaManager.addContact("Zelda Fitz", false, "555-9999")
    AgendaManager.addContact("alice wonderland", true, "111-0000") // Testando duplicidade (case-insensitive)
    AgendaManager.addContact("", true) // Testando nome vazio

    AgendaManager.listAllContactsDetails()

    println("\n--- Nomes dos Favoritos (Ordenados) ---")
    val favoriteNames = AgendaManager.listFavoriteNames()
    if (favoriteNames.isEmpty()) {
        println("Nenhum contato favorito encontrado.")
    } else {
        favoriteNames.forEach { println("- $it") }
    }
    println("\n--- Buscando por 'Alice' ---")
    val foundAlice = AgendaManager.findContactByName("Alice")
    if (foundAlice.isEmpty()) {
        println("Nenhum contato encontrado com 'Alice'.")
    } else {
        println("Contatos encontrados com 'Alice':")
        foundAlice.forEach { println("  -> ${it.name} (Favorito: ${it.isFavorite})") }
    }
    println("\n--- Buscando por 'xyz' (não existente) ---")
    val foundXYZ = AgendaManager.findContactByName("xyz")
    if (foundXYZ.isEmpty()) {
        println("Nenhum contato encontrado com 'xyz'.")
    } else {
        // Este bloco não deve ser executado
        println("Contatos encontrados com 'xyz': ${foundXYZ.joinToString { it.name }}")
    }
}
