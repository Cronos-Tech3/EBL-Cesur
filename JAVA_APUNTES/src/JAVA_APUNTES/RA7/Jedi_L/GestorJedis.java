package JAVA_APUNTES.RA7.Jedi_L;

public class GestorJedis {
    public static void main(String[] args) {


        Jedi j1 = new Jedi("Luis", 28, 70, "azul");
        Jedi j2 = new Jedi("Pablo", 16, 90, "rojo");
        Jedi j3 = new Jedi("Javier", 22, 100, "verde");
        Habilidad habilidad = new Habilidad("Super Fuerza", 40);
        Habilidad habilidad2 = new Habilidad("Invisibilidad", 60);
        Habilidad habilidad3 = new Habilidad("Volar", 49);
        Habilidad habilidad4 = new Habilidad("Inmortalidad", 50);
        j1.agregarHabilidad(habilidad);
        j2.agregarHabilidad(habilidad2);
        j2.agregarHabilidad(habilidad3);
        j2.agregarHabilidad(habilidad4);
        j2.calcularSumaPotenciaHabilidades();
        System.out.println("la suma de habilidades es: "+ j2.calcularSumaPotenciaHabilidades());
        try {
            j2.eliminarHabilidad("Volar");
            j1.eliminarHabilidad("Super Fuerza");
j2.mostrarHabilidades();
        } catch (SinHabilidadesException she) {
            System.out.println(she.getMessage());
        }
j2.obtenerHabilidadPotenciaMaxima();
        try {
            j2.usarFuerza();
        }
        catch(PotenciaInsuficienteException pie){
            System.out.println(pie.getMessage());
        }
        j2.calcularSumaPotenciaHabilidades();
        System.out.println(j2.calcularSumaPotenciaHabilidades());
    }
}
