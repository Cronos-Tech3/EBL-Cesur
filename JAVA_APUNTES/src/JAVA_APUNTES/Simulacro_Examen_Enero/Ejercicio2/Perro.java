package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio2;


class Perro extends Animal {
    private String raza;
    private boolean ladra;

    public Perro(String nombre, int edad, String tipoAlimentacion, boolean tieneCola, String raza, boolean ladra) {
        super(nombre, edad, tipoAlimentacion, tieneCola);
        this.raza = raza;
        this.ladra = ladra;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }
}
