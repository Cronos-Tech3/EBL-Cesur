package udp;

import java.io.IOException;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try{
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            DatagramSocket datagramSocket = new DatagramSocket(addr);
            System.out.println("Servidor preparado...");
//Recepción de mensajes:
            DatagramPacket datagrama;
            while (true) {
                byte[]buffer = new byte[1024];
                datagrama = new DatagramPacket(buffer,buffer.length);
                datagramSocket.receive(datagrama); //Espera bloqueante mientras recibe información
//Al recibir un datagrama, recupero el mensaje enviado, la IP y el puerto del cliente
                String mensaje = new String(datagrama.getData());
                System.out.println("Recibido mensaje del cliente: " +mensaje);
                InetAddress clientAddr =datagrama.getAddress();
                int clientPort =datagrama.getPort();
//Envío datagrama al cliente:
                mensaje = "Mensaje desde el servidor";
                byte[]respuesta =mensaje.getBytes();
                datagrama = new DatagramPacket(respuesta,respuesta.length,clientAddr,clientPort);
                datagramSocket.send(datagrama);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
