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
                miBundle.putString("Nombre", "Pepe")
                miIntent.putExtras(miBundle)
                startActivity(miIntent)
            }

            2 -> startActivity(Intent(this, ActivityStadistics::class.java))
            3 -> startActivity(Intent(this, ActivityHelp::class.java))

        }
    }
}
