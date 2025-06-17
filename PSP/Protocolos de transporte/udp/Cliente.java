package udp;

import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {

        try{
            String mensaje = "Mensaje desde el cliente";
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress serverAddr =InetAddress.getByName("localhost");
//Construimos y enviamos el datagrama:
            DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,serverAddr, 5555);
            datagramSocket.send(datagrama);
            System.out.println("Mensaje enviado al servidor");
//Esperamos la respuesta del servidor:
            byte[]respuesta = new byte[1024];
            datagrama = new DatagramPacket(respuesta,respuesta.length);
            datagramSocket.receive(datagrama);
            System.out.println("Mensaje recibido: " + new String(respuesta));
            datagramSocket.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
