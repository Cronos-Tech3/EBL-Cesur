package JAVA_APUNTES.RA6.Collection;

import java.util.*;

public class CollectionProcessorV2 {

    /*
1.¿Cuál es la diferencia principal entre un ArrayList y un LinkedList en términos de tiempo de acceso y modificaciones?

    ArrayList:

        Tiempo de acceso: Rápido para acceder a elementos por índice (O(1)), ya que se basa en un array dinámico.
        Modificaciones: Las operaciones de inserción y eliminación (en el peor de los casos) son más lentas (O(n)),
                    ya que pueden requerir desplazamientos de elementos.

    LinkedList:

        Tiempo de acceso: Más lento para acceder a elementos por índice (O(n)), ya que debes recorrer la lista desde
                      el principio o el final.

        Modificaciones: Las operaciones de inserción y eliminación son más rápidas (O(1)), siempre que tengas una referencia
                         al nodo, porque solo necesitas cambiar los enlaces.

2. Explique las diferencias entre un Set y un List. ¿En qué casos usarías uno sobre el otro?

        List:
            Permite elementos duplicados.
            Mantiene el orden de inserción.
            Ideal para cuando el orden y los duplicados son necesarios.

        Set:
            No permite elementos duplicados.
            No garantiza ningún orden específico (a menos que uses implementaciones como LinkedHashSet o TreeSet).
            Ideal para cuando necesitas evitar duplicados y no te importa el orden.

3.¿Cómo funciona un Map en Java? ¿Qué sucede si intentas insertar una clave duplicada?

        Map: Es una colección que asocia claves con valores. Cada clave puede mapearse a un solo valor.

        Clave duplicada: Si intentas insertar una clave duplicada, el nuevo valor reemplazará al valor
                         existente asociado con esa clave.

4.Describe el propósito de la clase Stack. ¿Cómo se relaciona con el concepto de una pila en Ciencias de la Computación?

    Stack:
        Implementa una pila LIFO (Last In, First Out), donde el último elemento insertado es el primero en salir.

    Relación con la pila en Ciencias de la Computación:

          Es una estructura de datos fundamental utilizada en algoritmos, recursión, gestión de memoria, etc.
          Las operaciones principales son push (insertar elemento) y pop (eliminar el último elemento).


5.En una situación donde necesitas evitar duplicados y no te importa el orden, ¿qué colección usarías y por qué?
        Set:
            Utilizaría un HashSet para evitar duplicados y no preocuparme por el orden de los elementos.
            Es eficiente en términos de tiempo (O(1) promedio para inserciones y búsquedas).
     */

public class ColeccionUtilidades {

        public static int sum(List<Integer> coleccion) {
            int suma = 0;
            for (int valor : coleccion) {
                suma += valor;
            }
            return suma;
        }

        public static boolean addValue(List<Integer> coleccion, int elemento) {
            return coleccion.add(elemento);
        }

        public static boolean deleteFirst(List<Integer> coleccion) {
            if (!coleccion.isEmpty()) {
                coleccion.remove(0);
                return true;
            }
            return false;
        }

        public static Integer addValueGetFirst(List<Integer> coleccion, int elemento) {
            coleccion.add(elemento);
            return coleccion.isEmpty() ? null : coleccion.get(0); // Error: get(0) puede lanzar una excepción si la lista está vacía
        }

        public static boolean checkValue(Map<String, Integer> coleccion, String clave, int valor) {
            if (coleccion.containsKey(clave)) {
                return true;
            } else {
                coleccion.put(clave, valor); // Error: put puede lanzar una excepción si la clave ya existe
                return false;
            }
        }
    }
}




