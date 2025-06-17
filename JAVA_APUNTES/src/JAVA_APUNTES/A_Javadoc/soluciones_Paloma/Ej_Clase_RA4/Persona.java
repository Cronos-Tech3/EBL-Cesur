package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Clase_RA4;

public class Persona {
    public String nombre;
    public int edad;
    public double estatura;

    public Persona(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    public void saludar(){
        System.out.println("Hola " + nombre + "!!");
    }

    public void cumplirAnios(){
        edad++;
    }

    public void crecer(double num){
        estatura+=num;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", estatura=" + estatura +
                '}';
    }
}
