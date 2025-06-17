package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

public class Ejercicio13Clase {
    public static void main(String[] args) {
        // crea un programa que muestre los 10 primeros numeros de la serie Fibonacci

        int num = 0;
        int num1= 0, num2 = 1, solucion=num1+num2;
        while(num<10){
            System.out.println(num1);
            num1 = num2;
            num2 = solucion;
            solucion = num1 + num2;

            num++;
        }

        for (int i = 0; i < 10; i++ ){
            System.out.println(num1);
            num1 = num2;
            num2 = solucion;
            solucion = num1 + num2;

            num++;

        }










    }
}
