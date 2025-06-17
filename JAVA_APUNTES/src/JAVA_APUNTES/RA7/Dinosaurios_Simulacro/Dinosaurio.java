package JAVA_APUNTES.RA7.Dinosaurios_Simulacro;

import java.util.ArrayList;

public class Dinosaurio extends CaracteristicaDino implements ICaracterizable, IVolador{

    private String nombre;
    private int alturaMaxima;
    private ArrayList<String> caracteristicas;

    public Dinosaurio(String descripcion, int edad, String color, double longitud, String nombre, int alturaMaxima) {
        super(descripcion, edad, color, longitud);
        this.nombre = nombre;
        this.alturaMaxima = alturaMaxima;
        this.caracteristicas = new ArrayList<>();
    }

    @Override
    public void agregarCaracteristica(String caracteristica) {
        caracteristicas.add(caracteristica);
        System.out.println("se ha agregado correctamente");
    }

    @Override
    public int eliminarCaracteristica(String caracteristica) {
        for (int i = 0; i < caracteristicas.size(); i++) {
            if(caracteristicas.get(i).equals(caracteristica)){
                caracteristicas.remove(i);
                System.out.println("Se ha eliminado correctamente");
                return i;
            }
        }
        return -1;
    }

    @Override
    public void mostrarCaracteristicas() {
        for(String c : caracteristicas){
            System.out.println(c);
        }
        //System.out.println(caracteristicas); //[dnaobsd, akjsbdais]
    }

    @Override
    public void despegar() throws AlturaInsuficienteException {
        if(alturaMaxima>=50){
            System.out.println("Despega y vuela");
        }else{
            throw new AlturaInsuficienteException();
        }
    }

    @Override
    public int calcularAlturaMaxima(int velocidad, int tiempo) throws AlturaInsuficienteException {
        int altura = velocidad * tiempo;
        if(altura>=50){
            return altura;
        }else{
            throw new AlturaInsuficienteException();
        }
    }

    @Override
    public int calcularDistanciaRecorrida(int velocidad, int tiempo) {
        return velocidad*tiempo;
    }
}
