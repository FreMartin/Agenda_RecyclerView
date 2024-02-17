package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.Clases.Persona
import com.example.agenda.adapter.PersonasAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListaRecycler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_recycler)
        cargarListaRV()
        val ivBackRV: ImageView = findViewById(R.id.ivBackRV)


        cargarListaRV()
        ivBackRV.setOnClickListener(){
            finish()
        }
    }

    fun cargarListaRV(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val listaRV: RecyclerView = findViewById(R.id.rvLista)
        listaRV.layoutManager = manager
        val json = intent.getStringExtra("lista")
        val gson = Gson()
        val tipoLista = object : TypeToken<List<Persona>>(){}.type
        val lista = gson.fromJson<List<Persona>>(json, tipoLista)

        listaRV.adapter = PersonasAdapter(lista)
        listaRV.addItemDecoration(decoration)

    }
}