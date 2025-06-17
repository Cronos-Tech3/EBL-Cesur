import java.security.*; // Importa clases para criptografía (claves, firmas).
import java.io.*; // Importa clases para entrada/salida de archivos.
import javax.crypto.Cipher; // Importa la clase Cipher para cifrado/descifrado.

public class CifradoYFirma { // Clase principal del programa.
    public static void main(String[] args) { // Método principal.
        try { // Bloque try-catch para manejar excepciones.
            String mensaje = "Mady Sanda"; // Mensaje a cifrar y firmar.

            PublicKey publicKey; // Declara una variable para la clave pública.
            try (ObjectInputStream ois = new ObjectInputStream( // Crea un ObjectInputStream para leer objetos desde un archivo.
                    new FileInputStream("publicKey"))) { // Abre el archivo "publicKey" para lectura.
                publicKey = (PublicKey) ois.readObject(); // Lee el objeto PublicKey del archivo.
            } // Cierra el ObjectInputStream automáticamente.

            // Cifrado del mensaje
            Cipher cipher = Cipher.getInstance("RSA"); // Obtiene una instancia de Cipher para el algoritmo RSA.
            cipher.init(Cipher.ENCRYPT_MODE, publicKey); // Inicializa el Cipher en modo de cifrado, usando la clave pública.
            byte[] mensajeCifrado = cipher.doFinal(mensaje.getBytes()); // Cifra el mensaje (convertido a bytes) y obtiene el resultado en bytes.

            // Guarda el mensaje cifrado en un archivo
            try (FileOutputStream fos = new FileOutputStream("mensaje")) { // Crea un FileOutputStream para escribir bytes en el archivo "mensaje".
                fos.write(mensajeCifrado); // Escribe los bytes del mensaje cifrado en el archivo.
            } // Cierra el FileOutputStream automáticamente.

            // Generación del par de claves para la firma
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); // Obtiene un generador de pares de claves RSA.
            KeyPair parEmisor = keyGen.generateKeyPair(); // Genera un nuevo par de claves (pública y privada) para el emisor.

            // Firma del mensaje
            Signature firma = Signature.getInstance("SHA256withRSA"); // Obtiene una instancia de Signature para el algoritmo de firma "SHA256withRSA".
            firma.initSign(parEmisor.getPrivate()); // Inicializa el objeto Signature para firmar, usando la clave privada del emisor.
            firma.update(mensaje.getBytes()); // Proporciona los bytes del mensaje al objeto Signature para que los procese.
            byte[] firmaBytes = firma.sign(); // Genera la firma digital del mensaje.

            // Guarda la firma en un archivo
            try (FileOutputStream fos = new FileOutputStream("mensajeCifrado")) { // Crea un FileOutputStream para escribir en el archivo "mensajeCifrado".  Aquí hay una potencial confusión, ya que parece que se sobrescribe el archivo del mensaje cifrado.  Debería ser otro nombre de archivo.
                fos.write(firmaBytes); // Escribe los bytes de la firma en el archivo.
            } // Cierra el FileOutputStream.

            //Guarda la clave publica del emisor
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("publicKey"))) {
                oos.writeObject(parEmisor.getPublic());
            }

            System.out.println("Mensaje cifrado y firmado correctamente."); // Imprime un mensaje de éxito.
        } catch (Exception e) { // Captura cualquier excepción.
            e.printStackTrace(); // Imprime la traza de la excepción.
        } // Fin del bloque try-catch.
    } // Fin del método main.
} // Fin de la clase CifradoYFirma.
