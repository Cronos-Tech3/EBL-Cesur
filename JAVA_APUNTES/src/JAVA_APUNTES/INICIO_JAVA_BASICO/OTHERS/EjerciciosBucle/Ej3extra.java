package EjerciciosBucle;

import java.util.Scanner;

public class Ej3extra {
    public static void main(String[] args) {
        //Pedir un número y calcular su factorial.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int n = sc.nextInt();
        int producto = 1;

       for( int i = n; i > 0; i--){
          producto *= i;
       }
        System.out.println(producto);
    }
}
