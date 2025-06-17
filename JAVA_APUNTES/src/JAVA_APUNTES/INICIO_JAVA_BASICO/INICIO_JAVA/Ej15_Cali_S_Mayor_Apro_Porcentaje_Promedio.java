package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej15_Cali_S_Mayor_Apro_Porcentaje_Promedio {
    public static void main(String[] args) {
        /*
        Escribe un programa que pregunte al usuario si desea analizar calificaciones de
        alumnos y, sólo si responde “S” comenzará el procesamiento de los datos, hasta que el
        usuario ingrese algo diferente de “S”. Por cada alumno, permitir ingresar su calificación.
        Si es mayor a 4 el alumno está aprobado. Finalmente, mostrar “Porcentaje de alumnos
        aprobados: x %” (donde x es el porcentaje de aprobados sobre el total de calificaciones
        procesadas). También se debe imprimir “Promedio de los aprobados: y” (donde y es la
        calificación promedio, sólo de los alumnos aprobados).
         */
        String quieres; //variable para almacenar la S
        //porcentaje de alumnos aprobados: totalAprobados/totalAlumnos * 100
        int totalAprobados = 0, totalAlumnos = 0;
        //promedio de aprobados: suma notas de los aprobados / totalAprobados
        double nota, sumaNotas = 0;

        Scanner scl = new Scanner(System.in); //para letras
        Scanner scn = new Scanner(System.in); //para numeros

        System.out.println("Quieres evaluar alumnos? S para si");
        quieres = scl.nextLine(); //el usuario inserta una S u otra cosa

        while(quieres.equalsIgnoreCase("S")){ //mientras que inserte una S hacemos cosas
            totalAlumnos++; //totalAlumnos = totalAlumnos + 1;

            System.out.println("Inserta la nota del alumno");
            nota = scn.nextDouble(); //pedimos una nota al usuario

            if(nota > 4){ //si la nota es mayor que 4 ha aprobado
                totalAprobados++; //totalAprobados = totalAprobados + 1 -> Sumando uno al total de aprobados
                sumaNotas += nota; //sumaNotas = sumaNotas + nota -> acumulando su nota en un sumatorio para poder hacer el promedio de notas
            }

            System.out.println("Quieres evaluar alumnos? S para si");
            quieres = scl.nextLine(); //volvemos a pedir al usuario una S
        }

        if(totalAprobados>0){ //si hay aprobados mostramos los datos
            //nos aseguramos de NO hacer una división entera, ponemos para ello el 1.0
            System.out.println("Porcentaje de alumnos aprobados: " + (totalAprobados*1.0/totalAlumnos*100) + "%");
            System.out.println("Promedio de aprobados: " + (sumaNotas/totalAprobados));
        }else if(totalAlumnos>0){ //si no hay alumnos aprobados pero si alumnos muestro mensaje
            System.out.println("No hay alumnos aprobados");
        }else{ //si no hay alumnos insertados muestro error
            System.err.println("No hay datos suficientes");
        }


    }
}
