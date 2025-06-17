package RA4_POO.EjercicioPOO.POO_Ej1;

public class Persona22 {

    public String nombre;
    public int edad;
    public boolean genero;

    public void esMayorDeEdad() {
        if (edad >= 18) {
            System.out.println("Eres mayor de 18 años");
        }else{
            System.out.println("debes ser mayor de edad");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Genero: " + genero);

    }



}
