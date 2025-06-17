package ejercicios;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creando y conectando el socket stream cliente");
        try {
            Socket cliente = new Socket("localhost",55000);
            String mensaje;

            //Stream de entrada de datos
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            //Stream de salida de datos
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            for (int i = 0; i < 3; i++) {
                switch (i){
                    case 0 :
                        System.out.println("(Escribe salir para finalizar antes");
                        System.out.println("Escribe el primer numero");
                        break;
                    case 1 :
                        System.out.println("Escribe el segundo numero");
                        break;
                    case 2 :
                        System.out.println("Escribe el operador, ej: + , - , * , /");
                        break;
                }
                mensaje = sc.nextLine();
                if(mensaje.equals("salir")){
                    i = 3;
                }else{
                    dos.writeUTF(mensaje);
                    System.out.println("Mensaje enviado");
                    System.out.println("Recibiendo mensaje del servidor:");
                    mensaje = dis.readUTF();
                    System.out.println("Mensaje del servidor: " + mensaje);
                }
            }
            System.out.println("Cerrando conexión con el servidor...");
            dos.close();
            dis.close();
            cliente.close();
            System.out.println("Terminando");

        } catch (IOException e) {
            System.err.println("Error al crear el socket.");
            System.out.println(e.getMessage());
        }
    }
}
