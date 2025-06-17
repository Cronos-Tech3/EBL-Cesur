package pspTrivial;



import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class ManejadorHilosServidor implements Runnable {
    private Socket clientSocket;
    private Semaphore semaphore;

    public ManejadorHilosServidor(Socket clientSocket, Semaphore semaphore) {
        this.clientSocket = clientSocket;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

            // Enviar preguntas y recibir respuestas
            for (int i = 0; i < 5; i++) {
                out.writeObject("Pregunta " + (i + 1));
                String respuesta = (String) in.readObject();
                System.out.println("Respuesta recibida: " + respuesta);
            }
            out.writeObject("Gracias por jugar. Tu puntuación es: X");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
