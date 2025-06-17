package JAVA_APUNTES.RA6;

import java.util.Stack;

public class ConcesionarioStack {
    private String nombre;
    private String direccion;
    private String telefono;
    private Stack<Vehiculo> inventario;
    private int cantidadVehiculos;

    public ConcesionarioStack(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        inventario = new Stack<Vehiculo>();
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

    public Stack<Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(Stack<Vehiculo> inventario) {
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
        //inventario.push(vehiculo);
        return true;
    }

    public void quitarUltimo(){
        inventario.pop();
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
