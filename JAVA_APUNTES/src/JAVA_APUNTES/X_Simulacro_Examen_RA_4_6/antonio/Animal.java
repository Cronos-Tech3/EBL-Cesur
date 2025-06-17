package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.antonio;

import java.util.HashMap;
import java.util.Objects;

/**

Atributos: Todos serán privados a excepción de los atributos de Animal que serán protected, a excepción del atributo animales de GestorAnimales que será estático y se inicializará vacío.
Todos los métodos de las clases son públicos. Puedes crear métodos extra que necesites para realizar el ejercicio.
Constructores: con todos los atributos excepto el constructor de GestorAnimales que será el por defecto.
Getters y setters: Crea sólo los necesarios, de manera que haya los menos posibles.
Clase Diente:
-
Atributos: String: nombre, int numero.
-
Métodos:
o
agregarDiente(String, int):boolean : devolverá true si se puede agregar un nuevo diente al hashMap, y false en el caso de que ya exista un valor asignado a esa clave.
o
obtenerDiente(String):int : devuelve el valor asociado a la clave o 0 si la clave no existe.
Clase Animal:
−
Atributos: nombre: String, edad: int, tipoAlimentacion: String, tieneCola: boolean, HashMap<Diente, boolean>: dientes.
−
Métodos:
o
Void hacerSonido()
−
Descripción: Este método está vacío, lo que significa que debe ser implementado por las clases que heredan de Animal. Representa el sonido que hace un animal según su comportamiento específico.
o
Double moverse()
−
Descripción: Este método también es vacío y representa cómo se mueve un animal según el tipo de movimiento especificado.
Clase Perro (hereda de Animal):
−
Atributos Adicionales: raza: String, ladra: boolean.
−
Métodos Implementados: hacerSonido(), moverse(). Hacer sonido mostrará por pantalla la palabra “Guau” y el método moverse en función del valor que tenga tipoAlimentación devolverá:
o
Si es Carnívora, y tieneCola es verdadero devolverá 1.5, y si no tiene cola 0.5.
o
Si es omnívora, y tieneCola es verdadero devolverá 2.0 y si no tiene cola 1.2.
o
Cualquier otra opción devolverá 0.3.
Clase Gato (hereda de Animal):
−
Atributos Adicionales: colorPelaje: String, cazaRatones: boolean.
−
Métodos Implementados: hacerSonido(), moverse(). Hacer sonido mostrará por pantalla la palabra “Miau” y el método moverse en función del valor que tenga tipoAlimentación devolverá:
o
Si es Carnívora, y tieneCola es verdadero y cazaRatones es verdadero devolverá 1.2, y si no tiene colay caza ratones 0.5, y sino 0.3.
o
Si es omnívora, y tieneCola es verdadero y cazaRatones es verdadero devolverá 1.6, y si no tiene colay caza ratones 0.8, y sino 0.25.
o
Cualquiera otra convinación devolverá 0.1.
−
GestorAnimales:
•
Atributos: animales: colección estática de tipo Stack de Animal.
•
Método main para probar la funcionalidad del programa.
o
Se crearán al menos 2 perros y dos gatos. Pidiendo datos por teclado y comprobando que los nombres de los animales son letras del alfabeto internacional, con mayúsculas y minúsculas de entre 3 y 25 caracteres admitiendo espacios.
o
Añade los animales creados al Stack.
o
Recorre el Stack utilizando un iterador, asegúrate de que se muestran bien todos los elementos de los animales (que se muestran todos sus atributos de forma correcta y sin la palabra null).
o
Llama a todos los métodos de los 4 animales. Mostrando una frase con el dato que devuelven.
 */
public   class  Animal {
    protected  String nombre;
    protected  int edad;
    protected  String Tipoalimentacion;
    protected boolean tineCola;
    //protected HashMap<Diente, Boolean> dientes;
    /*
    public Animal(String nombre, int edad, String tipoalimentacion, boolean tineCola, HashMap<Diente, Boolean> dientes) {
        this.nombre = nombre;
        this.edad = edad;
        Tipoalimentacion = tipoalimentacion;
        this.tineCola = tineCola;
        this.dientes = dientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoalimentacion() {
        return Tipoalimentacion;
    }

    public void setTipoalimentacion(String tipoalimentacion) {
        Tipoalimentacion = tipoalimentacion;
    }

    public boolean isTineCola() {
        return tineCola;
    }

    public void setTineCola(boolean tineCola) {
        this.tineCola = tineCola;
    }

    public HashMap<Diente, Boolean> getDientes() {
        return dientes;
    }

    public void setDientes(HashMap<Diente, Boolean> dientes) {
        this.dientes = dientes;
    }

    public   void HacerSonido(){};



    public   double moverse(){
        return 0;
    }



    public boolean AgregarDiente(String nombre, int numero) {
        Diente diente = new Diente(nombre, numero);

        if (!dientes.containsKey(diente)) {
            dientes.put(diente, true);
            return true;
        }else{
            return false;
        }
    }

    //obtenerDiente(String):int : devuelve el valor asociado a la clave o 0 si la clave no existe.

    public int obtenerDiente( String nombre) {
        for (Diente diente : dientes.keySet()) {
            if (diente.getNombre().equals(nombre)) {
                return diente.getNumero();
            }
        }
        return 0;
    }

    /**

    Ejemplo 1: Usar entrySet

Escenario:

Supongamos que tienes un HashMap de nombres de dientes y su número asociado, y necesitas buscar un diente específico por nombre. Sin embargo, también deseas devolver un mensaje si encuentras el diente, además de su número.

Aquí usaríamos entrySet, ya que en cada iteración obtenemos tanto la clave como el valor en forma de un par (Map.Entry).

Código:

public String buscarDienteConMensaje(String nombre) {

    for (Map.Entry<String, Integer> entry : dientes.entrySet()) {

        if (entry.getKey().equals(nombre)) {

            return "Diente encontrado: " + entry.getKey() + " con número " + entry.getValue();

        }

    }

    return "Diente no encontrado.";

}
Razón para usar entrySet:

Con entrySet, tienes acceso tanto a la clave como al valor directamente en cada iteración, evitando la necesidad de llamar a get para obtener el valor.

Ejemplo de uso:

System.out.println(buscarDienteConMensaje("Canino")); // Si existe: "Diente encontrado: Canino con número 2"

System.out.println(buscarDienteConMensaje("Molar"));  // Si no existe: "Diente no encontrado."
Ejemplo 2: Usar values

Escenario:

Supongamos que necesitas verificar si hay dientes con un número mayor a un valor específico. Aquí solo necesitas los valores (números de dientes), por lo que usar values() es más eficiente.

Código:

public boolean existeDienteConNumeroMayor(int numero) {

    for (int valor : dientes.values()) {

        if (valor > numero) {

            return true; // Si hay un número mayor, devuelve true

        }

    }

    return false; // Si no se encuentra ninguno, devuelve false

}
Razón para usar values:

Solo necesitas trabajar con los valores del HashMap, y no te importa cuál es la clave asociada.

Ejemplo de uso:

System.out.println(existeDienteConNumeroMayor(2)); // Si hay un diente con número mayor a 2: true

System.out.println(existeDienteConNumeroMayor(5)); // Si no hay dientes mayores a 5: false
Comparación de Uso
	1.	entrySet:

Úsalo cuando necesitas trabajar tanto con las claves como con los valores simultáneamente. Por ejemplo, cuando buscas un diente y quieres devolver más información combinada.
	2.	values:

Úsalo cuando solo necesitas los valores, como al calcular un total, verificar un rango, o encontrar el valor más alto o bajo.


     */


}
