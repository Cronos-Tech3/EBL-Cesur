package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba3;

public class Marisco {
    private String nombre;
    private String habitat;
    private boolean tieneConcha;
    private Concha concha;

    // Constructor: se llama cuando creamos un nuevo Marisco
    public Marisco(String nombre, String habitat, boolean tieneConcha, Concha concha) {
        this.nombre = nombre;
        this.habitat = habitat;
        this.tieneConcha = tieneConcha;
        this.concha = concha;
    }

    // Método para describir el desplazamiento
    public void desplazar() {
        System.out.println("El marisco se desplaza por su entorno.");
    }

    // Método para describir la alimentación
    public String alimentarse() {
        return "El marisco se alimenta de materia orgánica.";
    }

    // Getters para acceder a los atributos (si es necesario)
    public String getNombre() {
        return nombre;
    }

    public String getHabitat() {
        return habitat;
    }

    public boolean isTieneConcha() {
        return tieneConcha;
    }

    public Concha getConcha(){
        return concha;
    }
}
