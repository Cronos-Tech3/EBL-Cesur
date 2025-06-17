package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.biblioteca.biblioteca_paloma;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Biblioteca {
    ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro){

        libros.add(libro);
    }

    public ListIterator<Libro> buscarLibrosPorAutor(String autor){
        //copiar el contenido de mi arraylist de libros
        ArrayList<Libro> copia = new ArrayList<>(libros);
        //obtengo el iterador de la copia
        ListIterator<Libro> lista = copia.listIterator();

        //recorro el iterador, si tiene siguiente valor entro
        while(lista.hasNext()){
            //obtengo el valor de libro
            Libro l = lista.next(); //libro1, libro2, libro3
            //si no es igual el autor del libro al autor que le paso por parametro
            if(!l.getAutor().equals(autor)){
                //lo borrro
                lista.remove();
            }
        }

        //he llegado al final del iterador, tengo que recorrerlo al revés
        //para que esté en su primera posición
        //si tiene anterior
        while(lista.hasPrevious()){
            //me posiciono en el anterior
            lista.previous();
        }

        return lista;
    }

    public ListIterator<Libro> buscarLibrosPorAutor2(String autor){
        //hago una copia del arraylist de libros
        ArrayList<Libro> copia = new ArrayList<>(libros);

        //recorro la copia
        for (int i = 0; i < copia.size(); i++) {
            //si no es igual el autor al autor del libro
            if(!copia.get(i).getAutor().equals(autor)){
                //lo quito de la copia
                copia.remove(i);
            }
        }
        //saco el iterador de la copia
        ListIterator<Libro> lista = copia.listIterator();

        return lista;
    }

    public ListIterator<Libro> buscarLibrosPorAutor3(String autor){
        //hago un arraylist vacío
        ArrayList<Libro> copia = new ArrayList<>();

        //recorro el arraylist de libros
        for (int i = 0; i < libros.size(); i++) {
            //si el autor del libro es igual a mi autor
            if(libros.get(i).getAutor().equals(autor)){
                //lo añado a la copia
                copia.add(libros.get(i));
            }
        }

        //obtengo el iterator de la copia
        ListIterator<Libro> lista = copia.listIterator();

        return lista;
    }

    public Iterator<Libro> listarLibros(){
        return libros.iterator();
    }
}
