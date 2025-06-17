package Calculadora_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * ClienteCalculadoraUDP es una clase que implementa un cliente UDP para enviar operaciones básicas de cálculo al servidor.
 * El cliente envía la operación y los números a operar, y recibe el resultado del servidor.
 */
public class ClienteCalculadoraUDP {

    /**
     * Método principal que inicia el cliente y envía paquetes de datos al servidor.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            /*---------------------EXPLICACIÓN-----------------------------
            Bloque try con Recursos:

                try (DatagramSocket clientSocket = new DatagramSocket()) {
                        Función:
                            Este es un bloque try con recursos, lo que significa que cualquier recurso declarado dentro
                             de los paréntesis será cerrado automáticamente al final del bloque try.

                            Ventaja: Esto asegura que el socket se cierre correctamente, incluso si ocurre
                            una excepción, evitando posibles fugas de recursos.

                    Creación del Socket UDP:

                        DatagramSocket clientSocket = new DatagramSocket()
                            Función: Crea un nuevo socket UDP (DatagramSocket) para el cliente.
                            Sin Parámetros: Al no especificar un puerto, el sistema operativo asigna automáticamente
                                            un puerto disponible para el socket.

            Contexto
                En el contexto de tu cliente UDP, esta línea es parte del proceso para establecer la comunicación con
                el servidor. Aquí está el flujo completo:

            Creación del Socket:
                El cliente crea un socket UDP (clientSocket) que se utilizará para enviar y recibir paquetes de datos.

            Bloque try con Recursos:
                El uso de un bloque try con recursos asegura que el socket se cierre automáticamente al final del
                bloque, lo que es una buena práctica para manejar recursos de red.

            Comunicación con el Servidor:
                Dentro del bloque try, el cliente se comunica con el servidor enviando la operación y los números, y
                recibiendo el resultado.

            En resumen, esta línea crea un socket UDP para el cliente y asegura que se cierre correctamente al final
            del bloque try, facilitando la comunicación con el servidor
        ----------------------------------------------------------------------------------------------
             */

            InetAddress serverAddress = InetAddress.getByName("localhost"); // Dirección del servidor

            /*---------------------EXPLICACIÓN-----------------------------
            Uso de InetAddress:

                InetAddress serverAddress

                    Función: Declara una variable serverAddress de tipo InetAddress. Esta clase representa
                    una dirección IP.

                Metodo getByName:

                    InetAddress.getByName("localhost")
                        Función:
                            Este metodo estático obtiene una instancia de InetAddress que representa la dirección
                            IP asociada con el nombre de host especificado.

                        Parámetro:

                            "localhost":
                                El nombre de host que se está resolviendo. "localhost" es un nombre especial que
                                se refiere a la dirección IP de la máquina local (127.0.0.1).

            Contexto
                Esta línea es parte del proceso para establecer la comunicación con el servidor. Aquí está el flujo completo:


            Resolución de la Dirección del Servidor:

            El cliente necesita saber la dirección IP del servidor para poder enviarle paquetes de datos.
            InetAddress.getByName("localhost") resuelve el nombre de host "localhost" a la dirección IP de la máquina
            local (127.0.0.1).

            Asignación de la Dirección:
                La dirección IP resultante se asigna a la variable serverAddress, que se utilizará posteriormente para enviar paquetes al servidor.

        En resumen, esta línea resuelve el nombre de host "localhost" a la dirección IP de la máquina local y asigna
        esa dirección a la variable serverAddress, facilitando la comunicación con el servidor.
        --------------------------------------------------------------------------------------
         */

            int serverPort = 12345; // Puerto del servidor

            /*---------------------EXPLICACIÓN-----------------------------
            Declaración de la Variable:

                int serverPort
                    Función:
                        Declara una variable serverPort de tipo int. Esta variable almacenará el número de puerto
                        del servidor.

                    Asignación del Valor:

                    = 12345;
                        Función:
                        Asigna el valor 12345 a la variable serverPort.
                        Este número representa el puerto en el que el servidor está escuchando.

            Contexto
                Esta línea es parte del proceso para establecer la comunicación con el servidor.

            Definición del Puerto del Servidor:
                El cliente necesita saber en qué puerto está escuchando el servidor para poder enviarle
                paquetes de datos.

                serverPort se establece en 12345, que es el puerto en el que el servidor está configurado para escuchar.

            Uso del Puerto:
                    La variable serverPort se utiliza posteriormente para crear paquetes de datos (DatagramPacket)
                    que se enviarán al servidor.

            En resumen, esta línea define el puerto en el que el servidor está escuchando y asigna ese valor a la
            variable serverPort, facilitando la comunicación con el servidor.
            -----------------------------------------------------------------------------------------------
             */

