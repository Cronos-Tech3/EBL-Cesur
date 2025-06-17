package RA4_POO;

public class Libro {

    public String titulo;
    public String autor;
    public int paginas;

    public boolean esLibroExtenso() {
        if (paginas > 300) {
            return true;
        } else {
            return false;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Paginas: " + this.paginas);

    }
}
