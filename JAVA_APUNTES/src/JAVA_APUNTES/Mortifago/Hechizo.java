package Enrique_Benito_Lopez;

public class Hechizo {
    private String nombre;
    private int potencia;

    public Hechizo(String nombre, int potencia) {
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
        return "Hechizo{" +
                "nombre='" + nombre + '\'' +
                ", potencia=" + potencia +
                '}';
    }

}
