package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetorMariscos {
    private static ArrayList<Marisco> mariscos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear cangrejos
        for (int i = 0; i < 2; i++) {
            Cangrejo cangrejo = crearCangrejo(scanner);
            mariscos.add(cangrejo);
        }

        // Crear almejas
        for (int i = 0; i < 2; i++) {
            Almeja almeja = crearAlmeja(scanner);
            mariscos.add(almeja);
        }

        // Recorrer y mostrar información
        for (Marisco marisco : mariscos) {
            System.out.println("Nombre: " + marisco.getNombre());
            System.out.println("Hábitat: " + marisco.getHabitat());
            System.out.print("Concha: ");
            if (marisco.isTieneConcha()){
                System.out.println("Sí, de tipo "+ marisco.getConcha().obtenerMaterial());
            } else {
                System.out.println("No");
            }
            marisco.desplazar();
            System.out.println("Alimentación: " + marisco.alimentarse());
            System.out.println("--------------------");
        }
        scanner.close();
    }

    public static Cangrejo crearCangrejo(Scanner scanner) {
        String nombre = validarNombre(scanner, "cangrejo");
        System.out.println("Introduce el hábitat del cangrejo:");
        String habitat = scanner.nextLine();
        System.out.println("¿Tiene concha? (true/false):");
        boolean tieneConcha = scanner.nextBoolean();
        Concha concha = null;
        if(tieneConcha){
            concha = new Concha("Crustáceo");
            concha.agregarMaterial("Quitina");
        }
        System.out.println("Introduce el número de patas:");
        int numPatas = scanner.nextInt();
        System.out.println("¿Es gigante? (true/false):");
        boolean esGigante = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return new Cangrejo(nombre, habitat, tieneConcha, concha, numPatas, esGigante);
    }

    public static Almeja crearAlmeja(Scanner scanner) {
        String nombre = validarNombre(scanner, "almeja");
        System.out.println("Introduce el hábitat de la almeja:");
        String habitat = scanner.nextLine();
        System.out.println("¿Tiene concha? (true/false):");
        boolean tieneConcha = scanner.nextBoolean();
        Concha concha = null;
        if(tieneConcha){
            concha = new Concha("Bivalva");
            concha.agregarMaterial("Caliza");
        }
        System.out.println("¿Tiene perla? (true/false):");
        boolean tienePerla = scanner.nextBoolean();
        System.out.println("Introduce la forma de la concha:");
        scanner.nextLine();
        String formaConcha = scanner.nextLine();
        return new Almeja(nombre, habitat, tieneConcha, concha, tienePerla, formaConcha);
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
