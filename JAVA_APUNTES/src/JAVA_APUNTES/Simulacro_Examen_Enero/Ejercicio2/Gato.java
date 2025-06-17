package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio2;

class Gato extends Animal {
    private String colorPelaje;
    private boolean cazaRatones;

    public Gato(String nombre, int edad, String tipoAlimentacion, boolean tieneCola, String colorPelaje, boolean cazaRatones) {
        super(nombre, edad, tipoAlimentacion, tieneCola);
        this.colorPelaje = colorPelaje;
        this.cazaRatones = cazaRatones;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miau. ");
        if (cazaRatones){
            System.out.println(" Esta cazando");
        } else {
            System.out.println("No caza ");
        }
    }
}
