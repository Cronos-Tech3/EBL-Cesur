package ra2;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        // Crea un juego que genere un número al azar del 0 al 5 y pida un número al usuario
        //para que acierte el número.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero del 0 al 5");
        int num = sc.nextInt();
        int aleatorio = (int) (Math.random()*6);
        String resultado = (num==aleatorio) ? "Enorabuena has acertado":"Fallaste perdedor,intente de nuevo muahahaha";

        System.out.println(resultado + " el numero correcto es " + aleatorio);
    }
}
