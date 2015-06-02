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
import logica.CreditoLuz;
import logica.CreditoLuzId;
import logica.DetalleCamara;
import logica.DetalleCamaraId;


/**
 * Clase que permite realizar acciones sobre el detalle de la camara de comercio
 * @author LEIDY
 *
 */
public class DetalleCamaraDao{  


	/**
	 * Método que permite ingresar un detalle sobre la camara de comercio
	 * @param detalleCamara
	 * @return
	 */
	public boolean guardaDetalleCamara(DetalleCamara detalleCamara){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO detalle_camara VALUES(?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setString(1, detalleCamara.getDescripcionNegocio());
			ppStm.setInt(2, detalleCamara.getId().getClienteCedula());
			ppStm.setInt(3, detalleCamara.getId().getCamaraComercioNitCamaraComercio());

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
	 * Método que permite actualizar la informacion del detalla
	 *  de la camara de comercio
	 * @param detalleCamara
	 * @return
	 */
	public boolean actualizaDetalleComercio(DetalleCamara detalleCamara){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE detalle_camara SET"
					+ " Descripcion_Negocio = ? WHERE "
					+ "Camara_Comercio_Nit_Camara_Comercio= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setString(1, detalleCamara.getDescripcionNegocio());
			ppStm.setInt(2, detalleCamara.getId().getCamaraComercioNitCamaraComercio());

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
	 * Método que permite realizar la eliminacion de detalle de 
	 * camara de comercio 
	 * @param detalleCamara
	 * @return
	 */
	public boolean eliminaDetalleCamara(DetalleCamara detalleCamara){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM detalle_camara "
					+ "WHERE Camara_Comercio_Nit_Camara_Comercio = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, detalleCamara.getId().getCamaraComercioNitCamaraComercio());

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
	 * Método que permite obtener la informacion del detalle de la camara
	 * @param id
	 * @return
	 */
	public DetalleCamara obtenDetalleComercio(DetalleCamaraId id){ 
		DetalleCamara detalleCamara = null;

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM detalle_camara "
					+ "WHERE Camara_Comercio_Nit_Camara_Comercio = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getCamaraComercioNitCamaraComercio());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				detalleCamara = new DetalleCamara();
				detalleCamara.setDescripcionNegocio(resultSet.getString(1));
				detalleCamara.setId(new DetalleCamaraId(resultSet.getInt(2), 
						resultSet.getInt(3)));

			}else{
				return detalleCamara;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return detalleCamara; 
	}  

	public List<DetalleCamara> obtenListaDetalleComercio(){ 
		List<DetalleCamara> listaDetalleComercio = null;  
		return listaDetalleComercio; 
	}  

	//	public static void main(String[] args) {
	//
	//		DetalleCamaraDao daodc = new DetalleCamaraDao();
	//		ClienteDao daoc = new ClienteDao();
	//		SoatDao daos = new SoatDao();
	//		// Guardar
	//		//daodc.guardaDetalleCamara(new DetalleCamara(new DetalleCamaraId(108796548, 987426523), "Licoreia"));
	//		// Actualizar
	//		//daodc.actualizaDetalleComercio(new DetalleCamara(new DetalleCamaraId(108796548, 987426523), "Bar Aula Maxima"));
	//		//Borrar
	//		daodc.eliminaDetalleCamara(new DetalleCamara(new DetalleCamaraId(108796548, 987426523), null));
	//	}
}