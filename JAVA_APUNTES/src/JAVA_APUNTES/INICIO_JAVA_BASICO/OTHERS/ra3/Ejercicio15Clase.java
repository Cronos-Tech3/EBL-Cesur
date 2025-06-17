package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio15Clase {
    public static void main(String[] args) {
        //  Escribe un programa que pregunte al usuario si desea analizar calificaciones de
        //alumnos y, sólo si responde “S” comenzará el procesamiento de los datos, hasta que el
        //usuario ingrese algo diferente de “S”. Por cada alumno, permitir ingresar su calificación.
        //Si es mayor a 4 el alumno está aprobado. Finalmente, mostrar “Porcentaje de alumnos
        //aprobados: x %” (donde x es el porcentaje de aprobados sobre el total de calificaciones
        //procesadas). También se debe imprimir “Promedio de los aprobados: y” (donde y es la
        //calificación promedio, sólo de los alumnos aprobados).

        Scanner scl = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        String quieres; //variable para almacenar la S

        // % de alumnos aprobados: totalAprobados/totalAlumnos * 100
        double totalAprobados = 0, totalAlumnos = 0;

        //promedio de aprobados: suma notas de los aprobados / totalAprobados

        double nota, sumaNotas = 0;

        System.out.println("¿Quieres evaluar alumnos? S/N");
        quieres = scl.nextLine();

        while (quieres.equalsIgnoreCase("S")) { //mientras que inserte una S hacemos cosas
            totalAlumnos++; //totalAlumnos = totalAlumnos + 1
            System.out.println("Inserte la nota del alumno");
            nota = scn.nextDouble();

            if (nota>4){
                totalAprobados++;
                sumaNotas += nota;

            }

            System.out.println("¿Quieres evaluar alumnos? S/N");
            quieres = scl.nextLine(); //volvemos a pedir la S
        }

        if (totalAprobados>0) {
            System.out.println("porcentaje de alumnos aprobados: " + (totalAprobados / totalAlumnos * 100) + "%");
            System.out.println("promedio de alumnos aprobados " + (sumaNotas / totalAprobados));

        } else  if (totalAlumnos>0) {
            System.out.println("No hay aprobados");
        }else {
            System.out.println("No hay datos suficientes");
        }

    }
}
