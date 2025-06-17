package JAVA_APUNTES.ARRAYS.EJER;

import java.util.Scanner;

/**
 * Crear un vector de 5 elementos de cadenas de caracteres, inicializa el vector
 * con datos leídos por el teclado. Copia los elementos del vector en otro vector
 * pero en orden inverso, y muéstralo por la pantalla.
 */
public class ej3 {
    public static void main(String[] args) {

        String[] frase = new String[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce 5 palabras");
        for (int i = 0; i < frase.length; i++) {
            frase[i] = sc.nextLine();
        }
        for (String letras : frase) { //foreach no puede modificar los valores aunque lo pongas dentro;
            // sirve para recorrer el contenido de una colección
            System.out.println(letras);
        }



    }
}
