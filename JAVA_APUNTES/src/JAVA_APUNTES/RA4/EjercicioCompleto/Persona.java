package JAVA_APUNTES.RA4.EjercicioCompleto;

public class Persona {

    public String nombre;
    public int edad;
    public boolean genero;

public void esMayorDeEdad() {
    if (edad >= 18) {
        System.out.println("Eres mayor de 18 años");
    } else {
        System.out.println("Debes ser mayor de 18 años");
    }
}

public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Genero: " + genero);
    }
}
