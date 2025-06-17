package JAVA_APUNTES.A_Javadoc.teoria;

public class ra4 {
    /*
    *1 Programación orientada a objetos
La Programación Orientada a Objetos (POO) es un enfoque de programación que se basa en la
creación y manipulación de “objetos”. Estos objetos son entidades que combinan datos y
comportamientos en un solo paquete.
*
En la POO, los objetos tienen atributos que representan sus características o propiedades, y
métodos que definen las acciones que pueden realizar. Las clases se utilizan para definir la
estructura y el comportamiento de los objetos. Una clase actúa como una plantilla o un modelo a
partir del cual se crean objetos individuales con características únicas.
    *

1 Programación orientada a objetos
La Programación Orientada a Objetos (POO) es un enfoque de programación que se basa en la
creación y manipulación de “objetos”. Estos objetos son entidades que combinan datos y
comportamientos en un solo paquete.
En la POO, los objetos tienen atributos que representan sus características o propiedades, y
métodos que definen las acciones que pueden realizar. Las clases se utilizan para definir la
estructura y el comportamiento de los objetos. Una clase actúa como una plantilla o un modelo a
partir del cual se crean objetos individuales con características únicas.

*
Los pilares de la POO son:
• Encapsulación: La implementación y el estado de cada objeto se mantienen de forma
privada dentro de un límite definido o clase. Otros objetos no tienen acceso a esta clase o
la autoridad para realizar cambios, pero pueden llamar a una lista de funciones o métodos
públicos. Esta característica de ocultación de datos proporciona una mayor seguridad al
programa y evita la corrupción de datos no intencionada. Consiste en reunir en una cierta
estructura todos los elementos que a un cierto nivel de abstracción se pueden considerar
pertenecientes a una misma entidad.
*
• Abstracción: Los objetos solo revelan mecanismos internos que son relevantes para el uso
de otros objetos, ocultando cualquier código de implementación innecesario. Este
concepto ayuda a los desarrolladores a realizar cambios y adiciones más fácilmente a lo
largo del tiempo. Nos tenemos que centrar en el qué hace, y no en el cómo lo hace. En un
típico ejemplo, podemos pensar en una radio. Hay gente que no sabe cómo funciona internamente,
pero sí somos capaces de usarla gracias a la interfaz que presenta
(botones, ruedas…), y evitamos tener que aprender su funcionamiento interno, es decir, su
implementación.
*
• Herencia: Se pueden asignar relaciones y subclases entre objetos, lo que permite a los
desarrolladores reutilizar una lógica común sin dejar de mantener una jerarquía única.
Esta propiedad de la POO obliga a un análisis de datos más completo, reduce el tiempo de
desarrollo y asegura un mayor nivel de precisión.
*
• Polimorfismo: Los objetos pueden adoptar más de una forma según el contexto. El
programa determinará qué significado o uso es necesario para cada ejecución de ese
objeto, reduciendo la necesidad de duplicar código.
*
1.1 Clase
Es la parte de un programa en Java donde se definen las propiedades y operaciones que van a
tener los ejemplares (objetos, instancias) de dicha clase. Con una clase se define un nuevo tipo
de datos (Scanner, String, Coche).
    *
    *Para declarar una clase utilizamos la siguiente estructura:
modificadores class NombreClase{
declaracionesDeMiembros;
}
public class Persona {
//Definición de la clase
}
*
Para crear una nueva clase en Intellij tendremos que hacer clic derecho en el paquete donde la
queremos crear: New > Java Class. Aquí indicamos su nombre. Por convención, la nomenclatura
de las clases es CamelCase con la inicial mayúscula.
*
*
* 1.2 Propiedades y métodos
Dentro de una clase, como hemos visto hasta ahora, solo podemos definir dos cosas: métodos y
variables.
*
* Las variables definidas dentro del ámbito de la clase {dentro de los corchetes de la clase}
son las variables de instancia. Otras definiciones son: variables miembro, variables de
instancia, propiedades de la clase, atributos de la clase, etc. Son los datos que definen a
una clase.
*
• Los métodos definidos dentro de la clase se conocen como métodos de instancia, o
métodos miembro. Son un conjunto de instrucciones agrupadas bajo un nombre y con un
objetivo común, que se ejecuta al ser invocada.
En el siguiente código vemos la clase Coche, que contiene como atributos matrícula, numRuedas,
marca y kilómetros, y como métodos arrancar y acelerar.
*public class Coche {
//Atributos: definen el estado del objeto
public String matricula;
int numRuedas;
String marca;
private float kilometros;
//Métodos: operaciones del objeto
public void arrancar() {
}
private int acelerar(int intensidad) {
}
}
Para declarar una variable necesitaremos, por tanto:
[modificadores] tipoDeDato nombreAtributo
Para declarar un método:
[modificadores] tipoRetorno identificadorMetodo([lista parametros])
{
// instrucciones
[return valor;]
}

* • Modificadores: public, private, static...
• Tipo retorno: Tipo de datos que devuelve el método. Puede devolver un tipo concreto, o no
devolver nada (void).
• Identificador: El identificador que usaremos para ejecutarlo, igual que el de una variable.
Su forma de escribir el identificador de un método es lowerCamelCase.
• Lista de parámetros: Los tipos de datos que necesita el método para operar.
• Return: se usa para devolver el valor de retorno. El tipo retornado tiene que coincidir con
el tipo retorno del método.
Como vemos en el método arrancar, se trata de un método público, es void por lo que no devuelve
ningún valor, y no recibe ningún parámetro. Sin embargo, el método acelerar es privado, devuelve
un entero y recibe un parámetro entero llamado intensidad.
1.2.1 Modificadores de visibilidad o acceso
Para indicar desde qué clases se puede acceder a los miembros de otra clase se usan los llamados
modificadores de visibilidad.
Usan al declarar los miembros de una clase (atributos, métodos, o constructores) y definen desde
qué otras clases puedo acceder a sus miembros. Los modificadores son:
• public: cualquier miembro público es accedido desde cualquier clase en cualquier
paquete.
• private: los miembros privados solo se pueden acceder desde dentro de la clase que los
contiene.
• protected: los miembros protegidos solo se pueden usar desde dentro de la propia clase
o desde dentro de sus subclases (herencia de clases).
• default: si no se indica modificador, se pueden acceder a los miembros de la clase también
desde las clases que estén en el mismo paquete. Se conoce también como package-
private.
Por convenio, los atributos de una clase se deben definir como private. Por ejemplo:
public class Coche{
private int matricula;
*public int getMatricula(){
return matricula;
}
}
1.2.2 Getters y Setters
Como se acaba de comentar, los atributos de una clase se deben declarar private por convenio.
Entonces se necesitan métodos públicos para acceder a los atributos y poder modificarlos. Estos
métodos se conocen como getters y setters.
private String nombre;
private int edad;
private boolean casado;
//método getter del atributo nombre
public String getNombre(){
return nombre;
}
//método setter del atributo nombre
public void setNombre(String nombre){
this.nombre = nombre;
}
Estos métodos se nombran como get cuando quiero obtener el valor, y como set cuando quiero
establecerlo. En el caso de los atributos booleanos en lugar de get, se suele indicar is, aunque no
afecta al funcionamiento. En Intellij se pueden generar automáticamente estos métodos desde el
botón generate.
1.2.3 Métodos y variables estáticas
Una variable estática no se asocia a una instancia de una clase (objeto), sino a la clase misma.
Esto es: no hay una copia de la variable estática por cada objeto de la clase, sino una sola copia
por clase. A estas variables se les conoce como variables de clase.
Aunque se creen varios objetos de una misma clase, el valor de sus variables estáticas es el mismo
para todos los objetos, y si se modifican, se modifican para todos. Solo hay una copia en memoria.
Al igual que las variables estáticas, los métodos estáticos no dependen de un objeto de la clase, y
por eso se pueden llamar sin necesidad de crear un objeto de la clase. Se les llama método de
clase.
Dado que no es necesario crear un objeto para llamar a estos métodos, no puedes acceder a
variables miembro de la clase que no sean estáticas. Esto tiene sentido, ya que si las variables no
son estáticas dependen de un objeto, y como hemos dicho, no es necesario un objeto para llamar
al método.
Algunos de los métodos estáticos que hemos usado hasta ahora:
//Se ejecutan desde la clase
System.out.println("Introduce un valor");
Math.random();
Por ahora, la principal característica que nos interesa de la cláusula static es que para usar un
método static no necesitamos crear un objeto de la clase en la que se encuentra definido.
Por ejemplo: todos los métodos de la clase Math, son estáticos, y no necesitamos crear una
variable de tipo Math para ejecutarlos.
public static int num1;
public static int sumar(int entero1, int entero2){
int resultado;
resultado = entero1 + entero2;
return resultado;
}
1.3 Constructores
Crear un ejemplar (objeto) de una clase se conoce como instanciar una clase. Para crear un objeto
o instancia de una clase, debemos llamar o ejecutar su constructor.
*Se necesita usar el operador new para llamar al constructor de una clase. Se ha usado en otras
ocasiones:
Scanner sc = new Scanner(System.in);
La llamada a un constructor devuelve siempre la referencia al objeto creado en memoria (heap).
La declaración del constructor de una clase tiene una sintaxis parecida a la de los métodos, pero:
• No tiene tipo de retorno, por lo que no hay return.
• Su identificador (nombre) es el mismo que la clase.
modificadores nombre_clase(){
//instrucciones
}
//Ejemplo de clase Coche con constructor
public class Coche{
private String matricula;
private int km;
//Constructor de la clase Coche
public Coche(){
//instrucciones que se realizan al crear un objeto Coche
}
}
Los constructores también pueden recibir parámetros, pero recordamos que nunca devuelven un
valor.
public Coche(String cod_matricula){
matricula = cod_matricula;
}
Y así puedo crear instancias de la clase Coche utilizando los constructores que he definido:
public static void main(String[] args){
//usar el constructor vacio
Coche miCoche = new Coche();
//usando el constructor que recibe el parámetro matrícula
Coche miOtroCoche = new Coche("FDS-1234");
}
Si en una clase no definimos explícitamente un constructor, Java creará implícitamente un
constructor llamado no-args que se trata de un constructor vacío, que no recibe ningún parámetro
ni tiene instrucciones dentro. De este modo, aunque no definamos un constructor siempre
podremos instanciar una clase.
1.3.1 Palabra reservada this
La palabra this se usa dentro de un método o de un constructor en una clase y representa el objeto
actual: el objeto cuyo método o constructor está siendo llamado. this contiene una referencia al
objeto actual.
Hay 2 razones para usarlo:
• El nombre del parámetro en un método o constructor tiene el mismo nombre que un
atributo de la clase. Usamos this para diferenciarlos. Este es su uso principal.
• Un constructor usa otro constructor ya creado en la clase. Usamos this, para llamar al
constructor.
public class Persona{
private String nombre;
private int edad;
private int altura;
//Uso this para saber que uno el el atributo
//Y el otro el parámetro
public void setNombre(String nombre){
this.nombre = nombre;
}
public Persona(String nombre, int edad){
this.nombre = nombre;
this.edad = edad;
}
*
* 1.4 Recursividad
Se conoce con el nombre de recursividad a la técnica en la que un método hace una llamada a sí
mismo. Es una técnica muy potente, pero también muy pesada (consumo de recursos).
Ejemplo de método recursivo para obtener el valor factorial (1 x 2 x 3 x … x N) de un entero positivo
(N):
static int factorial(int entero){
//Condición de salida de recursividad
if (entero == 0){
return 1;
}
//LLamada recursiva
return factorial(entero - 1) * entero;
}
1.5 Diagramas UML
Para representar una clase, utilizaremos el diagrama de clases de UML (Unified Modeling
Language).
Para ello cada clase se representa con un rectángulo dividido en tres partes. La primera tiene el
nombre de la clase, la segunda los atributos y la tercera los métodos.
*
*
*2 Herencia
En Java podemos tener clases que heredan de otras (extends, o extienden). Cuando una clase
hereda de otra puede hacer uso de los miembros de su clase padre. Además, permite sobrescribir
métodos si en una subclase queramos concretar su funcionamiento.
Debemos tener en cuenta que toda clase en Java hereda de la clase Object de forma directa o
indirecta, y que por tanto hay una serie de métodos que heredan todas las clases.
* La herencia es un mecanismo mediante el cual aprovechamos la implementación de operaciones
de una clase padre (reutilización de código) y creamos nuevas clases hijas a partir de esa clase:
• Heredando y posiblemente modificando y/o añadiendo operaciones.
• Heredando y posiblemente añadiendo atributos.
Debemos tener en cuenta que un método o atributo heredado mediante el mecanismo de herencia
no puede ser suprimido en la subclase.
*
* Podríamos decir que la herencia nos permite usar el código creado en una clase para no tener que
volverlo a escribir en una subclase. Todas las subclases tienen las operaciones de la superclase,
y así no tenemos que repetir el código en cada una.
Otro planteamiento sería, si me encuentro con la necesidad de tener dos clases cuyas operaciones
(métodos) son iguales, pero que cada una tiene otras operaciones propias diferentes, debo
concluir que esas dos clases tienen un parte en común, la cual debería definirse en una
superclase, permitiendo a estas subclases implementar solo las operaciones específicas de cada
una.
2.1 Subclases
Si entendemos que una clase son “los planos” que definen la creación de un ejemplar (objeto,
instancia) de esa clase, podemos entender que cuando una clase hereda de otra, lo que está
haciendo es usar los planos de la clase padre, y añadirle más información para crear más o
diferentes funcionalidades de las que tenía.
Podemos llamar a las clases hijas subclases y a la clase padre, superclase. Para que una subclase
herede de una superclase debe usarse extends en la definición de la subclase.
Ejemplo de superclase: Vehiculo. Y las subclases serían avión, moto agua, coche, moto, etc.
2.2 Extends y final
Para indicar que una clase hereda de otra al declararla debemos añadir la palabra reservada
extends seguida del nombre de la clase de la que queremos que herede. Por ejemplo, si tenemos
la clase Vehículo:
public class Vehiculo{
private int km;
private String matricula;
public int getKm(){
return km;
}
public void setKm(int km){
*this.km = km;
}
public String getMatricula(){
return matricula;
}
public void setMatricula(String matricula){
this.matricula = matricula;
}
}
Y creamos la clase Coche que hereda de vehículo:
public class Coche extends Vehiculo{
//Campo específico de Coche
private int cilindrada;
//Métodos específicos de Coche
public void setCilindrada(int cilindrada){
this.cilindrada = cilindrada;
}
public int getCilindrada(){
return cilindrada;
}
}
Si, por el contrario, queremos que una clase no permita extender su funcionalidad, o lo que es lo
mismo, no permita ser heredada, definiremos dicha clase como final.
public final class Vehiculo{
...
}
*
* La palabra clave final la hemos usado en otras ocasiones para crear variables que no se puedan
modificar (constantes), y también se aplica a las clases y a los métodos con dicha finalidad.
Por ejemplo, las clases String o Math no se pueden heredar, ya que están definidas como final.
    * */














}
