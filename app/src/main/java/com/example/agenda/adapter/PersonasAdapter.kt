package com.example.agenda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.Clases.Persona
import com.example.agenda.R

class PersonasAdapter (var lista : List<Persona>): RecyclerView.Adapter<PersonasViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonasViewHolder(layoutInflater.inflate(R.layout.item_persona, parent, false))
    }

    override fun getItemCount(): Int {
       return lista.size
    }

    override fun onBindViewHolder(holder: PersonasViewHolder, position: Int) {
        val item = lista[position]
        holder.render(item)
    }

}