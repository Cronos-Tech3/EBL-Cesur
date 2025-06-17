package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class ManejadorServidorCliente implements Runnable{
    private final Socket cliente;
    private final Semaphore semaforo;

    public ManejadorServidorCliente(Socket cliente, Semaphore semaforo) {
        this.cliente = cliente;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

            double num1;
            double num2;
            String operador;

            //System.out.println(Thread.currentThread().getName() + ": Recibiendo mensaje:");
            System.out.println( ": Esperando mensaje de: " + Thread.currentThread().getName());
            try {
                num1 = Double.parseDouble(entrada.readUTF());
                System.out.println(Thread.currentThread().getName() + ": Numero 1 recibido " + num1);
                salida.writeUTF("Primer numero recibido, ole");

                System.out.println( ": Esperando mensaje de: " + Thread.currentThread().getName());
                num2 = Double.parseDouble(entrada.readUTF());
                System.out.println(Thread.currentThread().getName() + ": Numero 2 recibido " + num2);
                salida.writeUTF("Segundo numero recibido, ole ole");

                System.out.println( ": Esperando mensaje de: " + Thread.currentThread().getName());
                operador = entrada.readUTF();
                System.out.println(Thread.currentThread().getName() + ": Enviando mensaje al cliente:");
                salida.writeUTF(calculadora(num1, num2, operador));
                System.out.println(Thread.currentThread().getName() + ": Cerrando Streams y sockets...");
            } catch (EOFException e) {
                System.out.println(Thread.currentThread().getName() + ": Cliente cerró la conexión abruptamente");
            }
            entrada.close();
            salida.close();
            cliente.close();
            semaforo.release(); // Liberar un permiso del semáforo
        } catch (IOException e) {
            System.err.println("Error al manejar la conexión con el cliente");
            System.out.println(e.getMessage());
        }
    }
    static String calculadora(double num1, double num2, String operador){
        String respuesta;
        switch (operador){
            case "+":
                respuesta= ("la suma es: " + (num1+num2));
                break;
            case "-":
                respuesta= ("la resta es: " + (num1-num2));
                break;
            case "*":
                respuesta= ("la multiplicacion es: " + (num1*num2));
                break;
            case "/":
                respuesta= ("la division es: " + (num1/num2));
                break;
            default:
                respuesta= ("Esa operación no es válida");
                break;
        }
        return respuesta;
    }
}
