package JAVA_APUNTES.Ejercicios_Serie_POO_Array;

public class Capitulo {

    private String titulo;   //variables en minusculas

    private String fechaEstreno;

    private double valoracion;

    private String duracion;

    public Capitulo(String titulo, String fechaEstreno, double valoracion, String duracion) {
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        this.valoracion = valoracion;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Capitulo{" +
                "titulo='" + titulo + '\'' +
                ", fechaEstreno='" + fechaEstreno + '\'' +
                ", valoracion=" + valoracion +
                ", duracion='" + duracion + '\'' +
                '}';
    }
}
