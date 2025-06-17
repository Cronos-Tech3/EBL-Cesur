package JAVA_APUNTES.A_Javadoc.teoria;

public class ra2 {

    /*
    *1 Entrada y salida de datos
La entrada y salida estándar son flujos de datos que actúan como canales de comunicación
permitiendo la interacción entre un programa y su entorno en el sistema. En Java podemos tener
acceso a estos flujos de datos desde la clase java.lang.System.
1.1 Salida Estándar
La salida estándar está asociada por defecto a la terminal del sistema, es decir que el resultado
de los datos enviados a la salida se observa en pantalla a menos que su destino sea modificado.
Existen dos salidas con diferentes propositos, una es la propiamente denominada salida estándar
la cual se utiliza para la salida regular de datos, y la otra es la salida estándar de errores la cual
se utiliza para la salida de errores.
1.1.1 System.out
La salida estándar de datos para uso normal (abreviada y en inglés: StdOut) está representada
por un objeto PrintStream llamado out. La clase PrintStream es una implementación especial de
FilterOutputStream y por lo tanto también de la clase base OutputStream, de modo que mostrar
datos en pantalla es tan sencillo como referirnos a la variable out e invocar el método void
println(String x). Un ejemplo sencillo es:
Esto nos mostrará por pantalla: Hola mundo.
Los métodos print(...) y println(...) son los más usados. De hecho, la clase PrintStream posee
estos métodos sobrecargados para todos los datos primitivos (int, long, etc.) y entonces así
puede enviar cualquier tipo de dato como texto hacia la salida. Los objetos que se quieran
imprimir o concadenar serán implícitamente representados por su implementación del método
String toString().
Si miramos la API de PrintStream podemos ver la variedad de métodos para mostrar datos en
pantalla, algunos de estos:
- void print(String s): Escribe un string
- void println(String x): Escribe un string y termina la línea.
- void println(): Termina la línea actual.
- void printf(String format, Object... args): Utiliza un Formatter para poder escribir un String
formateado. (Disponible desde J2SE 5.0)
    *
    * 1.1.2 System.err
Esta es otra salida estándar, pero con el fin de ser utilizada para errores (abreviada y en inglés:
StdErr). Al igual que StdOut, también es representada por un objeto PrintStream que en este caso
se llama err. Los métodos que podemos invocar aquí son los mismos vistos anteriormente.
No parece muy útil utilizar out y err si su destino es el mismo, o al menos en el caso de la consola
del sistema donde las dos salidas son representadas con el mismo color y no notamos diferencia
alguna. En cambio, en la consola de IDEs la salida de err se ve en un color diferente, por ejemplo:
Figura 1: Uso de System.out y System.err.
RA2 PROGRAMACIÓN
1.2 Entrada estándar
Desde J2SE 5.0 se introduce la clase Scanner en el paquete de utilidades java.util. Esta clase
toma en cuenta un delimitador para procesar la entrada del flujo de datos en sub-cadenas, es
muy flexible y ya posee una gran variedad de métodos para diferentes necesidades. Para utilizar
esta clase solo tenemos que construir un objeto Scanner pasándole System.in como argumento,
el flujo de bytes es convertido a caracteres en el formato de caracteres por defecto del sistema,
aunque la clase también posee otros constructores para especificar el formato de preferencia.
1.2.1 Uso de la clase Scanner
Para utilizar la clase Scanner, antes debemos instanciar un objeto de esa clase. Para ello
importaremos la librería necesaria y crearemos una instancia de la lase scanner utilizando su
constructor. Después podremos llamar a los métodos de la clase para poder escribir por teclado
y que sea recogido por la aplicación.
Figura 2: Recogida de datos con Scanner.
RA2 PROGRAMACIÓN
1.3 Convertir tipos de datos de variables
Cuando utilizamos el método nextInt() e insertamos una cadena de caracteres, veremos que nos
salta una excepción.
Figura 3: InputMismatchException.
Para poder prevenir esa excepción vamos a ver cómo convertir una cadena en un entero. Para
ellos utilizaremos el método parseInt del wrapper Integer de la siguiente forma.
RA2 PROGRAMACIÓN
Figura 4: Conversión con parse.
De esta forma no utilizaremos el método nextInt(), que nos obliga a que el contenido sea un entero,
sino que recuperaremos el contenido con nextLine(), lo guardaremos en una variable acorde que
será por lo tanto tipo Strig, y luego lo almacenaremos en un entero convirtiéndolo con el método
parse().
Esto nos solucionará problemas futuros como, por ejemplo, cuando pedimos varios datos
alternados entre cadenas de caracteres y enteros. El problema surge cuando insertamos un entero
con nextInt() y luego pedimos con nextLine() una cadena. En el primer nextInt() habremos metido
un salto de línea (\n) el cual no será interpretado como final de línea y se utilizará en el siguiente
nextLine() disponible.
RA2 PROGRAMACIÓN
2 Clase Math
La clase Math contiene una serie de métodos que nos permiten hacer cálculos matemáticos.
Vamos a ver algunos de los más usados, pero puedes ver en la documentación el resto
(https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html ).
Sqrt
Este método nos devolverá la raíz cuadrada del número que le pasemos como argumento. Por
ejemplo:
Pow
Este método recibe dos parámetros, el segundo será el exponente al que deseamos elevar el
primer número. Ejemplo:
Random
Este método nos devolverá un valor decimal entre el 0 y el 1. Si queremos obtener un número
aleatorio entre 0 y 5 tendremos que multiplicar la salida por 6, ya que truncaremos el valor a un
número entero. Ejemplo:
Abs
Este método nos devolverá el valor absoluto de un número. Por ejemplo:
RA2 PROGRAMACIÓN
3 Clase String
La clase nos permite almacenar un conjunto de caracteres (char). Para declara un String
podemos hacerlo directamente, sin necesidad de usar el constructor de la clase:
Los métodos más importantes de la clase String son:
Length
Devuelve la longitud de la cadena de caracteres.
CharAt
Devuelve el caracter que hay en esa posición.
Substring
Devuelve la subcadena desde un índice startIndex (en caso de llevar un solo parámetro), o desde
un inicio hasta un fin endIndex (si lleva dos parámetros).
Equals
Comprueba si una cadena de texto es igual a otra.
IsEmpty
Comprueba si la cadena de texto está vacía.
ToUpperCase
Devuelve la cadena en mayúscula.
RA2 PROGRAMACIÓN
ToLowerCase
Devuelve la cadena en minúscula.
Replace
Encuentra un carácter o una secuencia y la modifica por lo que le indicamos.
Además, más adelante veremos el método split().
    * */







}
