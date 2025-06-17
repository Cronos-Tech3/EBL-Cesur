package JAVA_APUNTES.RA7.Jedi_L;

public class Habilidad {
    private String nombre;
    private int potencia;

    public Habilidad(String nombre, int potencia) {
        this.nombre = nombre;
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "nombre='" + nombre + '\'' +
                ", potencia=" + potencia +
                '}';
    }

    public int getPotencia() {
        return potencia;
    }
}
