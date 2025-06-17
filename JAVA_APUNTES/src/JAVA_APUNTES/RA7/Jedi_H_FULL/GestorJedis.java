package JAVA_APUNTES.RA7.Jedi_H_FULL;

public class GestorJedis {
    public static void main(String[] args){

        // Creación de los Jedi //
        /*
         -- Atributos de cada jedi--
            Nombre, Edad, Nivel de fuerza, Color de sable
         */
        Jedi jedi1 = new Jedi("Hector", 45, 60, "verde");
        Jedi jedi2 = new Jedi("Pablo", 15, 20, "azul");
        Jedi jedi3 = new Jedi("Jorge", 75, 5, "Gris");

        // Creación de habiliades
        /* Cada habilidad tiene como atributos:
            Nombre, Potncia
        */
        Habilidad h1 = new Habilidad("Tornado", 10);
        Habilidad h2 = new Habilidad("Fuego", 25);
        Habilidad h3 = new Habilidad("Hielo", 30);

        //ASIGNACIÓN DE HABILIDADES A LOS JEDIS  JEDIS//
        jedi1.agregarHabilidad(h1);
        jedi1.agregarHabilidad(h2);
        jedi1.agregarHabilidad(h3);
        jedi2.agregarHabilidad(h1);
        jedi2.agregarHabilidad(h2);
        jedi2.agregarHabilidad(h3);
        jedi3.agregarHabilidad(h1);
        jedi3.agregarHabilidad(h2);

        try{

            //Calculamos la suma de la potencia de las habilidades
            System.out.println("Esta es la suma de la potencia de las habilidades del Jedi1: " + jedi1.calcularSumaPotenciaHabilidades());

            // Eliminación de habilidades
            if(jedi1.eliminarHabilidad("Tornado")) System.out.println("Habilidad eliminada exitosamente");
                else System.out.println("Habilidad no encontrada");
            if(jedi1.eliminarHabilidad("Fuego")) System.out.println("Habilidad eliminada exitosamente");
                else System.out.println("Habilidad no encontrada");
            if(jedi1.eliminarHabilidad("hiel")) System.out.println("Habilidad eliminada exitosamente");
                else System.out.println("Habilidad no encontrada");

            // Agreamos una habilidad de nuevo y la exponemos
            jedi1.agregarHabilidad(h1);
            jedi1.mostrarHabilidades();
            System.out.println("-------------------------");

            // Asignación de los usus de fuerza a cada Jedi
            jedi1.usarFuerza();
            jedi2.usarFuerza();

            // Bloque try-catch para el manejo de ambas excepciones
            // SinHabilidadesException y PotenciaInsuficienteException
        }catch (SinHabilidadesException | PotenciaInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}
