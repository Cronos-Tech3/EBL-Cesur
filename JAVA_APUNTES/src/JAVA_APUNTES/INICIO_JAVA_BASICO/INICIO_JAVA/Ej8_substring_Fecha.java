package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej8_substring_Fecha {
    public static void main(String[] args) {
        //Crea un programa que reciba una fecha con el formato DD/MM/AAAA y muestre la
        // frase “Hoy es el día DD del mes MM del año AAAA”, cambiando las letras por DD, MM y
        // AAAA por lo datos insertados.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una fecha en formato DD/MM/YYYY ");
        String fecha = sc.nextLine();
        String trozoDia = fecha.substring(0,2); // Con substring estamos pidiendo que de DD/MM/YYYY trozoDia
        String trozoMes = fecha.substring(3,5);
        String trozoAnio = fecha.substring(6,10);
        System.out.println("Hoy es el dia " + trozoDia + " del mes " + trozoMes + " del año " + trozoAnio);

    }
}
