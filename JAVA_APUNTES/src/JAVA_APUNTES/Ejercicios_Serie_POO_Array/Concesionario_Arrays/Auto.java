package JAVA_APUNTES.Ejercicios_Serie_POO_Array.Concesionario_Arrays;

public class Auto extends Vehiculo {
    //Clase auto es herencia de Vehiculo que seria la clase padre, extends es la palabra que se usa para la herencia
    //auto es un tipo especifico de vehiculo

    //atributos de auto
    private int puertas;

    private boolean electrico;

    //constructor de Auto con su herencia
    public Auto(String marca, String modelo, int anio, double precio, int puertas, boolean electrico) {
        super(marca, modelo, anio, precio);  //super hace referencia a la clase que hereda
        this.puertas = puertas;
        this.electrico = electrico;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }


    //metodo calcularDescuento
    public double calcularDescuento() {
        /* Primera forma con if y contador
        double descuento = 0;
        double precioDescuento=0;

        if (electrico){

            descuento = getPrecio()*0.2;
        }else {

            descuento = getPrecio()*0.1;
        }
        return precioDescuento;
        */
        //operador ternario
        return (electrico)?getPrecio()*0.2:getPrecio()*0.1;
    }
}
