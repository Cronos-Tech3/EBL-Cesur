package RA4_POO;

public class Vehículo {

    public String marca;
    public String modelo;
    public int velicadadMax;

    public void puedeParticiparCarrera (int velocidadMinima){

        if (velicadadMax < velocidadMinima){
            System.out.println("No cumple con los requisitos mínimos");

        }else {
            System.out.println("Si cumple con los requisitos.Puede participar");

        }
    }

    public void mostrarDatos(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad: " + velicadadMax);
    }


}
