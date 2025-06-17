import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbuser = "root";
        String dbpass = "1234";
        String url = "jdbc:mysql://localhost/accesodatos";
        //Si la zona horaria no es compatible tenemos que añadir el siguiente codigo
        String params = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        try {
            Connection con = DriverManager.getConnection(url+params, dbuser, dbpass);
            Statement stm = con.createStatement();
            ResultSet filas = stm.executeQuery("select * from cafes");
            while(filas.next()){
                System.out.println(filas.getString("CAF_NOMBRE"));
            }
            filas.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}