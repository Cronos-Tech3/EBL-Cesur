package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej5Edades_Altura_Media_EdadMayor {
    public static void main(String[] args) {
        //Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media, la
        //cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden
        //más de 1.75.
        final int NUM_ALUMNOS = 5;
        int edad, sumaEdad = 0, contador18 = 0, contador175 = 0;
        double altura, sumaAltura = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < NUM_ALUMNOS; i++){
            System.out.print("Ingrese su edad: ");
            edad = sc.nextInt();
            System.out.print("Ingrese su altura: ");
            altura = sc.nextDouble();
            sumaAltura += altura;
            sumaEdad += edad;
            if (edad > 18){
                contador18++;
            }
            if (altura > 1.75){
                contador175++;
            }
        }
        System.out.println("La media de edad es: " + (sumaEdad*1.0/NUM_ALUMNOS));
        System.out.println("La media de altura es: " + (sumaAltura/NUM_ALUMNOS));
        System.out.println("Los alumnos mayores de 18 son: " + contador18);
        System.out.println("Los alumnos mayores de 1.75 son: " + contador175);
    }
}
