package JAVA_APUNTES.A_Javadoc.teoria;

public class ra1 {

    /**
     *
     *RA1 PROGRAMACIÓN
     * 16 de 25
     * boolean: almacenarán datos de tipo lógico, es decir, sólo podrá almacenar o verdadero o falso
     * (true/ false).
     * 6.2 Tipos de datos estructurados
     * Los tipos de datos estructurados se denominan de esta manera debido a su enfoque en la
     * contención de múltiples valores, usualmente de naturaleza primitiva. Además, se les llama
     * comúnmente "tipos objeto" ya que cumplen el papel de representar objetos y entidades dentro del
     * programa. Este conjunto diverso de tipos de datos ofrece una gran flexibilidad para modelar y
     * manipular información de manera eficiente en el mundo de la programación.
     * 6.2.1 Cadenas de caracteres
     * Son estancias de la clase String. Aunque cuando declaramos una cadena estamos creando un
     * objeto, su declaración no se diferencia de la de una variable de tipo primitivo. Las cadenas de
     * caracteres se delimitan entre comillas dobles, en lugar de simples como los caracteres
     * individuales. Un ejemplo de String sería: “Hola mundo”.
     * 6.2.2 Vectores o arrays
     * Los vectores son colecciones de datos de un mismo tipo. También son conocidos popularmente
     * como arrays e incluso como "arreglos". Un vector es una estructura de datos en la que a cada
     * elemento le corresponde una posición identificada por uno o más índices numéricos enteros. Los
     * elementos de un vector o array se empiezan a numerar en el 0, y permiten gestionar desde una
     * sola variable múltiples datos del mismo tipo.
     * Por ejemplo, si tenemos que almacenar una lista de 10 números enteros, declararíamos un vector
     * de tamaño 10 y de tipo entero, y no tendríamos que declarar 10 variables separadas de tipo
     * entero, una para cada número.
     * 6.2.3 Tipos definidos por el usuario
     * Además de los tipos estructurados básicos que acabamos de ver (cadenas y vectores) en Java
     * existen infinidad de clases en la plataforma, y de terceros, para realizar casi cualquier operación
     * o tarea. Más adelante generaremos nuestras propies clases.
     * 6.2.4 Tipos envoltorio o wrapper
     * RA1 PROGRAMACIÓN
     * 17 de 25
     * Java tiene tipos de datos estructurados equivalentes a cada tipo primitivo que hemos visto. Así,
     * por ejemplo, para representar un entero de 32 bits (int) de los que hemos visto al principio, Java
     * define una clase llamada Integer que representa y "envuelve" al mismo dato, pero le añade ciertos
     * métodos y propiedades útiles por encima.
     * Además, otra de las finalidades de estos tipos "envoltorio" es facilitar el uso de esta clase de
     * valores allí donde se espera un dato por referencia (un objeto) en lugar de un dato por valor. Estos
     * tipos equivalentes a los primitivos, pero en forma de objetos son: Byte, Short, Integer, Long,
     * Float, Double, Boolean y Character.
     * Figura 22: Resumen de tipos de dato en Java.
     * RA1 PROGRAMACIÓN
     * 18 de 25
     * 7 Variables
     * Una variable es un espacio en memoria del ordenador donde se almacenará un valor que podrá
     * cambiar durante la ejecución del programa. Utilizamos las variables siempre que necesitemos
     * almacenar un valor que utilicemos varias veces durante el programa.
     * 7.1 Declaración de variables
     * Para declarar una variable seguimos la siguiente estructura:
     * tipo_variable identificador;
     * Identificadores
     * Un identificador en Java es una secuencia ilimitada sin espacios de letras y dígitos Unicode, de
     * forma que el primer símbolo de la secuencia debe ser una letra, un símbolo de subrayado (_) o el
     * símbolo dólar ($).
     * A la hora de nombrar un identificador existen una serie de normas de estilo de uso generalizado
     * que, no siendo obligatorias, se usan en la mayor parte del código Java. Estas reglas para la
     * nomenclatura de variables son las siguientes:
     * • Java distingue las mayúsculas de las minúsculas. Por ejemplo, Alumno y alumno son
     * variables diferentes.
     * • No se suelen utilizar identificadores que comiencen con «$» o «_», además el símbolo del
     * dólar, por convenio, no se utiliza nunca.
     * • No se puede utilizar el valor booleano (true o false) ni el valor nulo (null).
     * • Los identificadores deben ser lo más descriptivos posibles. Es mejor usar palabras
     * completas en vez de abreviaturas crípticas. Así nuestro código será más fácil de leer y
     * comprender. En muchos casos también hará que nuestro código se autodocumente. Por
     * ejemplo, si tenemos que darle el nombre a una variable que almacena los datos de un
     * cliente sería recomendable que la misma se llamara algo así como FicheroClientes o
     * ManejadorCliente, y no algo poco descriptivo como Cl33.
     * Además de estas restricciones, en la siguiente tabla puedes ver otras convenciones, que, no
     * siendo obligatorias, sí son recomendables a la hora de crear identificadores en Java.
     * • Nombre de variable. Comienza por letra minúscula, y si tienen más de una palabra se
     * colocan juntas y el resto comenzando por mayúsculas.
     * RA1 PROGRAMACIÓN
     * 19 de 25
     * • Nombre de constante. En letras mayúsculas, separando las palabras con el guion bajo, por
     * convenio el guion bajo no se utiliza en ningún otro sitio.
     * • Nombre de una clase. Comienza por letra mayúscula.
     * • Nombre de función. Comienza con letra minúscula.
     * Declarando variables
     * Para declarar una variable de ejemplo la colocaremos dentro del método main de la clase que
     * hemos generado antes.
     * Figura 23: Declaración de variables.
     * 7.2 Inicializar una variable
     * Inicializar una variable es darle un valor. Debemos considerar el tipo de dato antes de asociar un
     * valor a una variable, de forma que asignaremos siempre el tipo de dato correspondiente.
     * RA1 PROGRAMACIÓN
     * 20 de 25
     * Figura 24: Inicialización de variables.
     * 8 Constantes
     * Espacio en memoria del ordenador donde se almacenará un valor que no podrá cambiar durante
     * la ejecución del programa. Utilizaremos constantes siempre que vayamos a reutilizar varias veces
     * el mismo dato, pero sabiendo que no se va a cambiar su valor durante toda la ejecución.
     * 8.1 Declaración e inicialización de constantes
     * Se declarará igual que una variable, pero añadiendo la palabra final delante. Además, por
     * convección, debemos utilizar una palabra en mayúscula para el identificador de la variable. En el
     * ejemplo vemos además que podemos inicializar las variables y las constantes en la misma línea.
     * Figura 25: declaración e inicialización de constantes.
     * RA1 PROGRAMACIÓN
     * 21 de 25
     * 9 Operadores
     * 9.1 Aritméticos
     * Símbolo Nombre Ejemplo
     * + Suma 3 + 2 = 5
     * - Resta 3 – 2 = 1
     * * Multiplicación 3 * 2 = 6
     * / División 6 / 3 = 2
     * % Módulo o resto 3 % 2 = 1
     * 9.2 Lógicos, relacionales o booleanos
     * Símbolo Nombre Ejemplo
     * = Asignación int x = 10
     * == Igualdad x == y
     * > Mayor que x > y
     * < Menor que y < x
     * >= Mayor o igual que x >= y
     * <= Menor o igual que y <= x
     * ! No lógico y != x
     * && Y lógico x>3 && y<5
     * || Ó lógico x>3 || y<5
     * ++ Incremento x++
     * - - Decremento x- -
     * += Incremento y asignación x += 1
     * - = Decremento y asignación x -= 1
     * + Concatenación (String o char) “Hola” + “!”
     * RA1 PROGRAMACIÓN
     * 22 de 25
     * 9.2.1 Tablas de verdad de los operadores lógicos
     * Figura 26: Tabla de verdad de and &&.
     * Figura 27: Tabla de verdad de or ||.
     * Figura 28: Tabla de verdad de not !.
     * 9.3 Operador condicional
     * El operador condicional “?:” sirve para evaluar una condición y devolver un resultado en función
     * de si es verdadera o falsa dicha condición. Es el único operador ternario de Java, y como tal,
     * necesita tres operandos para formar una expresión.
     * El primer operando se sitúa a la izquierda del símbolo de interrogación, y siempre será una
     * expresión booleana, también llamada condición. El siguiente operando se sitúa a la derecha del
     * símbolo de interrogación y antes de los dos puntos, y es el valor que devolverá el operador
     * condicional si la condición es verdadera. El último operando, que aparece después de los dos
     * puntos, es la expresión cuyo resultado se devolverá si la condición evaluada es falsa.
     * RA1 PROGRAMACIÓN
     * 23 de 25
     * Por ejemplo, en la expresión:
     * (x>y)?x:y;
     * Se evalúa la condición de si x es mayor que y, en caso afirmativo se devuelve el valor de la
     * variable x, y en caso contrario se devuelve el valor de y.
     * El operador condicional se puede sustituir por la sentencia if…then…else que veremos en la
     * siguiente unidad.
     * RA1 PROGRAMACIÓN
     * 24 de 25
     * 10. Comentarios
     * Los comentarios son muy importantes a la hora de describir qué hace un determinado programa.
     * A lo largo de la unidad los hemos utilizado para documentar los ejemplos y mejorar la comprensión
     * del código. Para lograr ese objetivo, es normal que cada programa comience con unas líneas de
     * comentario que indiquen, al menos, una breve descripción del programa, el autor de este y la
     * última fecha en que se ha modificado.
     * Todos los lenguajes de programación disponen de alguna forma de introducir comentarios en el
     * código. En el caso de Java, nos podemos encontrar los siguientes tipos de comentarios:
     * Comentarios de una sola línea.
     * Utilizaremos el delimitador // para introducir comentarios de sólo una línea.
     * // comentario de una sola línea
     * Comentarios de múltiples líneas.
     * Para introducir este tipo de comentarios, utilizaremos una barra inclinada y un asterisco (/*), al
     * principio del párrafo y un asterisco seguido de una barra inclinada (*/
    /**al
    final de este.
            * /* Esto es un comentario
     * de varias líneas */
            /*
    Comentarios Javadoc.
            *
    Utilizaremos los
    delimitadores /** y */
    /**Al igual
    que con
    los comentarios
    tradicionales,
    el texto
     *
    entre estos
    delimitadores será
    ignorado por
    el compilador.
    Este tipo
    de comentarios
    se emplean
     *
    para generar
    documentación automática
    del programa.
    A través
    del programa
    javadoc,
    incluido en
     *JavaSE ,
    se recogen
    todos estos
    comentarios y
    se llevan
    a un
    documento en
    formato.html .

             *
    RA1 PROGRAMACIÓN
     *25 de 25
            *11.
    Conversiones de

    tipos(cast)
     *
    Diferenciaremos entre
    dos tipos
    de conversiones:
            *11.1
    Conversiones implícitas
     *
    Se realiza
    automáticamente entre
    dos tipos
    de datos.
    Requiere que
    la variable
    destino tenga
    más
     *
    precisión que
    la variable
    origen:
            *11.2
    Conversiones explícitas
     *
    Al perder
    precisión,
    se debe
    forzar la
    conversión mediante
    una operación
    llamada cast:
     *
     *
     *
     *
     *
     *
     */




}
