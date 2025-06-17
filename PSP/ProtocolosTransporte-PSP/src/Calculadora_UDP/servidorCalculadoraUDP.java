package Calculadora_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * servidorCalculadoraUDP es una clase que implementa un servidor UDP para realizar operaciones básicas de cálculo.
 * El servidor espera paquetes de datos de los clientes, recibe la operación y los números a operar, y devuelve el
 * resultado.
 */

public class servidorCalculadoraUDP {

    /**
     * Método principal que inicia el servidor y espera paquetes de datos de los clientes.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {

        try (DatagramSocket serverSocket = new DatagramSocket(12345)) {
            /*
            Crea un DatagramSocket que escucha en el puerto 12345. El try con recursos asegura que el DatagramSocket
            se cierre automáticamente al finalizar.
             */

            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;
            /*
            Define dos búferes de bytes: uno para recibir datos (receiveBuffer) y otro para enviar datos (sendBuffer).
             */

            System.out.println("Servidor esperando conexiones...");

            while (true) {
                //Inicia un bucle infinito para aceptar y procesar paquetes de datos de los clientes.

                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                /*----------------EXPLICAICÓN ---------------------------
                DatagramPacket receivePacket:

                    Declara una variable receivePacket de tipo DatagramPacket. Un DatagramPacket es un contenedor para los datos que se envían y reciben a través de un socket UDP.


                new DatagramPacket(receiveBuffer, receiveBuffer.length):

                    Crea una nueva instancia de DatagramPacket utilizando el constructor que toma un búfer de bytes y
                    su longitud.

                    receiveBuffer: Este es el búfer de bytes que se utilizará para almacenar los datos recibidos.
                                   En este caso, receiveBuffer es un array de bytes previamente definido con una longitud
                                   de 1024.

                    receiveBuffer.length: Especifica la longitud del búfer. Esto le dice al DatagramPacket cuántos
                    bytes puede contener.

                    resumen
                    Esta línea de código crea un DatagramPacket que utilizará el búfer receiveBuffer para almacenar
                    los datos recibidos. El tamaño del paquete se establece en la longitud del búfer.
                    Este DatagramPacket se utilizará para recibir datos del cliente.
                    */
                serverSocket.receive(receivePacket);
                /*----------------EXPLICAICÓN ---------------------------
                serverSocket.receive(receivePacket);:
                    Este metodo bloquea la ejecución del programa hasta que se reciba un paquete de datos.

                    serverSocket: Es una instancia de DatagramSocket que está escuchando en un puerto específico
                    (en este caso, el puerto 12345).

                    receivePacket: Es una instancia de DatagramPacket que se utilizará para almacenar los datos
                    recibidos.

                Detalles
                    Bloqueo: El metodo receive es bloqueante, lo que significa que el programa se detendrá en esta línea
                    y esperará hasta que llegue un paquete de datos. Una vez que se recibe un paquete, los datos se
                    almacenan en el DatagramPacket proporcionado (receivePacket).

                    Almacenamiento de Datos: Los datos recibidos se almacenan en el búfer de bytes asociado con el
                    DatagramPacket (receiveBuffer en este caso). La longitud del paquete recibido se ajusta
                    automáticamente para reflejar la cantidad de datos recibidos.

                Resumen
                    Esta línea de código espera a recibir un paquete de datos del cliente y almacena los datos
                    recibidos en el DatagramPacket especificado (receivePacket). Este es un paso crucial en la
                    comunicación UDP, ya que permite al servidor recibir y procesar los datos enviados por el cliente.
                 */

                String operation = new String(receivePacket.getData(), 0, receivePacket.getLength());

                /*----------------EXPLICAICÓN ---------------------------
                receivePacket.getData():

                    Este metodo devuelve el búfer de bytes que contiene los datos recibidos en el DatagramPacket.
                    En este caso, receivePacket es el paquete que recibió los datos del cliente.

                new String(receivePacket.getData(), 0, receivePacket.getLength()):

                    Crea una nueva instancia de String utilizando el constructor que toma un array de bytes, un
                    desplazamiento inicial y una longitud.

                receivePacket.getData(): Es el array de bytes que contiene los datos recibidos.

                0: Es el desplazamiento inicial, que indica el punto de inicio en el array de bytes desde donde se
                   deben leer los datos. En este caso, comienza desde el principio del array.

                receivePacket.getLength(): Es la longitud de los datos recibidos en el paquete.
                                           Esto asegura que solo se conviertan a cadena los bytes que realmente
                                           contienen datos válidos.

                Detalles
                    Conversión de Bytes a Cadena:
                        Esta línea convierte los bytes recibidos en una cadena de caracteres. Esto es necesario porque
                        los datos enviados a través de UDP son bytes, pero queremos procesarlos como texto.

                    Desplazamiento y Longitud:
                        Al especificar el desplazamiento y la longitud, nos aseguramos de que solo se conviertan los
                        bytes relevantes, evitando cualquier byte adicional que pueda estar presente en el búfer.

                Resumen
                    Esta línea de código convierte los datos recibidos en el DatagramPacket (receivePacket) en una
                    cadena de caracteres (String). Esto permite al servidor interpretar la operación enviada por el
                    cliente como texto.
                 */

                InetAddress clientAddress = receivePacket.getAddress();

                /*----------------EXPLICAICÓN ---------------------------
                receivePacket.getAddress():
                    Este metodo devuelve la dirección IP del remitente del paquete de datos (DatagramPacket).
                    En este caso, receivePacket es el paquete que recibió los datos del cliente.

                InetAddress clientAddress:
                    Declara una variable clientAddress de tipo InetAddress. InetAddress es una clase que representa una
                    dirección IP.

                Asignación:
                    La dirección IP del cliente que envió el paquete se asigna a la variable clientAddress.

            Detalles
                Dirección IP del Cliente:
                    Esta línea de código permite al servidor obtener la dirección IP del cliente que envió el paquete.
                    Esto es útil para enviar respuestas de vuelta al cliente.

                Uso de InetAddress: InetAddress es una clase que encapsula una dirección IP, lo que facilita la
                manipulación y el uso de direcciones IP en la comunicación de red.

            Resumen
                Esta línea de código obtiene la dirección IP del cliente que envió el paquete de datos y la almacena
                en la variable clientAddress. Esto permite al servidor saber a qué dirección IP debe enviar
                las respuestas.
                ---------------------------------------------------------------------
                 */

                int clientPort = receivePacket.getPort();

                /*----------------EXPLICAICÓN ---------------------------
                receivePacket.getPort():
                    Este metodo devuelve el número de puerto del remitente del paquete de datos (DatagramPacket).
                    En este caso, receivePacket es el paquete que recibió los datos del cliente.

                int clientPort:
                    Declara una variable clientPort de tipo int. Esta variable almacenará el número de puerto del cliente.

                Asignación:
                    El número de puerto del cliente que envió el paquete se asigna a la variable clientPort.

                Detalles
                    Número de Puerto del Cliente:
                        Esta línea de código permite al servidor obtener el número de puerto del cliente que envió el
                        paquete. Esto es útil para enviar respuestas de vuelta al cliente en el puerto correcto.

                    Uso de getPort():
                        El metodo getPort() de DatagramPacket devuelve el número de puerto desde el cual se envió el
                        paquete, lo que facilita la comunicación bidireccional.

                Resumen
                    Esta línea de código obtiene el número de puerto del cliente que envió el paquete de datos y lo
                    almacena en la variable clientPort. Esto permite al servidor saber a qué puerto debe enviar las
                    respuestas.
                    -----------------------------------------------------------------------------
                 */

                sendBuffer = "Introduce el primer número: ".getBytes();

                /*-----------------EXPLICAICÓN ---------------------------
                "Introduce el primer número: ":
                    Esta es una cadena de caracteres (String) que contiene el mensaje que queremos enviar al cliente.
                    En este caso, el mensaje solicita al cliente que introduzca el primer número.

                .getBytes():
                    Este metodo convierte la cadena de caracteres en un array de bytes (byte[]).
                    Esto es necesario porque los datos enviados a través de UDP son bytes, no caracteres.

                sendBuffer:
                    Declara una variable sendBuffer de tipo byte[]. Esta variable almacenará el array de bytes que representa el mensaje.


                Asignación:
                     La cadena de caracteres convertida en bytes se asigna a la variable sendBuffer.

                Detalles
                    Conversión de Cadena a Bytes:
                        La conversión de la cadena de caracteres a bytes es esencial para enviar datos a través de un
                        socket UDP, ya que los sockets UDP operan con bytes.

                    Uso de getBytes():
                        El metodo getBytes() convierte cada carácter de la cadena en su representación de byte
                        correspondiente, creando un array de bytes que puede ser enviado a través del socket.

                    Resumen
                    Esta línea de código convierte el mensaje de solicitud ("Introduce el primer número: ") en un array
                    de bytes y lo almacena en la variable sendBuffer. Esto permite al servidor enviar el mensaje al
                    cliente utilizando el protocolo UDP.
                    ----------------------------------------------------------
                 */

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);

