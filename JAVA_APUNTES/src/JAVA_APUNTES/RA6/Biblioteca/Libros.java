package JAVA_APUNTES.RA6.Biblioteca;

public class Libros {

    private String titulo;

    private String autor;

    private int anio_publicacion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public Libros(String titulo, String autor, int anio_publicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio_publicacion=" + anio_publicacion +
                '}';
    }
}
