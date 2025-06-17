package JAVA_APUNTES.A_Javadoc.teoria;

public class array {
    /**
     * ¡Claro! Los arrays en Java son estructuras de datos que permiten almacenar múltiples valores del mismo tipo en una sola variable. Aquí tienes una explicación sencilla de cómo funcionan:
     *
     * 1. **Declaración y creación de un array**:
     *    Para declarar un array, especificas el tipo de datos seguido de corchetes `[]`. Luego, puedes crear el array usando la palabra clave `new` y especificando el tamaño del array.
     *    ```java
     *    int[] numeros = new int[5]; // Crea un array de enteros con 5 elementos
     *    ```
     *
     * 2. **Inicialización de un array**:
     *    Puedes inicializar un array al momento de crearlo o asignar valores a cada elemento individualmente.
     *    ```java
     *    int[] numeros = {1, 2, 3, 4, 5}; // Inicialización al momento de la creación
     *    numeros[0] = 10; // Asignar un valor al primer elemento
     *    ```
     *
     * 3. **Acceso a los elementos de un array**:
     *    Puedes acceder a los elementos de un array usando su índice, que comienza en 0.
     *    ```java
     *    int primerNumero = numeros[0]; // Acceder al primer elemento
     *    System.out.println("El primer número es: " + primerNumero);
     *    ```
     *
     * 4. **Recorrer un array**:
     *    Puedes usar un bucle `for` para recorrer todos los elementos de un array.
     *    ```java
     *    for (int i = 0; i < numeros.length; i++) {
     *        System.out.println("Elemento en el índice " + i + ": " + numeros[i]);
     *    }
     *    ```
     *
     * 5. **Arrays multidimensionales**:
     *    También puedes crear arrays de más de una dimensión, como matrices.
     *    ```java
     *    int[][] matriz = new int[3][3]; // Crea una matriz de 3x3
     *    matriz[0][0] = 1; // Asignar un valor a un elemento de la matriz
     *    ```
     *
     * Aquí tienes un ejemplo completo que muestra cómo declarar, inicializar y recorrer un array en Java:
     *
     * ```java
     * public class EjemploArray {
     *     public static void main(String[] args) {
     *         // Declarar y crear un array
     *         int[] numeros = new int[5];
     *
     *         // Inicializar el array
     *         numeros[0] = 10;
     *         numeros[1] = 20;
     *         numeros[2] = 30;
     *         numeros[3] = 40;
     *         numeros[4] = 50;
     *
     *         // Recorrer el array y mostrar los elementos
     *         for (int i = 0; i < numeros.length; i++) {
     *             System.out.println("Elemento en el índice " + i + ": " + numeros[i]);
     *         }
     *     }
     * }
     * ```
     *
     * Espero que esta explicación te haya sido útil. Si tienes alguna pregunta o necesitas más detalles, ¡dímelo! 😊*/
}
