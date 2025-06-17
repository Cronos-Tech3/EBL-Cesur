package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.GestorAnimales;

import java.util.Objects;

/**
 * INTRODUCCION ->
 * Atributos: Todos serán privados a excepción de los atributos de Animal que serán protected, a
 * excepción del atributo animales de GestorAnimales que será estático y se inicializará vacío.
 * Todos los métodos de las clases son públicos. Puedes crear métodos extra que necesites para
 * realizar el ejercicio.
 * Constructores: con todos los atributos excepto el constructor de GestorAnimales que será el
 * por defecto.
 * Getters y setters: Crea sólo los necesarios, de manera que haya los menos posibles.
 *  --
 *
 *Clase Diente: - -
 * Atributos: String: nombre, int numero.
 * Métodos:
 * o agregarDiente(String, int):boolean : devolverá true si se puede agregar un nuevo
 * diente al hashMap, y false en el caso de que ya exista un valor asignado a esa clave.
 * o obtenerDiente(String):int : devuelve el valor asociado a la clave o 0 si la clave no
 * existe.
 *
 * estos metodos se agregan a la clase Animal
 *
 */

public class Diente {

    private String nombre;
    private int numero;

    public Diente(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    // Este metodo se genera con el equals and hascode y nos sirve para cuando se agregue diente si ya esta el nombre y numero metidos nos retorne el false
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diente diente = (Diente) o;
        return numero == diente.numero && Objects.equals(nombre, diente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numero);
    }
}
