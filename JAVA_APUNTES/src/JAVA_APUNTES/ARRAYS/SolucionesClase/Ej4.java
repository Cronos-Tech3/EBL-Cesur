package solucionesEjerciciosArrys;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[][] mesesDias = {
                {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"},
                {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"}
        };
        System.out.println("Inserta un numero de mes");
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                int num = sc.nextInt();
                System.out.println("El mes es: " + mesesDias[0][num-1] + " con " + mesesDias[1][num-1] + " dias.");
                System.out.println("El mes es: " + meses[num-1] + " con " + dias[num-1] + " dias.");
                break;
            }catch (InputMismatchException ipe){
                System.out.println("Insertaste una letra en lugar de un numero");
                sc.nextLine();
            }catch (IndexOutOfBoundsException iobe){
                System.out.println("Insertaste un mes no válido");
            }
        }


    }
}
