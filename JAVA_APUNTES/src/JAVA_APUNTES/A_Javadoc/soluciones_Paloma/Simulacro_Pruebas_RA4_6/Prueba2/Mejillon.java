package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba2;

class Mejillon extends Marisco {
    private String tipoCuerda;
    private boolean esDeRoca;

    // Constructor: se llama cuando creamos un nuevo Mejillón
    public Mejillon(String nombre, String habitat, boolean tieneConcha,String tipoCuerda, boolean esDeRoca) {
        super(nombre, habitat, tieneConcha); // Llamamos al constructor de Marisco
        this.tipoCuerda = tipoCuerda;
        this.esDeRoca = esDeRoca;
    }

    // Método para describir el desplazamiento (específico para Mejillón)
    @Override // Indica que estamos sobrescribiendo un método de la clase padre
    public void moverse() {
        System.out.println("El mejillón se adhiere a las rocas y no se desplaza activamente.");
    }

    // Método para describir la alimentación (específico para Mejillón)
    @Override
    public String comer() {
        return "El mejillón se alimenta filtrando partículas del agua.";
    }

    public String getTipoCuerda() {
        return tipoCuerda;
    }

    public boolean isEsDeRoca() {
        return esDeRoca;
    }
}