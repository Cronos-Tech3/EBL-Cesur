package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorMariscos {
    private static Stack<Marisco> mariscos = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear cangrejos
        for (int i = 0; i < 2; i++) {
            Cangrejo cangrejo = crearCangrejo(scanner);
            mariscos.push(cangrejo); // Usamos push() para añadir al Stack
        }

        // Crear mejillones
        for (int i = 0; i < 2; i++) {
            Mejillon mejillon = crearMejillon(scanner);
            mariscos.push(mejillon); // Usamos push() para añadir al Stack
        }

        // Recorrer y mostrar información usando un iterador
        Iterator<Marisco> iterador = mariscos.iterator();
        while (iterador.hasNext()) {
            Marisco marisco = iterador.next();
            System.out.println("Nombre: " + marisco.getNombre());
            System.out.println("Hábitat: " + marisco.getHabitat());
            System.out.print("Concha: ");
            if (marisco.isTieneConcha()){
                System.out.println("Sí");
            } else {
                System.out.println("No");
            }
            marisco.moverse();
            System.out.println("Alimentación: " + marisco.comer());
            System.out.println("--------------------");
        }
        scanner.close();
    }

    // Métodos para crear cangrejos y mejillones (con validación)
    public static Cangrejo crearCangrejo(Scanner scanner) {
        String nombre = validarNombre(scanner, "cangrejo");
        System.out.println("Introduce el hábitat del cangrejo:");
        String habitat = scanner.nextLine();
        System.out.println("¿Tiene concha? (true/false):");
        boolean tieneConcha = scanner.nextBoolean();
        System.out.println("Introduce la especie del cangrejo:");
        scanner.nextLine();//limpiar buffer
        String especie = scanner.nextLine();
        System.out.println("Introduce el número de ojos:");
        int numOjos = scanner.nextInt();
        scanner.nextLine();//limpiar buffer
        return new Cangrejo(nombre, habitat, tieneConcha, especie, numOjos);
    }

    public static Mejillon crearMejillon(Scanner scanner) {
        String nombre = validarNombre(scanner, "mejillón");
        System.out.println("Introduce el hábitat del mejillón:");
        String habitat = scanner.nextLine();
        System.out.println("¿Tiene concha? (true/false):");
        boolean tieneConcha = scanner.nextBoolean();
        System.out.println("Introduce el tipo de cuerda:");
        scanner.nextLine();
        String tipoCuerda = scanner.nextLine();
        System.out.println("¿Es de roca? (true/false):");
        boolean esDeRoca = scanner.nextBoolean();
        scanner.nextLine();//limpiar buffer
        return new Mejillon(nombre, habitat, tieneConcha, tipoCuerda, esDeRoca);
    }

    public static String validarNombre(Scanner scanner, String tipoMarisco) {
        String nombre;
        do {
            System.out.println("Introduce el nombre del " + tipoMarisco + " (entre 3 y 25 letras y espacios):");
            nombre = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z ]{3,25}$");
            Matcher matcher = pattern.matcher(nombre);
            if (!matcher.matches()) {
                System.out.println("Nombre inválido. Inténtalo de nuevo.");
            }
        } while (!nombre.matches("^[a-zA-Z ]{3,25}$"));
        return nombre;
    }
}