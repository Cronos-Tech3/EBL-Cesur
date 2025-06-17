package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Teatro teatro = new Teatro("Teatro Principal");
        teatro.agregarAsiento(4,2,50.0,false);
        teatro.agregarAsiento(0,1,100.0,true);
        teatro.agregarAsiento(3,4,75.0,false);
        teatro.agregarAsiento(0,3,150.0,true);

        System.out.println(teatro);

        teatro.calcularPrecios("martes");



    }
}
