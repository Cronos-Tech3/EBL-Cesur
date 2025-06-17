import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    public String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    public String user = "admin";
    public String pass = "admin";
    public String ip = "192.168.56.101";
    public String port = "3306";
    public String database_name = "acceso";
    public String params = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    public Conexion(String jdbc_driver, String user, String pass, String ip, String port, String database_name, String params) {
        this.jdbc_driver = jdbc_driver;
        this.user = user;
        this.pass = pass;
        this.ip = ip;
        this.port = port;
        this.database_name = database_name;
        this.params = params;
    }

    public Conexion(String user, String pass, String database_name) {
        this.user = user;
        this.pass = pass;
        this.database_name = database_name;
    }

    public Conexion(String database_name) {
        this.database_name = database_name;
    }

    public Conexion(){}

    public Connection getConnection(){
        Connection conn = null;
        PreparedStatement stmt = null;

        String url = "jdbc:mysql://" + this.ip + ":" + this.port + "/" + this.database_name + this.params;
        try {
            conn = DriverManager.getConnection(url,this.user,this.pass);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

}
