package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.biblioteca.biblioteca_paloma;

public class Libro {
    private String titulo;
    private String autor;
    private String anioPublicacion;

    public Libro(String titulo, String autor, String anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                '}';
    }
}
