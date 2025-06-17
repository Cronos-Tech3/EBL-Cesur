/*package ra6.practicaBiblio;

import java.util.Arrays;

public class revista extends Publicacion{

    public int ISSN;

    public int Edicion;

    public revista(String titulo, Autoria[] autoria, int ejemplares, int prestados, int ISSN, int edicion) {
        super(titulo, autoria, ejemplares, prestados);
        this.ISSN = ISSN;
        Edicion = edicion;
    }

    @Override
    public String toString() {
        return "revista{" +
                "ISSN=" + ISSN +
                ", Edicion=" + Edicion +
                ", Titulo='" + Titulo + '\'' +
                ", autoria=" + Arrays.toString(autoria) +
                ", Ejemplares=" + Ejemplares +
                ", Prestados=" + Prestados +
                '}';
    }

    public Object getIssn() {
        return ISSN;
    }  /**aunque todo sea public hemos tenido que usar get en revista, libro y autoria
        para que funcionase el menu
        */
 /*
}

*/
