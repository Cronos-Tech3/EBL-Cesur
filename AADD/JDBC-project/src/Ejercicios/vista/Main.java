package vista;

import controlador.CafeJDBC;
import modelo.Cafe;
import modelo.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            Conexion c = new Conexion();
            Connection con = c.crearConexion();
            CafeJDBC controlador = new CafeJDBC(con);

            controlador.insertarCafe(new Cafe("pruebas", 101, 10, 5, 50));

            ArrayList<Cafe> cafes = controlador.verCafes();
            if(cafes==null){
                System.out.println("Ha habido un error");
            }else{
                if(cafes.isEmpty()){
                    System.out.println("No hay cafés almacenados");
                }else{
                    for(Cafe caf : cafes){
                        System.out.println(caf);
                    }
                }
            }

            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}