            Scanner scanner = new Scanner(System.in);

            /*---------------------EXPLICACIÓN-----------------------------
            Declaración de la Variable:

            Scanner scanner
                Función: Declara una variable scanner de tipo Scanner. Esta clase se utiliza para leer la entrada del
                usuario desde varias fuentes, como la consola.

            Creación del Objeto Scanner:
                new Scanner(System.in)
                    Función: Crea una nueva instancia de Scanner que leerá la entrada desde System.in, que es la
                    entrada estándar (generalmente el teclado).

            Contexto en tu Código:
                Esta línea es parte del proceso para interactuar con el usuario. Aquí está el flujo completo:

            Lectura de la Entrada del Usuario:
                El cliente necesita leer la operación y los números que el usuario desea enviar al servidor.
                Scanner se utiliza para leer esta entrada desde la consola.

            Uso del Scanner:
                La variable scanner se utiliza posteriormente para leer la operación y los números introducidos por
                el usuario.

        En resumen, esta línea crea un objeto Scanner que permite al cliente leer la entrada del usuario desde la
        consola, facilitando la interacción con el usuario para obtener la operación y los números a enviar al servidor.
        ---------------------------------------------------------------------------------------
             */

            System.out.print("Introduce la operación (suma, resta, multiplicacion, division): ");
            String operation = scanner.nextLine();
            byte[] sendBuffer = operation.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            /*---------------------EXPLICACIÓN-----------------------------
            Solicitud de la Operación:
                 System.out.print("Introduce la operación (suma, resta, multiplicacion, division): ");

                Función:
                    Muestra un mensaje en la consola solicitando al usuario que introduzca la operación que
                    desea realizar.

                Interacción:
                    Permite al usuario saber qué tipo de entrada se espera.

            Lectura de la Operación:
                     String operation = scanner.nextLine();

                Función:
                    Utiliza el objeto Scanner (scanner) para leer la línea de entrada del usuario desde la consola.

                Resultado:
                    La operación introducida por el usuario se almacena en la variable operation.

        Conversión de la Operación a Bytes:
                byte[] sendBuffer = operation.getBytes();

            Función:
                Convierte la cadena de texto (operation) en un array de bytes (sendBuffer).

                Uso:
                    Los datos en formato de bytes son necesarios para crear un paquete de datos (DatagramPacket) que se
                    enviará a través del socket UDP.

        Creación del Paquete de Envío:
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);

            Función:
                Crea un nuevo objeto DatagramPacket (sendPacket) utilizando el array de bytes (sendBuffer), la
                longitud del array (sendBuffer.length), la dirección del servidor (serverAddress), y el puerto del
                servidor (serverPort).

            Resultado:
                El paquete de datos (sendPacket) está listo para ser enviado al servidor.

        Envío del Paquete:
                clientSocket.send(sendPacket);

            Función:
                Utiliza el socket UDP (clientSocket) para enviar el paquete de datos (sendPacket) al servidor.

            Comunicación:
                Esta línea establece la comunicación inicial con el servidor, enviando la operación que el usuario
                desea realizar.

        Contexto
            Estas líneas son parte del proceso para enviar la operación matemática al servidor. Aquí está el flujo completo:

            Interacción con el Usuario:
             El cliente solicita al usuario que introduzca la operación matemática que desea realizar.

            Lectura y Conversión de la Operación:
                La operación introducida por el usuario se lee y se convierte en un array de bytes.

            Creación y Envío del Paquete:
                Se crea un paquete de datos (DatagramPacket) que contiene la operación y se envía al servidor utilizando
                el socket UDP.

        En resumen, estas líneas permiten al cliente leer la operación matemática del usuario, convertirla en un
        formato adecuado, crear un paquete de datos, y enviarlo al servidor para su procesamiento.
        ------------------------------------------------------------------------------------------------------
             */

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            System.out.print(new String(receivePacket.getData(), 0, receivePacket.getLength()));

