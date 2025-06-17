/*package ra6.practicaBiblio;

import java.util.ArrayList;
import java.util.Arrays;

public class Publicacion {

    public String Titulo;

    public Autoria[] autoria = new Autoria [5];

    public int Ejemplares;

    public int Prestados;

    public int Prestar(int posicion){
        if (Ejemplares-Prestados>0){
            Prestados++;
            return (Ejemplares-Prestados);
        }return -1;
    }



    public int Devolver(){
        if (Prestados>0){
            Prestados--;
            return (Ejemplares-Prestados);
        }return -1;
    }

    public Publicacion(String titulo, Autoria[] autoria, int ejemplares, int prestados) {
        Titulo = titulo;
        this.autoria = autoria;
        Ejemplares = ejemplares;
        Prestados = prestados;
    }



    @Override
    public String toString() {
        return "Publicacion{" +
                "Titulo='" + Titulo + '\'' +
                ", autoria=" + Arrays.toString(autoria) +
                ", Ejemplares=" + Ejemplares +
                ", Prestados=" + Prestados +
                '}';
    }
}

 */

