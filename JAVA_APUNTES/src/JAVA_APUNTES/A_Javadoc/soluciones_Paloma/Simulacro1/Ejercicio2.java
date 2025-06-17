package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro1;

import java.util.Scanner;

/**
 * Crea un programa que reciba un número del usuario. El programa pedirá al usuario ese número de
 * palabras y generará una frase añadiendo un espacio entre ellas.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        int numero;
        String palabra, frase = "";
        Scanner scn = new Scanner(System.in);
        Scanner scl = new Scanner(System.in);
/*
        while(true){
            try{
                numero = scn.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Ha habido un error");
                scn.nextLine();
            }//cierra try
        }//cierra while
        for (int i = 0; i < numero; i++) {
            palabra = scl.nextLine();
            frase += palabra + " ";
        }//cierra for
        System.out.println(frase.substring(0, frase.length()-1));
        System.out.println(frase.charAt(0));
        */
        try{
            numero = scn.nextInt();
            for (int i = 0; i < numero; i++) {
                palabra = scl.nextLine();
                frase += palabra + " ";
            }
            System.out.println(frase.substring(0, frase.length()-1));
            System.out.println(frase.charAt(0));
        }catch (Exception e){
            System.out.println("Ha habido un error");
        }
    }//cierra main
}//cierra clase
