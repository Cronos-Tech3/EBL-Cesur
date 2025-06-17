package Calculadora_TCP;

import java.io.*;
import java.net.*;

/**
 * ClienteCalculadora es una clase que implementa un cliente TCP para realizar operaciones básicas de cálculo.
 * El cliente se conecta al servidor, envía la operación y los números a operar, y recibe el resultado.
 */
public class ClienteCalculadora {

    /**
     * Método principal que inicia el cliente y se conecta al servidor.
     * Solicita al usuario la operación y los números, y muestra el resultado.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {

        /*
        Crea un Socket que se conecta al servidor en localhost en el puerto 12345.
        También crea los objetos BufferedReader y PrintWriter para manejar la entrada y salida de datos del socket,
        y un BufferedReader adicional para leer la entrada del usuario desde la consola.
        El try con recursos asegura que estos objetos se cierren automáticamente al finalizar.
         */
        try (Socket socket = new Socket("localhost", 12345);



             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

              /*
             socket.getInputStream():

                Este método obtiene el flujo de entrada (InputStream) asociado al socket (socket).
                        Este flujo de entrada permite leer los datos que el servidor envía al cliente.

            new InputStreamReader(socket.getInputStream()):

                InputStreamReader es una clase que convierte un flujo de bytes (InputStream) en un flujo de caracteres
                (Reader). Esto es necesario porque los datos enviados a través del socket son bytes, pero queremos
                leerlos como caracteres (texto).

            new BufferedReader(new InputStreamReader(socket.getInputStream())):

            BufferedReader es una clase que proporciona una manera eficiente de leer texto de un flujo de caracteres
            (Reader). Utiliza un búfer para leer grandes bloques de datos a la vez, lo que mejora el rendimiento en
            comparación con leer carácter por carácter.
            Al envolver el InputStreamReader en un BufferedReader, podemos utilizar métodos como readLine() para leer
            líneas completas de texto de manera eficiente.

            Resumen
            Esta línea de código crea un BufferedReader que lee datos del flujo de entrada del socket.
            Esto permite al cliente recibir y procesar los datos enviados por el servidor de manera eficiente.
              */

             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

             /*
             socket.getOutputStream():
                    Este método obtiene el flujo de salida (OutputStream) asociado al socket (socket).
                    Este flujo de salida permite enviar datos desde el cliente al servidor.

            new PrintWriter(socket.getOutputStream(), true):

                PrintWriter es una clase que proporciona métodos para imprimir representaciones formateadas de objetos
                en un flujo de salida de texto. Es útil para enviar datos de texto (como cadenas) a través de un flujo
                de salida.

                El primer argumento del constructor de PrintWriter es el flujo de salida (OutputStream) obtenido del ç
                socket.
                Esto significa que los datos enviados a través de este PrintWriter se enviarán al servidor.

                El segundo argumento es un booleano (true en este caso) que indica si se debe activar el modo
                de "auto-flush". Cuando el modo de auto-flush está activado, el PrintWriter vacía automáticamente el
                búfer de salida cada vez que se llama a un método println, printf, o format.
                Esto asegura que los datos se envíen inmediatamente al servidor sin necesidad de llamar manualmente
                al método flush.

            Resumen
                Esta línea de código crea un PrintWriter que envía datos al flujo de salida del socket.
                El modo de auto-flush está activado, lo que garantiza que los datos se envíen inmediatamente al
                servidor cada vez que se imprime algo.
                */

             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            /*
            System.in:

                System.in es el flujo de entrada estándar que permite leer datos desde la consola.
                Es un flujo de bytes (InputStream) que representa la entrada del usuario.

            new InputStreamReader(System.in):

                InputStreamReader es una clase que convierte un flujo de bytes (InputStream) en un flujo de caracteres
                (Reader). Esto es necesario porque los datos introducidos por el usuario en la consola son bytes, pero
                queremos leerlos como caracteres (texto).

            new BufferedReader(new InputStreamReader(System.in)):

                BufferedReader es una clase que proporciona una manera eficiente de leer texto de un flujo de
                caracteres (Reader). Utiliza un búfer para leer grandes bloques de datos a la vez, lo que mejora el
                rendimiento en comparación con leer carácter por carácter.

                Al envolver el InputStreamReader en un BufferedReader, podemos utilizar métodos como readLine() para
                leer líneas completas de texto de manera eficiente.
            Resumen
                Esta línea de código crea un BufferedReader que lee datos de la entrada estándar (la consola).
                Esto permite al cliente recibir y procesar la entrada del usuario de manera eficiente.
             */

            System.out.print("Introduce la operación (suma, resta, multiplicacion, division): ");
            //Imprime un mensaje solicitando al usuario que introduzca la operación que desea realizar.

            String operation = stdIn.readLine();
            //Lee la operación introducida por el usuario desde la consola.
            out.println(operation);
            //Envía la operación al servidor.

            System.out.print(in.readLine());
            //Lee e imprime el mensaje del servidor solicitando el primer número.
            String num1 = stdIn.readLine();
           // Lee el primer número introducido por el usuario desde la consola.
            out.println(num1);
            //Envía el primer número al servidor.

            System.out.print(in.readLine());
            //Lee e imprime el mensaje del servidor solicitando el segundo número.
            String num2 = stdIn.readLine();
            //Lee el segundo número introducido por el usuario desde la consola.
            out.println(num2);
            //Envía el segundo número al servidor.

            System.out.println(in.readLine());
            //Lee e imprime el resultado de la operación enviado por el servidor.
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        catch (IOException e) {:

            Este es el inicio de un bloque catch que captura excepciones de tipo IOException.
            Las excepciones IOException son lanzadas por operaciones de entrada/salida que fallan o son interrumpidas.
            Esto incluye errores de red, problemas de lectura/escritura de archivos, etc.
            La sintaxis catch (IOException e) indica que cualquier excepción de tipo IOException que ocurra dentro del
            bloque try será capturada y manejada por este bloque catch.

        e.printStackTrace();:

                Este metodo imprime el seguimiento de la pila de la excepción (e) a la consola.
                El seguimiento de la pila es una lista de los métodos que estaban en ejecución en el momento en que se
                lanzó la excepción.
                Esto es útil para depurar, ya que proporciona información sobre dónde y por qué ocurrió la excepción.

         */
    }
}