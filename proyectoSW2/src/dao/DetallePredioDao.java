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
import logica.DetalleCamara;
import logica.DetalleCamaraId;
import logica.DetallePredio;
import logica.DetallePredioId;

/**
 * Clase que permite realizar acciones sobre detallePredio en la 
 * base de datos
 * @author LEIDY
 *
 */
public class DetallePredioDao{  

	/**
	 * Método que permite almacenar la informacion en la base de datos
	 * @param detallePredio
	 * @return
	 */
	public boolean guardaDetallePredio(DetallePredio detallePredio){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO detalle_predio VALUES(?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setString(1, detallePredio.getDescripcionPredio());
			ppStm.setInt(2, detallePredio.getId().getClienteCedula());
			ppStm.setInt(3, detallePredio.getId().getImpuestoPredialNPredio());

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
	 * @param detallePredio
	 * @return
	 */
	public boolean actualizaDetallePredio(DetallePredio detallePredio){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE detalle_predio SET"
					+ " Descripcion_Predio = ? WHERE "
					+ "Impuesto_Predial_N_Predio= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setString(1, detallePredio.getDescripcionPredio());
			ppStm.setInt(2, detallePredio.getId().getImpuestoPredialNPredio());

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
	 * Método que permite eliminar la informacion de detalle de predio
	 * @param detallePredio
	 * @return
	 */
	public boolean eliminaDetallePredio(DetallePredio detallePredio){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM detalle_predio "
					+ "WHERE Impuesto_Predial_N_Predio = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, detallePredio.getId().getImpuestoPredialNPredio());

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
	 * Método que permite obtener la informacion del detalle de predio
	 * @param id
	 * @return
	 */
	public DetallePredio obtenDetallePredio(DetallePredioId id){ 
		DetallePredio detallePredio = null;  

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM detalle_predio "
					+ "WHERE Impuesto_Predial_N_Predio = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getImpuestoPredialNPredio());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				detallePredio = new DetallePredio();
				detallePredio.setDescripcionPredio(resultSet.getString(1));
				detallePredio.setId(new DetallePredioId(resultSet.getInt(2), 
						resultSet.getInt(3)));

			}else{
				return detallePredio;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return detallePredio; 
	}  

	public List<DetallePredio> obtenListaDetallePredio(){ 
		List<DetallePredio> listaDetallePredio = null;  
		return listaDetallePredio; 
	}  

	//       public static void main(String[] args) {
	//           
	//        DetallePredioDao daodp = new DetallePredioDao();
	//        ClienteDao daoc = new ClienteDao();
	//        SoatDao daos = new SoatDao();
	//        // Guardar
	//        //daodp.guardaDetallePredio(new DetallePredio(new DetallePredioId(108796548, 846259), "Finca Duitama"));
	//        // Actualizar
	//        //daodp.actualizaDetallePredio(new DetallePredio(new DetallePredioId(108796548, 846259), "Finca Sogamoso"));
	//        //Borrar
	//        daodp.eliminaDetallePredio(new DetallePredio(new DetallePredioId(108796548, 846259), null));
	//        //daods.eliminaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"), null));
	//    }
}