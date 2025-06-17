package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio1;

import java.util.Arrays;

public class Pulpo {
    public String nombre;
    public Tentaculo[] tentaculos;

    public Pulpo(String nombre) {
        this.nombre = nombre;
        this.tentaculos = new Tentaculo[8];
    }

    public int anadirTentaculo(Tentaculo tentaculo){
        //[t1, null, t3, null, null]
        boolean insertado = false;
        for (int i = 0; i < tentaculos.length; i++) {
            if(tentaculos[i]==null){
                tentaculos[i] = tentaculo;
                insertado = true;
            }else{
                if(tentaculos[i].getId()==tentaculo.getId()){
                    return -1;
                }
            }
        }
        int cont = 0;
        if(insertado){
            for (int i = 0; i < tentaculos.length; i++) {
                if(tentaculos[i]!=null){
                    cont++;
                }
            }
            return cont;
        }

        return -1;
    }

    public int crecerTentaculo(int id, int longitud){
        for (int i = 0; i < tentaculos.length; i++) {
            if(tentaculos[i]!=null && tentaculos[i].getId()==id){
                return tentaculos[i].crecer(longitud);
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String frase = "Pulpo {" + nombre + "}:";

        for (int i = 0; i < tentaculos.length; i++) {
            if(tentaculos[i]!=null){
                frase += tentaculos[i] + ", ";
            }
        }

        return frase.substring(0, frase.length()-2);
    }
}
