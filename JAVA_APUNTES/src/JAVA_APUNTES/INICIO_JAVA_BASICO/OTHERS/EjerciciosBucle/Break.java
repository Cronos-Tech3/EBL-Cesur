package EjerciciosBucle;

import java.util.Scanner;

public class Break {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 3;
        while (true){
            System.out.println("hola inserta un numero");
            x = sc.nextInt();
            if(x==3){
                System.out.println("dentro del if");
                break;
            } else if (x==4){
                continue;
            }

            System.out.println("final de la interaccion");
        }
        System.out.println("Adios");
    }
}
