package com.example.joselitoaugustogironmartinez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityInformacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)
        initEvents()        //Iniciar evento para cambiar de activity, y permite que se muestre, cada vez que se regresa a esta activity
    }

    fun initEvents(){   //Funcion que permite regrear a la Activity principal, cuando se presione el Boton regresar
        val button = findViewById<Button>(R.id.regresarBoton)
        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}