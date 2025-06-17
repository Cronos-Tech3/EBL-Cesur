package JAVA_APUNTES.Try_Catch_Pruebas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryPruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        while(true){

            try {
             x = sc.nextInt();
                break;
            } catch (InputMismatchException sE) {
            System.out.println("hubo un error");
            System.out.println(sE.getMessage());
            sc.nextLine(); // sirve para vaciar el buffer, porque al dar enter,
                           // ese espacio nos llena el buffer y se bloquea y entra en bucle infinito
            }
        }
        System.out.println(x);



    }
}
