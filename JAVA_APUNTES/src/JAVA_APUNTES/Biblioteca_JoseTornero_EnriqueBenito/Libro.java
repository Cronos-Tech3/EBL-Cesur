package JAVA_APUNTES.Biblioteca_JoseTornero_EnriqueBenito;


public class Libro extends Publicacion {

    // Atributos
    private String ISBN;
    private String genero;
    private String editorial;

    // Constructor
    public Libro(String titulo, Autoria[] autorias, int ejemplares, String ISBN, String genero, String editorial) {
        super(titulo, autorias, ejemplares);
        this.ISBN = ISBN;
        this.genero = genero;
        this.editorial = editorial;
    }

    // Getters y Setters
    public String getISBN() {
        return ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    // Metodo ToString

    @Override
    public String toString() {
        return super.toString() + "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", genero='" + genero + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}
