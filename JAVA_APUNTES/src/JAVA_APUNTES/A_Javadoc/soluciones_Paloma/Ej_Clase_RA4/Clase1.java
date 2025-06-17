package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Clase_RA4;

import java.util.Scanner;

public class Clase1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arbol roble1 = new Arbol(5, 5, "roble");
        Arbol roble2 = new Arbol(6, 6, "roble");
        Arbol roble3 = new Arbol(-10, 7, "roble");
        System.out.println(roble3.altura);

        System.out.println(roble1.caduca);

        roble1.sumarAnio(1);


        Mamifero humano = new Mamifero();
        humano.numPatas=2;
        humano.desplazamiento="andar";
        humano.carnivoro = false;
        humano.especie = "Homo sapiens";
        humano.extinto = false;

        humano.comeCarne();
        System.out.println(humano.moverse());
        humano.comprobarExtincion(false);

    }
}
