package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio2;

public class Arbusto extends Planta{
    private boolean flores;
    private Clima clima;

    public Arbusto(String especie, double altura, boolean frutos, boolean flores, Clima clima) {
        super(especie, altura, frutos);
        this.flores = flores;
        this.clima = clima;
    }

    @Override
    public int producir_frutos(){
        if(frutos){
            return (int) (2*altura/0.5);
        }
        return -1;
    }

    @Override
    public double regar(int cantidadRecibida){
        this.cantidad_regada += cantidadRecibida;
        double devolver = 0;

        if(this.clima.media() > 15){
            devolver = cantidadRecibida*0.01;
        }else{
            devolver = cantidadRecibida*0.02;
        }
        altura += devolver;

        return devolver;
    }

    public double podar(){
        altura -= 0.05;
        return altura;
    }

    public boolean florece(){
        if(flores && !clima.getNombre().equals("seco")){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Arbusto{" +
                "flores=" + flores +
                ", clima=" + clima +
                ", especie='" + especie + '\'' +
                ", altura=" + altura +
                ", frutos=" + frutos +
                ", cantidad_regada=" + cantidad_regada +
                '}';
    }
}
