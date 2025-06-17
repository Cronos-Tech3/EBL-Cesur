package JAVA_APUNTES.Biblioteca_JoseTornero_EnriqueBenito;

public class Revista extends Publicacion {

    //Atributos
    private String ISSN;
    private int edicion;

    // Constructor
    public Revista(String titulo, Autoria[] autorias, int ejemplares, String ISSN, int edicion) {
        super(titulo, autorias, ejemplares);
        this.ISSN = ISSN;
        this.edicion = edicion;
    }

    // Getters y Setters
    public String getISSN() {
        return ISSN;
    }


    //Metodo toString

    @Override
    public String toString() {
        return super.toString() + "Revista{" +
                "ISSN='" + ISSN + '\'' +
                ", edicion=" + edicion +
                '}';
    }
}

