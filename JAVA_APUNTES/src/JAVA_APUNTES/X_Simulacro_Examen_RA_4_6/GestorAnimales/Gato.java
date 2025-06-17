package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.GestorAnimales;

import java.util.HashMap;

/**
 *Clase Gato (hereda de Animal):
 * − Atributos Adicionales: colorPelaje: String, cazaRatones: boolean.
 * − Métodos Implementados: hacerSonido(), moverse(). Hacer sonido mostrará por
 * pantalla la palabra “Miau” y el método moverse en función del valor que tenga
 * tipoAlimentación devolverá:
 * o Si es Carnívora, y tieneCola es verdadero y cazaRatones es verdadero devolverá 1.2,
 * y si no tiene colay caza ratones 0.5, y sino 0.3.
 * o Si es omnívora, y tieneCola es verdadero y cazaRatones es verdadero devolverá 1.6,
 * y si no tiene colay  caza ratones 0.8, y sino 0.25.
 * o Cualquiera otra convinación devolverá 0.1.
 *
 */

public class Gato extends Animal {

    private String colorPelaje;

    private boolean cazaRatones;

    public Gato(String nombre, int edad, String tipoAlimentacion, boolean tieneCola, HashMap<Diente, Boolean> dientes, String colorPelaje, boolean cazaRatones) {
        super(nombre, edad, tipoAlimentacion, tieneCola, dientes);
        this.colorPelaje = colorPelaje;
        this.cazaRatones = cazaRatones;
    }

    @Override
    public void hacerSonido(){
        System.out.println("MIAUU");
    }

    @Override
    public double moverse(){
        double x = 0;

        if (tipoAlimentacion.equalsIgnoreCase("carnivora")){
            if (cazaRatones && tieneCola){
                x = 1.2;
            }else if (!tieneCola && cazaRatones){
                x = 0.5;
            }else{
                x = 0.3;
            }

        } else if (tipoAlimentacion.equalsIgnoreCase("omnivora")) {
            if (cazaRatones && tieneCola){
                x = 1.6;
            }else if (!tieneCola && cazaRatones){
                x = 0.8;
            }else{
                x = 0.25;
            }
        }else{
            x = 0.1;
        }
        return x;

    }

    @Override
    public String toString() {
        return "Gato{" +
                "colorPelaje='" + colorPelaje + '\'' +
                ", cazaRatones=" + cazaRatones +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", tieneCola=" + tieneCola +
                ", dientes=" + dientes +
                '}';
    }
}
