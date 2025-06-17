package Ej_Cliente_Servidor_TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Servidor {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(2);

        try {
            ServerSocket servidor = new ServerSocket(55000);
            System.out.println("Servidor escuchando en el puerto 55000...");

            for (int i = 0; i < 3; i++) {
                Socket cliente = servidor.accept();
                semaforo.acquire(); // Adquirir un permiso del semáforo
                System.out.println("Conexión establecida con " + cliente.getInetAddress());
                Thread clientThread = new Thread(new ManejadorServidorCliente(cliente, semaforo));
                clientThread.setName("Hilo-" + (i+1));
                clientThread.start();
            }

        } catch (IOException e) {
            System.err.println("Error al crear el socket");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Error al adquirir el permiso del semáforo");
            System.out.println(e.getMessage());
        }
    }
}
