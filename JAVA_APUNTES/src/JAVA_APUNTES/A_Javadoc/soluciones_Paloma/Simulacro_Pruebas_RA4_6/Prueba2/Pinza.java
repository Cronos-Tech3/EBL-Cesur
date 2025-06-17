package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba2;

public class Pinza {
    private String tipo;
    private int fuerza;

    // Constructor: se llama cuando creamos una nueva Pinza
    public Pinza(String tipo) {
        this.tipo = tipo;
        this.fuerza = 0; // Inicializamos la fuerza a 0
    }

    // Método para agregar fuerza a la pinza
    public boolean agregarFuerza(int incremento) {
        if (incremento > 0) {
            this.fuerza += incremento;
            return true;
        } else {
            return false;
        }
    }

    // Método para obtener la fuerza de la pinza
    public int obtenerFuerza() {
        return this.fuerza;
    }

    // Getters para acceder a los atributos (si es necesario)
    public String getTipo() {
        return tipo;
    }
}
