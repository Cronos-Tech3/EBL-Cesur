package JAVA_APUNTES.BUCLES.Bucles_Extra;
import java.util.Scanner;
public class Ej9Copilot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char caracter;

        System.out.println("Introduce caracteres. El programa termina cuando se introduce 'A' .");

        while (true) {
            caracter = scanner.next().charAt(0);

            if (caracter == 'A') {
                        break;
            }

            if (esVocal(caracter)) {
                        System.out.println("VOCAL");
            } else {
                        System.out.println("NO VOCAL");
            }
        }
    }

    public static boolean esVocal(char c) {
                c = Character.toLowerCase(c);
                return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
