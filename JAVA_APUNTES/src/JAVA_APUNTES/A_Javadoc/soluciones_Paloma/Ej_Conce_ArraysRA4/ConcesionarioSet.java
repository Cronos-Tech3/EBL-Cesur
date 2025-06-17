package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Conce_ArraysRA4;
import java.util.HashSet;

public class ConcesionarioSet {
    private String nombre;
    private String direccion;
    private String telefono;
    private HashSet<Vehiculo> inventario;
    private int cantidadVehiculos;

    public ConcesionarioSet(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        inventario = new HashSet<Vehiculo>();
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

    public HashSet<Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(HashSet<Vehiculo> inventario) {
        this.inventario = inventario;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo){
        boolean resultado = false;
        //si no existe ese elemento lo añade, si existe no lo añade
        if(inventario.add(vehiculo)){
            cantidadVehiculos++;
            resultado = true;
        }
        return resultado;
    }

    public boolean quitarVehiculo(Vehiculo vehiculo){
        //si existe lo borro
        if(inventario.remove(vehiculo)){
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
