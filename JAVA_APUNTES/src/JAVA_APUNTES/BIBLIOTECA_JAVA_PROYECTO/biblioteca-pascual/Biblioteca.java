/*package bibliotecaPascualQuiles;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**@author Pascual Quiles
 * */

/*

public class Biblioteca {

    //Scanner para letras y para números
    static Scanner scL = new Scanner(System.in);
    static Scanner scN = new Scanner(System.in);

    //inicializamos las listas para poder usarlas
  public static   ArrayList<Autoria> autores = new ArrayList<>();
  public static   ArrayList<Libro> libros = new ArrayList<>();
  public static   ArrayList<Revista> revistas = new ArrayList<>();

/*al final no he encontrado ningún uso para este métod0, pues lo que necesitaba era recorrer las listas de
las clases hijas con sus atributos específicos*/

/*
  public static ListIterator<Publicacion> mostrarPublicacion(String opcion){

      Pattern patron = Pattern.compile("^[a-zA-Z]{5,7}$");
      Matcher matcher = patron.matcher(opcion);

      if (matcher.find()) {
          ArrayList<Publicacion> al= new ArrayList<>();
          if (opcion.equalsIgnoreCase("revista")) {
              al.addAll(revistas);
                return al.listIterator();

          } else if (opcion.equalsIgnoreCase("libro")) {
              al.addAll(libros);
              return al.listIterator();

          }
      }
      return null;
  }

  //He usado un listIterator en vez de un iterador normal por si me proporcionaba más funcionalidades, aunque al final solo he usado el previous en un lugar
    public static ListIterator<Autoria> mostrarAutor(){
            return autores.listIterator();
        }


        //función boolean para recibir si se ha realizado la operación o no
  public static boolean crearAutor(){
      //try-catch por si se hace un input numérico incorrecto
      try {
          System.out.println("Introduzca el id del autor");
          int id = scN.nextInt();

          //recorremos todos los autores registrados para ver si coincide el id
          ListIterator<Autoria> aut = mostrarAutor();
          while (aut.hasNext()){
              if (aut.next().getId() == id){
                  System.out.println("El id ya está en uso");
                  return false;
              }
          }

          System.out.println("Introduzca el nombre del autor");
          String nombre = scL.nextLine();

          System.out.println("Introduzca los apellidos del autor");
          String apellidos = scL.nextLine();

          //se crea el autor y se añade a la lista
          Autoria a1 = new Autoria(id, nombre, apellidos);
          autores.add(a1);
          return true;

      } catch (InputMismatchException e) {
          //se vacía el buffer y se devuelve false
          scN.nextLine();
            return false;
      }
  }

  //función que recibe un listiterator genérico y lo recorre mostrándolo
  public static void ensenarIterador(ListIterator it){
      while (it.hasNext()){
          System.out.println(it.next());
      }
  }

  //en su mayoría igual que crear autor
  public static boolean crearLibro(){
      try{
          System.out.println("Introduzca el ISBN");
          String isbn = scL.nextLine();
          ListIterator <Libro> it = libros.listIterator();
          while (it.hasNext()){
              if (it.next().getIsbn().equals(isbn)){
                  System.out.println("El ISBN ya se encuentra registrado");
                  return false;
              }
          }
          System.out.println("Introduzca el nombre del libro");
          String nombre = scL.nextLine();

          //el número ha de ser 0 o mayor, en caso contrario salta excepción y se devolverá false
          System.out.println("Introduzca el número de ejemplares");
          int ejemplares = scN.nextInt();
          if (ejemplares<0) throw new Exception();
          int nAutores;

          //aseguramos que el número de autores sea válido
          while (true) {
              System.out.println("Introduzca el número de autores que tiene el libro entre 1 y 5");
               nAutores = scN.nextInt();
              if (nAutores>0 && nAutores <= 5){
                  break;
              }
          }
          //array de autores para el libro
          Autoria [] autLibro = new Autoria[nAutores];

          //se intentan añadir cada uno de los autores
          for (int i = 0; i < nAutores; i++) {

              System.out.println("Introduzca el id del autor");
              int id = scN.nextInt();

              ListIterator<Autoria> aut = mostrarAutor();
              boolean encontrado = false;
              while (aut.hasNext()){
                  if (aut.next().getId() == id){
                      encontrado = true;
                      aut.previous();
                      autLibro[i] = aut.next();
                      break;
                  }
              }
              //si no se encuentra el id del autor se devuelve false
              if (!encontrado){
                  System.out.println("El autor no ha sido encontrado o no existe");
                  return false;
              }
          }

          //si tod0 es exitoso se crea, añade a la lista y devuelve true
          Libro l1 = new Libro(nombre, autLibro, ejemplares, 0, isbn);
          libros.add(l1);
          return true;

          //en caso de excepción devuelve false, si es inputMismatch vacía el buffer
      } catch (InputMismatchException e) {
          scN.nextLine();
          return false;
      } catch (Exception e){
          return false;
      }
  }

  //devuelve t/f según se haya podido realizar la operación
  public static boolean prestarLibro(){

      System.out.println("Introduzca el ISBN");
      String isbn = scL.nextLine();
      ListIterator <Libro> it = libros.listIterator();
      while (it.hasNext()){
          Libro lib = it.next();
          if (lib.getIsbn().equals(isbn)){
              //si se encuentra el isbn se intenta realizar el préstamo
              int n = lib.prestar();
              //según el valor retornado se habrá podido prestar
              if (n!=-1){
                  System.out.println("El libro se prestó correctamente");
                  System.out.println("Ejemplares restantes: " + n);
                  return true;
              }
              System.out.println("No quedan ejemplares para prestar");
              return false;
          }
      }
      System.out.println("No se encontró el ISBN");
      return false;
  }

    //misma función que prestar solo que empleando el métod0 devolver de publicación
    public static boolean devolverLibro() {
        System.out.println("Introduzca el ISBN");
        String isbn = scL.nextLine();
        ListIterator<Libro> it = libros.listIterator();
        while (it.hasNext()) {
            Libro lib = it.next();
            if (lib.getIsbn().equals(isbn)) {
                int n = lib.devolver();
                if (n != -1) {
                    System.out.println("El libro se devolvió correctamente");
                    System.out.println("Ejemplares restantes: " + n);
                    return true;
                }
                System.out.println("No existen ejemplares en préstamo");
                return false;
            }
        }
        System.out.println("No se encontró el ISBN");
        return false;
    }


    //las funciones propias de revista son iguales que las de libro pero con los atributos propios
    public static boolean crearRevista(){
        try{
            System.out.println("Introduzca el ISSN");
            String issn = scL.nextLine();
            ListIterator <Revista> it = revistas.listIterator();
            while (it.hasNext()){
                if (it.next().getIssn().equals(issn)){
                    System.out.println("El ISSN ya se encuentra registrado");
                    return false;
                }
            }
            System.out.println("Introduzca el nombre de la revitsa");
            String nombre = scL.nextLine();

            System.out.println("Introduzca el número de ejemplares");
            int ejemplares = scN.nextInt();
            if (ejemplares<0) throw new Exception();
            int nAutores;

            while (true) {
                System.out.println("Introduzca el número de autores que tiene la revista entre 1 y 5");
                nAutores = scN.nextInt();
                if (nAutores>0 && nAutores <= 5){
                    break;
                }
            }
            Autoria [] autRevis = new Autoria[nAutores];
            for (int i = 0; i < nAutores; i++) {

                System.out.println("Introduzca el id del autor");
                int id = scN.nextInt();

                ListIterator<Autoria> aut = mostrarAutor();
                boolean encontrado = false;
                while (aut.hasNext()){
                    if (aut.next().getId() == id){
                        encontrado = true;
                        aut.previous();
                        autRevis[i] = aut.next();
                        break;
                    }
                }
                if (!encontrado){
                    System.out.println("El autor no ha sido encontrado o no existe");
                    return false;
                }
            }

            Revista r1 = new Revista(nombre, autRevis, ejemplares, 0, issn);
            revistas.add(r1);
            return true;

        } catch (InputMismatchException e) {
            scN.nextLine();
            return false;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean prestarRevista(){
        System.out.println("Introduzca el ISSN");
        String issn = scL.nextLine();
        ListIterator <Revista> it = revistas.listIterator();
        while (it.hasNext()){
            Revista rev = it.next();
            if (rev.getIssn().equals(issn)){
                int n = rev.prestar();
                if (n!=-1){
                    System.out.println("La revista se prestó correctamente");
                    System.out.println("Ejemplares restantes: " + n);
                    return true;
                }
                System.out.println("No quedan ejemplares para prestar");
                return false;
            }
        }
        System.out.println("No se encontró el ISSN");
        return false;
    }

    public static boolean devolverRevista() {
        System.out.println("Introduzca el ISSN");
        String issn = scL.nextLine();
        ListIterator<Revista> it = revistas.listIterator();
        while (it.hasNext()) {
            Revista rev = it.next();
            if (rev.getIssn().equals(issn)) {
                int n = rev.devolver();
                if (n != -1) {
                    System.out.println("La revista se devolvió correctamente");
                    System.out.println("Ejemplares restantes: " + n);
                    return true;
                }
                System.out.println("No existen ejemplares en préstamo");
                return false;
            }
        }
        System.out.println("No se encontró el ISBN");
        return false;
    }




    public static void main(String[] args) {



      //hasta que el usuario elija salir se repite el programa
        int inputUser = -1;
        while (inputUser != 0) {

            System.out.println("1. Crear autor/a\n" +
                    "2. Ver autoras/es\n" +
                    "3. Crear libro\n" +
                    "4. Mostrar libros\n" +
                    "5. Prestar un libro\n" +
                    "6. Devolver un libro\n" +
                    "7. Crear una revista\n" +
                    "8. Mostrar revistas\n" +
                    "9. Prestar una revista\n" +
                    "10. Devolver una revista\n" +
                    "0. Salir");

            //aseguramos que el input del usuario es válido
            while (true) {
                try {
                    inputUser = scN.nextInt();
                    if (inputUser >= 0 && inputUser < 11) break;
                } catch (InputMismatchException e1) {
                    scN.nextLine();
                }
                System.out.println("Input inválido");
            }

            //switch con cada una de las opciones
            switch (inputUser){
                case 1:
                    //como la funcion devuelve un valor boolean comprobamos si la operación se realiza con éxito
                    if (crearAutor()) System.out.println("Se añadieron los datos");
                    else System.out.println("Ocurrió un problema con los datos");
                    break;
                case 2:
                    ensenarIterador(mostrarAutor());
                    break;
                case 3:
                    //como la funcion devuelve un valor boolean comprobamos si la operación se realiza con éxito
                    if (crearLibro()) System.out.println("El libro se añadió correctamente");
                    else System.out.println("No se pudo añadir el libro");
                    break;
                case 4:
                    ensenarIterador(libros.listIterator());
                    break;
                case 5:
                    //como la funcion devuelve un valor boolean comprobamos si la operación se realiza con éxito
                    if (prestarLibro()) System.out.println("Operación realizada con éxito");
                    else System.out.println("No se pudo realizar la operación");
                    break;
                case 6:
                    //como la funcion devuelve un valor boolean comprobamos si la operación se realiza con éxito
                    if (devolverLibro()) System.out.println("Operación realizada con éxito");
                    else System.out.println("No se pudo realizar la operación");
                    break;
                case 7:
                    //como la funcion devuelve un valor boolean comprobamos si la operación se realiza con éxito
                    if (crearRevista()) System.out.println("La revista se añadió correctamente");
                    else System.out.println("No se pudo añadir la revista");
                    break;
                case 8:
                    ensenarIterador(revistas.listIterator());
                    break;
                case 9:
                    //como la funcion devuelve un valor boolean comprobamos si la operación se realiza con éxito
                    if (prestarRevista()) System.out.println("Operación realizada con éxito");
                    else System.out.println("No se pudo realizar la operación");
                    break;
                case 10:
                    //como la funcion devuelve un valor boolean comprobamos si la operación se realiza con éxito
                    if (devolverRevista()) System.out.println("Operación realizada con éxito");
                    else System.out.println("No se pudo realizar la operación");
                    break;

            }


        }
    }



}
*/
