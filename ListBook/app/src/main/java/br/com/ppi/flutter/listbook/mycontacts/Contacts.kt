package mycontacts.example.listbook

data class Contact(
    val id: Int,
    val name: String,
    val phone: String,
    val email: String = ""
)