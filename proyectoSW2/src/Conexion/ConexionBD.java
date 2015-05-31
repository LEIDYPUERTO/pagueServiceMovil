package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase permite establecer la conexión con la base de datos
 * @author LEIDY
 *
 */
public class ConexionBD {
	
	private static final String URL = "jdbc:mysql://localhost/pague_services";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "";
	
	/**
	 * Método que permite realizar la conexion
	 * @return
	 * @throws SQLException
	 */
	public static Connection obtenerConexion() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
	}

}
