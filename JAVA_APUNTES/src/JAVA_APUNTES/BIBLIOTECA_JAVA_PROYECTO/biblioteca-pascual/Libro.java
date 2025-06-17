/*package bibliotecaPascualQuiles;

import java.util.Arrays;

public class Libro extends Publicacion {

    private String isbn;

    private String genero;

    private String editorial;

    //existen 2 constructores, pues no es necesario introducir la editorial y el género a la hora de crearse
    public Libro(String titulo, Autoria[] autoria, int ejemplares, int prestados, String isbn, String genero, String editorial) {
        super(titulo, autoria, ejemplares, prestados);
        this.isbn = isbn;
        this.genero = genero;
        this.editorial = editorial;
    }

    public Libro(String titulo, Autoria[] autoria, int ejemplares, int prestados, String isbn) {
        super(titulo, autoria, ejemplares, prestados);
        this.isbn = isbn;
    }

    //el métod0 llama a los atributos de la clase padre para poder mostrarlos todos
    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                "titulo='" + super.getTitulo() + '\'' +
                ", autoria=" + Arrays.toString(super.getAutoria()) +
                ", ejemplares=" + super.getEjemplares() +
                ", prestados=" + super.getPrestados() +
                ", genero='" + genero + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenero() {
        return genero;
    }

    public String getEditorial() {
        return editorial;
    }

    //los únicos atributos que tienen setter son género y editorial, pues podrían ser modificados a posteriori

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}

 */
