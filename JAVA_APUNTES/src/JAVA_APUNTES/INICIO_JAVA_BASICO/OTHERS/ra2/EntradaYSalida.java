package ra2;

import java.util.Scanner;

public class EntradaYSalida {
    public static void main(String[] args) {
        //metodo estatico de la clase system
        System.out.println("hola");
        System.err.println("Cacatua");
        //entrada estandar
        //
        int num;
        String frase;
        // scanner para numero y scanner para letras
        Scanner sn = new Scanner(System.in);
        Scanner sl = new Scanner(System.in);

        System.out.println("Inserte un numero");
        num = sn.nextInt();
        System.out.println("el numero es " + num);

        System.out.println("Ingrese una frase");
        frase = sl.nextLine();
        System.out.println("La frase escrita es " + frase);






    }
}
