package JAVA_APUNTES.Biblioteca_JoseTornero_EnriqueBenito;

public class Autoria {
    // Atributos
    private int id;
    private String nombre;
    private String apellidos;

    // Constructor
    public Autoria(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // Metodo ToString
    @Override
    public String toString() {
        return "Autoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
