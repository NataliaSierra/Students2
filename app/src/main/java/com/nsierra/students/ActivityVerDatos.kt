package com.nsierra.students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class ActivityVerDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_datos)


        val bundle = intent.extras
        val dato1 = bundle?.getString("Dato1")
        val dato2 = bundle?.getString("Dato2")
        val dato3 = bundle?.getDouble("Dato3")
        val dato4 = bundle?.getString("Dato4")
        val dato5 = bundle?.getDouble("Dato5")
        val dato6 = bundle?.getString("Dato6")
        val dato7 = bundle?.getDouble("Dato7")
        val dato8 = bundle?.getString("Dato8")
        val dato9 = bundle?.getDouble("Dato9")
        val dato10 = bundle?.getString("Dato10")
        val dato11 = bundle?.getDouble("Dato11")

        val nameTxT : TextView = findViewById(R.id.nameE)
        val mate1 : TextView = findViewById(R.id.mate1)
        val note1 : TextView = findViewById(R.id.note1)
        val mate2 : TextView = findViewById(R.id.mate2)
        val note2 : TextView = findViewById(R.id.note2)
        val mate3 : TextView = findViewById(R.id.mate3)
        val note3 : TextView = findViewById(R.id.note3)
        val mate4 : TextView = findViewById(R.id.mate4)
        val note4 : TextView = findViewById(R.id.note4)
        val mate5 : TextView = findViewById(R.id.mate5)
        val note5 : TextView = findViewById(R.id.note5)

        nameTxT.text = dato1.toString()

        mate1.text = dato2.toString()
        note1.text = dato3.toString()

        mate2.text = dato4.toString()
        note2.text = dato5.toString()

        mate3.text = dato6.toString()
        note3.text = dato7.toString()

        mate4.text = dato8.toString()
        note4.text = dato9.toString()

        mate5.text = dato10.toString()
        note5.text = dato11.toString()
    }
}