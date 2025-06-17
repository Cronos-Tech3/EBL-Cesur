package JAVA_APUNTES.Try_Catch_Pruebas;

import java.util.Scanner;

public class Ej16_Error_Try_Catch {
    public static void main(String[] args) {
        /*
        Crea un programa que reciba una frase e imprima por pantalla cada letra de la frase.
         */
        String frase;
        int contador = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta una frase");
        frase = sc.nextLine();

        while(contador<=frase.length()){
            try {
                System.out.println(frase.charAt(contador)); //0 1 2
            } catch (StringIndexOutOfBoundsException nombreE){
                System.out.println(nombreE.getMessage()); // aqui estamos diciendo que imprima el error que hemos llamado nombreE con todo su mensaje

                System.out.println("Hubo un error, intentaste acceder a una posicion del string que no existe while(contador<frase NO <=");
            } catch (Exception e) {
                System.out.println("hubo un error inesperado");
            }
            contador++;
        }
    }
}
