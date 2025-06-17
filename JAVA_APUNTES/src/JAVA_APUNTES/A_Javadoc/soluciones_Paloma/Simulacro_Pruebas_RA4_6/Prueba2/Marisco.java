package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba2;

import java.util.HashMap;

public class Marisco {
    private String nombre;
    private String habitat;
    private boolean tieneConcha;
    private HashMap<String, Pinza> pinzas;

    // Constructor: se llama cuando creamos un nuevo Marisco
    public Marisco(String nombre, String habitat, boolean tieneConcha) {
        this.nombre = nombre;
        this.habitat = habitat;
        this.tieneConcha = tieneConcha;
        this.pinzas = new HashMap<>(); // Inicializamos el HashMap de pinzas
    }

    // Método para describir el desplazamiento
    public void moverse() {
        System.out.println("El marisco se desplaza por su entorno.");
    }

    // Método para describir la alimentación
    public String comer() {
        return "El marisco se alimenta de materia orgánica.";
    }

    public String getNombre(){
        return nombre;
    }

    public String getHabitat(){
        return habitat;
    }

    public boolean isTieneConcha(){
        return tieneConcha;
    }

    public HashMap<String, Pinza> getPinzas() {
        return pinzas;
    }
}
