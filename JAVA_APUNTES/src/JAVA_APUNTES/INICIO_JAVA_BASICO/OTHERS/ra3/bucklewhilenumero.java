package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;


import java.util.Scanner;

public class bucklewhilenumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserta un numero para mostrar su tabla de multiplicacion");
        int usuario = sc.nextInt();
        int num= 0;
        while(num<=10){
            System.out.println(usuario + " x " + num + " = " + (num*usuario));
            num++;
        }
    }
}
