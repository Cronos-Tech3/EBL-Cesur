package controlador;

import modelo.Cafe;

import java.sql.*;
import java.util.ArrayList;

public class CafeJDBC implements CafeDAO{
    private static final String SELECT_ALL = "select * from cafes";
    private static final String INSERT_ONE = "insert into cafes values (?,?,?,?,?)";


    private Connection con;

    public CafeJDBC (Connection con){
        this.con = con;
    }

    @Override
    public ArrayList<Cafe> verCafes() {
        ArrayList<Cafe> lista = new ArrayList<>();
        Statement stm = null;
        try {
            stm = con.createStatement();
            ResultSet filas = stm.executeQuery(SELECT_ALL);
            while(filas.next()){
                String nombre = filas.getString("CAF_NOMBRE");
                int proveedor = filas.getInt("PROV_ID");
                double precio = filas.getDouble("PRECIO");
                int venta = filas.getInt("VENTAS");
                double total = filas.getDouble("TOTAL");
                Cafe c = new Cafe(nombre, proveedor, precio, venta, total);
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            lista = null;
        }
        return lista;
    }

    @Override
    public int insertarCafe(Cafe c) {
        int resultado = 0;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(INSERT_ONE);
            pstm.setString(1, c.getNombre());
            pstm.setInt(2, c.getProveedor());
            pstm.setDouble(3, c.getPrecio());
            pstm.setInt(4, c.getVentas());
            pstm.setDouble(5, c.getTotal());
            resultado = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            resultado = -1;
        }
        return resultado;
    }

    @Override
    public int borrarCafe(String nombre) {
        return 0;
    }

    @Override
    public int actualizarVentasCafe(String nombre, int ventas) {
        return 0;
    }

    @Override
    public Cafe buscarCafePorNombre(String nombre) {
        return null;
    }

    @Override
    public Cafe cafeMarCaro() {
        return null;
    }

    @Override
    public Cafe cafeMarBarato() {
        return null;
    }

    @Override
    public Cafe cafeMasVendido() {
        return null;
    }

    @Override
    public double totalVentas() {
        return 0;
    }
}
