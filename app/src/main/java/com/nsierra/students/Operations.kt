package com.nsierra.students
import java.io.Serializable


class Operations : Serializable {
    var listDataStudents : ArrayList<Class_DStudents> = arrayListOf<Class_DStudents>()

    fun registerStudent(student: Class_DStudents){

        listDataStudents.add(student)


    }

    fun printListEstudents(){
        for(student in listDataStudents){
            println(student)
        }
    }

    fun calcularPromedio(student: Class_DStudents): Double {

        var prom=(student.nota1 + student.nota2 + student.nota3 + student.nota4 + student.nota4 + student.nota5)/5

        return prom


    }

    fun consultarLista(student: Class_DStudents) {
        println(student)
    }
}