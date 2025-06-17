package Calculadora_TCP;

import java.io.*;
import java.net.*;

/**
 * ServidorCalculadora es una clase que implementa un servidor TCP para realizar operaciones básicas de cálculo.
 * El servidor espera conexiones de clientes, recibe la operación y los números a operar, y devuelve el resultado.
 */
public class ServidorCalculadora {

    /**
     * Método principal que inicia el servidor y espera conexiones de clientes.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {

        /*
        Crea un ServerSocket que escucha en el puerto 12345.
        El try con recursos asegura que el ServerSocket se cierre automáticamente al finalizar.
         */
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor esperando conexiones...");

            /*
            Inicia un bucle infinito para aceptar conexiones de clientes.
             */
            while (true) {

                /*
                Acepta una conexión de cliente y crea los objetos BufferedReader y PrintWriter para
                manejar la entrada y salida de datos. El try con recursos asegura que estos objetos se
                cierren automáticamente al finalizar.
                 */
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     /*
                    clientSocket.getInputStream():
                        Este metodo obtiene el flujo de entrada (InputStream) asociado al socket del cliente
                        (clientSocket).
                        Este flujo de entrada permite leer los datos que el cliente envía al servidor.

                    new InputStreamReader(clientSocket.getInputStream()):

                        InputStreamReader es una clase que convierte un flujo de bytes (InputStream) en un flujo de
                        caracteres (Reader). Esto es necesario porque los datos enviados a través del socket son bytes,
                        pero queremos leerlos como caracteres (texto).

                   new BufferedReader(new InputStreamReader(clientSocket.getInputStream())):

                        BufferedReader es una clase que proporciona una manera eficiente de leer texto de un flujo de
                        caracteres (Reader). Utiliza un búfer para leer grandes bloques de datos a la vez, lo que mejora
                        el rendimiento en comparación con leer carácter por carácter.

                        Al envolver el InputStreamReader en un BufferedReader, podemos utilizar métodos
                        como readLine() para leer líneas completas de texto de manera eficiente.

                        Esta línea de código crea un BufferedReader que lee datos del flujo de entrada del socket del
                        cliente. Esto permite al servidor recibir y procesar los datos enviados por el
                        cliente de manera eficiente.
                      */

                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    /*
                    clientSocket.getOutputStream():

                        Este método obtiene el flujo de salida (OutputStream) asociado al socket del cliente
                        (clientSocket). Este flujo de salida permite enviar datos desde el servidor al cliente.

                    new PrintWriter(clientSocket.getOutputStream(), true):

                        PrintWriter es una clase que proporciona métodos para imprimir representaciones formateadas
                        de objetos en un flujo de salida de texto. Es útil para enviar datos de texto (como cadenas)
                        a través de un flujo de salida.

                        El primer argumento del constructor de PrintWriter es el flujo de salida (OutputStream)
                        obtenido del socket del cliente. Esto significa que los datos enviados a través de este P
                        rintWriter se enviarán al cliente.

                        El segundo argumento es un booleano (true en este caso) que indica si se debe activar el modo
                        de "auto-flush". Cuando el modo de auto-flush está activado, el PrintWriter vacía
                        automáticamente el búfer de salida cada vez que se llama a un método println, printf, o format.
                        Esto asegura que los datos se envíen inmediatamente al cliente sin necesidad de llamar
                        manualmente al método flush.
                     */

                    System.out.println("Conexión establecida con " + clientSocket.getInetAddress());
                    /*
                    Imprime un mensaje indicando que se ha establecido una conexión con el cliente.
                     */

                    String operation = in.readLine();
                    //Lee la operación enviada por el cliente.
                    out.println("Introduce el primer número: ");
                    //Envía un mensaje al cliente solicitando el primer número.
                    double num1 = Double.parseDouble(in.readLine());
                    //Lee el primer número enviado por el cliente y lo convierte a double.


                    out.println("Introduce el segundo número: ");
                    //Envía un mensaje al cliente solicitando el segundo número
                    double num2 = Double.parseDouble(in.readLine());
                    //Envía un mensaje al cliente solicitando el segundo número.
                    double result = performOperation(operation, num1, num2);
                    //Lee el segundo número enviado por el cliente y lo convierte a double.

                    out.println("El resultado de " + operation + " es: " + result);
                }   /*
                    Llama al metodo performOperation para realizar la operación especificada
                    con los números recibidos.
                    */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza la operación especificada con los dos números dados.
     * @param operation La operación a realizar (suma, resta, multiplicacion, division).
     * @param num1 El primer número.
     * @param num2 El segundo número.
     * @return El resultado de la operación.
     */
    private static double performOperation(String operation, double num1, double num2) {
        switch (operation) {
            case "suma":
                return num1 + num2;
            case "resta":
                return num1 - num2;
            case "multiplicacion":
                return num1 * num2;
            case "division":
                return num1 / num2;
            default:
                return Double.NaN;
        }
        /*
        Este bloque switch realiza la operación correspondiente según el valor de operation. Si la operación
        no es válida, devuelve Double.NaN.
         */
    }
}