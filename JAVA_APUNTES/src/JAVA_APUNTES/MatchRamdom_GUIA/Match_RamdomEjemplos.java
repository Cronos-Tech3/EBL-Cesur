package JAVA_APUNTES.MatchRamdom_GUIA;

import java.util.Scanner;

public class Match_RamdomEjemplos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //entre 0 y 1 es el aleatorio
        double aleatorio = Math.random();
        System.out.println(aleatorio);

        // ahora estaria entre 0 y 6
        double aleatorio2 = Math.random()*6;
        System.out.println(aleatorio2);
        // al ser entero el siguiente rango seria de 0 a 5
        int aleatorio3 =(int) (Math.random()*6);
        System.out.println(aleatorio3);

        //para que el rango sea de 1 a 6

        int aleatorio4 = (int) (Math.random()*6)+1;
        System.out.println(aleatorio4);

        // entre 1 y 50

        int aleatorio5 = (int) (Math.random()*50)+1;
        System.out.println(aleatorio5);
        // entre 3 y 6
        int  aleatorio6 = (int) (Math.random()*4)+3;
        System.out.println(aleatorio6);
    }
}
