package JAVA_APUNTES.BUCLES.Bucles_Extra;
import java.util.Scanner;
public class Ej14_Cronometro_Copilot {
    public static void main(String[] args) throws InterruptedException {
        //. Hacer un programa que muestre un cronometro, indicando las horas, minutos y
        //segundos. Se pedirá al usuario primero un número determinado de horas,
        //minutos y segundos.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce las horas: ");
        int horas = scanner.nextInt();
        System.out.println("Introduce los minutos: ");
        int minutos = scanner.nextInt();
        System.out.println("Introduce los segundos: ");
        int segundos = scanner.nextInt();
        scanner.close();

        int totalSegundos = horas * 3600 + minutos * 60 + segundos;

        for (int i = totalSegundos; i >= 0; i--) {
                    int h = i / 3600;
                    int m = (i % 3600) / 60;
                    int s = i % 60;
                    System.out.printf("%02d:%02d:%02d\n", h, m, s);
                    Thread.sleep(1000);
        }
        System.out.println("¡Tiempo terminado!");



    }
}
