package JAVA_APUNTES.ARRAYS.AHORCADO;
/**
 * @author Enrique Benito Lopez
 * @author David Lopez Acosta
 * @author Marcos Lopez Salgado
 * @author teamLopez
 *
 * Genera el juego del ahorcado.
 * Para ello deberás generar un array con las posibles palabras que se utilizarán en el juego (al menos 10).
 * Luego generarás un número aleatorio para que el programa seleccione con qué palabra se va a jugar.
 * Después pedirás al usuario letras para que adivine la palabra,
 * si la letra está en la palabra habrá que mostrar las letras que se han acertado de la palabra,
 * si no el personaje del usuario se irá dibujando hasta que esté colgado y pierda o acierte la palabra (6 intentos).
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
        public class ejAhorcado {
            public static void main(String[] args) {
                // creamos el array list de las palabras para el ahorcado
                String[] lenguajes = {"java", "javascript", "python", "html", "css", "kotlin", "ruby", "php", "cobol", "pascal"};
                // Selección aleatoria de palabra
                Random random = new Random(); // llamamos a la clase random que se importa
                String palabra = lenguajes[random.nextInt(lenguajes.length)]; // asociamos el string palabra al array lenguajes
                // Se inicia el juego en el siguiente apartado
                char[] palabraAdivinada = new char[palabra.length()];   // array de los caracteres individuales que recorren la palabra
                for (int i = 0; i < palabraAdivinada.length; i++) {    // for i para la palabra adivinada
                    palabraAdivinada[i] = '_';                         // aqui esta poniendo los huecos de la palabra adivinada
                }
                ArrayList<Character> letrasAdivinadas = new ArrayList<>();
                int intentosRestantes = 6;
                boolean palabraCompleta = false;
                Scanner scanner = new Scanner(System.in);
                // Bucle del juego
                while (intentosRestantes > 0 && !palabraCompleta) {
                    System.out.println("Palabra: " + String.valueOf(palabraAdivinada));
                    System.out.println("Intentos restantes: " + intentosRestantes);
                    dibujarAhorcado(intentosRestantes);
                    System.out.print("Introduce una letra: ");
                    char letra = scanner.next().charAt(0);
                    if (letrasAdivinadas.contains(letra)) {
                        System.out.println("Ya has adivinado esa letra. Intenta con otra.");
                        continue;
                    }
                    letrasAdivinadas.add(letra); // Funcion añadir letra
                    boolean letraEncontrada = false;  // si la letra para la palabra aleatoria generada es falsa
                    for (int i = 0; i < palabra.length(); i++) {    // bucle for i
                        if (palabra.charAt(i) == letra) {    // if la letra introducida es igual a la letra a adivinar
                            palabraAdivinada[i] = letra;
                            letraEncontrada = true;  //la letra es acertada
                        }
                    }
                    if (!letraEncontrada) {  // si la letra no coincide
                        intentosRestantes--; // se resta un intento
                        System.out.println("Letra incorrecta."); // y se informa al usuario de ello
                    }
                    palabraCompleta = true;  // si la letra es acertada pero no está la palabra completa se continua
                    for (char c : palabraAdivinada) {
                        if (c == '_') {
                            palabraCompleta = false;
                            break;
                        }
                    }
                }
                if (palabraCompleta) { //fin del juego
                    System.out.println("Enhorabuena!! Lo adivinaste! Era: " + palabra);  //ganado
                } else{
                    System.out.println("  +---+");
                    System.out.println("  |   |");
                    System.out.println("  O   |");
                    System.out.println(" /|\\  |");
                    System.out.println(" / \\  |");
                    System.out.println("      |");
                    System.out.println("=========");
                    System.out.println("Ooooh, perdiste, era: " + palabra); //perdido
                }


            }


            public static void dibujarAhorcado(int intentosRestantes) {
                switch (intentosRestantes) {
                    case 6:
                        System.out.println("  +---+");
                        System.out.println("  |   |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("=========");
                        break;
                    case 5:
                        System.out.println("  +---+");
                        System.out.println("  |   |");
                        System.out.println("  O   |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("=========");
                        break;
                    case 4:
                        System.out.println("  +---+");
                        System.out.println("  |   |");
                        System.out.println("  O   |");
                        System.out.println("  |   |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("=========");
                        break;
                    case 3:
                        System.out.println("  +---+");
                        System.out.println("  |   |");
                        System.out.println("  O   |");
                        System.out.println(" /|   |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("=========");
                        break;
                    case 2:
                        System.out.println("  +---+");
                        System.out.println("  |   |");
                        System.out.println("  O   |");
                        System.out.println(" /|\\  |");
                        System.out.println("      |");
                        System.out.println("      |");
                        System.out.println("=========");
                        break;
                    case 1:
                        System.out.println("  +---+");
                        System.out.println("  |   |");
                        System.out.println("  O   |");
                        System.out.println(" /|\\  |");
                        System.out.println(" /    |");
                        System.out.println("      |");
                        System.out.println("=========");
                        break;
                }
            }
        }








