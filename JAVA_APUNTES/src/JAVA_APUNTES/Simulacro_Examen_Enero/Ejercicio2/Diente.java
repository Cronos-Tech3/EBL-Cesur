package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio2;

import java.util.HashMap;

class Diente {
    private String nombre;
    private int numero;

    public Diente(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public static boolean agregarDiente(HashMap<String, Integer> dientes, String nombre, int numero) {
        if (dientes.containsKey(nombre)) {
            return false;
        }
        dientes.put(nombre, numero);
        return true;
    }

    public static int obtenerDiente(HashMap<String, Integer> dientes, String nombre) {
        return dientes.getOrDefault(nombre, 0);
    }
}
