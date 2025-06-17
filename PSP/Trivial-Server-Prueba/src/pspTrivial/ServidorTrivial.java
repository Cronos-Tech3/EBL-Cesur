package pspTrivial;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class ServidorTrivial {
    private static final int PORT = 12345;
    private static final int MAX_CLIENTS = 2;
    private static Semaphore semaphore = new Semaphore(MAX_CLIENTS);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado en el puerto " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                semaphore.acquire();
                new Thread(new ManejadorHilosServidor(clientSocket, semaphore)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
