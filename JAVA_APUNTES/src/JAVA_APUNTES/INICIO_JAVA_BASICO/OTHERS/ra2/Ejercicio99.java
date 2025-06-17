package ra2;

import java.util.Scanner;

public class Ejercicio99 {
    public static void main(String[] args) {
        // Numero aleatorio entre 11,5 y 15,5
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entre el 11,5 y 15,5");
        float num = sc.nextFloat();
        double aleatorio = (float) (Math.random()*3.5)+11.5;
        String resultado = num==aleatorio ? "Has acertado":" Fallaste el numero correcto era ";
        System.out.println(resultado + (int)aleatorio/10);



    }
}
