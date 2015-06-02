/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Conexion.ConexionBD;
import logica.DetallePredio;
import logica.DetallePredioId;
import logica.DetalleSoat;
import logica.DetalleSoatId;


/**
 * Clase que permite realizar acciones sobre el detalle soat en la base de datos
 * @author LEIDY
 *
 */
public class DetalleSoatDao{  

	/**
	 * Método que permite ingresar un detalle nuevo en la base de datos
	 * @param detalleSoat
	 * @return
	 */
	public boolean guardarDetalleSoat(DetalleSoat detalleSoat){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO detalle_soat VALUES(?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setString(1, detalleSoat.getDetalleSoat());
			ppStm.setInt(2, detalleSoat.getId().getClienteCedula());
			ppStm.setString(3, detalleSoat.getId().getSoatNPlaca());

			ppStm.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
		return true;
	}  

	/**
	 * Método que permite actualizar la informacion en la base de datos
	 * @param detalleSoat
	 * @return
	 */
	public boolean actualizarDetalleSoat(DetalleSoat detalleSoat){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE detalle_soat SET"
					+ " Detalle_Soat = ? WHERE "
					+ "SOAT_N_Placa= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setString(1, detalleSoat.getDetalleSoat());
			ppStm.setString(2, detalleSoat.getId().getSoatNPlaca());

			ppStm.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
		return true;
	}  

	/**
	 * Método que permite eliminar el detalle del soat
	 * @param detalleSoat
	 * @return
	 */
	public boolean eliminarDetalleSoat(DetalleSoat detalleSoat){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM detalle_soat "
					+ "WHERE SOAT_N_Placa = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setString(1, detalleSoat.getId().getSoatNPlaca());

			ppStm.executeUpdate();

			conn.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}  

	/**
	 * Método que permite obtener el detalle del soat
	 * @param id
	 * @return
	 */
	public DetalleSoat obtenerDetalleSoat(DetalleSoatId id){ 
		DetalleSoat detalleSoat = null;  
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM detalle_soat "
					+ "WHERE SOAT_N_Placa = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setString(1, id.getSoatNPlaca());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				detalleSoat = new DetalleSoat();
				detalleSoat.setDetalleSoat(resultSet.getString(1));
				detalleSoat.setId(new DetalleSoatId(resultSet.getInt(2),
						resultSet.getString(3)));

			}else{
				return detalleSoat;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return detalleSoat; 
	}  

	public List<DetalleSoat> obtenListaDetalleSoat(){ 
		List<DetalleSoat> listaDetalleSoat = null;  
		return listaDetalleSoat; 
	}  

	//       public static void main(String[] args) {
	//           
	//        DetalleSoatDao daods = new DetalleSoatDao();
	//        ClienteDao daoc = new ClienteDao();
	//        SoatDao daos = new SoatDao();
	//        // Guardar
	//        //daods.guardaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"),"Carro"));
	//        // Actualizar
	//        //daods.actualizaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"), "Ferrary Modelo 2014"));
	//        //Borrar
	//        //daods.eliminaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"), null));
	//    }
}