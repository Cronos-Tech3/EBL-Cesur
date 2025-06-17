package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba2;

public class Cangrejo extends Marisco{
    private String especie;
    private int numOjos;

    // Constructor: se llama cuando creamos un nuevo Cangrejo
    public Cangrejo(String nombre, String habitat, boolean tieneConcha,String especie, int numOjos) {
        super(nombre, habitat, tieneConcha); // Llamamos al constructor de Marisco
        this.especie = especie;
        this.numOjos = numOjos;
    }

    // Método para describir el desplazamiento (específico para Cangrejo)
    @Override // Indica que estamos sobrescribiendo un método de la clase padre
    public void moverse() {
        System.out.println("El cangrejo se desplaza lateralmente.");
    }

    // Método para describir la alimentación (específico para Cangrejo)
    @Override
    public String comer() {
        return "El cangrejo come algas y otros pequeños animales.";
    }

    public String getEspecie() {
        return especie;
    }

    public int getNumOjos() {
        return numOjos;
    }
}
