package JAVA_APUNTES.RA6;

import java.util.Arrays;

public class AraryPruebas {
    public static void main(String[] args) {
        //declarando un array de numeros
        int [] numeros;
        //inicilizando el array con 5 posiciones
        numeros = new int[5];
        //rellenar el array con un numero aleatorio entre el 1 y el 10
        //numeros[0] = (int)( Math.random()*10 + 1 );
        //numeros[1] = (int)( Math.random()*10 + 1 );
        //numeros[2] = (int)( Math.random()*10 + 1 );
        //numeros[3] = (int)( Math.random()*10 + 1 );
        //numeros[4] = (int)( Math.random()*10 + 1 );

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)( Math.random()*10 + 1 );
            System.out.print(numeros[i]);
        }
        System.out.println("************");
        for(int num : numeros){
            num = 3;
            System.out.print(num);
        }
        System.out.println("************");
        for(int num : numeros) {
            System.out.print(num);
        }
        System.out.println("************");
        Arrays.sort(numeros); //ordeno de menor a mayor
        System.out.println(numeros[0]); //muestro el menor
        System.out.println(Arrays.toString(numeros)); //muestro como un string


        int[] diasMes = {31, 28, 31, 30, 31};

    }
}
