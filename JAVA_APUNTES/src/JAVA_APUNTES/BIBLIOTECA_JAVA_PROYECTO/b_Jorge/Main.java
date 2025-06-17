package JAVA_APUNTES.BIBLIOTECA_JAVA_PROYECTO.b_Jorge;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static <integer> void main(String[] args) {

        //Array
        {
            //Declararlo

            String[] array = new String[5]; //5 objetos

            array[0] = "Patata"; //Rellenarlo
            array[1] = "Melón"; //Rellenarlo

            //Rellenar un array con un for
            int[] arrayBucle = new int[5];
            for (int i = 0; i <arrayBucle.length ; i++) {
                arrayBucle[i] = 5;

            }

            System.out.println(Arrays.toString(arrayBucle));

            //Rellenarlo desde el principio
            String[] holaMundo = {"Hola1","Hola2","Hola3"};


            //Acceder a su contenido
            for (String holas : holaMundo){
                System.out.println(holas);
            }


        }

        //Array Bidimensional
        {
            //Declararlo

            int[][] numeros = new int[10][10];

            String[][] numeros1 = {{"545443435","44324343243","4321234324"},{"4323443243","43432432324"}};

            //Recorrerlo
            for (int i = 0; i <numeros.length ; i++) {
                for (int j = 0; j <numeros[i].length ; j++) {

                    System.out.println( numeros[i][j] +"["+i+"]"+"["+j+"]");
                    //  System.out.println( "["+i+"]"+"["+j+"]");
                }

            }

        }

            // Funciones con la clase Array
            {
            //Arrays.binarySearch();
            {
                //Busca en un array un elemento que se pasa por parametro. Devuelve la posición dodne lo encuentra o -1 si no lo encuentra

                int[] numeros = {1,2,3,4,5};

                int resultado = Arrays.binarySearch(numeros,2);
                System.out.println(resultado); //1
                //IMPORTANTE = El array debe estar ordenado = {1,2,3,4,5}. Asi no {6,9,3,1}

            }

            //Arrays.copyOf();
            {
                //Cambia la longuitud del array
                int[] numeros = new int[8];

                int[] masNumeros = Arrays.copyOf(numeros, 20);
                System.out.println(numeros.length);
                System.out.println(masNumeros.length);


            }

            //Arrays.equals();
            {
                //Comprueba si 2 arrays son iguales

                int[] numeros = {1,3,4};
                int[] numeros2 = {1,3,4};
                System.out.println(Arrays.equals(numeros,numeros2 )); //true
            }

            //Arrays.fill();
            {
                //Rellena el array con el valor que se le pasa por parámetro
                int[] numeros = new int[3];
                Arrays.fill(numeros, 5); //fill = llenar
                System.out.println(Arrays.toString(numeros));

            }

            //Arrays.sort();
            {
                //Ordena lo que se pasa por parámetro
                int[] numeros = {4,10,3,6};
                Arrays.sort(numeros);
                System.out.println(Arrays.toString(numeros)); // [3,4,6,10]
            }




        }

            //ArrayList
            {
              //Declararla
              ArrayList<String> listaLibros = new ArrayList<>();

              //Añadir un elemento
                listaLibros.add("libro1");
                listaLibros.add("libro2");
                listaLibros.add("libro3");

                //Obtener un elemento
                 listaLibros.get(1);

                //Eliminar un libro
                 listaLibros.remove(2);

                //Eliminar todos los elementos
                 listaLibros.clear();

                //obtener el lenght
                 listaLibros.size();

                 //obtener el arraytoString()
                  listaLibros.toArray();

        }

            //LikedList
            {
            //Declararla
            LinkedList<String> listaLibros = new LinkedList<>();

            //Añadir un elemento
            listaLibros.add("libro1");
            listaLibros.add("libro2");
            listaLibros.add("libro3");

            //Añadir un elemento al principio
            listaLibros.addFirst("libro0");

            //Añadir un elemento al Final
            listaLibros.addLast("libroZ");

            //Añadir una coleccion (Añadir otra linkedlist)
            LinkedList<Integer> numeros1 = new LinkedList<Integer>();
            numeros1.add(1);
            numeros1.add(2);
            numeros1.add(3);
            numeros1.add(4);

            LinkedList<Integer> numeros2 = new LinkedList<Integer>();
            numeros2.add(5);
            numeros2.add(6);
            numeros2.add(7);
            numeros2.add(8);

           numeros1.addAll(numeros2); //Función
           System.out.println(numeros1); //Resultado

            //Obtener un elemento
            numeros1.get(2);

            //Obtener el primer/Último elemento
            numeros1.getFirst();
            numeros1.getLast();

            //Eliminar y obtener el último elemento
            numeros1.removeFirst();
            numeros1.removeLast();

            //Eliminar todos los elementos
           // numeros1.clear();

            //Obtener el lenght
            numeros1.size();

            //Obtener el arrayToString

            //Nota= para obtener el array to string, ademas de hacer el array.toString, se debe pasar a array con .toArray()
            System.out.println(Arrays.toString(numeros1.toArray()));
        }

            //Stack (LIFO)
            {
                //Declararlo
                Stack<String> Libros = new Stack<>();

                //Añadir
                Libros.push("Libro1");
                Libros.push("Libro2");
                Libros.push("Libro3");

                //Retirar
                Libros.pop();

                //Obtener sin retirar el elemento alto de la pila
                Libros.peek();

                //Obtener la posición de un elemento
                Libros.search("Libro2");

                //Obtener el lenght
                Libros.size();
            }

            //Maps
            {
                //Declararlo
                HashMap<Integer,String> libros = new HashMap<>();

                //Añadir elementos
                libros.put(0,"libro1");
                libros.put(1,"libro2");
                libros.put(2,"libro3");

                //Obtener un elemento
                libros.get(1); //Se le indica el indice

                //Comprobar si existe a traves de su clave
                libros.containsKey("libro1");

                //Elimina todos los elementos

                // libros.clear();

                //Elimina un elemento
                libros.remove("libro3");

                //Obtener una coleccion con todos los valores
                Collection<String> losLibros = libros.values();
                //Deberas comentar el libros.clear() si quieres ver los valores de libros
                System.out.println(losLibros);


                //Obtener una colección con todas las claves
                Collection<Integer> lasclaves = libros.keySet();
                System.out.println(lasclaves);

                //Obtener el lenght
                libros.size();




            }

            //Iteradores
            {
            ArrayList<integer> numeros = new ArrayList<>();

            //Declararlo
            Iterator<integer> it = numeros.iterator();

            //Recorrerlo
            while (it.hasNext()){ //Mientras que tenga uno
                System.out.println(it.next()); //recorrera ese elemento
            }

            //Eliminar elementos de una lista
            while (it.hasNext()){ //Mientras que haya un siguiente elemento
                integer numero = it.next(); //Asignamos a un atributo el valor del siguiente elemento
                if (numero.equals(2)){ //Si ese atributo equivale al valor que le pongamos...
                    it.remove();//Borrara ese elento
                }
            }
        }

            //Expresiones regulares

            //Patron pattern
            {
                //Buscar hola sin tener en cuenta mayusculas
                Pattern pattern = Pattern.compile("hola",Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher("Hola mundo");

                boolean matchFound = matcher.find(); //Devolvera true o false

                if (matchFound){
                    System.out.println("Patrón encontrado");
                }else {
                    System.out.println("Patrón no encontrado");
                }

                //Buscar hola teniendo en cuenta el tipo de letra
                Pattern pattern1 = Pattern.compile("HOLA",Pattern.LITERAL);
                Matcher matcher1 = pattern1.matcher("hola mundo");

                boolean matchFound1 = matcher1.find(); //Devolvera true o false

                if (matchFound1){
                    System.out.println("Patrón encontrado");
                }else {
                    System.out.println("Patrón no encontrado");
                }

                //Buscar el patron ignorando las letras que no sean de alfabeto internacional

                Pattern pattern2 = Pattern.compile("holana",Pattern.UNICODE_CASE);
                Matcher matcher2 = pattern2.matcher("holana mundo");

                boolean matchFound2 = matcher2.find(); //Devolvera true o false

                if (matchFound2){
                    System.out.println("Patrón encontrado");
                }else {
                    System.out.println("Patrón no encontrado");
                }


            }

            //Patron Compile
            {
                Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]{3,50}$");
                //De la a-z (Incluyendo en mayuscula),perimote numeros del 3-50 y espacios

                Pattern patter = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n"); // Patron para email

            }


        }





}