package com.nsierra.students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityStadistics : AppCompatActivity() {

    var operaciones:Operations? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadistics)

        validar()
    }
    private fun validar(){
        var bundle: Bundle? = this.intent.extras
        operaciones = bundle?.getSerializable("operaciones") as Operations?

        var prom = operaciones?.listDataStudents?.get(0)?.promedio?.toDouble()
        var length = operaciones?.listDataStudents?.size

        val nR = findViewById<TextView>(R.id.textNR)
        nR.text = length.toString()

        val nG = findViewById<TextView>(R.id.textNG)

        var i = 0
        for(est in operaciones?.listDataStudents!!){
            if(est.promedio > 3.4){
                i += 1
            }
        }

        nG.text = i.toString()

        val nP = findViewById<TextView>(R.id.textNP)

        var k = 0
        for(est in operaciones?.listDataStudents!!){
            if(est.promedio < 3.5){
                k +=1
            }
        }

        nP.text = k.toString()

        val nRe = findViewById<TextView>(R.id.textNRE)

        var l = 0
        for(est in operaciones?.listDataStudents!!){
            if(est.promedio > 2.4 && est.promedio < 3.5){
                l +=1
            }
        }

        nRe.text = l.toString()
    }
}
