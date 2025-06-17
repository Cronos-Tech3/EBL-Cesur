package JAVA_APUNTES.RA4.Poligono;

public class Cuadrado {

    // lado al cuadrado
    //perimetro 4*lado
    public double lado;

    public double calcularArea() {
        double area = lado*lado;
        return area;
    }

    public double calcularPerimetro(){
        double perimetro= lado*lado*lado*lado;
        return perimetro;
    }

    @Override
    public String toString() {
        return "Cuadrado{" +
                "lado=" + lado +
                '}';
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }
}
