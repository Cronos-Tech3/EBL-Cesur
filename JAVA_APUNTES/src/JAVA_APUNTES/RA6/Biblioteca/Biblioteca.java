package JAVA_APUNTES.RA6.Biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Biblioteca {
    ArrayList<Libros> libros;

    public Biblioteca() {
        this.libros= new ArrayList<>();
    }





    public void agregarLibro(Libros libro){
       libros.add(libro);

    }
/*
    public ListIterator<Libros> buscarLibrosPorAutor(String autor){
        ArrayList<Libros> copia = new ArrayList<>(libros);
        ListIterator<Libros>
    }

    public String buscarLibrosPorAutor (String autor) {

        return autor;
    }



 */


}
