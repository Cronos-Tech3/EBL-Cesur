/*
package bibliotecaPascualQuiles;


import java.util.Arrays;

public class Revista extends Publicacion {

    private String issn;

    private int edicion;


    //2 constructores por si no se conoce/no es relevante la edición a la hora de crear la revista
    public Revista(String titulo, Autoria[] autoria, int ejemplares, int prestados, String issn, int edicion) {
        super(titulo, autoria, ejemplares, prestados);
        this.issn = issn;
        this.edicion = edicion;
    }

    public Revista(String titulo, Autoria[] autoria, int ejemplares, int prestados, String issn) {
        super(titulo, autoria, ejemplares, prestados);
        this.issn = issn;
    }

    public String getIssn() {
        return issn;
    }

    public int getEdicion() {
        return edicion;
    }

    //el único setter es el de edición en caso de que cambie
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    //incluye los atributos de la clase padre
    @Override
    public String toString() {
        return "Revista{" +
                "issn='" + issn + '\'' +
                ", edicion=" + edicion +
                ", titulo='" + super.getTitulo() + '\'' +
                ", autoria=" + Arrays.toString(super.getAutoria()) +
                ", ejemplares=" + super.getEjemplares() +
                ", prestados=" + super.getPrestados() +
                '}';
    }
}

 */

