package com.nsierra.students

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class ActivityRegistroDatos : AppCompatActivity() {

    var idStudent : EditText? = null;
    var nameStudent : EditText? = null;
    var ageStudent : EditText? = null;
    var phoneStudent : EditText? = null;
    var directionStudent : EditText? = null;

    var m1 : EditText? = null;
    var n1 : EditText? = null;

    var m2 : EditText? = null;
    var n2 : EditText? = null;

    var m3 : EditText? = null;
    var n3 : EditText? = null;

    var m4 : EditText? = null;
    var n4 : EditText? = null;

    var m5 : EditText? = null;
    var n5 : EditText? = null;

    var operaciones:Operations?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_datos)

        traerDatos()
    }

    private fun traerDatos() {

        operaciones= Operations()

        idStudent = findViewById(R.id.studentID)
        nameStudent = findViewById(R.id.studentName)
        ageStudent = findViewById(R.id.studentAge)
        phoneStudent = findViewById(R.id.studentPhone)
        directionStudent = findViewById(R.id.studentDirection)

        m1 = findViewById(R.id.mate1)
        m2 = findViewById(R.id.materia2)
        m3 = findViewById(R.id.materia3)
        m4 = findViewById(R.id.materia4)
        m5 = findViewById(R.id.materia5)

        n1 = findViewById(R.id.nota1)
        n2 = findViewById(R.id.nota2)
        n3 = findViewById(R.id.nota3)
        n4 = findViewById(R.id.nota4)
        n5 = findViewById(R.id.nota5)


        val btnAdd : Button = findViewById(R.id.btnAddDatos)
        btnAdd.setOnClickListener{ registerStudent()}
    }

    private fun registerStudent() {

        var student: Class_DStudents = Class_DStudents()

        student.studentId = idStudent?.text.toString().toInt()
        student.studentName = nameStudent?.text.toString()
        student.studentAge = ageStudent?.text.toString().toInt()
        student.studentDirection = directionStudent?.text.toString()
        student.studentPhone = phoneStudent?.text.toString().toInt()


        student.materia1 = m1?.text.toString()
        student.materia2 = m2?.text.toString()
        student.materia3 = m3?.text.toString()
        student.materia4 = m4?.text.toString()
        student.materia5 = m5?.text.toString()

        student.nota1 = n1?.text.toString().toDouble()
        student.nota2 = n2?.text.toString().toDouble()
        student.nota3 = n3?.text.toString().toDouble()
        student.nota4 = n4?.text.toString().toDouble()
        student.nota5 = n5?.text.toString().toDouble()


        if(idStudent?.text.toString() == "" || nameStudent?.text.toString() == "" ||
            ageStudent?.text.toString() == "" || phoneStudent?.text.toString() == "" ||
            directionStudent?.text.toString() == "" || m1?.text.toString() == "" ||
            n1?.text.toString() == "" || m2?.text.toString() == "" || n2?.text.toString() == "" ||
            m3?.text.toString() == "" || n3?.text.toString() == ""|| m4?.text.toString() == "" ||
            n4?.text.toString() == "" || m5?.text.toString() == "" || n5?.text.toString() == "") {
            Toast.makeText(this, "No fue posible realizar esta accion. Recuerda llenar todos los campos.", Toast.LENGTH_SHORT).show()
        }else if (n1?.text.toString().toDouble() !! > 5){
            Toast.makeText(this, "Recuerda que las notas no deben ser mayores a 5.", Toast.LENGTH_SHORT).show()
        }else if (n2?.text.toString().toDouble() !! > 5){
            Toast.makeText(this, "Recuerda que las notas no deben ser mayores a 5.", Toast.LENGTH_SHORT).show()
        }else if (n3?.text.toString().toDouble() !! > 5) {
            Toast.makeText(this, "Recuerda que las notas no deben ser mayores a 5.", Toast.LENGTH_SHORT).show()
        }else if (n4?.text.toString().toDouble() !! > 5){
            Toast.makeText(this, "Recuerda que las notas no deben ser mayores a 5.", Toast.LENGTH_SHORT).show()
        }else if (n5?.text.toString().toDouble() !! > 5){
            Toast.makeText(this, "Recuerda que las notas no deben ser mayores a 5.", Toast.LENGTH_SHORT).show()
        } else if (n1?.text.toString().toDouble() !! < 0){
            Toast.makeText(this, "Recuerda que las notas no deben ser menores a 0.", Toast.LENGTH_SHORT).show()
        }else if (n2?.text.toString().toDouble() !! < 0){
            Toast.makeText(this, "Recuerda que las notas no deben ser menores a 0.", Toast.LENGTH_SHORT).show()
        }else if (n3?.text.toString().toDouble() !! < 0){
            Toast.makeText(this, "Recuerda que las notas no deben ser menores a 0.", Toast.LENGTH_SHORT).show()
        }else if (n4?.text.toString().toDouble() !! < 0){
            Toast.makeText(this, "Recuerda que las notas no deben ser menores a 0.", Toast.LENGTH_SHORT).show()
        }else if (n5?.text.toString().toDouble() !! < 0){
            Toast.makeText(this, "Recuerda que las notas no deben ser menores a 0.", Toast.LENGTH_SHORT).show()
        }else {
            operaciones?.registerStudent(student)
            Toast.makeText(this, "Registro exitoso.", Toast.LENGTH_SHORT).show()

            student.promedio= operaciones!!.calcularPromedio(student)

            if (student.promedio > 3.5){
                Toast.makeText(this, "El estudiante ha ganado con un promedio de: " + student.promedio, Toast.LENGTH_SHORT).show()
            } else if (student.promedio > 2.5 || student.promedio < 3.5 ){
                Toast.makeText(this, "El estudiante aun puede recuperar. Su promedio es: " + student.promedio, Toast.LENGTH_SHORT).show()
            } else if(student.promedio < 2.5){
                Toast.makeText(this, "El estudiante ha perdido con un promedio de: " + student.promedio, Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(this, ActivityVerDatos::class.java))
            enviarDatos()

            operaciones?.printListEstudents()
        }
    }

    private fun enviarDatos() {
        var Intent: Intent = Intent(this, ActivityVerDatos::class.java)
        Intent.putExtra("Dato1", nameStudent?.getText().toString())

        Intent.putExtra("Dato2", m1?.getText().toString())
        Intent.putExtra("Dato3", n1?.getText().toString().toDouble())

        Intent.putExtra("Dato4", m2?.getText().toString())
        Intent.putExtra("Dato5", n2?.getText().toString().toDouble())

        Intent.putExtra("Dato6", m3?.getText().toString())
        Intent.putExtra("Dato7", n3?.getText().toString().toDouble())

        Intent.putExtra("Dato8", m4?.getText().toString())
        Intent.putExtra("Dato9", n4?.getText().toString().toDouble())

        Intent.putExtra("Dato10", m5?.getText().toString())
        Intent.putExtra("Dato11", n5?.getText().toString().toDouble())

        startActivity(Intent)
    }
    private fun devolverResultados(){
        var miIntent: Intent = Intent()
        miIntent.putExtra("resultado","Registro exitoso")
        var miBundle:Bundle= Bundle()
        miBundle.putSerializable("objetoOperaciones",operaciones)
        miIntent.putExtras(miBundle)
        //miIntent.putExtra("obj",operaciones)
        setResult(RESULT_OK,miIntent)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode== KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "Se cierra el registro Activity", Toast.LENGTH_SHORT).show()
            devolverResultados()
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }

}