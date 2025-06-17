package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.GestorAnimales;

import java.util.HashMap;

/**
 * Clase Perro (hereda de Animal):
 * − Atributos Adicionales: raza: String, ladra: boolean.
 * − Métodos Implementados: hacerSonido(), moverse(). Hacer sonido mostrará por
 * pantalla la palabra “Guau” y el método moverse en función del valor que tenga
 * tipoAlimentación devolverá:
 * o Si es Carnívora, y tieneCola es verdadero devolverá 1.5, y si no tiene cola 0.5.
 * o Si es omnívora, y tieneCola es verdadero devolverá 2.0 y si no tiene cola 1.2.
 * o Cualquier otra opción devolverá 0.3.
 *
 */

public class Perro extends Animal {

    private String raza;

    private boolean ladra;

    public Perro(String nombre, int edad, String tipoAlimentacion, boolean tieneCola, HashMap<Diente, Boolean> dientes, String raza, boolean ladra) {
        super(nombre, edad, tipoAlimentacion, tieneCola, dientes);
        this.raza = raza;
        this.ladra = ladra;
    }

    @Override
    public void hacerSonido(){
        System.out.println("GUAU");
    }

    @Override
    public double moverse(){
        double x = 0.3;

        if(tipoAlimentacion.equalsIgnoreCase("carnivora")){
            if(tieneCola){
                x = 1.5;
            }else{
                x = 0.5;
            }
        } else if (tipoAlimentacion.equalsIgnoreCase("omnivora")){
            if(tieneCola){
                x = 2.0;
            }else{
                x = 1.2;
            }
        }else{
            x = 0.3;
        }

        return x;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "raza='" + raza + '\'' +
                ", ladra=" + ladra +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", tieneCola=" + tieneCola +
                ", dientes=" + dientes +
                '}';
    }
}
