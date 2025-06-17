package RA4_POO;

public class Persona {

    public String nombre;
    public int edad;
    public String genero;

public boolean esMayorDeEdad() {
   /* if (edad >= 18) {
        System.out.println("Eres mayor de 18 años");
    } else {
        System.out.println("Debes ser mayor de 18 años");
    }
    */
    return (edad>=18);
}

public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre +"," + edad +  "," + genero);

    }
}
