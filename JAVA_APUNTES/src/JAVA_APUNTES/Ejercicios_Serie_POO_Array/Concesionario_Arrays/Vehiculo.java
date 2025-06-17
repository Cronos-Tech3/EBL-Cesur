package JAVA_APUNTES.Ejercicios_Serie_POO_Array.Concesionario_Arrays;

public class Vehiculo {

    //Atributos de la clase Vehiculo

    private String marca;

    private String modelo;

    private int anio;

    private double precio;

    public Vehiculo(String marca, String modelo, int anio, double precio) {  //constructor
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }
    //getter and setter generados porque son atributos Privados, porque se va a instanciar Vehiculo en la clase Main

    //getter para llamar al atributo //setter para poder cambiar el valor del atributo
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    // metodos mostrarDetalles --> con sout
    public void mostrarDetalles(){
        System.out.println(marca);
        System.out.println(modelo);
        System.out.println(anio);
        System.out.println(precio);
    }

    // mostrarDetalles2 sin sout toString
    // sino esta el toString el metodo con this solo nos mostraria la unidad de memoria

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                '}';
    }
    //Una vez tenemos el toString creamos el metodo llamando al toString
    public void mostrarDetalles2() {
        System.out.println(this);
     }




    //metodo para calcularImpuesto
    public double calcularImpuesto(){

        double resultado = 0.10*precio;   // el tipo de dato que devuelva debe ser el mismo que se pide en el metodo

        return resultado;
    }
}
