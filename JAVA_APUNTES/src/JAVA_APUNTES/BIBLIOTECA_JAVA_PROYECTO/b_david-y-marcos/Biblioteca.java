/*package ra6.practicaBiblio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/***
 * @Author David López Acosta
 * @Author Marcos López Salgado
 */

/*

public class Biblioteca {

    //inicializamos las listas para poder usarlas
    public static ArrayList<Autoria> autores;
    public static ArrayList<libro> libros;
    public static ArrayList<revista> revistas;

    public static Iterator<Publicacion> mostrar(){  //iterador por tipo de publicacion
        Scanner sc = new Scanner(System.in);
        ArrayList<Publicacion> p = new ArrayList<>();
        String opcion = sc.nextLine();
        if (opcion.equals(libros)){
            p.addAll(libros);
        }else if(opcion.equals(revistas)){
            p.addAll(revistas);
        }

        return p.iterator();
    }
    public static Iterator<Autoria> mostrarAutores(){
        return autores.iterator();
    }
    //escaners pàra crear entradas de datos
    static Scanner scn = new Scanner(System.in);
    static Scanner scl = new Scanner(System.in);




    public static void main(String[] args) {

        int num = 0;
        while (num>=0 && num<=10){ //menu que se mostrara al usuario
            System.out.println("1. Crear autor/a \n" +
                    "2. Ver autoras/es \n" +
                    "3. Crea el libro \n" +
                    "4. Mostras libros\n" +
                    "5. Presta el libro\n" +
                    "6. Devuelve el libro\n" +
                    "7. Crea la revista\n" +
                    "8. Mostras revistas\n" +
                    "9. Presta una revista\n" +
                    "10. Devuelve una revista\n" +
                    "0. Salir"
            );

           switch (num) { // switch que recoge las opciones del menu
               case 0:
                   System.out.println("Saliendo...");
                   break;
               case 1:
                   crearAutor();
                   break;
               case 2:
                   verAutores();
                   break;
               case 3:
                   crearLibro();
                   break;
               case 4:
                   mostrarLibros();
                   break;
               case 5:
                   prestarLibro();
                   break;
               case 6:
                   devolverLibro();
                   break;
               case 7:
                   crearRevista();
                   break;
               case 8:
                   mostrarRevistas();
                   break;
               case 9:
                   prestarRevista();
                   break;
               case 10:
                   devolverRevista();
                   break;
               default:
                   System.out.println("Error...Introduce una opción válida");

           }


        }


    }

    //las funciones de crear con mas complejas y necesitan try-catch para evitar caracteres erroneos
    public static boolean crearAutor(){
        try {
            System.out.println("Introduce el ID");
            int id = scn.nextInt();

            Iterator<Autoria> aut = mostrarAutores();
            while (aut.hasNext()){
                if (aut.next().getId() == id){
                    System.out.println("El ID ya está en uso");
                    return false;
                }
            }

            System.out.println("Introduce el nombre del autor");
            String nombre = scl.nextLine();

            System.out.println("Introduce los apellidos del autor");
            String apellidos = scl.nextLine();

            Autoria a1 = new Autoria(id, nombre, apellidos);
            autores.add(a1);
            return true;

        } catch (InputMismatchException e) {
            scn.nextLine(); //para vaciar el buffer
            return false;
        }
    }

    public static void verAutores() {
        if (Autoria.isEmpty()) {
            System.out.println("No se ha encontrado autoría");
            return;
        }

        for (Autoria autor : autores) {
            System.out.println(autor);
        }
    }
    //estas se usan en todo lo que no es crear
    public static int cuentaLibros = 0;
    public static int prestados = 0;
    public static int cuentaRevista = 0;
    public static int prestada = 0;

    public static boolean crearLibro(){
        try{
            System.out.println("Introduce el ISBN");
            String isbn = scl.nextLine();
            ListIterator <libro> it = libros.listIterator();
            while (it.hasNext()){
                if (it.next().getIsbn().equals(isbn)){
                    System.out.println("Ese ISBN ya está en la lista");
                    return false;
                }
            }
            System.out.println("Introduce el título del libro");
            String nombre = scl.nextLine();


            System.out.println("Introduce el número de ejemplares");
            int ejemplares = scn.nextInt();
            if (ejemplares<0) throw new Exception();
            int nAutores;

            while (true) {
                System.out.println("Introduce el número de autores (de 1 a 5)");
                nAutores = scn.nextInt();
                if (nAutores>0 && nAutores <= 5){
                    break;
                }
            }

            Autoria [] autLibro = new Autoria[nAutores];

            for (int i = 0; i < nAutores; i++) {

                System.out.println("Introduce el ID del autor");
                int id = scn.nextInt();

                Iterator<Autoria> aut = mostrarAutores();
                boolean encontrar = false;
                while (aut.hasNext()){
                    if (aut.next().getId() == id){
                        encontrar = true;
                        autLibro[i] = aut.next();
                        break;
                    }
                }

                if (!encontrar){
                    System.out.println("Error...El autor no ha sido encontrado");
                    return false;
                }
            }

            //crear el libro con ejemplo de datos
            libro lib = new libro(nombre, autLibro, ejemplares, 0, 435345345, "fantasia", "literup" );
            libros.add(lib);
            return true;

            //catch de caracteres erroneos
        } catch (InputMismatchException e) {
            scn.nextLine();
            return false;
        } catch (Exception e){
            return false;
        }
    }

        //mas funciones de libros

    public static void mostrarLibros (){
        for (libro lib : libros) {
            System.out.println(lib);
        }
    }


    public static int prestarLibro(){
        if (cuentaLibros-prestados>0){
            prestados++;
            return (cuentaLibros-prestados);
        }return -1;
    }

    public static int devolverLibro(){
        if (prestados>0){
            prestados--;
            return (cuentaLibros-prestados);
        }return -1;
    }

    //repetimos crear libro pero con revistas
    public static boolean crearRevista(){
        try{
            System.out.println("Introduce el ISSN");
            String issn = scl.nextLine();
            ListIterator <revista> it = revistas.listIterator();
            while (it.hasNext()){
                if (it.next().getIssn().equals(issn)){
                    System.out.println("Ese ISSN ya está en lista");
                    return false;
                }
            }
            System.out.println("Introduce el nombre de la revista");
            String nombre = scl.nextLine();

            System.out.println("Introduce el número de ejemplares");
            int ejemplares = scn.nextInt();
            if (ejemplares<0) throw new Exception();
            int nAutores;

            while (true) {
                System.out.println("Introduce el número de autores (de 1 a 5))");
                nAutores = scn.nextInt();
                if (nAutores>0 && nAutores <= 5){
                    break;
                }
            }
            Autoria [] autRevis = new Autoria[nAutores];
            for (int i = 0; i < nAutores; i++) {

                System.out.println("Introduce el ID del autor");
                int id = scn.nextInt();

                Iterator<Autoria> aut = mostrarAutores();
                boolean encontrado = false;
                while (aut.hasNext()){
                    if (aut.next().getId() == id){
                        encontrado = true;
                        autRevis[i] = aut.next();
                        break;
                    }
                }
                if (!encontrado){
                    System.out.println("Error...El autor no ha sido encontrado");
                    return false;
                }
            }
            //crear revista con ejemplo de datos
            revista rev = new revista(nombre, autRevis, ejemplares, 0, 807345, 3);
            revistas.add(rev);
            return true;

        } catch (InputMismatchException e) {
            scn.nextLine();
            return false;
        } catch (Exception e){
            return false;
        }
    }
        //mas funciones de revistas
    public static void mostrarRevistas (){
        for (libro lib : libros) {
            System.out.println(lib);
        }
    }


    public static int prestarRevista (){
        if (cuentaRevista-prestada>0){
            prestada++;
            return (cuentaRevista-prestada);
        }return -1;
    }

    public static int devolverRevista(){
        if (prestada>0){
            prestada--;
            return (cuentaRevista-prestada);
        }return -1;
    }

}
*/