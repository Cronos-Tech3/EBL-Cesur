package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej8_Fecha_Maniana {
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
        int mes = Integer.parseInt(fraseMes);
        int annio = Integer.parseInt(fraseAnio);
        int maniana = dia + 1;


        System.out.println("Hoy es el dia " + fraseDia + " del mes " + fraseMes + " del año " + fraseAnio);

        if (maniana>30) {
            mes++;
            maniana=1;
        }  if (mes>12){
            annio++;
            mes=1;
        }

        System.out.println("mañana es " + maniana + " del mes "  + mes + " del año " + annio);
        //Vanis a poner letras al mes, Enero = 1

        String mesletra;
        if (mes==1) {
            mesletra="Enero";
        }else if (mes==2) {
            mesletra = "Febrero";
        }else if (mes==3) {
            mesletra = "Marzo";
        }else if (mes==4) {
            mesletra = "abril";
        }else  if (mes==5) {
            mesletra = "mayo";
        }else if (mes==6) {
            mesletra = "junio";
        }else  if (mes==7) {
            mesletra = "julio";
        }else  if (mes==8) {
            mesletra = "agosto";
        }else   if (mes==9) {
            mesletra = "septiembre";
        }else  if (mes==10) {
            mesletra = "octubre";
        }else if (mes==11) {
            mesletra = "noviembre";
        }else {
            mesletra="diciembre";
        }
        System.out.println("Mañana es " + maniana + " del mes " + mesletra + " del año " + annio );

        switch (mes) {
            case 1:
                mesletra = "Enero";
                System.out.println("Enero");
                break;
            case 2:
                mesletra = "Febrero";
                System.out.println("Febrero");
                break;
        }

    }
}
