package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio2;


import java.util.Stack;

public class GestorAnimales {
    private static Stack<Animal> animales = new Stack<>();

    public static void main(String[] args) {
        // Crear perros
        Perro perro1 = new Perro("Toby", 5, "Carnívora", true, "Labrador", true);
        Perro perro2 = new Perro("Max", 3, "Omnívora", false, "Beagle", false);

        // Crear gatos
        Gato gato1 = new Gato("Luna", 2, "Carnívora", true, "Negro", true);
        Gato gato2 = new Gato("Simba", 4, "Omnívora", false, "Marrón", false);

        // Añadir animales al stack
        animales.push(perro1);
        animales.push(perro2);
        animales.push(gato1);
        animales.push(gato2);

        // Iterar y mostrar animales
        for (Animal animal : animales) {
            System.out.println("Nombre: " + animal.nombre);
            System.out.println("Edad: " + animal.edad);
            System.out.println("Tipo de alimentación: " + animal.tipoAlimentacion);
            System.out.println("Tiene cola: " + animal.tieneCola);
            animal.hacerSonido();
            System.out.println("Movimiento: " + animal.moverse());
            System.out.println();
        }
    }
}
