package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Connect {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/xilften?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "system";

	public static void main(String[] args) {


		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//paso 2: Register JDBC driver a partir de JDK 6 ya no hace falta
			//Class.forName(JDBC_DRIVER);

			//paso 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//paso 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.prepareStatement("select * from GENEROS");

			//stmt.setFloat(1, (float) 1.1);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String nombreGenero = rs.getString("nombreGenero");
				double idGen = rs.getFloat("idGenero");
				String descripcionGenero = rs.getString("descripcionGenero");

				//Genero gen = new Genero(idGen, nombreGenero, descripcionGenero);
				System.out.print("ID: " + idGen);
				System.out.print(", name: " + nombreGenero);
				System.out.println(", desc: " + descripcionGenero);
			}

			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main
}