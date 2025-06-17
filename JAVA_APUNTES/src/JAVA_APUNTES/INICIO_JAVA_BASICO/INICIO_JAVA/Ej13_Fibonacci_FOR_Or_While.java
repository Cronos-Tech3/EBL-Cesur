package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

public class Ej13_Fibonacci_FOR_Or_While {
    public static void main(String[] args) {
        /*
        Crea un programa que muestre los primeros 10 números de la serie de Fibonacci.
         */
        //int num = 0;
        //Solucion con while limitando
       /* while(num<10){
            System.out.println(num1);
            num1 = num2;
            num2 = solucion;
            solucion = num1 + num2;
            num++;
            System.out.println(num1);
            System.out.println(num2);
        }*/
        //Solucion con while sabiendo el ultimo valor del rango
       /* while(solucion<34){
            num1 = num2;
            num2 = solucion;
            solucion = num1 + num2;
            System.out.println(solucion);
        }*/
        /*
        for (int solucion = num1 + num2; solucion < 34; solucion = num1 + num2) {
            num1 = num2;
            num2 = solucion;
            System.out.println(solucion);
        }
         */
        /* Este seria el adecuado sin saber el valor de fibonacci */
        int num1 = 0, num2 = 1;
        int solucion = num1 + num2;
        for (int i = 0; i < 10; i++) {
            System.out.println(num1);
            num1 = num2;
            num2 = solucion;
            solucion = num1 + num2;
        }
    }
}