                /*-----------------EXPLICAICÓN ---------------------------
                DatagramPacket sendPacket:
                    Declara una variable sendPacket de tipo DatagramPacket.
                    Un DatagramPacket es un contenedor para los datos que se envían y reciben a través de un socket UDP.

                new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort):
                    Crea una nueva instancia de DatagramPacket utilizando el constructor que toma un array de bytes,
                    su longitud, una dirección IP y un número de puerto.

                    sendBuffer:
                        Este es el array de bytes que contiene los datos que se van a enviar.
                        En este caso, sendBuffer es el array de bytes que representa el mensaje "Introduce el primer
                        número: ".

                    sendBuffer.length:
                        Especifica la longitud del array de bytes. Esto le dice al DatagramPacket cuántos bytes
                        contiene el mensaje.

                    clientAddress:
                        Es la dirección IP del cliente que recibirá el paquete. Esta dirección se obtuvo previamente
                        del paquete recibido.

                    clientPort:
                    Es el número de puerto del cliente que recibirá el paquete. Este puerto se obtuvo previamente
                    del paquete recibido.

            Detalles
                Creación del Paquete:
                    Esta línea de código crea un DatagramPacket que contiene los datos que se van a enviar, la longitud
                    de esos datos, y la dirección y puerto del cliente destinatario.

                Dirección y Puerto del Cliente:
                    Al especificar la dirección IP y el puerto del cliente, el DatagramPacket sabe exactamente a
                    dónde enviar los datos.

            Resumen
                Esta línea de código crea un DatagramPacket que contiene el mensaje "Introduce el primer ç
                número: " en forma de bytes, y especifica que este paquete debe ser enviado a la dirección IP y puerto
                del cliente. Esto permite al servidor enviar el mensaje al cliente utilizando el protocolo UDP.
                -----------------------------------------------------------------------------------
                 */


