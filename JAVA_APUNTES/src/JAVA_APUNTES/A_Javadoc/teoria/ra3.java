package JAVA_APUNTES.A_Javadoc.teoria;

public class ra3 {

    /*
    *RA3 PROGRAMACIÓN
2 de 23
1 Estructuras de selección o condicionales
Los condicionales son estructuras de control que nos permiten alterar el flujo normal de un
programa.
1.1 Estructura if/else
La sentencia if permite tomar una decisión en base a una condición. Dicha condición puede ser
simple (comparar dos expresiones) o bien compleja, pudiéndose comparar múltiples expresiones
unidas por cualquier operador lógico. Si el resultado final de la condición es verdadero (la
condición se cumple), se ejecutará el bloque de código asociado a la instrucción if , y a
continuación, el programa seguirá inmediatamente después. En caso contrario, no se ejecutará
ese código y se ejecutará el bloque de código asociado al caso else antes de continuar
inmediatamente después. Para utilizarlo se debe escribir:
if (condición) {
sentencias que cumplen la condición;
}else{
sentencias que no cumplen la condición;
}
*
* RA3 PROGRAMACIÓN
3 de 23
Por ejemplo, si tenemos una variable llamada x que vale 3, podemos comprobar si x es igual a 3,
si es igual el programa nos devolverá la frase por terminal “Es igual a 3”, si no es igual nos
devolverá “No es igual a 3”.
int x = 3;
if (x==3){
System.out.println("Es igual a 3");
}else{
System.out.println("No es igual a 3");
}
*
* 1.2 Estructura if/else if
Este es el caso más completo de la sentencia if . Realmente es posible evaluar tantas condiciones
como se deseen y asociar un bloque de código al cumplimiento de cada una de esas condiciones,
teniendo en cuenta que, por cada sentencia if sólo se acabará ejecutando un sólo bloque de
instrucciones. Se ejecutará siempre el bloque asociado a la condición que antes se cumpla (en
orden de arriba a abajo) o el bloque asociado al caso else si no se cumple ninguna condición
(siempre que se haya incluido caso else). Así, es posible que, aun incluyendo una sentencia if,
puede que nunca se ejecute ninguna sentencia.
if (condicion1) {
sentencias_1;
}
else if (condicion2) {
sentencias_2;
}
else if (condicion3) {
sentencias_3;
}
. . .
. . .
else {
sentencias_else;
}
if (x > 10) {
System.out.println("x es mayor que 10");
}
else if (x < 10) {
System.out.println("x es menor que 10");
}
else {
System.out.println("x es igual a 10");
}

*
*1.3 Estructura switch-case
La sentencia switch-case permite tomar una decisión en base al valor de una variable. A cada
posible valor se le asocia un bloque de sentencias que será ejecutado cuando la variable contenga
dicho valor. Además, de forma similar a como ocurre con la sentencia if, esta sentencia tiene un
caso por defecto, en este caso se llama default, cuyo bloque asociado se ejecutará en caso de que
la variable no tenga ninguno de los valores recogidos en los casos case. La sentencia break nos
asegurará que no se ejecuten todas las sentencias desde la primera coincidencia encontrada.
switch(condición) {
case valor_1:
sentencias_1;
break;
default:
sentencia_default;
break;
}
switch(color) {
case "azul":
System.out.println("El color es azul");
break;
case "rojo":
System.out.println("El color es rojo");
break;
case "negro":
System.out.println("El color es negro");
break;
default:
System.out.println("No es ninguno de los colores seleccionados");
break;
}
    *
    * 2. Estructuras de repetición o bucles
Las estructuras de bucle o repetición permiten ejecutar de forma repetida estructuras de código.
Existen diferentes tipos de bucle que veremos a continuación.
    *
    *2.1 Estructura while
La estructura while es adecuada para los casos en los que tengamos que repetir una estructura
de código hasta que se produzca una situación determinada. No nos importa el número de veces
que se tenga que ejecutar el bucle, sino que éste permanecerá hasta que ocurra algo.
while (condición) {
sentencias;
}
En el siguiente programa el bucle se repetirá mientras el usuario escriba en mensaje cualquier
cadena de caracteres distinta de “.”:
Scanner sc = new Scanner(System.in);
String mensaje = "";
while (! mensaje.equals(".")){ //mientras que el mensaje no sea igual a .
System.out.println("Introduce el nombre de un producto, . para salir");
mensaje = sc.nextLine();
}
*
*2.2 Estructura do-while
La sentencia do-while es muy similar al bucle while pero garantiza que siempre se ejecutará al
menos una iteración de este. La condición se evalúa al final de cada iteración asi que, al menos,
se garantiza que la primera iteración siempre se ejecutará.
do {
sentencias;
} while (condición)
En el siguiente programa se inicia una variable de tipo entero a 10, se muestra el valor de la
variable, se suma uno al valor de la variable y luego si la variable es menor que 10 se repite el
bloque, sino se acaba el programa, como es en este caso.
int i = 10;
do {
System.out.println(i);
i++;
} while (x < 10);
*
* 2.3 Estructura for
La sentencia for es adecuada en los casos en que conocemos el número de veces que se debe
ejecutar la estructura. Al definir el bucle podemos elegir los valores inicial y final para los que se
repetirá y de cuanto en cuanto (valor de paso) iremos incrementando la variable de control que
gestiona el número de iteraciones que se deben realizar.
for (inicio; condición; incremento) {
sentencias;
}
En este caso, el bucle inicia con una variable entera que vale 0, la condición es menor que 10 y el
incremento es que se sume uno en cada pasada del bucle. Dentro del bucle se imprime el valor
de la variable entera, por lo tanto este programa nos mostrará los números del 0 al 9.
for (int i = 0; i < 10; i++} {
System.out.println(i);
}
*
* 3 Sentencias de salto
En Java existen dos sentencias que permiten modificar el flujo secuencial de un programa y
provocan un salto en la ejecución. Estas sentencias son break y continue. Ambas se utilizan con
las estructuras de repetición para interrumpir la ejecución con break o volver al principio con
continue.
3.1 Break
Todas las estructuras de bucle pueden interrumpirse con la instrucción break. Cuando se
encuentra dicha instrucción, se corta la ejecución completa de todo el bucle (la iteración actual y
todas las que pudieran quedar) y el código continua su ejecución inmediatamente después del
final de la estructura de bucle.
while (condicion1) {
sentencia1;
sentencia2;
// Si se cumple condicion2, se rompe el bucle
// y la ejecución del programa seguirá en sentencia4
if (condicion2){
break;
}
sentencia3;
}
sentencia4;
*
* 3.2 Continue
Existe también una instrucción que permite interrumpir una estructura de bucle, pero sólo actúa
para la iteración actual. La instrucción continue corta la ejecución de la iteración actual y vuelve
al inicio del bucle para continuar su ejecución justo en la iteración siguiente a la interrumpida.
do {
sentencia1;
sentencia2;
// Si se cumple la condición no se ejecutarán
// sentencia3 y sentencia4 para esa iteración
// Pero el bucle continuará con la siguiente iteración
if (condicion2){
continue;
}
sentencia3;
sentencia4;
} while (condicion1)
*
* 4 Control y creación de excepciones
Las excepciones en Java son errores que se producen en tiempo de ejecución. Cuando realizamos
el proceso de compilación pueden aparecer una serie de errores que deben ser corregidos para
que el programa pueda compilarse y generarse. Más tarde, durante la ejecución de este, pueden
producirse una serie de errores, los cuales son imposibles de detectar durante la fase de
compilación. Son este tipo de errores los que, en Java, acaban lanzando una excepción si llegan a
producirse:
• Estamos escribiendo en disco y éste se llena (IOException)
• Estamos descargando un fichero y cae la conexión a Internet (ConnectionException)
• Estamos recorriendo un array en un bucle y accedemos a una posición que no existe
(IndexOutOfBoundException)
• Accedemos atributos o métodos de un objeto cuyo valor es nulo (NullPointerException)
• Realizamos una operación matemática no válida (división por cero) (ArithmeticException)
En Java se propone el control de excepciones para evitar que se produzcan estos errores en lugar
de tener que escribir continuamente estructuras if que controlen que no ocurre nada anómalo que
impida la ejecución de un cierto código. Así, lo que haremos será colocar dentro un bloque
controlado todo el código (y el que dependa de éste) que sea susceptible de producir una
excepción, sin interrumpir el flujo de nuestro programa (al contrario de lo que ocurre añadiendo
sentencias if).
Se recomienda excepciones como NullPointerException y IndexOfOutBoundException no se traten
como tal ya que, por lo general, corresponderán a errores de codificación, por lo que realmente,
se debería evitar que se produjeran corrigiendo el programa y no esperando capturarlas cuando
se produzcan. Son dos excepciones que derivan de RuntimeException. Son lo que se conoce como
unchecked exceptions.
*
* 4.1 Tipos de excepciones
4.1.1 Checked Exceptions
Excepciones que deben ser capturadas o declaradas en el método donde se producen
• Heredan directamente de la clase Exception.
• En general, serán las excepciones que deberemos capturar siempre en nuestro código.
• IOException y ParseException son dos ejemplos de excepciones checked.
4.1.2 Unchecked Exceptions
Excepciones que pueden ser lanzadas sin ser capturadas o declaradas
• Heredan de la clase RuntimeException, que a su vez hereda de Exception.
• En general, serán las excepciones que no deberemos capturar. Deberíamos evitar que se
produjeran como, por ejemplo, en el caso de la excepción unchecked NullPointerException.
• ArithmeticException y ArrayIndexOutOfBoundsException son otros ejemplos de
excepciones “unchecked”.
*
* 4.2 Bloque try-catch
El bloque try-catch es el bloque Java que permite delimitar el código susceptible de generar
excepción (parte try) y ejecutar otro bloque para corregir o notificar el problema (parte catch).
try {
// código a probar si tiene excepción
} catch (Exception e1) {
//si salta e1 se ejecuta este código
} catch (Exception e2) {
//si salta e2 se ejecuta este código
}
En el siguiente código se hace una división por 0, por lo que se capturará la excepción de tipo
ArithmeticException y se imprimirá por pantalla.
try{
int data=50/0; //may throw exception
}catch(ArithmeticException e){
System.out.println(e);
}
Se puede añadir también un tercer bloque de código asociado a la parte try que permite añadir
código que se ejecutará siempre, de forma que incluso lo hará cuando se produzca una excepción
no controlada. Normalmente se utiliza para la zona donde se liberarán recursos que hayan sido
ocupados durante el bloque try. De esta forma nos aseguramos que siempre se liberen
correctamente, incluso aunque el flujo de ejecución del código se vea interrumpido por una
excepción.
try{
int data=50/0; //may throw exception
}catch(ArithmeticException e){
System.out.println(e);
}finally{
System.out.println("Bloque finally que se ejecuta siempre");
}
*
* 4.3 Instrucción throws
También podemos, en lugar de capturar la excepción, lanzarla haciendo que tenga que ser
controlada en un nivel superior. Por ejemplo, si estoy desarrollando una clase que debe controlar
una determinada excepción, quizás me pueda resultar interesante hacerla “subir” de nivel para
que sea controlada, por ejemplo, en el controlador de la aplicación o bien cerca de la interfaz con
el usuario. Así es probable que podamos ajustar mejor el comportamiento en caso de error.
El ejemplo es un caso en el que tenemos un método estático que utilizamos para parsear fechas
en nuestra aplicación. Cuando el texto que se le pase no se corresponda con un formato válido de
fecha, lanzará una excepción. En el método no tenemos claro que hacer, ya que dicho método lo
usarán desde diferentes localizaciones del código en la aplicación. Por eso es mejor que lancemos
fuera la excepción para que sea quién utilice este método quién deba decidir qué hacer en caso
de fallo.
public static Date parseFecha(String fecha) throws ParseException {
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
return sdf.parse(fecha);
}
*
* 4.4 Crear una excepción
Como ya hemos visto, Java tiene una serie de unchecked y checked exceptions que son lanzadas
en determinadas situaciones. Vamos a ver ahora cómo también podemos crear nuestras propias
excepciones y lanzarlas cuando se produzcan situaciones de “más alto nivel” en nuestra lógica de
la aplicación.
Por ejemplo, en una aplicación para la gestión de inventarios, almacenes o pedidos, podemos
definir una excepción como la del siguiente ejemplo, para que sea lanzada en el caso de que se
termine el stock de algún producto de nuestro almacén:
public class FueraDeStockException extends Exception {
public FueraDeStockException() {
super();
}
public FueraDeStockException(String mensaje) {
super(mensaje);
}
}
Más adelante veremos que significa las palabras reservadas extends y super.
Para utilizar esta nueva excepción utilizaremos:
if (stock <= 0) {
throw new FueraDeStockException();
}
*
* 5 Aserciones
Las aserciones son sentencias utilizadas para comprobar si una condición es cierta (o no) y
controlar asi los errores en el código. Básicamente equivale a una sentencia if que evalúa una
condición y genera una Excepción AssertException si ésta se cumple, mostrando el mensaje
asociado a la misma. De forma similar a cómo hacen las excepciones, permite hacerlo de forma
cómoda y sin romper el flujo del código. Además, estás condiciones en forma de aserción sólo
tienen efecto si se pasa la opción -ea o -enableassertions a la máquina virtual cuando se ejecuta
la aplicación. Así solo se activan cuando es necesario o interesa usarlas.
assert cadena == null : "La cadena es nula";
//es lo mismo que:
if (cadena == null) {
throw new AssertionError("La cadena es nula");
}
*
* 6 Depuración de código
La depuración es el proceso de encontrar y solucionar errores en el código fuente de cualquier
software. Permite suspender la ejecución del programa, reanudarla, inspeccionar las variables y
evaluar las expresiones mediante el depurador. Para utilizar el depurador necesitamos utilizar el
botón Debug de nuestro IDE .
Para conseguir que nuestro programa pare en un punto en concreto es necesario añadir puntos
de interrupción al programa, normalmente desde el propio IDE, en la zona de numeración de líneas
nos dejará poner un punto (normalmente rojo o naranja) el cual nuestro programa parará si llega
a esa línea de ejecución.
*En la figura anterior vemos como se ha colocado un punto de interrupción en la línea 10, si ahora
ejecutamos el programa en modo debug el programa se parará en esa línea, y al tratarse de un
bucle, cuando lo reanudemos volverá a parar si vuelve a ejecutarse el bucle.
*
* Cuando iniciamos la depuración y se para nuestro programa nos aparece una pantalla como la de
la figura anterior. En ella podemos ver el valor que tiene la variable mensaje, que como inicia en
una cadena vacía y aún no hemos llegado a la línea en la que se le pide al usuario que le cambie
el valor, está vacía. Además, se aprecian una serie de botones que nos permiten controlar la
depuración. De izquierda a derecha tenemos:
Rerun: relanza el programa.
Stop: interrumpe la ejecución del programa.
Resume: continua la ejecución del programa.
Pause: pausa la ejecución del programa.
Step over: ejecuta la siguiente línea de código.
Step into: ejecuta la siguiente línea de código. Si esa línea es una llamada a otra función, el
programa entrará en esa función.
Step out: sale de la función actual.

*
* 7 Javadoc
Documentar un proyecto es algo fundamental de cara a su futuro mantenimiento. Cuando
programamos una clase, debemos generar documentación detallada sobre ella como para que
otros programadores puedan usarla solo con su interfaz. No debe existir necesidad de leer o
estudiar su implementación, lo mismo que nosotros para usar una clase del API Java no leemos
ni estudiamos su código fuente.
Javadoc es una utilidad de Oracle para la generación de documentación de APIs en formato HTML
a partir de código fuente Java. Javadoc es el estándar para documentar clases de Java. La mayoría
de los IDEs utilizan javadoc para generar de forma automática documentación de clases.
Para documentar una clase de deben incluir:
• Nombre de la clase, descripción general, número de versión, nombre de autores.
• Documentación de cada constructor o método (especialmente los públicos) incluyendo:
nombre del constructor o método, tipo de retorno, nombres y tipos de parámetros si los
hay, descripción general, descripción de parámetros (si los hay), descripción del valor que
devuelve.
Además de documentar las clases, todo proyecto debería tener un archivo Leeme o Readme. En
el readme.txt sería adecuado incluir al menos: título del proyecto, descripción, versión, cómo
arrancar el proyecto, autores e instrucciones para los usuarios.
Para que javadoc sea capaz de generar documentación automáticamente han de seguirse estas
reglas:
1. La documentación para javadoc ha de incluirse entre símbolos de comentario que han de
empezar con una barra y doble asterisco, y terminar con un asterisco y barra simple.
2. La ubicación le define a javadoc qué representa el comentario: si está incluido justo antes
de la declaración de clase se considerará un comentario de clase, y si está incluido justo
antes de la signatura de un constructor o método se considerará un comentario de ese
constructor o método.
3. Para alimentar javadoc se usan ciertas palabras reservadas (tags) precedidas por el
carácter "@", dentro de los símbolos de comentario javadoc. Si no existe al menos una
línea que comience con @ no se reconocerá el comentario para la documentación de la
clase.
*
7.1 Etiquetas más utilizadas
* Etiqueta DESCRIPCIÓN
@author Nombre del desarrollador.
@deprecated Indica que el método o clase es obsoleto (propio de versiones anteriores) y
que no se recomienda su uso.
@param Definición de un parámetro de un método, es requerido para todos los
parámetros del método.
@return Informa de lo que devuelve el método, no se aplica en constructores o
métodos "void".
@see Asocia con otro método o clase.
@version Versión del método o clase.
@exception
@throws Informa de que puede lanzar una excepción y describe cómo se da.
Un ejemplo de javadoc sencillo sería:
/**
* Esto es una prueba
*
* @author Paloma
* @version 1.0
*
*/
/* Para generar el javadoc en intellij basta con ir al apartado de tools->generate javadoc.
*
* Crear ejecutables
Para generar un ejecutable de java (.jar) en intellij deberemos generar un artifact que utilizaremos
al hacer el build de nuestro proyecto. Para ello debemos ir a File -> Project structure -> Artifacts
darle al + Jar, y elegir from modules with dependencies. Nos aparecerá el siguiente panel en el
que elegiremos la clase que arranca nuestro proyecto (la que contiene el método main).
Una vez generado el artifecto podemos darle a Build -> Build Artifact -> Seleccionamos el artefacto
que acabamos de generar y le damos a build. Esto generará un archivo .jar por defecto en la
carpeta out/artifacts.
Una vez generado, podemos probarlo desde la terminal utilizando el comando java –jar seguido
del nombre del ejectuble.
*
* */









}
