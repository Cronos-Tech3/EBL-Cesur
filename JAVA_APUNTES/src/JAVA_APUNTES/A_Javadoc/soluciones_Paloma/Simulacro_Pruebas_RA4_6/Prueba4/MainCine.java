package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba4;

public class MainCine {
    public static void main(String[] args) {

        /**
        Aquí tienes un ejercicio adaptado, similar al que mostraste, pero utilizando arrays unidimensionales en lugar de bidimensionales. También he modificado algunos métodos para darle un toque diferente.
Ejercicio: Clases y Arrays
Contexto:
Vamos a implementar una clase que gestiona una lista de entradas de cine para diferentes personas.
Clase Entrada
Atributos:
• nombreCliente: String (nombre del cliente que compró la entrada).
• precio: double (precio de la entrada).
• diaSemana: String (día de la semana para la función).
• vip: boolean (si la entrada es VIP o no).
Métodos:
1. calcularPrecioFinal(): double
• Si el día es “miércoles”, aplica un descuento del 30%.
• Si la entrada es VIP, aplica un recargo del 15%.
• Devuelve el precio final de la entrada.
2. toString(): String
• Devuelve una representación en cadena del objeto Entrada con el formato:
"Cliente: [nombreCliente], Día: [diaSemana], Precio final: [precioFinal]".
Clase Cine
Atributos:
• nombre: String (nombre del cine).
• entradas: Entrada[] (un array unidimensional que almacena las entradas compradas).
Métodos:
1. agregarEntrada(nombreCliente: String, precio: double, diaSemana: String, vip: boolean): boolean
• Agrega una nueva entrada al array.
• Verifica si hay espacio disponible (posición nula).
• Si hay espacio, crea un nuevo objeto Entrada y lo agrega al array.
• Devuelve true si la entrada fue agregada correctamente, o false si el array está lleno.
2. calcularRecaudacionTotal(): double
• Calcula y devuelve la suma de los precios finales de todas las entradas del array.
3. listarEntradasVIP(): void
• Muestra en consola todas las entradas VIP con su información.
4. toString(): String
• Devuelve una cadena que representa todas las entradas registradas en el cine.
• Si una entrada es nula, muestra "Espacio libre".
tiene menú contextual

Aquí tienes una descripción en forma de ejercicio sobre qué debes hacer en el main para probar las funcionalidades de las clases Entrada y Cine:
Ejercicio: Clase principal (Main)
Descripción:
Implementa el método principal (main) para probar las funcionalidades del cine y las entradas. Deberás realizar las siguientes acciones:
Acciones Esperadas:
1. Crear un objeto de la clase Cine.
• Asigna un nombre al cine.
• Indica la capacidad del array de entradas (por ejemplo, 5).
2. Agregar varias entradas al cine:
• Usa el método agregarEntrada para añadir al menos 3 entradas con diferentes configuraciones de precios, días de la semana y si son VIP o no.
• Asegúrate de probar lo siguiente:
• Una entrada con un descuento (miércoles).
• Una entrada VIP (recargo del 15%).
• Una entrada normal sin descuento ni recargo.
3. Mostrar todas las entradas:
• Llama al método toString del objeto Cine para imprimir las entradas registradas. Si hay espacios vacíos en el array, deben mostrarse como “Espacio libre”.
4. Calcular y mostrar la recaudación total del cine:
• Usa el método calcularRecaudacionTotal para calcular la suma de todos los precios finales de las entradas registradas.
• Imprime el resultado en consola.
5. Listar solo las entradas VIP:
• Llama al método listarEntradasVIP para mostrar en consola todas las entradas que son VIP.


         */

        /*
        Entrada[] entradas=new Entrada[5];

        Cine cine = new Cine("Cine1",entradas);

        System.out.println( cine.agregarEntrada("tony",10,"miercoles",false));
        System.out.println( cine.agregarEntrada("tony",10,"jueves",true));
        System.out.println( cine.agregarEntrada("tony",10,"jueves",false));
        System.out.println("***********************************************************");
        String mostrar=cine.toString();
        System.out.println(mostrar);

        System.out.println("***********************************************************");
        System.out.println("La recaudacion total es" + cine.calcularRecaudacionTotal());
        System.out.println("*********************************************************");
        System.out.println("Entradas vip registradadas");
       cine.listarEntradasVip();

         */

    }
}