            /*---------------------EXPLICACIÓN-----------------------------
            Creación del Buffer de Recepción:

                byte[] receiveBuffer = new byte[1024];

                Función:
                    Declara un array de bytes (receiveBuffer) de tamaño 1024. Este buffer se utilizará para almacenar
                    los datos recibidos del servidor.

            Creación del Paquete de Recepción:
                    DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                Función:
                    Crea un nuevo objeto DatagramPacket (receivePacket) utilizando el buffer de recepción
                    (receiveBuffer) y su longitud (receiveBuffer.length).

                Resultado: El paquete de datos (receivePacket) está listo para recibir datos del servidor.

            Recepción de Datos:

                clientSocket.receive(receivePacket);

                Función:
                    Utiliza el socket UDP (clientSocket) para recibir un paquete de datos del servidor.
                    Este metodo bloquea la ejecución del programa hasta que se recibe un paquete.

                Resultado:
                    Los datos recibidos se almacenan en receivePacket.

            Conversión y Visualización de Datos:

                System.out.print(new String(receivePacket.getData(), 0, receivePacket.getLength()));

                Función:
                    Convierte los datos recibidos (almacenados en receivePacket) en una cadena de texto.

                Parámetros:

                receivePacket.getData():
                    Obtiene el array de bytes que contiene los datos recibidos.

                0:
                    El índice inicial desde donde empezar a convertir los bytes.

                receivePacket.getLength():
                 La longitud de los datos relevantes en el paquete.

                Resultado:
                    Muestra la cadena de texto en la consola.

        Contexto
            En el contexto de tu cliente UDP, estas líneas son parte del proceso para recibir y mostrar la solicitud
            del primer número del servidor. Aquí está el flujo completo:

            Creación del Buffer y Paquete de Recepción:
                Se crea un buffer (receiveBuffer) y un paquete de datos (receivePacket) para recibir datos del servidor.

            Recepción de Datos:
                El cliente recibe un paquete de datos del servidor utilizando el socket UDP
                (clientSocket.receive(receivePacket);).

            Conversión y Visualización de Datos:
                Los datos recibidos se convierten en una cadena de texto y se muestran en la consola
                (System.out.print(...)).

        En resumen, estas líneas permiten al cliente recibir la solicitud del primer número del servidor, convertir los
        datos recibidos en una cadena de texto, y mostrar esa cadena en la consola.
        ------------------------------------------------------------------------------
             */

