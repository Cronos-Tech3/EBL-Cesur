package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio2;

import java.util.HashMap;

public class Animal {

    protected String nombre;
    protected int edad;
    protected String tipoAlimentacion;
    protected boolean tieneCola;
    protected HashMap<String, Diente> dientes = new HashMap<>();

    public Animal(String nombre, int edad, String tipoAlimentacion, boolean tieneCola) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoAlimentacion = tipoAlimentacion;
        this.tieneCola = tieneCola;
    }

    public void hacerSonido() {

    }

    public double moverse(){
        return 0;
    }
}
