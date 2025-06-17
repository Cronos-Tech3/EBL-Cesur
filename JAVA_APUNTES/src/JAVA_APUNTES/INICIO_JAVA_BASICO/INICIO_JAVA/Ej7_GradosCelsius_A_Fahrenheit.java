package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej7_GradosCelsius_A_Fahrenheit {
    public static void main(String[] args) {
        /*Creaunprograma que pida al usuario una temperatura en grados Celsius y la
        transforme en Fahrenheit. Celsius = (5/9) * (Fahrenheit-32)
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero representando los grados celsius");
        double num = sc.nextDouble(); //Pedimos numero
        double farem = num*9/5+32;    // declaramos variable con el num introducido para pasarlos a faremhein
        System.out.println(farem + " Grados Faremheim");
    }
}
