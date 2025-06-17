package tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {
        try{
            Socket cliente = new Socket("localhost", 55000);
            InputStream is =cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os =cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            System.out.println("Enviando mensaje al servidor...");
            String mensaje = "Mensaje desde el cliente";
            dos.writeUTF(mensaje);
            System.out.println("Mensaje enviado.");
            System.out.println("Recibiendo mensaje del servidor...");
            mensaje =dis.readUTF();
            System.out.println("Mensaje recibido: " +mensaje);
            System.out.println("Cerrando streams y sockets...");
            dos.close();
            dis.close();
            cliente.close();
            System.out.println("Terminado.");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
