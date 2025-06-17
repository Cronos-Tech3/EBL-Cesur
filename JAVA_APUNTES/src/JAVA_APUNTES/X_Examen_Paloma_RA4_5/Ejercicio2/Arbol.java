package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio2;

public class Arbol extends Planta{
    private String tipoHoja;
    private double diametro;

    public Arbol(String especie, double altura, boolean frutos, String tipoHoja, double diametro) {
        super(especie, altura, frutos);
        this.tipoHoja = tipoHoja;
        this.diametro = diametro;
    }

    @Override
    public int producir_frutos(){
        if(frutos){
            return (int) (altura*diametro);
        }
        return -1;
    }

    @Override
    public double regar(int cantidadRecibida){
        this.cantidad_regada += cantidadRecibida;
        altura += cantidadRecibida*0.02;
        diametro += cantidadRecibida*0.01;
        return altura;
    }

    public boolean caer_hojas(){
        if(tipoHoja.equals("caduca")){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "tipoHoja='" + tipoHoja + '\'' +
                ", diametro=" + diametro +
                ", especie='" + especie + '\'' +
                ", altura=" + altura +
                ", frutos=" + frutos +
                ", cantidad_regada=" + cantidad_regada +
                '}';
    }
}
