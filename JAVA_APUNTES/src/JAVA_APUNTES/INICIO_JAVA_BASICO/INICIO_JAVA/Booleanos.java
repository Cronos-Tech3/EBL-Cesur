package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

public class Booleanos {
    public static void main(String[] args) {
        // para 2 valores vamos a mostrar todos los operadores aritmeticos
        int num1, num2;
        num1 = 8;
        num2 = 5;
        int suma, resta, multi, divi, resto;
        suma = num1 + num2;
        resta = num1 - num2;
        multi = num1 * num2;
        divi = num1 / num2;
        resto = num1 % num2;
         // ahora mostraremos con el mismo valor de num1 y num2 los valores logicos, relacionales o booleanos
        // valor de asignacion, estamos asignando el valor de x e y
        int x = num1;
        int y = num2;
        //igualdad
        boolean igualdad;
        igualdad = num1 == num2;
        System.out.println("¿son iguales los Pruebas_X.numeros? " + igualdad);
        // mayor que >=
        boolean mayorque;
        mayorque = num1 > num2;
        System.out.println("el primer numero es mayor que el segundo " + mayorque);
        // menor que <
        boolean menorque = num1 < num2;
        System.out.println("el primer numero es menor que el segundo "+ menorque);
        // mayor igual que >=
        boolean mayor = num1 >= num2;
        System.out.println(" el primer numero es mayor o igual que el segundo "+ mayor );
        //
        boolean nologico = num1 != num2;
        System.out.println("¿el numero uno, no es igual al numero 2 ?" + nologico);
        //
        // si es menor igual que
        String s = num1 <= num2 ? "True" : "false";
        System.out.println("el primer numero es menor o igual " + s);


    }
}
