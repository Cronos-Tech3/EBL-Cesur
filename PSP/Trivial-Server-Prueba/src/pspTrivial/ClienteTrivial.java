package pspTrivial;



import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTrivial {
    private static final String SERVER_IP = "localhost";
    private static final int PORT = 12345   ;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Comunicación con el servidor
            for (int i = 0; i < 5; i++) {
                String pregunta = (String) in.readObject();
                System.out.println(pregunta);
                // Enviar respuesta (simulada)
                out.writeObject("Respuesta " + (i + 1));
            }
            String mensajeDespedida = (String) in.readObject();
            System.out.println(mensajeDespedida);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
