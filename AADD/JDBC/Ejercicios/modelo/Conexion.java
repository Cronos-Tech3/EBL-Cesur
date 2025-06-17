package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String dbuser = "root";
    private String dbpass = "";
    private String url = "jdbc:mysql://localhost/accesodatos";

    public Conexion(){}

    public Conexion(String dbuser, String dbpass, String url) {
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.url = url;
    }
    public Connection crearConexion(){
        Connection con;
        try {
            con = DriverManager.getConnection(url, dbuser, dbpass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            con = null;
        }
        return con;
    }
}
