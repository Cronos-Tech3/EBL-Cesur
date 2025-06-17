package tcp;

import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            System.out.println("Creando y conectando el socket stream cliente...");
            //Construyo y conecto el socket con la dirección IP (127.0.0.1 o localhost) y el puerto.
            //3. Programación distribuida página 31
            //o localhost) y el puerto.
            Socket cliente = new Socket("localhost", 55000);
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            System.out.println("Enviando mensaje al servidor...");
            String mensaje = "Mensaje desde el cliente";
            dos.writeUTF(mensaje);
            System.out.println("Mensaje enviado.");
            System.out.println("Recibiendo mensaje del servidor...");
            mensaje = dis.readUTF();
            System.out.println("Mensaje recibido: " + mensaje);
            System.out.println("Cerrando streams y sockets...");
            dos.close();
            dis.close();
            cliente.close();
            System.out.println("Terminado.");
        } catch (IOException ex) {
            System.err.println("Error al crear el socket: " +
                    ex.getMessage());
        }
    }


}
