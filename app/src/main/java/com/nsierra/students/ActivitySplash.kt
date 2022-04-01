package com.nsierra.students

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class ActivitySplash : AppCompatActivity() {

    var Operaciones: Operations? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Operaciones = Operations()
        iniciarComponents()

    }

    private val response =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { valor ->
            if (valor.resultCode == RESULT_OK) {
                //resp y resp 2 almacenan el mismo dato, solo se muestran 2 formas como podria capturarse el dato
                val resp = valor?.data?.extras?.get("resultado") as String
                val resp2 = valor?.data?.getStringExtra("resultado")
                println("Valor respuesta=$resp y la resps2=$resp2")
                //capturamos el objeto nuevo y lo asignamos a operaciones
                Operaciones = valor?.data?.extras?.get("objetoOperaciones") as Operations?
                Operaciones?.printListEstudents()
            }
        }

    private fun iniciarComponents() {

        var operacionesEnviado: Bundle? = this.intent.extras
        Operaciones = operacionesEnviado?.getSerializable("operaciones") as Operations?

        val btnInicio: Button = findViewById(R.id.btnInicio)
        val btnEstadisticas: Button = findViewById(R.id.btnStadistics)
        val btnAyuda: Button = findViewById(R.id.btnHelp)

        btnInicio.setOnClickListener { onClick(1) }
        btnEstadisticas.setOnClickListener { onClick(2) }
        btnAyuda.setOnClickListener { onClick(3) }

    }

    private fun onClick(boton: Int) {

        when (boton) {
            1 -> {
                var miIntent: Intent = Intent(this, ActivityRegistroDatos::class.java)
                var miBundle: Bundle = Bundle()
                miBundle.putSerializable("operaciones", Operaciones)
                miIntent.putExtras(miBundle)
                response.launch(miIntent)
            }

            2 -> {
                var miIntent: Intent = Intent(this, ActivityStadistics::class.java)
                var miBundle: Bundle = Bundle()
                miBundle.putSerializable("operaciones", Operaciones)
                miIntent.putExtras(miBundle)
                response.launch(miIntent)
            }
            3 -> startActivity(Intent(this, ActivityHelp::class.java))

        }
    }
}
