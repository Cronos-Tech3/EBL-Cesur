package ahoracado;

import java.util.Arrays;
import java.util.Scanner;

public class MainAhorcado {
    public static void main(String[] args) {
        //instancio el Ahorcado
        Ahorcado juego = new Ahorcado();
        //muestro la solucion para ayudarme a debuggear
        System.out.println(juego.solucion);
        Scanner sc = new Scanner(System.in);
        //mientras me queden intentos
        while(juego.intentos>0){
            //muestro lo que hay en el array
            System.out.println(Arrays.toString(juego.solucionArray));
            //pinto el dibujo
            System.out.println(juego.pintarAhorcado());
            System.out.println("inserta una letra");
            String letra = sc.nextLine();
            //llamo al método
            if(juego.buscarLetra(letra)){
                System.out.println("Has acertado letra");
            }else{
                System.out.println("Esa letra no está");
            }
            //si he acertado el mismo número de letras que hay en la palabra he ganado
            if(juego.aciertos==juego.solucion.length()){
                System.out.println("Has ganado");
                break;
            }
        }
    }
}
