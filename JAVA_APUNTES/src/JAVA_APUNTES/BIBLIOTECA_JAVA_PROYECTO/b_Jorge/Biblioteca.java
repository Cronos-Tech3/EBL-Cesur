package JAVA_APUNTES.BIBLIOTECA_JAVA_PROYECTO.b_Jorge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Biblioteca {

    public String nombre;
    public ArrayList<Libro> libros;

    public Biblioteca(String nombre, ArrayList<Libro> libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    Scanner sc = new Scanner(System.in);

    public void agregarLibro(String titulo,String autor,double precio,boolean disponible){

        while (true) {

            if (Libro.validarTitulo(titulo)) {
                Libro libro = new Libro(titulo, autor, disponible, precio);
                libros.add(libro);
                System.out.println("Libro agregado correctamente");
                break;
            } else {
                System.out.println("Titulo inválido,por favor no utilice caracteres especiales y que sea de 3 a 20 caracteres");
                titulo = sc.nextLine();
            }
        }

    }

    public void mostrarLibros(){
        Iterator<Libro> it = libros.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    public void calcularDescuentoGlobal(String tipoCliente) {
        Iterator<Libro> it = libros.iterator();

        while (it.hasNext()) {
            Libro libro = it.next(); // Obtenemos el libro
            double precioFinal = libro.descuentoEspecial(tipoCliente); // Calculamos el descuento
            System.out.println(libro); // Mostramos la información del libro
            System.out.println("Precio final con descuento: " + precioFinal); // Mostramos el precio con descuento
        }
    }






}
