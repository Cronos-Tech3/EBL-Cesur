package JAVA_APUNTES.Entornos_JavaDoc.MiniCalculadora;

public class miniCalculadora {

    /**
     * Suma dos numeros enteros.
     * @author EnriqueBenitoLopez
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return La suma de a y b.
     */

    public int suma(int a, int b) {
        return a + b;
    }

    /**
     * Resta el segundo número del primero.
     *
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return La diferencia entre a y b.
     */
    public int resta(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos numeros enteros.
     *
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return El producto de a y b.
     */
    public int multiplica(int a, int b) {
        return a * b;
    }

    /**
     * Divide el primer numero por el segundo.
     *
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return El cociente de a dividido por b.
     * @throws ArithmeticException Si b es igual a 0.
     */
    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return (double) a / b;
    }

    /**
     * Calcula el factorial de un numero.
     *
     * @param n El numero para el cual se desea calcular el factorial.
     * @return El factorial de n.
     * @throws IllegalArgumentException Si n es negativo.
     */
    public long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
