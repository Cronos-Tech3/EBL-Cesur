package JAVA_APUNTES.RA7.Jedi_H_FULL;

public class Habilidad {

    private String nombre;
    private int potencia;

    public Habilidad(String nombre, int potencia) {
        this.nombre = nombre;
        this.potencia = potencia;
    }

    public String getNombre() {
        return nombre;
    }


    public int getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "nombre='" + nombre + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}


