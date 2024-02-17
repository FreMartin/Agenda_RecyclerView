package com.example.agenda.Clases

data class Persona (val id: Int, val nombre: String, val telefono: String, val email: String) {

    override fun toString(): String{
        return "${this.id}, ${this.nombre}, ${this.telefono}, ${this.email}"
    }
}