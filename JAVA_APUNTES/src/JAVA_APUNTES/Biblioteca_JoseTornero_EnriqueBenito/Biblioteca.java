package JAVA_APUNTES.Biblioteca_JoseTornero_EnriqueBenito;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author JuanJoseTornero
 * @author EnriqueBenito
 *
 */

public class Biblioteca {

    //creamos e instanciamos los 3 atributos principales de biblioteca

    private static ArrayList<Autoria> autorias = new ArrayList<>();
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Revista> revistas = new ArrayList<>();

    // Iniciamos el main donde se va a ejecutar el código
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        //menu do-while
        do {
            System.out.println("1. Crear autor/a");
            System.out.println("2. Ver autoras/es");
            System.out.println("3. Crear libro");
            System.out.println("4. Mostrar libros");
            System.out.println("5. Prestar un libro");
            System.out.println("6. Devolver un libro");
            System.out.println("7. Crear revista");
            System.out.println("8. Mostrar revistas");
            System.out.println("9. Prestar una revista");
            System.out.println("10. Devolver una revista");
            System.out.println("11. Mostrar Catalogo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            //Aqui hacemos un while(true) al try-catch para mantenernos en esa excepción hasta que se ingresen bien los datos
            while(true){
                try{
                    opcion = scanner.nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Ingrese en numeros enteros las opciones del Menu.");
                    scanner.nextLine();  //Aqui vaciamos el buffer y nos volvera a pedir la opcion a meter
                }
            }

            //switch de las opciones del menu principal
            switch (opcion) {
                case 1:
                    crearAutor(scanner);
                    break;
                case 2:
                    mostrarAutores();
                    break;
                case 3:
                    crearLibro(scanner);
                    break;
                case 4:
                    mostrarLibros();
                    break;
                case 5:
                    prestarLibro(scanner);
                    break;
                case 6:
                    devolverLibro(scanner);
                    break;
                case 7:
                    crearRevista(scanner);
                    break;
                case 8:
                    mostrarRevistas();
                    break;
                case 9:
                    prestarRevista(scanner);
                    break;
                case 10:
                    devolverRevista(scanner);
                    break;
                case 0:
                    System.out.println("¡Saliendo del Programa!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // Funcion Mostrar Catalogo con Pattern como pide en el enunciado de la tarea
    // Hemos intentado dar utilidad a esta función pero no lo hemos conseguido

    public static void mostrarCatalogo (Scanner scanner) {
        String catalogo;

        //Menu del Catalogo
        System.out.println("Ingrese por teclado una de las siguientes opciones: ");
        System.out.println("autor");
        System.out.println("libro");
        System.out.println("revista");

        catalogo = scanner.nextLine();

        if (!Pattern.matches("[a-zA-Z]{5,7}", catalogo)) {
            System.out.println("Opción no válida.");
            return;
        }

        //switch del catalogo
        switch (catalogo) {
            case "autor":
                for (Autoria autor : autorias) {
                    System.out.println(autor);
                }
                break;
            case "libro":
                for (Libro libro : libros) {
                    System.out.println(libro);
                }
                break;
            case "revista":
                for (Revista revista : revistas) {
                    System.out.println(revista);
                }
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }

    // Metodo crear Autor
    private static void crearAutor(Scanner scanner) {
        try {

            //Pedimos los datos al usuario
            System.out.print("Introduce el ID del autor/a: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer Necesario para que despues de capturar la excepcion no pida el resto de datos de golpe
            System.out.print("Introduce el nombre del autor/a: ");
            String nombre = scanner.nextLine();
            System.out.print("Introduce los apellidos del autor/a: ");
            String apellidos = scanner.nextLine();

            // Verificar que no se repita el ID con un for each
            for (Autoria autor : autorias) {
                if (autor.getId() == id) {
                    System.out.println("El ID ya existe. No se puede crear el autor/a.");
                    return;
                }
            }
            //Aqui se añade el autor con los datos establecidos al arrayList
            Autoria nuevoAutor = new Autoria(id, nombre, apellidos);
            autorias.add(nuevoAutor);
            System.out.println("Autor/a creado/a exitosamente.");

            // en el catch capturamos la excepción, si el usuario inserta una letra en vez de un numero
        } catch (InputMismatchException e) {
            System.out.println("Introduce el ID del autor/a: En numeros enteros");
            System.out.println("Vuelva a seleccionar la opcion del menu.");
            scanner.nextLine();
        }
    }

    // metodo mostrar Autores
    private static void mostrarAutores() {
        for (Autoria autor : autorias) {  //Se recorre el arrayList con un for each
            System.out.println(autor);
        }
    }

    //metodo para crear libros
    private static void crearLibro(Scanner scanner) {

        try{
            System.out.print("Introduce el ISBN del libro: ");
            String ISBN = scanner.next();

            // Verificar que no se repita el ISBN con un for each que recorre el arrayList
            for (Libro libro : libros) {
                if (libro.getISBN().equals(ISBN)) {
                    System.out.println("El ISBN ya existe. No se puede crear el libro.");
                    return;
                }
            }

            scanner.nextLine(); // Vacia buffer
            System.out.print("Introduce el título del libro: ");
            String titulo = scanner.nextLine();
            System.out.print("Introduce el número de ejemplares: ");
            int ejemplares = scanner.nextInt();
            System.out.print("Introduce el género del libro: ");
            scanner.nextLine(); // vacia el buffer
            String genero = scanner.nextLine();
            System.out.print("Introduce la editorial del libro: ");
            String editorial = scanner.nextLine();
            System.out.print("Introduce el número de autoras/es que tiene el libro: ");
            int numAutores = scanner.nextInt();

            //Aqui estamos creando un Array de autoria, dandole la longitud de numAutores introducidos por el usuario
            Autoria[] autoriasLibro = new Autoria[numAutores];

            //for i para recorrer el array de Autoria y que no se repita el id de autor, al añadir uno nuevo
            for (int i = 0; i < numAutores; i++) {
                System.out.print("Introduce el ID del autor/a " + (i + 1) + ": ");
                int idAutor = scanner.nextInt();
                Autoria autor = buscarAutor(idAutor);
                if (autor == null) {
                    System.out.println("El ID del autor/a no existe. No se puede crear el libro.");
                    return;
                }
                autoriasLibro[i] = autor;
            }

            //Aqui se añaden los datos al arraList de Libros si todos los datos son correctos
            Libro nuevoLibro = new Libro(titulo, autoriasLibro, ejemplares, ISBN, genero, editorial);
            libros.add(nuevoLibro);
            System.out.println("Libro creado exitosamente.");

        } catch (InputMismatchException e){
            System.out.println("El numAutores, ejemplares e Id del autor en numeros enteros ");
            System.out.println("Vuelva a seleccionar la opcion del menu.");
            scanner.nextLine();
        }

    }

    //Metodo buscar Autor, que sirve para  localizar los id de autores
    private static Autoria buscarAutor(int idAutor) {
        for (Autoria autoria : autorias) {
            if (autoria.getId() == idAutor) {
                return autoria;
            }
        }
        return null;
    }

    //Funcion que sirve para mostrar los libros registrados en el arrayList
    private static void mostrarLibros() {
        for (Libro libro : libros) {   //for each
            System.out.println(libro);
        }
    }

    //Funcion prestar Libro
    private static void prestarLibro(Scanner scanner) {
        System.out.print("Introduce el ISBN del libro a prestar: ");
        String ISBN = scanner.next();
        Libro libro = buscarLibro(ISBN);

        if (libro != null) {
            int ejemplaresDisponibles = libro.prestar();
            if (ejemplaresDisponibles != -1) {
                System.out.println("Libro prestado. Ejemplares disponibles: " + ejemplaresDisponibles);
            } else {
                System.out.println("No quedan ejemplares disponibles para prestar.");
            }
        } else {
            System.out.println("El ISBN no existe.");
        }
    }

    //Funcion buscar Libro
    private static Libro buscarLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    //Funcion devolver Libro
    private static void devolverLibro(Scanner scanner) {
        System.out.print("Introduce el ISBN del libro a devolver: ");
        String ISBN = scanner.next();
        Libro libro = buscarLibro(ISBN);

        if (libro != null) {
            int ejemplaresDisponibles = libro.devolver();
            if (ejemplaresDisponibles != -1) {
                System.out.println("Libro devuelto. Ejemplares disponibles: " + ejemplaresDisponibles);
            } else {
                System.out.println("No había ejemplares prestados para devolver.");
            }
        } else {
            System.out.println("El ISBN no existe.");
        }
    }

    //Funcion crear Revista
    private static void crearRevista(Scanner scanner) {

        try {
            System.out.print("Introduce el ISSN de la revista: ");
            String ISSN = scanner.next();

            // Verificar que no se repita el ISSN
            for (Revista revista : revistas) {
                if (revista.getISSN().equals(ISSN)) {
                    System.out.println("El ISSN ya existe. No se puede crear la revista.");
                    return;
                }
            }

            scanner.nextLine(); // Vacia el buffer
            System.out.print("Introduce el título de la revista: ");
            String titulo = scanner.nextLine();
            System.out.print("Introduce el número de ejemplares: ");
            int ejemplares = scanner.nextInt();
            System.out.print("Introduce la edición de la revista: ");
            int edicion = scanner.nextInt();
            System.out.print("Introduce el número de autoras/es que tiene la revista: ");
            int numAutores = scanner.nextInt();

            //Array Autoria para añadir autores a la revista
            Autoria[] autoriasRevista = new Autoria[numAutores];

            //for i para introducir los autores, la longitud depende del numero introducido por el usuario
            for (int i = 0; i < numAutores; i++) {
                System.out.print("Introduce el ID del autor/a " + (i + 1) + ": ");
                int idAutor = scanner.nextInt();
                Autoria autor = buscarAutor(idAutor);
                if (autor == null) {
                    System.out.println("El ID del autor/a no existe. No se puede crear la revista.");
                    return;
                }
                autoriasRevista[i] = autor;
            }

            Revista nuevaRevista = new Revista(titulo, autoriasRevista, ejemplares, ISSN, edicion);
            revistas.add(nuevaRevista);
            System.out.println("Revista creada exitosamente.");

        } catch (InputMismatchException e) {
            System.out.println("Ingrese ejemplares, edicion, numAutores e IdAutores con numeros enteros ");
            System.out.println("Vuelva a seleccionar la opcion del menu.");
            scanner.nextLine();
        }

    }

    //Funcion mostrar revista, que nos muestra las revistas que tenemos introducidas en nuestro arrayList
    private static void mostrarRevistas() {
        for (Revista revista : revistas) {
            System.out.println(revista);
        }
    }

    //Funcion prestar Revista
    private static void prestarRevista(Scanner scanner) {
        System.out.print("Introduce el ISSN de la revista a prestar: ");
        String ISSN = scanner.next();
        Revista revista = buscarRevista(ISSN);

        if (revista != null) {
            int ejemplaresDisponibles = revista.prestar();
            if (ejemplaresDisponibles != -1) {
                System.out.println("Revista prestada. Ejemplares disponibles: " + ejemplaresDisponibles);
            } else {
                System.out.println("No quedan ejemplares disponibles para prestar.");
            }
        } else {
            System.out.println("El ISSN no existe.");
        }
    }

    //Funcion buscar Revista
    private static Revista buscarRevista(String issn) {
        for (Revista revista : revistas) {
            if (revista.getISSN().equals(issn)) {
                return revista;
            }
        }
        return null;
    }

    //Funcion devolver Revista
    private static void devolverRevista(Scanner scanner) {
        System.out.print("Introduce el ISSN de la revista a devolver: ");
        String ISSN = scanner.next();
        Revista revista = buscarRevista(ISSN);

        if (revista != null) {
            int ejemplaresDisponibles = revista.devolver();
            if (ejemplaresDisponibles != -1) {
                System.out.println("Revista devuelta. Ejemplares disponibles: " + ejemplaresDisponibles);
            } else {
                System.out.println("No había ejemplares prestados para devolver.");
            }
        } else {
            System.out.println("El ISSN no existe.");
        }
    }
}

