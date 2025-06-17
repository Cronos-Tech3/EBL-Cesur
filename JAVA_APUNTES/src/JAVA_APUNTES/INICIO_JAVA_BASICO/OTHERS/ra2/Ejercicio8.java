package ra2;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        //Crea un programa que reciba una fecha con el formato DD/MM/AAAA y muestre la
        //frase “Hoy es el día DD del mes MM del año AAAA”, cambiando las letras por DD, MM y
        //AAAA por lo datos insertados.
        //Extra sumar un dia a la fecha
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una fecha en formato dd/mm/yyyy");
        String fecha = sc.nextLine();
        String fraseDia = fecha.substring(0,2);
        String fraseMes = fecha.substring(3,5);
        String fraseAnio = fecha.substring(6,10);
        int dia = Integer.parseInt(fraseDia);
        int diaMasUno = dia + 1;


        System.out.println("Hoy es el dia " + fraseDia + " del mes " + fraseMes + " del año " + fraseAnio);

        System.out.println(" mañana es " + diaMasUno + " del mes " + fraseMes + " del año " + fraseAnio);
    }
}
