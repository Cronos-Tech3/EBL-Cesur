package JAVA_APUNTES.RA6;

import java.util.ArrayList;

public class ConcesionarAL {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Vehiculo> inventario;
    private int cantidadVehiculos;

    public ConcesionarAL(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        inventario = new ArrayList<Vehiculo>();
        //cantidadVehiculos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Vehiculo> inventario) {
        this.inventario = inventario;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo){
        cantidadVehiculos++;
        inventario.add(vehiculo);
        return true;
    }

    public boolean quitarVehiculo(int posicion){
        if(posicion>=0 && posicion< inventario.size()){
            inventario.remove(posicion);
            cantidadVehiculos--;
            return true;
        }
        return false;
    }

    public void mostrarInventario(){
        //System.out.println(inventario); //también vale así
        for(Vehiculo v : inventario){
            if(v!=null){
                System.out.println(v.generarDetalles());
            }
        }
    }
}
