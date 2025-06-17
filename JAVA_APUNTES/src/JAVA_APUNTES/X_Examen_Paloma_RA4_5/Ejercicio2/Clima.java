package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class Clima {
    private String nombre;
    private String ubicacion;
    private HashMap<String, Double> temperaturas;

    public Clima(String nombre, String ubicacion, HashMap<String, Double> temperaturas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.temperaturas = temperaturas;
    }

    public boolean agregarTemperatura(String estacion, double temp){
        if(temperaturas.containsKey(estacion)){
            return false;
        }else{
            temperaturas.put(estacion, temp);
            return true;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double obtenerTemperatura(String estacion){
        if(temperaturas.containsKey(estacion)){
            return temperaturas.get(estacion);
        }else{
            return -1000;
        }
    }

    public double media(){
        double media = 0;
        for(double x : temperaturas.values()){
            media += x;
        }
        if(!temperaturas.isEmpty()){
            media/=temperaturas.size() ;
        }
        return media;
    }

    @Override
    public String toString() {
        return "Clima{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", temperaturas=" + temperaturas +
                '}';
    }
}
