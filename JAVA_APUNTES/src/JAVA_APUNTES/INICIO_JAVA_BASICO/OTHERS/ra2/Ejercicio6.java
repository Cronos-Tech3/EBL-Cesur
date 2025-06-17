package ra2;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Crea un programa que pregunte el número de capítulos de la nueva temporada de
        //“Haikyū!!” y devuelva si has acertado o no.
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos capitulos tiene la nueva temporada de Haikyu?");
        int num = sc.nextInt();
        final int capitulos = 25;

        String acierto = num == 25 ? " es correcto" : "es incorrecto ";
        System.out.println(acierto);

        String capitulosAcierto = num == capitulos ? "El numero de capitulos es correcto" : "El mumero es incorrecto, el numero correcto es el 25";
        String resultado;
        if (num==capitulos) {
            System.out.println("El numero de capitulos es correcto");
        } else {
            System.out.println("El numero de capitulos es incorrecto "  + "el numero correcto de capitulos es " + capitulos);
        }
    }
}
