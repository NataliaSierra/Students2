package com.nsierra.students

import android.widget.EditText
import java.io.Serializable

class Class_DStudents : Serializable{

    var studentId : Int = 0;
    var studentName : String = "";
    var studentAge: Int = 0;
    var studentPhone: Int = 0;
    var studentDirection: String  = "";



    var materia1: String = "";
    var nota1: Double = 0.0;

    var materia2: String = "";
    var nota2: Double = 0.0;

    var materia3: String = "";
    var nota3: Double = 0.0;

    var materia4: String = "";
    var nota4: Double = 0.0;

    var materia5: String = "";
    var nota5: Double = 0.0;


    var estado : String = "";
    var promedio : Double = 0.0;


    override fun toString(): String {
        return "Estudiante(Documento='$studentId', Nombre='$studentName'," +
                " Edad=$studentAge, Telefono='$studentPhone', Direccion='$studentDirection'," +
                " Materia 1='$materia1', Materia 2='$materia2', " +
                "Materia 3='$materia3', Materia 4='$materia4', Materia 5='$materia5'," +
                " Nota 1=$nota1, Nota 2=$nota2, Nota 3=$nota3, Nota 4=$nota4, " +
                "Nota 5=$nota5, Promedio=$promedio)"
    }

}
