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
import java.util.Date;

import Conexion.ConexionBD;
import logica.EGas;
import logica.EGasId;
import logica.InternetTv;
import logica.InternetTvId;


/**
 * Clase que permite realizar acciones sobre la entidad
 * de internet y tv en la base de datos
 * @author LEIDY
 *
 */
public class InternetvDao{  

	/**
	 * MÈtodo que permite ingresar un nuevo recibo del servicio de 
	 * internet y tv
	 * @param internetTv
	 * @return
	 */
	public boolean guardarInternetv(InternetTv internetTv){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO internet_tv VALUES(?,?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, internetTv.getId().getReciboInternet());
			ppStm.setDate(2, (java.sql.Date) internetTv.getFechaPagoInternet());
			ppStm.setDouble(3, internetTv.getValorInternet());
			ppStm.setString(4, internetTv.getDetallerInternet());
			ppStm.setInt(5, internetTv.getId().getClienteCedula());

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
	 * MÈtodo que permite actualizar la informacion en la base de datos
	 * @param internetTv
	 * @return
	 */
	public boolean actualizarInternetv(InternetTv internetTv){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE internet_tv SET"
					+ " Fecha_Pago_Internet = ?, Valor_Internet = ?, Detaller_Internet "
					+ "= ? WHERE Recibo_Internet= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDate(1, (java.sql.Date) internetTv.getFechaPagoInternet());
			ppStm.setDouble(2, internetTv.getValorInternet());
			ppStm.setString(3, internetTv.getDetallerInternet());
			ppStm.setInt(4, internetTv.getId().getReciboInternet());

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
	 * MÈtodo que permite eliminar el recibo de internet
	 * @param internetTv
	 * @return
	 */
	public boolean eliminarInternetv(InternetTv internetTv){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM internet_tv "
					+ "WHERE Recibo_Internet = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, internetTv.getId().getReciboInternet());

			ppStm.executeUpdate();

			conn.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}  

	public InternetTv obtenerInternetv(InternetTvId id){ 
		InternetTv internetTv = null;  

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM internet_tv "
					+ "WHERE Recibo_Internet = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getReciboInternet());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				internetTv = new InternetTv();
				internetTv.setId(new InternetTvId(resultSet.getInt(1), 
						resultSet.getInt(5)));
				internetTv.setFechaPagoInternet(resultSet.getDate(2));
				internetTv.setValorInternet(resultSet.getDouble(3));
				internetTv.setDetallerInternet(resultSet.getString(4));

			}else{
				return internetTv;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return internetTv; 
	}  

	public List<InternetTv> obtenListaInternetv(){ 
		List<InternetTv> listaInternetv = null;  
		return listaInternetv; 
	}  

	//	public static void main(String[] args) {
	//		//mes dia a√±o
	//		String fecha = "03/25/2015";
	//		String[] strings = fecha.split("/");
	//		Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//
	//		InternetvDao daoi = new InternetvDao();
	//		ClienteDao daoc = new ClienteDao();
	//		// Agregar  
	//		daoi.guardaInternetv(new InternetTv(new InternetTvId(77585,daoc.obtenCliente(108796548).getCedula()), fechaV, 35000, "calle sur 45-48"));
	//		// Actualizar
	//		//  daoi.actualizaInternetv(new InternetTv(new InternetTvId(77585, daoc.obtenCliente(108796548).getCedula()), fechaV, 12000, "comuna 12 3-85"));
	//		// Eliminar
	//		//  daoi.eliminaInternetv(new InternetTv(new InternetTvId(77585, 108796548), fechaV, 0, fecha));
	//
	//	}
}