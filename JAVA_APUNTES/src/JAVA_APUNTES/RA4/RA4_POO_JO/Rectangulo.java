package RA4_POO;

public class Rectangulo {

    private double base;
    private double altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calculoArea(){
        return base * altura;
    }

    public boolean  esCuadrado () {
        if (base == altura) {
            System.out.println("Es un cuadrado");
        }
        return false;
    }


}
