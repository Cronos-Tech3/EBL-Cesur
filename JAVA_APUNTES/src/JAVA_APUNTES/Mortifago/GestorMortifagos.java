package Enrique_Benito_Lopez;

public class GestorMortifagos {
    public static void main(String[] args) {
        // añadimos mortifagos 3
        Mortifago mortifago1 = new Mortifago("Enrique", 31, 150, "Vampirica-Maestra");
        Mortifago mortifago2 = new Mortifago("Juan", 30, 180, "Sol-Roja");
        Mortifago mortifago3 = new Mortifago("David", 31, 120, "Lunar");

        // creamos hechizos
        Hechizo hechizo1 = new Hechizo("AlojoMora", 90);
        Hechizo hechizo2 = new Hechizo("Abadacadabra", 150);
        Hechizo hechizo3 = new Hechizo("Turticulis", 50);

        // Agignamos hechizos

        mortifago1.agregarHechizo(hechizo1);
        mortifago1.agregarHechizo(hechizo2);
        mortifago1.agregarHechizo(hechizo3);

        try{

            System.out.println("La media de la Potencia del Mortifago1 es:  " + mortifago1.calcularMediaPotenciaHechizos());

            if (mortifago1.eliminarHechizo("Turticulis")) System.out.println("habilidad eliminada exitosamente");
                else System.out.println("Habilidad no encontrada");
            if (mortifago1.eliminarHechizo("AlojoMora")) System.out.println("Habilidad eliminada exitosamente");
                else System.out.println("Habilidad no encontrada");


             mortifago1.agregarHechizo(hechizo1);
             mortifago1.agregarHechizo(hechizo3);

             mortifago1.usarHechizo();

        } catch (PotenciaInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (SinHechizosException e) {
            throw new RuntimeException(e);
        }

    }
}
