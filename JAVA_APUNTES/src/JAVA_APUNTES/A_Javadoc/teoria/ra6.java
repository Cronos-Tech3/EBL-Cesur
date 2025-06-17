package JAVA_APUNTES.A_Javadoc.teoria;

public class ra6 {

    /*
    *1 Colecciones
Las colecciones en Java son estructuras de datos dinámicas que permiten almacenar listas o
colecciones de datos de un tipo determinado. Además, proporcionan una API muy completa de
operaciones para poder realizar sobre toda la colección. Se pueden considerar como una
evolución de los arrays ya que éstos son estáticos y tienen una operativa más básica. Además, los
diferentes tipos de colecciones permiten afinar el comportamiento de cada una de ellas de forma
que podremos elegir la que más nos convenga para cada caso. Existen, por ejemplo, colecciones
de datos en las que los elementos están automáticamente ordenados en todo momento (TreeSet)
u otras que no admiten elementos repetidos (HashSet). Otras estructuras mantienen el orden de
los elementos (LinkedList o ArrayList) mientras que en otras esa información no es relevante
(HashMap)
Existe numerosos tipos de datos para almacenar colecciones con diferentes características. En
esta sección veremos algunas de las más utilizadas: LinkedList, ArrayList y HashMap. También
veremos cómo funcionan las pilas y las colas, para las que Java proporciona los tipos Stack y
Queue , respectivamente.
Además, existe una serie de interfaces y clases como List, Collection o Arrays de la que extienden
o implementan estas estructuras de colección, lo que permite que además existan operaciones
que permiten que se puedan hacer operaciones que combinen distintos tipos de colección y otras
estructuras de datos como los arrays.
    *
    *2 Arrays
Un array es una estructura de datos que permite almacenar un número indeterminado de variables
del mismo tipo, que son referenciadas por el mismo identificador.
Dentro del array, cada valor ocupa una posición y se puede recuperar o modificar su valor
combinando el identificador y dicha posición.
Como se puede observar en la figura, la primera posición del array es la posición 0. Como
consecuencia, la última posición del array será igual a la longitud de este menos uno.
2.1 Declarar y crear un array
El array se declara como una variable, indicando tipo e identificador, acompañado de los
caracteres [ y ] que lo caracterizan, puesto que son los caracteres que se emplean para referirse
a alguna posición del mismo.
Una vez declarado puede ser instanciado con la instrucción new seguido del tipo e indicando el
número de elementos para los que se quiere reservar espacio en memoria, tal y como se indica a
continuación. En este caso, para asignar valor a cada uno de los espacios que se han reservado
se puede acceder al array e indicar la posición para la que se quiere asignar.
String[] telefonos = new String[5];
telefonos[0] = "976123456";
También es posible inicializar los valores de un array aprovechando una estructura de bucle como
for de forma que se puede asignar a cada elemento de este, posición por posición.
String[] telefonos = new String[5];
for (int i = 0; i < telefonos.length; i++) {
telefonos[i] = " . . . ";
}
También es posible crear un array asignando directamente los valores que queremos que
contenga el mismo. En ese caso se declara un array con la capacidad justa para almacenar todos
los valores especificados.
String[] telefonos = {"976123456", "91123456", "986789876"};
*
* 2.2 Acceder al contenido del array
Cada elemento de este, una vez indicada la posición, se puede tratar como una variable del mismo
tipo que el array, por lo que las operaciones que se pueden hacer con cada elemento son las
mismas que se pueden hacer sobre variables individuales.
Utilizando la posición se puede acceder al contenido de un array que ya haya sido inicializado, por
ejemplo, una forma muy práctica de observar el contenido de un array es utilizando un bucle for
como en el siguiente ejemplo:
//declaramos el array
int[] numeros = new int[10];
//lo rellenamos con los números del 1 al 10
for (int i = 0; i < numeros.length; i++) {
numeros[i] = i + 1;
}
//mostramos el contenido del array por pantalla
for (int i = 0; i < numeros.length; i++) {
System.out.println(numeros[i]);
}
2.2.1 Bucle for each
Es un tipo de bucle mejorado para el caso en que se quiera recorrer un array y acceder a cada uno
de los elementos del mismo. Por eso, no es necesario utilizar variable auxiliar para el índice ni
asignar cada elemento del array para trabajar sobre él, lo hará automáticamente la propia
estructura del bucle:
for (int num : numeros) {
System.out.println(num);
}
2.3 Dimensión de un array
2.3.1 Arrays bidimensionales (Matrices)
Los arrays bidimensionales, también llamados matrices, son arrays en dos dimensiones. En la
práctica se puede interpretar como un array unidimensional en el que hay almacenado otro array
en cada elemento del primero.Se declaran e inicializan de la misma manera que los arrays unidimensionales, pero esta vez hay
que tratar con dos dimensiones. Al poderse interpretar como una matriz, la primera dimensión
hará referencia a las filas, y la segunda a las columnas.
Es posible inicializar los valores de un array aprovechando una estructura de bucle como for de
forma que se puede asignar a cada elemento de este, posición por posición. En este caso será
necesario anidar dos bucles para acceder a las dos dimensiones del array.
int[][] numeros = new int[10][10];
for (int i = 0; i < numeros.length; i++) {
for (int j = 0; j < numeros[i].length; j++) {
numeros[i][j] =i;
}
}
También es posible crear un array bidimensional asignando directamente los valores que
queremos que contenga el mismo. En ese caso se declara un array con la capacidad justa para
almacenar todos los valores especificados.
String[] telefonos = {{"976123456", "91123456", "986789876"}, . . . };
2.4 Clase Arrays
En Java disponemos de la clase Arrays que facilita algunas de las operaciones más comunes que
se pueden llevar a cabo con los arrays:
• Arrays.binarySearch(): Busca en un array un elemento que se pasa como parámetro.
Devolverá la posición donde lo encuentra o el valor -1 si no existe. Hay que tener en cuenta
que el array deberá de estar ordenado.
int[] numeros = new int[10];
for (int i = 0; i < numeros.length; i++) {
numeros[i] = i * 10;
}
int resultado = Arrays.binarySearch(numeros, 20);
System.out.println(resultado); // 2
*
* • Arrays.copyOf(): Permite copiar el array a otro de diferente longitud (mayor o menor),
rellenando o truncando los valores nuevos o eliminados, respectivamente. Devuelve el
array resultante.
int[] numeros = new int[5];
int[] masNumeros = Arrays.copyOf(numeros, 10);
System.out.println(masNumeros.length); // 10
• Arrays.equals(): Comprueba si dos arrays son iguales. Devuelve un valor booleano
indicando si son o no iguales.
int[] numeros = {1, 3, 4};
int[] otrosNumeros = {1, 3, 4};
System.out.println(Arrrays.equals(numeros, otrosNumeros)); // true
• Arrays.fill(): Rellena un array con el valor que se le pasa como parámetro.
int[] numeros = new int[3];
Arrays.fill(numeros, 5);
System.out.println(Arrays.toString(numeros)); // [5, 5, 5]
• Arrays.sort(): Ordena el array que se pasa como parámetro.
int[] numeros = {4, 10, 3, 6}
Arrays.sort(numeros);
System.out.println(Arrays.toString(numeros)); // [3, 4, 6, 10]
• Arrays.toString(): Devuelve una representación en String del array que se pasa como
parámetro.
int[] numeros = {10, 20, 30, 5}
System.out.println(Arrays.toString(numeros)); // [10, 20, 30, 5]
3 Listas
List es la interface padre de todas las colecciones de tipo Lista.
3.1 ArrayList
La clase ArrayList permite definir arrays dinámicos. Son colecciones de datos dinámicas con el
acceso y funcionamiento de un array, puesto que sólo es posible recuperar cada elemento a partir
de la posición del mismo.
• Implementa la interface List.
• Es el tipo de colección más genérica.
• Define una colección de elementos sin ninguna característica especial.
• Los elementos se pueden obtener a partir de la posición donde fuera añadidos.
* Entre las operaciones que se pueden realizar con un ArrayList las más comunes son las siguientes:
Añadir un elemento.
ArrayList<Libro> listaLibros = new ArrayList<>();
. . .
Libro libro = new Libro(. . .);
listaLibros.add(libro);
Añadir toda una colección al final.
ArrayList<Libro> listaLibros = new ArrayList<>();
ArrayList<Libro> otraListaLibros = new ArrayList<>();
. . .
listaLibros.addAll(otraListLibros);
Obtener un elemento.
Libro unLibro = listaLibros.get(4);
Eliminar un libro.
Libro libroEliminado = listaLibros.remove(4);
Eliminar todos los elementos.
listaLibros.clear();
Obtener el tamaño de la colección (número de elementos).
int tamano = listaLibros.size();
Obtener un array estático con los elementos de la colección.
Libro[] libros = listaLibros.toArray();
3.2 LinkedList
La clase LinkedList es una lista doblemente enlazada, que permite almacenar una colección de
objetos, obtenerlos, eliminarlos y algunas operaciones para acceder a los mismos. Acceder al
primer y último elemento, entre otros, son operaciones muy directas en este tipo de colección.
• Implementa la interface List y Queue.
• Se utiliza para definir estructuras FIFO (First In First Out), también conocidas como colas.
• Define métodos que permiten, directamente, acceder/eliminar el primer elemento de una
lista (el primer elemento de la cola).
Entre las operaciones que se pueden realizar con un LinkedList las más comunes son las
siguientes:
Añadir un elemento.
LinkedList<Libro> listaLibros = new LinkedList<>();
Libro libro = new Libro(. . .);
listaLibros.add(libro);
* Añadir un elemento al principio.
LinkedList<Libro> listaLibros = new LinkedList<>();
Libro libro = new Libro(. . .);
listaLibros.addFirst(libro);
Añadir un elemento al final.
LinkedList<Libro> listaLibros = new LinkedList<>();
Libro libro = new Libro(. . .);
listaLibros.addLast(libro);
Añadir toda una colección al final.
LinkedList<Libro> listaLibros = new LinkedList<>();
LinkedList<Libro> otraListaLibros = new LinkedList<>();
listaLibros.addAll(otraListLibros);
Obtener un elemento.
Libro unLibro = listaLibros.get(4);
Obtener el primer/último elemento.
Libro primerLibro = listaLibros.getFirst();
Libro ultimoLibro = listaLibros.getLast();
Eliminar (y obtener) el primer/último elemento.
Libro primerLibro = listaLibros.removeFirst();
Libro ultimoLibro = listaLibros.removeLast();
Eliminar todos los elementos
listaLibros.clear();
Obtener el tamaño de la colección (número de elementos).
int tamano = listaLibros.size();
Obtener un array estático con los elementos de la colección.
Libro[] libros = listaLibros.toArray();
3.3 Stack
Las Pilas son colecciones de datos donde éstos se colocan apilándolos y sólo puede ser retirado
el elemento que se encuentra encima de la pila. Siguen el principio LIFO (Last In First Out) donde
el último elemento en llegar a la colección es el primero en salir de la misma.
• Implementa la interface List.
• Permite manejar una lista como si se tratara de una estructura LIFO (Last In First Out),
también conocidas como pilas.
• Define métodos (push y pop) para coger y dejar directamente del final de la lista (lo que
sería la parte alta de la pila).
* Operaciones con Stack:
Añadir un elemento.
Stack<Libro> pilaLibros = new Stack<>();
Libro libro = new Libro(. . .);
pilaLibros.push(libro);
Retirar un elemento de la pila.
Libro libro = pilaLibros.pop();
Obtener, sin retirar, el elemento de lo alto de la pila.
Libro libro = pilaLibros.peek();
Obtener la posición de un elemento (posicion >= 1).
int posicion = pilaLibros.search(libro);
Comprobar el tamaño de la pila.
int tamano = pilaLibros.size();
3.4 Sets
Por definición no acepta elementos duplicados. No define métodos nuevos, solamente
implementa Collection e impide que existan elementos duplicados. Se pueden implementar como:
• HashSet: Rendimiento constante para las operaciones más habituales, no garantiza el
orden de los elementos de la colección.
• LinkedHashSet: Mantiene una lista doblemente enlazada por lo que puede obtenerse un
iterador con el orden en que los elementos fueron añadidos a la colección.
• EnumSet: Es un Set especializado para enumeraciones. El rendimiento es ligeramente
inferior al de HashSet.
• TreeSet: Garantiza el orden de los elementos, sus elementos se mantienen siempre
ordenados de forma natural o por un Comparator que se proporcione en su constructor.
Su rendimiento es el menor de todos los Sets.
// Crear un Set de nombres
Set<String> nombres = new HashSet<>();
// Agregar nombres al Set
nombres.add("Juan");
nombres.add("María");
nombres.add("Pedro");
nombres.add("Juan"); // Intentar agregar un duplicado, se ignora
// Mostrar el contenido del Set
System.out.println("Nombres únicos:");
for (String nombre : nombres) {
System.out.println(nombre);
}
// Verificar si un elemento está en el Set
String buscar = "María";
if (nombres.contains(buscar)) {
System.out.println(buscar + " está en el conjunto.");
} else {
System.out.println(buscar + " no está en el conjunto.");
}
// Eliminar un elemento del Set
nombres.remove("Pedro");
System.out.println("Después de eliminar a Pedro:");
System.out.println(nombres);
// Mostrar el tamaño del Set
System.out.println("Tamaño del conjunto: " + nombres.size());
3.5 Maps
Es una colección de elementos que se encuentran mapeados por una clave (parejas clave-valor,
key-value, K, V):
• La clave asociada a cada elemento permite recuperarlo.
• No se permiten claves duplicadas (se sobrescribe el valor si la clave se vuelve a registrar).
3.5.1 HashMap
Es una tabla hash que implementa el interfaz Map de Java, lo que le convierte en una estructura
de colección que almacena objetos asociados a una clave. Este tipo de colecciones, a diferencia
de los anteriores, no garantiza el orden de los elementos, puesto que éstos se pueden obtener
solamente utilizando la clave que se asoció al mismo en el momento de añadirlo.
Añadir un elemento (pareja clave-valor).
HashMap<String, Libro> libros = new HashMap<>();
Libro libro = new Libro(. . .);
libros.add(libro.getTitulo(), libro);
Obtener un elemento.
Libro unLibro = libros.get(tituloLibro);
Comprobar si existe un elemento (a través de su clave).
libros.containsKey(tituloLibro)
Eliminar todos los elementos.
libros.clear();
Eliminar un elemento.
libros.remove(tituloLibro);
Obtener una colección con todos los valores.
Collection<Libro> losLibros = libros.values()
*
* Obtener una colección con todas las claves.
Set<String> losTitulos = libros.keySet();
Obtener el número de elementos del HashMap.
libros.size();
// Crear un HashMap para almacenar estudiantes y sus notas
HashMap<String, Double> notas = new HashMap<>();
// Agregar elementos al HashMap
notas.put("Juan", 8.5);
notas.put("María", 9.0);
notas.put("Pedro", 7.5);
notas.put("Ana", 10.0);
// Mostrar el contenido del HashMap
System.out.println("Notas de los estudiantes:");
for (Map.Entry<String, Double> entrada : notas.entrySet()) {
System.out.println(entrada.getKey() + ": " + entrada.getValue());
}
// Obtener la nota de un estudiante específico
String estudiante = "María";
if (notas.containsKey(estudiante)) {
System.out.println("La nota de " + estudiante + " es: " +
notas.get(estudiante));
} else {
System.out.println(estudiante + " no está en el registro.");
}
// Modificar la nota de un estudiante
notas.put("Pedro", 8.0); // Reemplaza la nota existente
System.out.println("Después de modificar la nota de Pedro:");
System.out.println(notas);
// Eliminar a un estudiante del HashMap
notas.remove("Ana");
System.out.println("Después de eliminar a Ana:");
System.out.println(notas);
// Mostrar el tamaño del HashMap
System.out.println("Número de estudiantes en el registro: " + notas.size());
4 Iteradores
Un Iterador es un objeto que recorre una estructura de datos de forma homogénea. Es decir, da lo
mismo cual sea la estructura de datos que la forma de recorrer no cambia. Una de las situaciones
*
* más habituales para manejar iteradores es recorrer una lista de elementos. En Java se puede
realizar de varias maneras, una es usando un Iterator y la otra o usando un bucle forEach. Para
usar el Iterador utilizaremos los métodos hasNext() y next().
Iterator < String > it = lista.iterator();
while (it.hasNext()) {
System.out.println(it.next());
}
Si lo que queremos es eliminar elementos de una lista podremos hacerlo utilizando el método
remove().
Iterator < String > it = lista.iterator();
while (it.hasNext()) {
String nombre = it.next();
if (nombre.equals("Pedro")) {
it.remove();
}
}
5 Expresiones regulares
Una expresión regular es un patrón para encontrar una cadena en el texto. En Java, la
representación original de este patrón es siempre una cadena, es decir, un objeto de la clase
String. Sin embargo, no es cualquier cadena que se pueda compilar en una expresión regular, solo
cadenas que se ajustan a las reglas para crear expresiones regulares. La sintaxis se define en la
especificación del lenguaje. Las expresiones regulares se escriben con letras y números, así como
con metacaracteres, que son caracteres que tienen un significado especial en la sintaxis de las
expresiones regulares.
En Java utilizaremos el paquete java.util.regex y las clases Pattern, Matcher y
PatternSyntaxException, por ejemplo:
//creamos el patrón a buscar, en este caso hola y sin imortar mayúsculas de
minúsculas
Pattern pattern = Pattern.compile("hola", Pattern.CASE_INSENSITIVE);
//pasamos el patrón por la frase Hola Mundo!
Matcher matcher = pattern.matcher("Hola Mundo!");
//usamos el método find para saber si coinciden
boolean matchFound = matcher.find();
if(matchFound) {
System.out.println("patrón encontrado");
} else {
System.out.println("patrón no encontrado");
}
Tipos de flags que podemos pasarle a Pattern:
• Pattern.CASE_INSENSITIVE: Se ignoran mayúsculas de minúsculas.
• Pattern.LITERAL: Los caracteres especiales pierden su significado y son sólo caracteres.
• Pattern.UNICODE_CASE: Para ignorar letras que no sean del alfabeto internacional.
*Lista de metacaracteres para utilizar en expresiones regulares:
Caracter Descripción
. Cualquier caracter.
[ ] Indica un rango de valores o una serie de caracteres específicos con los
que debe coincidir. Ej: [abc]
^ Inicio de la cadena de caracteres.
- Indica un rango de caracteres. Ej: [a-z] letras de la a a la z
? Indica que los caracteres anteriores a este pueden coincidir 1 sola vez o
ninguna.
+ Indica que los caracteres anteriores a este pueden coincidir 1 o multiples
veces.
* Indica que los caracteres anteriores a este pueden coincidir ninguna vez o
multiples veces.
( ) Indica un grupo de expresiones regulares.
\ Caracter de escape, sirve para utilizar un metacaracter como si fuese un
caracter normal.
$ Indica el final de la cadena de caracteres.
` `
?? Es coincidente con cierta parte de los caracteres o rangos de valores
opcionales.
+? Es coincidente con cierta parte de los caracteres o rangos de valores
opcionales. La parte coincidente puede repetirse una o varias veces.
*? Es coincidente con cierta parte de los caracteres o rangos de valores
opcionales. La parte coincidente puede repetirse 0 o multiples veces.
Ejemplos de expresiones regulares:
• Email: ([a-zA-Z0-9._%-]+)@([a-zA-Z0-9.-]+).([a-zA-Z]{2,6})
• Teléfono: ^[0-9]{10}$
• Contraseña con letra mayúscula, minúscula, númer, caracter especial y entre 8 y 20
caracteres: ^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,20}$
• Nombre y Apellido (solo letras y espacios): ^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$
6 Interfaz Comparable
La interface Comparable se usa para comparar objetos entre sí y poderlos ordenar. Para ello
implementamos la interface y luego sobrescribimos el método compareTo(). Este método es el
usado para comparar dos objetos y decidir cuando uno es mayor que otro. Devuelve 1 si el objeto
actual es mayor que el que pasamos como parámetro. Devuelve 0 si en la comparación se produce
una relación de igualdad y devuelve -1 si es menor.
public class Persona implements Comparable<Persona>{
private String nombre;
private int edad;
public String getNombre() {
return nombre;
}
public void setNombre(String nombre) {this.nombre = nombre;
}
public int getEdad() {
return edad;
}
public void setEdad(int edad) {
this.edad = edad;
}
public Persona(String nombre, int edad) {
this.nombre = nombre;
this.edad = edad;
}
@Override
public int compareTo(Persona o) {
if (this.getEdad()>o.getEdad()) {
return 1;
}else if (this.getEdad()<o.getEdad()) {
return -1;
}else {
return 0;
}
}
}
De esta forma podemos apoyándonos en Java Comparable ordenar un ArrayList de objetos de
forma rápida por ejemplo por la propiedad edad que es de lo que se encarga el código que hemos
construido. Si construimos un programa main podremos ordenar una lista por edad.
public static void main(String[] args) {
Persona p1= new Persona ("pedro",20);
Persona p2= new Persona ("juan",30);
Persona p3= new Persona ("maria",40);
Persona p4= new Persona ("gema",15);
ArrayList<Persona> lista= new ArrayList<Persona>();
lista.add(p1);
lista.add(p2);
lista.add(p3);
lista.add(p4);
Collections.sort(lista);
for (Persona p :lista) {
System.out.print(p.getNombre());
System.out.println(p.getEdad());
}
}
    * */




}
