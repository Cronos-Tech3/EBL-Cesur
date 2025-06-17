import java.security.*;
// Importa las clases necesarias para la generación de claves (KeyPairGenerator, KeyPair, PublicKey, PrivateKey)
import java.io.*;
// Importa las clases necesarias para la entrada/salida de archivos (ObjectOutputStream, FileOutputStream)

// Define la clase principal del programa.
public class GeneradorClaves {
    public static void main(String[] args) { // Define el método main, el punto de entrada del programa
        try {
            // Inicia un bloque try-catch para manejar las excepciones que puedan ocurrir.
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); // Obtiene una instancia del generador de pares de claves para el algoritmo RSA.  "RSA" es el algoritmo criptográfico

            KeyPair par = keyGen.generateKeyPair(); // Genera un par de claves (pública y privada) utilizando el generador

            // Bloque para escribir la clave pública en un archivo
            try (ObjectOutputStream oos = new ObjectOutputStream( // Crea un ObjectOutputStream para escribir objetos Java en un archivo.  El try-with-resources asegura que el stream se cierre automáticamente
                    new FileOutputStream("publicKey"))) { // Crea un FileOutputStream para escribir bytes en el archivo "publicKey".
                oos.writeObject(par.getPublic()); // Escribe el objeto PublicKey (la clave pública) en el archivo.
            }

            // Bloque para escribir la clave privada en un archivo.
            try (ObjectOutputStream oos = new ObjectOutputStream( // Crea un ObjectOutputStream para escribir objetos Java en un archivo.
                    new FileOutputStream("privateKey"))) { // Crea un FileOutputStream para escribir bytes en el archivo "privateKey"
                oos.writeObject(par.getPrivate()); // Escribe el objeto PrivateKey (la clave privada) en el archivo.
            } // El ObjectOutputStream se cierra automáticamente aquí. Al ser un Try-with-resource


        } catch (Exception e) { // Captura cualquier excepción que ocurra dentro del bloque try.  Es una práctica generalizada usar Exception para simplificar, pero en producción, se manejarían excepciones más específicas.
            e.printStackTrace(); // Imprime la traza de la excepción en la consola, lo cual es útil para el debugging.
        } // Termina el bloque try-catch.
    } // Termina el metodo main.
} // Termina la clase GeneradorClaves.

