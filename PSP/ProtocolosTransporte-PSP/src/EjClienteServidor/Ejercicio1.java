package EjClienteServidor;

public class Ejercicio1 {

    /**
     * Ejercicio 1
     *  Crea un programa modelo cliente-servidor en el que el servidor será una calculadora, y los clientes
     * máquinas que quieren hacer operaciones sencillas: sumar, restar, multiplicar y dividir (+, -, *, /)
     *  El protocolo de comunicaciones será el siguiente:
     *  El servidor se queda escuchando por su IP (localhost, o 127.0.0.1) y el puerto 50005. Podrá aceptar a
     * un máximo de 5 clientes (semáforo) simultáneamente (Threads).
     *  El cliente se conecta al servidor. Y se comunica del siguiente modo en bucle infinito, hasta que
     * cliente envía "salir":
     *  Por ejemplo:
     *  1.
     *  2.
     *  3.
     *  4.
     *  5.
     *  6.
     *  7.
     *  Servidor envía al cliente: "Dime el primer operando o "salir".
     *  Cliente envía al servidor: 2 (como String, para que también sea válido si envía "salir")
     *  Servidor envía al cliente: "Dime el segundo operando"
     *  Cliente envía al servidor: 5 (como String, o como prefieras...)
     *  Servidor envía al cliente: "Dime el operador [+, -, /, *]"
     *  Cliente envía al servidor: "+" (char o String)
     *  Servidor responde al cliente: 7 (como int, double, String...)
     */


}
