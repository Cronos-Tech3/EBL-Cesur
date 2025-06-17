package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej13_Cuotas_Compras {
    public static void main(String[] args) {
        // Una persona adquirió un producto para pagar en 20 meses. El primer mes pagó
        //10 €, el segundo 20 €, el tercero 40 € y así sucesivamente. Realizar un programa
        //para determinar cuánto debe pagar mensualmente y el total de lo que pagará
        //después de los 20 meses. Este programa puede servir para calcular otras
        //compras y con diferentes plazos
        int exponente = 2;
        double resultado = 5;
        double total = 0;
        for (int i = 1; i <= 20; i++) {
            resultado *= exponente;
            total += resultado;
            System.out.println("para el mes " + i + " hay que pagar: " + resultado);
        }
        System.out.println("el total a pagar es: " + total);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese en cuantas cuotas le gustaria pagar: ");

        double total2 = 0;
        int cuotas = sc.nextInt();
        System.out.println("Ingrese el pago inicial: ");
        double pagoInicial = sc.nextDouble();
        System.out.println("Ingrese el interes: ");
        double interes = sc.nextDouble();
        for (int i = 1; i <= cuotas; i++) {
            pagoInicial *= interes;
            total2 += pagoInicial;
            System.out.println("para el mes " + i + " hay que pagar: " + pagoInicial);
        }
        System.out.println("el total a pagar en " + cuotas + " cuotas: "  + total2);

    }
}
