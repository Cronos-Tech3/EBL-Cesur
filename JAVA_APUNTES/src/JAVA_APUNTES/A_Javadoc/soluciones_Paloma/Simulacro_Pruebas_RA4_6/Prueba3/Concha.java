package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba3;

import java.util.HashSet;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Concha {
    private String tipo;
    private HashSet<String> materiales;

    // Constructor: se llama cuando creamos una nueva Concha
    public Concha(String tipo) {
        this.tipo = tipo;
        this.materiales = new HashSet<>(); // Creamos un HashSet vacío
    }

    // Método para añadir un material a la concha
    public boolean agregarMaterial(String material) {
        return this.materiales.add(material); // Añade el material si no existe y devuelve true, si ya existe devuelve false
    }

    // Método para obtener un material aleatorio de la concha
    public String obtenerMaterial() {
        if (this.materiales.isEmpty()) {
            return "Desconocido"; // Si no hay materiales, devuelve "Desconocido"
        } else {
            List<String> listaMateriales = new ArrayList<>(this.materiales);
            Random random = new Random();
            int indiceAleatorio = random.nextInt(listaMateriales.size());
            return listaMateriales.get(indiceAleatorio); // Devuelve un material al azar
        }
    }
}
