package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej17_Piramide_N {
    public static void main(String[] args) {
        // Realiza un programa que pinte una pirámide por pantalla. La altura se debe
        //pedir por teclado. El carácter con el que se pinta la pirámide también se debe
        //pedir por teclado.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la altura de la piramide ");
        int n = sc.nextInt();
        System.out.println("introduce su ancho");
        int ContadordEspacios = sc.nextInt();
        int contadorNumeros = 1;
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < ContadordEspacios; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print(contadorNumeros + " ");
                contadorNumeros++;
            }
            ContadordEspacios--;
            System.out.println();
        }
    }
}
