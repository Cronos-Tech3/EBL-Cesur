package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba3;

public class Almeja extends Marisco{
    private boolean tienePerla;
    private String formaConcha;
    public Almeja(String nombre, String habitat, boolean tieneConcha, Concha concha, boolean tienePerla, String formaConcha) {
        super(nombre, habitat, tieneConcha, concha); // Llamamos al constructor de Marisco
        this.tienePerla = tienePerla;
        this.formaConcha = formaConcha;
    }

    // Método para describir el desplazamiento (específico para Almeja)
    @Override // Indica que estamos sobrescribiendo un método de la clase padre
    public void desplazar() {
        System.out.println("La almeja se mueve excavando en la arena.");
    }

    // Método para describir la alimentación (específico para Almeja)
    @Override
    public String alimentarse() {
        return "La almeja filtra partículas del agua.";
    }

    public boolean isTienePerla() {
        return tienePerla;
    }

    public String getFormaConcha() {
        return formaConcha;
    }
}