                serverSocket.send(sendPacket);

                /* -----------------EXPLICAICÓN ---------------------------
                serverSocket.send(sendPacket);:
                    Este metodo envía el paquete de datos (DatagramPacket) a través del socket (DatagramSocket).
                    En este caso, serverSocket es el socket del servidor y sendPacket es el paquete que contiene los
                    datos que se van a enviar al cliente.

                Detalles
                    Envío del Paquete:
                    El metodo send toma el DatagramPacket que contiene los datos, la dirección IP y el puerto del
                    cliente, y lo envía a través de la red.

                    Protocolo UDP:
                        Dado que estamos utilizando el protocolo UDP, el paquete se envía sin establecer una
                        conexión previa. UDP es un protocolo no orientado a la conexión, lo que significa que los paquetes se
                        envían de manera independiente y no se garantiza su entrega.

                Resumen
                    Esta línea de código envía el DatagramPacket (sendPacket) que contiene el mensaje "Introduce el
                    primer número: " al cliente a través del socket del servidor (serverSocket).
                    Esto permite al servidor comunicarse con el cliente utilizando el protocolo UDP.
                    -------------------------------------------------------------------------------------
                 */


                receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                /*----------------EXPLICAICÓN ---------------------------
                receivePacket:
                    Esta es una variable de tipo DatagramPacket que se utilizará para recibir datos.

                new DatagramPacket(receiveBuffer, receiveBuffer.length):
                Crea una nueva instancia de DatagramPacket utilizando el constructor que toma un búfer de bytes y
                su longitud.

                    receiveBuffer:
                        Este es el búfer de bytes que se utilizará para almacenar los datos recibidos.
                        En este caso, receiveBuffer es un array de bytes previamente definido con una longitud de 1024.

                    receiveBuffer.length:
                        Especifica la longitud del búfer. Esto le dice al DatagramPacket cuántos bytes puede contener.

                Detalles
                    Creación del Paquete:
                        Esta línea de código crea un DatagramPacket que utilizará el búfer receiveBuffer para almacenar
                        los datos recibidos. El tamaño del paquete se establece en la longitud del búfer.

                    Reutilización de la Variable:
                        La variable receivePacket se reutiliza para recibir nuevos datos.
                        Esto es eficiente y evita la necesidad de crear nuevas instancias de DatagramPacket cada vez
                        que se reciben datos.
                Resumen
                    Esta línea de código crea un DatagramPacket que utilizará el búfer receiveBuffer
                    para almacenar los datos recibidos. El tamaño del paquete se establece en la longitud del búfer.
                    Este DatagramPacket se utilizará para recibir datos del cliente.
                    --------------------------------------------------------------------------------------
                 */

