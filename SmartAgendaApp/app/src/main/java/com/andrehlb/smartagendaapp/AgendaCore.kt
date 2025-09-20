package com.andrehlb.smartagendaapp

import androidx.compose.ui.geometry.isEmpty

// Lógica principal da Agenda Inteligente (sem interface de usuário)
data class Contact(
    val name: String,
    val phoneNumber: String = "Sem número", // var para me permitir alterar o número depois
    var isFavorite: Boolean = false,

)

// Classe ou objeto que vai gerenciar os contatos da agenda
object AgendaCore { // usando um object (singleton) para simplificar o acesso
     private val contacts = mutableListOf<Contact>()

    fun addContact(name: String, isFavorite: Boolean, phoneNumber: String = "Sem número") {
        if (name.isBlank()) {
            println("Aviso: Este contato '$name' já existe. Fique tranquilo, não será adicionado de novo.")
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
            val favStatus = if (contact.isFavorite) "🌟 Favorito" else "😐 Comum"
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
    println("===================================================")
    println("🚀 TESTES DA AGENDA INTELIGENTE (CONSOLE) INICIADO 🚀")
    println("===================================================")

    // Usando o