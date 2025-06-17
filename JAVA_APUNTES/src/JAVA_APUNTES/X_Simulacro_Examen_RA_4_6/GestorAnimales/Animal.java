package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.GestorAnimales;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Animal:
 * − Atributos: nombre: String, edad: int, tipoAlimentacion: String, tieneCola:
 * boolean, HashMap<Diente, boolean>: dientes.
 * − Métodos:
 * o Void hacerSonido()
 * − Descripción: Este método está vacío, lo que significa que debe ser
 * implementado por las clases que heredan de Animal. Representa el sonido
 * que hace un animal según su comportamiento específico.
 * o Double moverse()
 * − Descripción: Este método también es vacío y representa cómo se mueve un
 * animal según el tipo de movimiento especificado.
 *
 */

public class Animal {

    protected String nombre;

    protected int edad;

    protected String tipoAlimentacion;

    protected boolean tieneCola;

    protected HashMap<Diente, Boolean> dientes;

    public Animal(String nombre, int edad, String tipoAlimentacion, boolean tieneCola, HashMap<Diente, Boolean> dientes) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoAlimentacion = tipoAlimentacion;
        this.tieneCola = tieneCola;
        this.dientes = dientes;
    }

    public HashMap<Diente, Boolean> getDientes() {
        return dientes;
    }

    public void hacerSonido(){

    }

    public double moverse(){
        return 0;
    }

    public boolean agregarDiente(String nom, int num){
        Diente d = new Diente(nom, num);
        if(dientes.containsKey(d)){
            return false;
        }else{
            dientes.put(d, true);
            return true;
        }
    }

    public int obtenerDiente(String nom){
        int x = 0;
        //Primera forma de hacerlo
        /*
        for(Map.Entry<Diente, Boolean> entrada : dientes.entrySet()){
            Diente d = entrada.getKey();
            if (d.getNombre().equals(nom)){
                x = d.getNumero();
                boolean a = entrada.getValue();
                break;
            }
        }
         */
        //Segunda forma de gacerlo mas sencillo
        for (Diente d : dientes.keySet()){
            if (d.getNombre().equals(nom)){
                x = d.getNumero();
                break;
            }
        }
        return x;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", tieneCola=" + tieneCola +
                ", dientes=" + dientes +
                '}';
    }


}
