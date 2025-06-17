package JAVA_APUNTES.RA4.Poligono;

public class Poligono {
    // perimetro * apotema dividido entre 2

    public double perimetro;
    public double apotema;

    public double calcularArea(){
      double area= perimetro * apotema / 2;
      return area;
    }

    public void calcularPerimetro(){
        double perimetro;
        return;

    }


    public Poligono(double perimetro, double apotema) {
        this.perimetro = perimetro;
        this.apotema = apotema;
    }

    @Override
    public String toString() {
        return "Poligono{" +
                "perimetro=" + perimetro +
                ", apotema=" + apotema +
                '}';
    }
}
