package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.teatroSol;

/**
 *Clase principal Main:
 * − main(String[] args)
 * o Descripción: El método principal donde se prueba la funcionalidad del programa.
 * o Acciones Esperadas:
 * − Crea un objeto Teatro.
 * − Agrega algunos asientos utilizando el método agregarAsiento.
 * − Muestra la disposición del teatro utilizando el método toString.
 * − Calcula y muestra los precios para un día específico utilizando el método
 * calcularPrecios.
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Teatro teatro = new Teatro("Teatro Principal");
        teatro.agregarAsiento(4,2,10.0,false);
        teatro.agregarAsiento(0,1,10.0,true);
        teatro.agregarAsiento(3,4,10.0,false);
        teatro.agregarAsiento(0,3,10.0,true);
        teatro.agregarAsiento(5,2,10.0,false);
        teatro.agregarAsiento(1,1,10.0,true);
        teatro.agregarAsiento(3,4,10.0,false);
        teatro.agregarAsiento(10,3,10.0,true);

        System.out.println(teatro);

        teatro.calcularPrecios("martes");
        System.out.println("*************************");
        teatro.calcularPrecios("jueves");


    }
}
