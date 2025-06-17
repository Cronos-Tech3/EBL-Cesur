package JAVA_APUNTES.BUCLES.Bucles_Extra;
import java.util.Scanner;



public class Ej14 {
    public static void main(String[] args)  {
            //. Hacer un programa que muestre un cronometro, indicando las horas, minutos y
            //segundos. Se pedirá al usuario primero un número determinado de horas,
            //minutos y segundos.
             Scanner sc = new Scanner(System.in);
             System.out.println("Ingrese las horas ");
             int horas = sc.nextInt();
             System.out.println("Ingrese los minutos ");
             int minutos = sc.nextInt();
             System.out.println("Ingrese los segundos ");
             int segundos = sc.nextInt();
        // Horas a segundos: Dado que cada hora tiene 3600 segundos (60 minutos/hora * 60 segundos/minuto), multiplicamos las horas por 3600.
        //Minutos a segundos: Cada minuto tiene 60 segundos, así que multiplicamos los minutos por 60.
        //Segundos: Los segundos ya están en la unidad correcta, por lo que simplemente se suman.
        int totalSegundos = horas * 3600 + minutos * 60 + segundos;
        for (int i = 0; i < totalSegundos; i--) {
            int h = i / 3600;
            int m = (i % 3600) / 60;
            int s = i % 60;
            System.out.printf("%02d:%02d:%02d\n", h, m, s);

        }



    }

}
