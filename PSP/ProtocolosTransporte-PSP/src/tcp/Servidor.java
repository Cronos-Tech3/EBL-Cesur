package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        try {
            //Construir el objeto ServerSocket, queda escuchando por el
            //puerto indicado.
            ServerSocket servidor = new ServerSocket(55000);
            System.out.println("Aceptando conexiones...");
            //Espera bloqueado conexiones de clientes: accept
            //Cuando llega una conexión, devuelve un objeto de la clase
            //Socket
            Socket cliente = servidor.accept();
            System.out.println("Conexión con cliente establecida.");
            DataInputStream dis = new
                    DataInputStream(cliente.getInputStream());
            DataOutputStream dos = new
                    DataOutputStream(cliente.getOutputStream());
            System.out.println("Recibo mensaje de cliente...");
            System.out.println(dis.readUTF());
            System.out.println("Envío mensaje al cliente...");
            dos.writeUTF("Mensaje desde el servidor");
            System.out.println("Cerrando streams y sockets...");
            dos.close();
            dis.close();
            cliente.close();
            servidor.close();
        } catch (IOException ex) {
            System.err.println("Error al crear el socket: " +
                    ex.getMessage());
        }
    }


}
