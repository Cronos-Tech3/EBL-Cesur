package JAVA_APUNTES.RA6.Collection;

import java.util.*;

// La declaración import java. util. *;
// se puede utilizar para cargar el contenido del paquete java. util en un programa Java

public class CollectionProcessorV1 {

    //Preguntas -->
    /*
    1.¿Cuál es la diferencia principal entre un ArrayList y un LinkedList en términos de tiempo de acceso y modificaciones?

        ArrayList: ->Tiempo de acceso: rápido para acceder a elementos por indice (0(1))
               ->Modificaciones: Las operaciones de insercion y eliminacion son mas lentas (0,(n)),
                  ya que pueden requerir desplazamientos de elementos.

        LinkedList: ->Tiempo de acceso: Más lento para acceder a elementos por índice (O(n)), ya que debes recorrer la lista desde
                   el principio o el final.
                ->Modificaciones: Las operaciones de inserción y eliminación son más rápidas (O(1)), siempre que tengas una referencia
                    al nodo, porque solo necesitas cambiar los enlaces.

     2. Explique las diferencias entre un Set y un List. ¿En qué casos usarías uno sobre el otro?

        List: ->Permite elementos duplicados.
                Mantiene el orden de inserción.
                Ideal para cuando el orden y los duplicados son necesarios.
         Set: -> No permite elementos duplicados.
            No garantiza ningún orden específico (a menos que uses implementaciones como LinkedHashSet o TreeSet).
            Ideal para cuando necesitas evitar duplicados y no te importa el orden.

     3. ¿Cómo funciona un Map en Java? ¿Qué sucede si intentas insertar una clave duplicada?

        Map: ->Es una colección que asocia claves con valores. Cada clave puede mapearse a un solo valor.

        Clave duplicada: ->Si intentas insertar una clave duplicada, el nuevo valor reemplazará al valor
                         existente asociado con esa clave.

      4. Describe el propósito de la clase Stack. ¿Cómo se relaciona con el concepto de una pila en Ciencias de la Computación?

        Stack: ->Implementa una pila LIFO (Last In, First Out), donde el último elemento insertado es el primero en salir.

        Relación con la pila en Ciencias de la Computación:

          ->Es una estructura de datos fundamental utilizada en algoritmos, recursión, gestión de memoria, etc.
          Las operaciones principales son push (insertar elemento) y pop (eliminar el último elemento).

      5.En una situación donde necesitas evitar duplicados y no te importa el orden, ¿qué colección usarías y por qué?

        Set: ->Utilizaría un HashSet para evitar duplicados y no preocuparme por el orden de los elementos.
            Es eficiente en términos de tiempo (O(1) promedio para inserciones y búsquedas).

     */


//Metodos para la clase CollectionProccesor -->

    //Primer Metodo
    /*
    *sum(coleccion): recibirá la colección de enteros y devolverá
    *la suma de todos sus valores.
    */

//metodo sum(coleccion)

    //array
    public static int sum(int[] array){
        int suma =0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    //arraylist
    public static int sum(ArrayList<Integer> array){
        int suma =0;
        for (int i = 0; i < array.size(); i++) {
            suma += array.get(i);
        }
        return suma;
    }

    //linkedList
    public static int sum(LinkedList<Integer> array){
        int suma =0;
        for (int i = 0; i < array.size(); i++) {
            suma += array.get(i);
        }
        return suma;
    }

    //hashSet
    public static int sum(HashSet<Integer> array){
        int suma =0;
        for (int x : array) {
            suma += x;
        }
        return suma;
    }
    //Stack
    public static int sum(Stack<Integer> array){
        int suma =0;
        for (int x : array) {
            suma += x;
        }
        return suma;
    }
    //Map
    public static int sum(HashMap<Integer, Integer> array){
        int suma =0;
        for (int x : array.keySet()) {
            suma += array.get(x);
        }
        return suma;
    }

    //FIN DEL METODO SUM

    /*
    addValue(coleccion, elemento): recibirá la colección y un
    elemento y añadirá ese elemento a la colección. Devolverá true
    si lo ha podido añadir y false si no ha podido añadirlo. Para
    Map debe recibir también el nombre de la clave.
    */


    //addValue array

    public boolean addValue(Integer[] coleccion, Integer elemento) {
        for (int i = 0; i < coleccion.length; i++) {
            if (coleccion[i] == null) { // Espacio disponible identificado como 'null'
                coleccion[i] = elemento;
                return true; // Elemento añadido con éxito
            }
        }
        return false; // No se encontró espacio disponible
    }

    //addValue ArrayList
    public static boolean addValue(ArrayList<Integer> coleccion, int elemento) {
        coleccion.add(elemento);
        return true;
    }
    //addValue LinkedList
    public static boolean addValue(LinkedList<Integer> coleccion, int elemento) {
        coleccion.add(elemento);
        return true;
    }
    //addValue HashSet
    public static boolean addValue(HashSet<Integer> coleccion, int elemento) {
        coleccion.add(elemento);
        return true;
    }
    //addValue Stack
    public static boolean addValue(Stack<Integer> coleccion, int elemento) {
        coleccion.push(elemento);
        return true;
    }

    public static boolean addValue(HashMap<String, String> colleccion, String elemento, String clave){
        if (colleccion.containsKey(clave)){
            colleccion.put(clave, elemento);
            return true;
        }
        return false;
    }
    //FIN DE AddValue
    /*
    deleteFirst(coleccion): recibirá la colección y eleminará el
    primer elemento de la colección. Devolverá true si lo ha
    podido eliminar y false si no lo ha podido hacer.
    */

    // deleteFirst Array
    public static boolean deleteFirst(Integer[] collection) {
        if (collection[0] != null) {
            collection[0] = null;
            return true;
        }
        return false;
    }
    //deleteFirst ArrayList
    public static boolean deleteFirst(ArrayList<Integer> collection) {
        collection.removeFirst();
        return true;
    }
    //deleteFirst LinkedList
    public static boolean deleteFirst(LinkedList<Integer> collection) {
        collection.removeFirst();
        return true;
    }
    // deleteFirst HashSet
    public static boolean deleteFirst(HashSet<Integer> collection) {
        collection.remove(0);
        return true;
    }
    // deleteFirst Stack
    public static boolean deleteFirst(Stack<Integer> collection) {
        collection.removeFirst();
        return true;
    }
    // deleteFirst Map
    public static boolean deleteFirst(HashMap<Integer, Integer> collection) {
        collection.remove(0);
        return true;
    }
    //FIN deleteFirst

    /*
    addValueGetFirst(coleccion, elemento): recibirá la colección y
    un elemento y añadirá ese elemento a la colección. Devolverá
    el primer elemento de la colección o nulo si no lo puede
    obtener.
     */


    //addValueGetFirst







    /*
    checkValue(coleccion, valor): comprobará si existe el valor en
    la colección, si no existe lo insertará. Para Map debe recibir
    también el nombre de la clave.
    */


}
