package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba1;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos un objeto Pescaderia
        Pescaderia miPescaderia = new Pescaderia("Mariscos Frescos");

        // 2. Agregamos algunos mariscos
        miPescaderia.agregarMarisco("Gamba Roja", "Crustáceo", 12.50, true);
        miPescaderia.agregarMarisco("Mejillón de Roca", "Molusco", 3.00, false);
        miPescaderia.agregarMarisco("Pulpo Gallego", "Cefalópodo", 22.00, true);

        // 3. Mostramos la lista de mariscos
        System.out.println(miPescaderia); // Llama automáticamente al método toString()

        // 4. Calculamos y mostramos los precios para un mes
        System.out.println("\nPrecios en Diciembre:");
        miPescaderia.calcularPrecios("diciembre");

        System.out.println("\nPrecios en Agosto:");
        miPescaderia.calcularPrecios("agosto");

        System.out.println("\nPrecios en Noviembre:");
        miPescaderia.calcularPrecios("noviembre");
    }

}
