package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej2_TresNotas_Media {
    public static void main(String[] args) {
        // Crea un programa que pida tres notas por pantalla y saque la media
        Scanner sc = new Scanner(System.in); // Declaramos Scanner
        System.out.println("ingrese la nota de matemáticas "); // Pedimos al usuario nota de matematicas
        double mat = sc.nextDouble(); // Pedimos por teclado la nota, en double para la media
        System.out.println("ingrese la nota de ingles");
        double ingles = sc.nextDouble();
        System.out.println("ingrese la nota de programacion");
        double programacion = sc.nextDouble();
        System.out.println("Su nota media de las tres asignaturas es " + ((mat + ingles + programacion)/3));
        // en caso de que el numero sea Int (mat + ingles + programacion)*1.0 / 3
        // multiplicamos el numero int * 1.0 para convertirlo en double
    }
}
