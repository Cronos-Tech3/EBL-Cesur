package controlador;

import modelo.Cafe;

import java.util.ArrayList;

public interface CafeDAO {
    ArrayList<Cafe> verCafes();
    int insertarCafe(Cafe c);
    int borrarCafe(String nombre);
    int actualizarVentasCafe(String nombre, int ventas);
    Cafe buscarCafePorNombre(String nombre);
    Cafe cafeMarCaro();
    Cafe cafeMarBarato();
    Cafe cafeMasVendido();
    double totalVentas();

}
