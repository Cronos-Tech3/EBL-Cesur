package ra2;

import java.util.Scanner;

public class ejercicio9IF {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero del 0 al 5");
        int num = sc.nextInt();
        int aleatorio = (int) (Math.random()*6);
        String resultado = (num==aleatorio) ? "Enorabuena has acertado":"Fallaste perdedor,intente de nuevo muahahaha";

        System.out.println(resultado + " el numero correcto es " + aleatorio);

        if (num==aleatorio) {
            System.out.println("Acertastes, el numero correcto era " + aleatorio );
        } else {
            System.out.println("Fallaste, el numero correcto era " + aleatorio);
        }

    }
}
