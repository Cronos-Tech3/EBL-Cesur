package JAVA_APUNTES.RA4.Clase;

public class Persona {

    //atributos

    public String nombre;
    public int edad;
    public double estatura;


    public Persona(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    public Persona(){

    }

    public void cumplirAnios(){
        edad++;
    }

    public void crecer(double num){
        estatura+=num;

    }

    public void saludar(){
        System.out.println("Hola " + nombre + " !!");
    }

    // boton derecho generar toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", estatura=" + estatura +
                '}';
    }



}