                serverSocket.receive(receivePacket);

                /*----------------EXPLICAICÓN ---------------------------
                    serverSocket.receive(receivePacket);:
                        Este metodo bloquea la ejecución del programa hasta que se reciba un paquete de datos.

                        serverSocket:
                            Es una instancia de DatagramSocket que está escuchando en un puerto específico
                            (en este caso, el puerto 12345).

                        receivePacket:
                        Es una instancia de DatagramPacket que se utilizará para almacenar los datos recibidos.

                   Detalles
                        Bloqueo:
                            El metodo receive es bloqueante, lo que significa que el programa se detendrá en esta línea
                            y esperará hasta que llegue un paquete de datos. Una vez que se recibe un paquete, los
                            datos se almacenan en el DatagramPacket proporcionado (receivePacket).

                        Almacenamiento de Datos:
                            Los datos recibidos se almacenan en el búfer de bytes asociado con el DatagramPacket
                            (receiveBuffer en este caso). La longitud del paquete recibido se ajusta automáticamente
                            para reflejar la cantidad de datos recibidos.
                    Resumen
                    Esta línea de código espera a recibir un paquete de datos del cliente y almacena los datos
                    recibidos en el DatagramPacket especificado (receivePacket). Este es un paso crucial en la
                    comunicación UDP, ya que permite al servidor recibir y procesar los datos enviados por el cliente.
                    -------------------------------------------------------------------------------
                 */

                double num1 = Double.parseDouble(new String(receivePacket.getData(), 0, receivePacket.getLength()));
                /*----------------EXPLICAICÓN ---------------------------
                receivePacket.getData():
                    Este metodo devuelve el búfer de bytes que contiene los datos recibidos en el DatagramPacket.
                    En este caso, receivePacket es el paquete que recibió los datos del cliente.

                new String(receivePacket.getData(), 0, receivePacket.getLength()):
                    Crea una nueva instancia de String utilizando el constructor que toma un array de bytes, un
                    desplazamiento inicial y una longitud.

                receivePacket.getData():
                    Es el array de bytes que contiene los datos recibidos.

                0:
                    Es el desplazamiento inicial, que indica el punto de inicio en el array de bytes desde donde
                    se deben leer los datos. En este caso, comienza desde el principio del array.

                receivePacket.getLength():
                    Es la longitud de los datos recibidos en el paquete. Esto asegura que solo se conviertan a cadena
                    los bytes que realmente contienen datos válidos.

                Double.parseDouble(new String(...)):
                    Convierte la cadena de caracteres resultante en un valor double.
                    El metodo parseDouble de la clase Double toma una cadena que representa un número y la convierte en
                    un valor double.

                double num1:
                    Declara una variable num1 de tipo double y le asigna el valor convertido.

            Detalles
                Conversión de Bytes a Cadena:
                Primero, los bytes recibidos se convierten en una cadena de caracteres.
                Esto es necesario porque los datos enviados a través de UDP son bytes, pero queremos procesarlos
                como texto.

            Conversión de Cadena a double: Luego, la cadena de caracteres que representa un número se convierte en un
            valor double utilizando Double.parseDouble.

            Resumen
                Esta línea de código convierte los datos recibidos en el DatagramPacket (receivePacket) en una cadena
                de caracteres, y luego convierte esa cadena en un valor double. El valor resultante se almacena en la
                variable num1, que representa el primer número enviado por el cliente
            ----------------------------------------------------------------------------------------------
            */

