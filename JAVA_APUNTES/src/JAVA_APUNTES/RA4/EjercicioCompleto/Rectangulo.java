package RA4_POO.EjercicioPOO.POO_Ej1;

public class Rectangulo {

    public int base;
    public int altura;

    public void calculoArea(int area) {
         area= base*altura;
        System.out.println(area);
    }

    public void esCuadrado (){
        if (base == altura){
            System.out.println("Es un cuadrado");
        }
    }

}
