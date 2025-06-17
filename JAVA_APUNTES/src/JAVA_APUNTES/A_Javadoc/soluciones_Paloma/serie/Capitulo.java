package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.serie;

public class Capitulo {
    private String titulo;
    private String fecha;
    private String duracion;
    private double valoracion;
    private int numero;

    public Capitulo(String titulo, String fecha, String duracion, double valoracion, int numero) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Capitulo{" +
                "titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", duracion='" + duracion + '\'' +
                ", valoracion=" + valoracion +
                ", numero=" + numero +
                '}';
    }
}
