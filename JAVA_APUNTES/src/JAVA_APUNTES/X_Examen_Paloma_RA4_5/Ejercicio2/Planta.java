package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio2;

public class Planta {
    protected String especie;
    protected double altura;
    protected boolean frutos;
    protected double cantidad_regada;

    public Planta(String especie, double altura, boolean frutos) {
        this.especie = especie;
        this.altura = altura;
        this.frutos = frutos;
        this.cantidad_regada = 0;
    }

    public double regar(int cantidad){
        return 0;
    }

    public int producir_frutos(){
        return 0;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "especie='" + especie + '\'' +
                ", altura=" + altura +
                ", frutos=" + frutos +
                ", cantidad_regada=" + cantidad_regada +
                '}';
    }
}
