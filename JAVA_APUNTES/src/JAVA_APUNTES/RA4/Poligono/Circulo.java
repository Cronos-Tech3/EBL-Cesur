package JAVA_APUNTES.RA4.Poligono;

public class Circulo extends Poligono {

    //pi * r al cuadrado

    // el perimetro de un circulo se calcula 2pir


    public double radio;


    public Circulo(double perimetro, double apotema, double radio) {
        super(perimetro, apotema);
    }

    public double calcularArea() {
        double area =(Math.PI)*Math.pow(radio,2);
        return area;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                ", perimetro=" + perimetro +
                ", apotema=" + apotema +
                '}';
    }
}
