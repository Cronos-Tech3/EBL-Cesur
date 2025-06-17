package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.biblioteca.biblioteca_paloma;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //creo una instancia de biblioteca
        Biblioteca b1 = new Biblioteca();
        //creo 5 libros
        Libro l1 = new Libro("Titulo1","Autor1","2004");
        Libro l2 = new Libro("Titulo2","Autor1","2005");
        Libro l3 = new Libro("Titulo3","Autor1","2006");
        Libro l4 = new Libro("Titulo4","Autor1","2007");
        Libro l5 = new Libro("Titulo1","Autor2","2014");
        //añado los libros a la biblioteca
        b1.agregarLibro(l1);
        b1.agregarLibro(l2);
        b1.agregarLibro(l3);
        b1.agregarLibro(l4);
        b1.agregarLibro(l5);
        //meter 10 libros
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("dime titulo, autor y fecha de un libro");
            Libro l = new Libro(sc.nextLine(), sc.nextLine(), sc.nextLine());
            b1.agregarLibro(l);
        }
        //obtengo el iterador de la función listarLibros
        Iterator<Libro> it = b1.listarLibros();
        //recorro el iterador
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("*****************");
        ListIterator<Libro> lista = b1.buscarLibrosPorAutor("Autor1");
        while(lista.hasNext()){
            System.out.println(lista.next());
        }
    }
}
