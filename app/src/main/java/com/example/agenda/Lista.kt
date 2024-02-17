package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import com.example.agenda.Clases.Persona
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Lista : AppCompatActivity() {


    lateinit var lvLista: ListView
    lateinit var json : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val ivBack: ImageView = findViewById(R.id.ivBack)
        val btnMostrarRV : Button = findViewById(R.id.btnMostrarRV)
        lvLista = findViewById(R.id.lvContactos)

        cargarLista()


        ivBack.setOnClickListener(){
            finish()
        }


        btnMostrarRV.setOnClickListener(){

            val intent = Intent(this,ListaRecycler::class.java)
            intent.putExtra("lista", json)
            startActivity(intent)
        }
    }

    fun cargarLista(){

        json = intent.getStringExtra("lista").toString()
        val gson = Gson()

        val tipoLista = object : TypeToken<List<Persona>>(){}.type
        val lista = gson.fromJson<List<Persona>>(json, tipoLista)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        lvLista.adapter = adapter
    }
}