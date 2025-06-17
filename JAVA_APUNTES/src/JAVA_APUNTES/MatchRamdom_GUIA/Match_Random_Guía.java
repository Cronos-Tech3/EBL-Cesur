package JAVA_APUNTES.Random;

import java.util.Random;

public class Match_Random_Guía {
    public static void main(String[] args) {
        int aleatorio1 = (int) (Math.random()*51)+10;      // entre 10 y 60
        System.out.println(aleatorio1);

        int aleatorio2 = (int) (Math.random()*51)+50;      // Entre 50 y 100
        System.out.println(aleatorio2);
                                                                //Recordamos que el *50 incluye del 0 al 50 por eso añadimos 1 más

        int  aleatorio6 = (int) (Math.random()*4)+3;       //entre 3 y 6
        System.out.println(aleatorio6);

        int  aleatorio7 = (int) (Math.random()*201)+100;    //entre 100 y 300
        System.out.println(aleatorio7);

        //Clase Ramdom   Crea un objeto random al que les das valores en variables
        System.out.println("Comienza la clase Random");

        Random hola = new Random();
        int holaRandom = hola.nextInt(120)+10;       //Entre 10 y 130
                                                                //Se suman y tienes el numero maximo
        System.out.println(holaRandom);
        int holaRandom2 = hola.nextInt(100)+50;      //Entre 50 y 150
        System.out.println(holaRandom2);



    }


}
