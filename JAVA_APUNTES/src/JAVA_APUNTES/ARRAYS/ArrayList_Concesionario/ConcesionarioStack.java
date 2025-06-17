package JAVA_APUNTES.ARRAYS.ArrayList_Concesionario;

import java.util.Stack;

public class ConcesionarioStack {

    private String nombreConcesionario;

    private String direccionFisica;

    private String telefono;

    private int cantidadVehiculos;

    private Stack<Vehiculo> inventario;


    public ConcesionarioStack(String nombreConcesionario, String direccionFisica, String telefono) {

        this.nombreConcesionario = nombreConcesionario;
        this.direccionFisica = direccionFisica;
        this.telefono = telefono;

        inventario = new Stack<Vehiculo>();
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

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public Stack<Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(Stack<Vehiculo> inventario) {
        this.inventario = inventario;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo){
        cantidadVehiculos++;
        return inventario.add(vehiculo);
    }

    public void quitarUltimo() {
        inventario.pop();
    }

    public boolean quitarVehiculo(int posicion){
        if (posicion>=0 && posicion< inventario.size()){
            inventario.remove(posicion);
            cantidadVehiculos--;
            return true;
        }
        return false;
    }

    public void mostrarInventario(){

        for (Vehiculo v : inventario) {
            if (v!=null){
              //  System.out.println(v.mostrarInventario());  //Todo  Aqui faltan cosas
            }

        }



    }

}
