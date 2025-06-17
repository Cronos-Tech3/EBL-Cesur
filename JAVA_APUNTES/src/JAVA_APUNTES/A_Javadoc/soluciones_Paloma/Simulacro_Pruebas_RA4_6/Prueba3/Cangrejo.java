package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba3;

public class Cangrejo extends Marisco {
    private int numPatas;
    private boolean esGigante;

    // Constructor: se llama cuando creamos un nuevo Cangrejo
    public Cangrejo(String nombre, String habitat, boolean tieneConcha, Concha concha, int numPatas, boolean esGigante) {
        super(nombre, habitat, tieneConcha, concha); // Llamamos al constructor de Marisco para inicializar los atributos heredados
        this.numPatas = numPatas;
        this.esGigante = esGigante;
    }

    // Método para describir el desplazamiento (específico para Cangrejo)
    @Override // Indica que estamos sobrescribiendo un método de la clase padre
    public void desplazar() {
        if (esGigante) {
            System.out.println("El cangrejo se desplaza con sus pinzas.");
        } else {
            System.out.println("El cangrejo camina lateralmente.");
        }
    }

    // Método para describir la alimentación (específico para Cangrejo)
    @Override
    public String alimentarse() {
        return "El cangrejo come algas y otros pequeños animales.";
    }
}
