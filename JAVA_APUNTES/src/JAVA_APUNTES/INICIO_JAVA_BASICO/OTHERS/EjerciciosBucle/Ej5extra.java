package EjerciciosBucle;

import java.util.Scanner;

public class Ej5extra {
    public static void main(String[] args) {
        // Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media, la
        //cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden
        //más de 1.75.
        //pedir estatura y edad
        //sumatorioAlturas += altura
        //sumatorioEdad += edad
        //Si edad es más de 18; contador18++
        Scanner sc = new Scanner(System.in);
        final int NUM_ALUMNOS=5;
        int  edad, sumatorioEdad = 0, contador18 = 0, contador175 = 0;
        double altura, sumatorioAlturas = 0;

        for (int i = 0; i < 5; i++){
            System.out.println("Ingrese altura ");
            altura = sc.nextDouble();
            System.out.println("Ingrese edad ");
            edad = sc.nextInt();
            sumatorioEdad++;
            sumatorioAlturas++;
            if (edad>18){
                contador18++;

            } if (altura>1.75){
                contador175++;
            }
        }
        System.out.println("La media de edad es:  " + (sumatorioEdad*1.0/NUM_ALUMNOS));
        System.out.println("los alumnos con altura mayor a 1.75 son" + (sumatorioAlturas/NUM_ALUMNOS));
        System.out.println("Mayores de 18: " + contador18);
        System.out.println("Con altura de mas 1.75: " + contador175);
    }
}
