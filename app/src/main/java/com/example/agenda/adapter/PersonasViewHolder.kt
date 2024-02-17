package com.example.agenda.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.agenda.Clases.Persona
import com.example.agenda.R

class PersonasViewHolder(view : View) : RecyclerView.ViewHolder(view){

    val id = view.findViewById<TextView>(R.id.id)
    val nombre = view.findViewById<TextView>(R.id.nombre)
    val telefono = view.findViewById<TextView>(R.id.telefono)
    val email = view.findViewById<TextView>(R.id.email)

    fun render(persona: Persona){
        id.text = persona.id.toString()
        nombre.text = persona.nombre
        telefono.text = persona.telefono
        email.text = persona.email
    }
}