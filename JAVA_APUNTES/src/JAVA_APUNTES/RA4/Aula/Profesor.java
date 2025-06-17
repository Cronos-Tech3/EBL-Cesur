package JAVA_APUNTES.RA4.Aula;

public class Profesor {

    public String nombre;

    public String asignatura;

    public String apellidos;

    public Profesor(String nombre, String asignatura, String apellidos) {
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", asignatura='" + asignatura + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }

    public Profesor(){


    }

}
