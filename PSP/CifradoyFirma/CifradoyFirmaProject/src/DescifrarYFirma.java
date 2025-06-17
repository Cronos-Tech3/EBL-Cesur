import java.security.*; // Importa clases para criptografía (claves, firmas).
import java.io.*; // Importa clases para entrada/salida de archivos.
import javax.crypto.Cipher; // Importa la clase Cipher para cifrado/descifrado.

public class DescifrarYFirma { // Clase principal del programa.
    public static void main(String[] args) { // Método principal.
        try { // Bloque try-catch para manejar excepciones.
            // 1. Cargar clave privada del receptor (deserializada)
            PrivateKey privateKey; // Declara una variable para la clave privada.
            try (ObjectInputStream ois = new ObjectInputStream( // Crea un ObjectInputStream para leer objetos desde un archivo.
                    new FileInputStream("privateKey"))) { // Abre el archivo "privateKey" para lectura.
                privateKey = (PrivateKey) ois.readObject(); // Lee el objeto PrivateKey del archivo.
            } // Cierra el ObjectInputStream automáticamente.

            // 2. Descifrar mensaje
            byte[] mensajeCifrado = new byte[(int) new File("mensaje").length()]; // Crea un array de bytes del tamaño del archivo "mensaje" (que contiene el mensaje cifrado).
            try (FileInputStream fis = new FileInputStream("mensaje")) { // Crea un FileInputStream para leer bytes desde el archivo "mensaje".
                fis.read(mensajeCifrado); // Lee los bytes del archivo y los almacena en el array mensajeCifrado.
            } // Cierra el FileInputStream automáticamente.

            Cipher cipher = Cipher.getInstance("RSA"); // Obtiene una instancia de Cipher para el algoritmo RSA.
            cipher.init(Cipher.DECRYPT_MODE, privateKey); // Inicializa el Cipher en modo de descifrado, usando la clave privada.
            byte[] mensajeBytes = cipher.doFinal(mensajeCifrado); // Descifra el mensaje cifrado y obtiene el resultado en bytes.
            String mensajeDescifrado = new String(mensajeBytes); // Convierte los bytes del mensaje descifrado a un String.
            System.out.println("Mensaje descifrado: " + mensajeDescifrado); // Imprime el mensaje descifrado.

            // 3. Verificar firma con clave pública del emisor
            PublicKey publicKeyEmisor;  // Declara variable para la clave pública del emisor.
            try (ObjectInputStream ois = new ObjectInputStream( // Crea un ObjectInputStream para leer objetos.
                    new FileInputStream("publicKey"))) { // Abre el archivo "publicKey" (del emisor)
                publicKeyEmisor = (PublicKey) ois.readObject(); // Lee la clave pública del emisor.
            } // Cierra el ObjectInputStream.

            byte[] firmaBytes = new byte[(int) new File("mensajeCifrado").length()]; // Crea un array de bytes para la firma, leyendo del archivo.
            try (FileInputStream fis = new FileInputStream("mensajeCifrado")) { // Abre el archivo que contiene la firma.
                fis.read(firmaBytes); // Lee los bytes de la firma.
            } // Cierra el FileInputStream.

            Signature firma = Signature.getInstance("SHA256withRSA"); // Obtiene instancia de Signature para verificar.
            firma.initVerify(publicKeyEmisor); // Inicializa para verificación con la clave pública del emisor.
            firma.update(mensajeDescifrado.getBytes()); // Proporciona el mensaje descifrado (en bytes) para la verificación.
            boolean esValida = firma.verify(firmaBytes); // Verifica la firma usando los bytes de la firma.

            System.out.println("Firma válida: " + esValida); // Imprime el resultado de la verificación.
        } catch (Exception e) { // Captura excepciones.
            e.printStackTrace(); // Imprime la traza de la excepción.
        } // Fin del bloque try-catch.
    } // Fin del método main.
} // Fin de la clase DescifrarYFirma.
