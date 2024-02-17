package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.agenda.Clases.Persona
import com.example.agenda.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var lista : MutableList<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lista = mutableListOf()
        binding.btnAgregar.setOnClickListener{
            var nombre = binding.etNombre.text.toString()
            var telefono = binding.etTelefono.text.toString()
            var email = binding.etEmail.text.toString()

            if (nombre.isEmpty() || nombre.isBlank()){
                Snackbar.make(binding.etNombre, "Tiene que ingresar el nombre", Snackbar.LENGTH_SHORT).show()
            }else if (telefono.isEmpty() || telefono.isBlank()) {
                Snackbar.make(
                    binding.etNombre,
                    "Tiene que ingresar el telefono",
                    Snackbar.LENGTH_SHORT
                ).show()
            }else if (email.isEmpty() || email.isBlank()) {
                Snackbar.make(
                    binding.etNombre,
                    "Tiene que ingresar el email",
                    Snackbar.LENGTH_SHORT
                ).show()
            }else{
                lista.add(Persona(lista.size+1, nombre, telefono, email))
                Snackbar.make(binding.etNombre, "Elemento ${lista.size} guardado", Snackbar.LENGTH_SHORT).show()
                binding.etNombre.setText("")
                binding.etTelefono.setText("")
                binding.etEmail.setText("")
                binding.etNombre.requestFocus()
            }
        }

        binding.btnMostrar.setOnClickListener(){
            val gson = Gson()
            val json = gson.toJson(lista)
            val intent = Intent(this,Lista::class.java)
            intent.putExtra("lista", json)
            startActivity(intent)
        }
    }



}

// Gson

// Generar un ejemplo con el recyclerview