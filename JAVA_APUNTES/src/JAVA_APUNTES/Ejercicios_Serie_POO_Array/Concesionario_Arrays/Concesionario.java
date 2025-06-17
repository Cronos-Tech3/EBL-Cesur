package JAVA_APUNTES.Ejercicios_Serie_POO_Array.Concesionario_Arrays;

import java.util.Arrays;

public class Concesionario {

    //atributos de concesionario
    private String nombreConcesionario;
    private String direccionFisica;
    private String telefono;

    private Vehiculo[] inventario;  //array Lista fija no es un array list por ser lista fija
    private int cantidadVehiculos;

    //generamos constructor con nombre direccion y telefono
    public Concesionario(String nombreConcesionario, String direccionFisica, String telefono, int capacidad) {  //le añadimos int capacidad numero que sera el limite del array, dar un tamaño al array
        this.nombreConcesionario = nombreConcesionario;
        this.direccionFisica = direccionFisica;
        this.telefono = telefono;
        inventario = new Vehiculo[capacidad];  // Aqui llamamos al array
    }

    public String getNombreConcesionario() {

        return nombreConcesionario;
    }

    public void setNombreConcesionario(String nombreConcesionario) {

        this.nombreConcesionario = nombreConcesionario;
    }

    public String getDireccionFisica() {

        return direccionFisica;
    }

    public void setDireccionFisica(String direccionFisica) {

        this.direccionFisica = direccionFisica;
    }

    public String getTelefono() {

        return telefono;
    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    public Vehiculo[] getInventario() {
        return inventario;
    }

    public void setInventario(Vehiculo[] inventario) {
        this.inventario = inventario;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    //metodos

    public boolean agregarVehiculo(Vehiculo vehiculo){


        boolean resultado = false;
        /*
        if (cantidadVehiculos<inventario.length){   //este codigo es valido porque no quita vehiculos
            inventario[cantidadVehiculos] = vehiculo;
            resultado = true;
        }
        */
        //for i seria el metodo adecuado para recorrer el array y encontrar y cambiar el factor nulo
        //recorro mi inventario y si alguno de los valores es nulo cambio el valor de ese nulo y se añade un vehiculo nuevo
        for (int i=0; i < inventario.length;i++){
            if (inventario[i]==null){
                inventario[i] = vehiculo;
                cantidadVehiculos++;
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    // mostrar inventario
    public void mostrarInventario(){
        System.out.println(Arrays.toString(inventario));

        /*
        for (Vehiculo v : inventario){
            System.out.println(v.mostrarDetalles2());
        }
        */


    }

    //metodo quitarVehiculo

    public boolean quitarVehiculo(int posicion){ //va a pasar una posicion
        boolean resultado = false;


        if (posicion < inventario.length && posicion>=0){
            if (inventario[posicion] !=null){
                inventario[posicion] = null;
                resultado = true;
                resultado = true;
                cantidadVehiculos--;
            }

        }

        //try catch



        for (int i = 0; i < inventario.length; i++){


        }


     return resultado;
    }
}