                sendBuffer = "Introduce el segundo número: ".getBytes();
                /*----------------EXPLICAICÓN ---------------------------
                "Introduce el segundo número: ":
                    Esta es una cadena de caracteres (String) que contiene el mensaje que queremos enviar al cliente.
                    En este caso, el mensaje solicita al cliente que introduzca el segundo número.

                .getBytes():
                    Este metodo convierte la cadena de caracteres en un array de bytes (byte[]).
                    Esto es necesario porque los datos enviados a través de UDP son bytes, no caracteres.

                sendBuffer:
                    Declara una variable sendBuffer de tipo byte[].
                    Esta variable almacenará el array de bytes que representa el mensaje.

            Asignación:
                La cadena de caracteres convertida en bytes se asigna a la variable sendBuffer.

            Detalles
                Conversión de Cadena a Bytes:
                    La conversión de la cadena de caracteres a bytes es esencial para enviar datos a través de un
                    socket UDP, ya que los sockets UDP operan con bytes.

                Uso de getBytes():
                    El metodo getBytes() convierte cada carácter de la cadena en su representación de byte
                    correspondiente, creando un array de bytes que puede ser enviado a través del socket.

            Resumen
                Esta línea de código convierte el mensaje de solicitud ("Introduce el segundo número: ")
                en un array de bytes y lo almacena en la variable sendBuffer. Esto permite al servidor enviar el
                 mensaje al cliente utilizando el protocolo UDP.
                 -------------------------------------------------------------------------------------
                 */

                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);

                /*----------------EXPLICAICÓN ---------------------------
                sendPacket:
                    Esta es una variable de tipo DatagramPacket que se utilizará para enviar datos.

                new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort):
                    Crea una nueva instancia de DatagramPacket utilizando el constructor que toma un array de bytes,
                    su longitud, una dirección IP y un número de puerto.

                    sendBuffer:
                        Este es el array de bytes que contiene los datos que se van a enviar.
                        En este caso, sendBuffer es el array de bytes que representa el mensaje "Introduce
                        el segundo número: ".

                    sendBuffer.length:
                        Especifica la longitud del array de bytes. Esto le dice al DatagramPacket cuántos bytes
                        contiene el mensaje.

                    clientAddress:
                        Es la dirección IP del cliente que recibirá el paquete. Esta dirección se obtuvo previamente
                        del paquete recibido.

                    clientPort:
                    Es el número de puerto del cliente que recibirá el paquete.
                    Este puerto se obtuvo previamente del paquete recibido.

            Detalles
                Creación del Paquete:
                    Esta línea de código crea un DatagramPacket que contiene los datos que se van a enviar, la longitud
                     de esos datos, y la dirección y puerto del cliente destinatario.

                Dirección y Puerto del Cliente:
                    Al especificar la dirección IP y el puerto del cliente, el DatagramPacket sabe exactamente a
                    dónde enviar los datos.

            Resumen
                Esta línea de código crea un DatagramPacket que contiene el mensaje "Introduce el segundo
                número: " en forma de bytes, y especifica que este paquete debe ser enviado a la dirección IP y puerto
                del cliente. Esto permite al servidor enviar el mensaje al cliente utilizando el protocolo UDP.
                --------------------------------------------------------------------------------------------------
                 */

                serverSocket.send(sendPacket);
                /*----------------EXPLICAICÓN ---------------------------
                serverSocket.send(sendPacket);
                    Este metodo envía el paquete de datos (DatagramPacket) a través del socket (DatagramSocket).
                            En este caso, serverSocket es el socket del servidor y sendPacket es el paquete
                            que contiene los datos que se van a enviar al cliente.

                Detalles
                    Envío del Paquete:
                        El metodo send toma el DatagramPacket que contiene los datos, la dirección IP y el puerto del
                        cliente, y lo envía a través de la red.

                Protocolo UDP:
                    Dado que estamos utilizando el protocolo UDP, el paquete se envía sin establecer una conexión
                    previa. UDP es un protocolo no orientado a la conexión, lo que significa que los paquetes se envían
                     de manera independiente y no se garantiza su entrega.

            Resumen
            Esta línea de código envía el DatagramPacket (sendPacket) que contiene el mensaje "Introduce el segundo
            número: " al cliente a través del socket del servidor (serverSocket). Esto permite al servidor comunicarse
            con el cliente utilizando el protocolo UDP.
            ---------------------------------------------------------------------------------------------------
                 */

                receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                /*----------------EXPLICAICÓN ---------------------------
                receivePacket:
                    Esta es una variable de tipo DatagramPacket que se utilizará para recibir datos.

                new DatagramPacket(receiveBuffer, receiveBuffer.length):
                    Crea una nueva instancia de DatagramPacket utilizando el constructor que toma un búfer de bytes
                    y su longitud.

                        receiveBuffer:
                            Este es el búfer de bytes que se utilizará para almacenar los datos recibidos.
                            En este caso, receiveBuffer es un array de bytes previamente definido con una longitud
                            de 1024.

                        receiveBuffer.length:
                            Especifica la longitud del búfer. Esto le dice al DatagramPacket cuántos bytes puede
                            contener.
                Detalles
                    Creación del Paquete:
                        Esta línea de código crea un DatagramPacket que utilizará el búfer receiveBuffer para almacenar
                        los datos recibidos. El tamaño del paquete se establece en la longitud del búfer.

                    Reutilización de la Variable:
                        La variable receivePacket se reutiliza para recibir nuevos datos.
                        Esto es eficiente y evita la necesidad de crear nuevas instancias de DatagramPacket
                        cada vez que se reciben datos.

               Resumen
                   Esta línea de código crea un DatagramPacket que utilizará el búfer receiveBuffer para almacenar los
                   datos recibidos. El tamaño del paquete se establece en la longitud del búfer. Este DatagramPacket se
                   utilizará para recibir datos del cliente.
                ----------------------------------------------------------------------------------------------
                 */

                serverSocket.receive(receivePacket);
                /*----------------EXPLICAICÓN ---------------------------
                Este metodo bloquea la ejecución del programa hasta que se recibe un paquete de datos.
                Los datos recibidos se almacenan en receivePacket.
                 */

                double num2 = Double.parseDouble(new String(receivePacket.getData(), 0, receivePacket.getLength()));
                /*----------------EXPLICAICÓN ---------------------------
                Objetivo: Convertir los datos recibidos en un número de tipo double.
                Función:
                    receivePacket.getData():
                        obtiene el array de bytes que contiene los datos recibidos.

                    new String(receivePacket.getData(), 0, receivePacket.getLength()):
                        convierte esos bytes en una cadena, utilizando solo los bytes relevantes
                        (desde el índice 0 hasta receivePacket.getLength()).

                    Double.parseDouble(...):
                        convierte la cadena resultante en un número de tipo double.
                 ----------------------------------------------------------------------------------------------
                 */
                double result = performOperation(operation, num1, num2);
                /*----------------EXPLICAICÓN ---------------------------
                Llamada al Método performOperation:

                    performOperation(operation, num1, num2)

                Función:
                    Llama al método performOperation para realizar una operación matemática.

                Parámetros:
                    operation:
                        Una cadena que indica la operación a realizar
                        (por ejemplo, "suma", "resta", "multiplicacion", "division").

                    num1:
                        El primer número para la operación.

                    num2:
                        El segundo número para la operación.

                Asignación del Resultado:
                       double result = ...

                    Función: Asigna el resultado de la operación a la variable result.

            Contexto
                Esta línea es parte del proceso para calcular el resultado de
                la operación matemática solicitada por el cliente. Aquí está el flujo completo:

                Recepción de la Operación y los Números:
                    El servidor recibe la operación y los dos números del cliente.

                Realización de la Operación:
                    El metodo performOperation se llama con los parámetros operation, num1, y num2.
                    Este metodo realiza la operación especificada y devuelve el resultado.

            Metodo performOperation:

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
                }

             Función:
                Este metodo realiza la operación matemática especificada por el parámetro operation utilizando los
                números num1 y num2.

            Resultado:
                Devuelve el resultado de la operación.

            En resumen,
            la línea double result = performOperation(operation, num1, num2);
                llama al metodo performOperation para calcular el resultado de la operación matemática solicitada por el
                cliente y asigna ese resultado a la variable result.
            ---------------------------------------------------------------------------------------------------
                 */

                sendBuffer = ("El resultado de " + operation + " es: " + result).getBytes();
                /*/*----------------EXPLICAICÓN ---------------------------
                Creación del Mensaje:

                  "El resultado de " + operation + " es: " + result
                    Función:
                        Crea una cadena de texto que contiene el resultado de la operación.


                Contenido;
                 "El resultado de ":
                    Texto fijo que forma parte del mensaje.

                operation:
                    La operación realizada (por ejemplo, "suma", "resta", "multiplicacion", "division").

                " es: ":
                    Texto fijo que forma parte del mensaje.

                result:
                    El resultado de la operación.

            Ejemplo: Si operation es "suma" y result es 5, la cadena resultante sería "El resultado de suma es: 5".

                        Conversión a Bytes:

            .getBytes()
                Función:
                    Convierte la cadena de texto en un array de bytes.

                Resultado:
                    El array de bytes que representa el mensaje.

            Contexto
            Esta línea es parte del proceso para enviar el resultado de la operación
            matemática al cliente. Aquí está el flujo completo:

                Realización de la Operación:
                         El servidor calcula el resultado de la operación solicitada por el cliente.

                Creación del Mensaje:
                        Se crea una cadena de texto que contiene el resultado de la operación.

                Conversión del Mensaje:
                    La cadena de texto se convierte en un array de bytes para poder ser enviada a través del socket UDP.

                Envío del Mensaje:
                    El array de bytes (sendBuffer) se utiliza para crear un DatagramPacket que se envía al cliente.

            En resumen, la línea sendBuffer = ("El resultado de " + operation + " es: " + result).getBytes(); crea un
            mensaje que contiene el resultado de la operación matemática, lo convierte en un array de bytes, y lo
             almacena en sendBuffer para ser enviado al cliente.
                 */

                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                /*----------------EXPLICAICÓN ---------------------------

                Creación del Paquete de Envío:
                    new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort)

                        Función:
                            Crea un nuevo objeto DatagramPacket llamado sendPacket.

                        Parámetros:
                            sendBuffer:
                                El array de bytes que contiene los datos a enviar (en este caso, el mensaje con el
                                resultado de la operación).

                        sendBuffer.length:
                            La longitud del array de bytes.

                        clientAddress:
                            La dirección IP del cliente a quien se enviará el paquete.

                        clientPort:
                            El puerto del cliente a quien se enviará el paquete.

                Contexto
                     Esta línea es parte del proceso para enviar el resultado de la
                     operación matemática al cliente. Aquí está el flujo completo:

                    Creación del Mensaje:
                            Se crea una cadena de texto que contiene el resultado de la operación y se convierte en un
                             array de bytes (sendBuffer).

                    Creación del Paquete de Envío:
                        Utilizando sendBuffer, sendBuffer.length, clientAddress, y clientPort,
                        se crea un DatagramPacket (sendPacket) que contiene los datos a enviar y la información
                         de destino.

                    Envío del Paquete:
                        El paquete sendPacket se envía al cliente utilizando el método serverSocket.send(sendPacket);.

            En resumen, la línea sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress,
            clientPort); crea un paquete de datos que contiene el mensaje con el resultado de la operación y la
            información necesaria para enviarlo al cliente.
            ----------------------------------------------------------------------------------------------
                 */
                serverSocket.send(sendPacket);
                /*----------------EXPLICAICÓN ---------------------------

                Envío del Paquete:
                    serverSocket.send(sendPacket);
                        Función: Envía el paquete de datos sendPacket al cliente a través del socket serverSocket.

                        Proceso: Utiliza el socket UDP (serverSocket) para enviar el DatagramPacket (sendPacket)
                                    que contiene los datos y la información de destino (dirección IP y puerto del
                                    cliente).
            Contexto
            Esta línea es parte del proceso final para enviar el resultado de la operación matemática al cliente.
            Aquí está el flujo completo:

                Creación del Mensaje:
                    Se crea una cadena de texto que contiene el resultado de la operación y se convierte en un array
                     de bytes (sendBuffer).

                Creación del Paquete de Envío:
                    Utilizando sendBuffer, sendBuffer.length, clientAddress, y clientPort, se crea un DatagramPacket
                    (sendPacket) que contiene los datos a enviar y la información de destino.

                Envío del Paquete:
                    El paquete sendPacket se envía al cliente utilizando serverSocket.send(sendPacket);.

            En resumen, la línea serverSocket.send(sendPacket); es la que finalmente envía el paquete de datos con el
            resultado de la operación matemática al cliente. Este paso completa el ciclo de comunicación entre el
            servidor y el cliente
            --------------------------------------------------------------------------------------
             */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*---------------EXPLICAICÓN ---------------------------
        Bloque catch:

        } catch (Exception e) {

            Función:
                Captura cualquier excepción que ocurra dentro del bloque try.

            Parámetro:
                Exception e:
                    La excepción capturada.
                    Exception es una clase base para todas las excepciones en Java, lo que significa que este bloque
                    puede capturar cualquier tipo de excepción.

            Manejo de la Excepción:

                e.printStackTrace();
                    Función: Imprime el stack trace de la excepción. Esto proporciona información detallada sobre la
                    excepción, incluyendo el tipo de excepción, el mensaje de error, y la ubicación en el código donde
                    ocurrió la excepción.

                Resultado: Ayuda a los desarrolladores a diagnosticar y solucionar problemas en el código.

            Contexto
                En el contexto de tu servidor UDP, estas líneas son parte del manejo de excepciones.

                Bloque try:
                    El bloque try contiene el código principal del servidor, incluyendo la creación del socket,
                    la recepción y envío de paquetes, y la realización de operaciones matemáticas.

                Bloque catch:
                    Si ocurre cualquier excepción dentro del bloque try, el control pasa al bloque catch.
                    La excepción capturada se imprime usando e.printStackTrace(), lo que proporciona información
                    útil para la depuración.
        En resumen, estas líneas aseguran que cualquier excepción que ocurra en el servidor se maneje adecuadamente
        imprimiendo el stack trace, lo que facilita la identificación y solución de problemas.
        ---------------------------------------------------------------------------------
         */
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
    }
    /*---------------EXPLICAICÓN ---------------------------
    Firma del Método:

        private static double performOperation(String operation, double num1, double num2)

            Modificadores:
                private: El método solo es accesible dentro de la clase ServidorCalculadoraUDP.

                static: El método pertenece a la clase en sí, no a una instancia específica de la clase.

                Tipo de Retorno: double, el método devuelve un valor de tipo double.

            Parámetros:
                String operation:
                    La operación a realizar (por ejemplo, "suma", "resta", "multiplicacion", "division").

                double num1:
                    El primer número para la operación.

                double num2:
                    El segundo número para la operación.

            Estructura switch:
                switch (operation) {

                    Función:
                        Evalúa el valor de operation y ejecuta el bloque de código correspondiente.

                    Casos del switch:

                            Suma:
                            case "suma":
                                return num1 + num2;
                            Función: Devuelve la suma de num1 y num2.

                            Resta:
                            case "resta":
                                return num1 - num2;
                            Función: Devuelve la resta de num1 y num2.

                            Multiplicación:
                            case "multiplicacion":
                                return num1 * num2;
                            Función: Devuelve la multiplicación de num1 y num2.

                            División:
                            case "division":
                                return num1 / num2;
                            Función: Devuelve la división de num1 entre num2.

                            Caso por Defecto:
                            default:
                                return Double.NaN;
                            Función: Devuelve Double.NaN (Not a Number) si la operación no es válida.

            Contexto
                En el contexto de tu servidor UDP, este metodo se utiliza para realizar la operación matemática
                solicitada por el cliente. Aquí está el flujo completo:

            Recepción de la Operación y los Números:
                El servidor recibe la operación y los dos números del cliente.

            Llamada al Metodo performOperation:
                El metodo performOperation se llama con los parámetros operation, num1, y num2.
                Este metodo realiza la operación especificada y devuelve el resultado.

            Envío del Resultado:
                El resultado de la operación se envía al cliente.

        En resumen, el metodo performOperation realiza la operación matemática especificada utilizando los números
        proporcionados y devuelve el resultado.
        -------------------------------------------------------------------------------------------------
     */
}