            double num1 = scanner.nextDouble();
            sendBuffer = String.valueOf(num1).getBytes();
            sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);
            /*---------------------EXPLICACIÓN-----------------------------
            Lectura del Primer Número:

            double num1 = scanner.nextDouble();

                Función:
                    Utiliza el objeto Scanner (scanner) para leer el siguiente número introducido por el usuario
                    desde la consola.

                Resultado: El número introducido por el usuario se almacena en la variable num1 de tipo double.

            Conversión del Número a Bytes:

            sendBuffer = String.valueOf(num1).getBytes();

                Función:
                    Convierte el número (num1) en una cadena de texto utilizando String.valueOf(num1), y luego
                    convierte esa cadena en un array de bytes (sendBuffer).

                Uso: Los datos en formato de bytes son necesarios para crear un paquete de datos (DatagramPacket)
                 que se enviará a través del socket UDP.

            Creación del Paquete de Envío:
                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);

                Función:
                    Crea un nuevo objeto DatagramPacket (sendPacket) utilizando el array de bytes (sendBuffer),
                    la longitud del array (sendBuffer.length), la dirección del servidor (serverAddress),
                    y el puerto del servidor (serverPort).

                Resultado: El paquete de datos (sendPacket) está listo para ser enviado al servidor.

            Envío del Paquete:
                clientSocket.send(sendPacket);

            Función: Utiliza el socket UDP (clientSocket) para enviar el paquete de datos (sendPacket) al servidor.

            Comunicación: Esta línea envía el primer número introducido por el usuario al servidor.

        Contexto:
            Estas líneas son parte del proceso para enviar el primer número al servidor.

            Interacción con el Usuario:
                El cliente solicita al usuario que introduzca el primer número.

            Lectura y Conversión del Número:
                El número introducido por el usuario se lee y se convierte en un array de bytes.

            Creación y Envío del Paquete:
                Se crea un paquete de datos (DatagramPacket) que contiene el primer número y se envía al servidor
                 utilizando el socket UDP.

        En resumen, estas líneas permiten al cliente leer el primer número del usuario, convertirlo en un formato
        adecuado, crear un paquete de datos, y enviarlo al servidor para su procesamiento.
             */

            receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            System.out.print(new String(receivePacket.getData(), 0, receivePacket.getLength()));

            /*---------------------EXPLICACIÓN-----------------------------
            Creación del Paquete de Recepción:
                receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                    Función:
                        Crea un nuevo objeto DatagramPacket (receivePacket) utilizando el buffer de recepción
                         (receiveBuffer) y su longitud (receiveBuffer.length).

                    Resultado:
                        El paquete de datos (receivePacket) está listo para recibir datos del servidor.

            Recepción de Datos:
                clientSocket.receive(receivePacket);

                    Función:
                        Utiliza el socket UDP (clientSocket) para recibir un paquete de datos del servidor.
                        Este metodo bloquea la ejecución del programa hasta que se recibe un paquete.

                    Resultado: Los datos recibidos se almacenan en receivePacket.

        Conversión y Visualización de Datos:
            System.out.print(new String(receivePacket.getData(), 0, receivePacket.getLength()));

                    Función:
                        Convierte los datos recibidos (almacenados en receivePacket) en una cadena de texto.

                    Parámetros:
                        receivePacket.getData():
                            Obtiene el array de bytes que contiene los datos recibidos.

                        0:
                            El índice inicial desde donde empezar a convertir los bytes.

                        receivePacket.getLength():
                            La longitud de los datos relevantes en el paquete.

                    Resultado:
                        Muestra la cadena de texto en la consola.
        Contexto:
            Estas líneas son parte del proceso para recibir y mostrar la solicitud del segundo número del servidor.

            Creación del Buffer y Paquete de Recepción:
                Se crea un buffer (receiveBuffer) y un paquete de datos (receivePacket) para recibir datos del servidor.

            Recepción de Datos:
                El cliente recibe un paquete de datos del servidor utilizando el socket UDP
                (clientSocket.receive(receivePacket);).

            Conversión y Visualización de Datos:
                Los datos recibidos se convierten en una cadena de texto y se muestran en la consola
                (System.out.print(...)).

            En resumen, estas líneas permiten al cliente recibir la solicitud del segundo número del servidor,
            convertir los datos recibidos en una cadena de texto, y mostrar esa cadena en la consola
            ------------------------------------------------------------------------------------------------------
             */

            double num2 = scanner.nextDouble();
            sendBuffer = String.valueOf(num2).getBytes();
            sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            /*---------------------EXPLICACIÓN-----------------------------
            Lectura del Segundo Número:
                double num2 = scanner.nextDouble();

                    Función:
                        Utiliza el objeto Scanner (scanner) para leer el siguiente número introducido por el usuario
                        desde la consola.

                    Resultado:
                        El número introducido por el usuario se almacena en la variable num2 de tipo double.

            Conversión del Número a Bytes:
                sendBuffer = String.valueOf(num2).getBytes();

                    Función:
                        Convierte el número (num2) en una cadena de texto utilizando String.valueOf(num2), y luego
                        convierte esa cadena en un array de bytes (sendBuffer).

                    Uso:
                        Los datos en formato de bytes son necesarios para crear un paquete de datos (DatagramPacket)
                        que se enviará a través del socket UDP.

            Creación del Paquete de Envío:
                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);

                    Función:
                        Crea un nuevo objeto DatagramPacket (sendPacket) utilizando el array de bytes (sendBuffer),
                        la longitud del array (sendBuffer.length), la dirección del servidor (serverAddress), y el
                        puerto del servidor (serverPort).

                    Resultado:
                        El paquete de datos (sendPacket) está listo para ser enviado al servidor.

            Envío del Paquete:
                clientSocket.send(sendPacket);

                        Función:
                            Utiliza el socket UDP (clientSocket) para enviar el paquete de datos (sendPacket)
                            al servidor.

                        Comunicación: Esta línea envía el segundo número introducido por el usuario al servidor.

            Contexto
                Estas líneas son parte del proceso para enviar el segundo número al servidor.


                Interacción con el Usuario:
                    El cliente solicita al usuario que introduzca el segundo número.

                Lectura y Conversión del Número:
                    El número introducido por el usuario se lee y se convierte en un array de bytes.

                Creación y Envío del Paquete:
                    Se crea un paquete de datos (DatagramPacket) que contiene el segundo número y se envía al servidor
                    utilizando el socket UDP.

        En resumen, estas líneas permiten al cliente leer el segundo número del usuario, convertirlo en un formato
        adecuado, crear un paquete de datos, y enviarlo al servidor para su procesamiento.
        ------------------------------------------------------------------------------------------------
             */

            receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println(result);
            /*---------------------EXPLICACIÓN-----------------------------
            Creación del Paquete de Recepción:
                receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                Función:
                    Crea un nuevo objeto DatagramPacket (receivePacket) utilizando el buffer de recepción
                    (receiveBuffer) y su longitud (receiveBuffer.length).

                Resultado:
                    El paquete de datos (receivePacket) está listo para recibir datos del servidor.

            Recepción de Datos:
                clientSocket.receive(receivePacket);

                Función:
                    Utiliza el socket UDP (clientSocket) para recibir un paquete de datos del servidor.
                    Este metodo bloquea la ejecución del programa hasta que se recibe un paquete.

                Resultado: Los datos recibidos se almacenan en receivePacket.

            Conversión de Datos:
                   String result = new String(receivePacket.getData(), 0, receivePacket.getLength());

                Función:
                    Convierte los datos recibidos (almacenados en receivePacket) en una cadena de texto.

                Parámetros:

                    receivePacket.getData():
                        Obtiene el array de bytes que contiene los datos recibidos.

                    0:
                         El índice inicial desde donde empezar a convertir los bytes.

                    receivePacket.getLength():
                         La longitud de los datos relevantes en el paquete.

                Resultado:
                    La cadena resultante (result) contiene el mensaje recibido del servidor.

            Visualización del Resultado:
                System.out.println(result);

                    Función:
                        Muestra la cadena de texto (result) en la consola.

                    Resultado:
                        El usuario puede ver el resultado de la operación matemática.
        Contexto:
        Estas líneas son parte del proceso para recibir y mostrar el resultado de la operación matemática del servidor

            Creación del Buffer y Paquete de Recepción:
                Se crea un buffer (receiveBuffer) y un paquete de datos (receivePacket) para recibir datos del servidor.

            Recepción de Datos:
                El cliente recibe un paquete de datos del servidor utilizando el socket UDP
                (clientSocket.receive(receivePacket);).

            Conversión y Visualización de Datos:
                Los datos recibidos se convierten en una cadena de texto (String result = new String(...)) y se muestran
                en la consola (System.out.println(result)).

        En resumen, estas líneas permiten al cliente recibir el resultado de la operación matemática del servidor,
        convertir los datos recibidos en una cadena de texto, y mostrar esa cadena en la consola.
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*---------------------EXPLICACIÓN-----------------------------
        Bloque catch:
            } catch (Exception e) {
                Función:
                    Captura cualquier excepción que ocurra dentro del bloque try.
                Parámetro:
                    Exception e:
                        La excepción capturada.
                        Exception es una clase base para todas las excepciones en Java, lo que significa que este
                        bloque puede capturar cualquier tipo de excepción.
        Manejo de la Excepción:
            e.printStackTrace();
                Función:
                    Imprime el stack trace de la excepción. Esto proporciona información detallada sobre la excepción,
                    incluyendo el tipo de excepción, el mensaje de error, y la ubicación en el código donde ocurrió
                    la excepción.

                Resultado:
                    Ayuda a los desarrolladores a diagnosticar y solucionar problemas en el código.

        Contexto
            Estas líneas son parte del manejo de excepciones.

        Bloque try:
            El bloque try contiene el código principal del cliente, incluyendo la creación del socket, la recepción y
            envío de paquetes, y la interacción con el usuario.

        Bloque catch:
            Si ocurre cualquier excepción dentro del bloque try, el control pasa al bloque catch.
            La excepción capturada se imprime usando e.printStackTrace(), lo que proporciona información útil para
            la depuración.

    En resumen, estas líneas aseguran que cualquier excepción que ocurra en el cliente se maneje adecuadamente
    imprimiendo el stack trace, lo que facilita la identificación y solución de problemas.
    ----------------------------------------------------------------------------------------
         */
    }
}