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
import logica.CamaraComercio;
import logica.CrediGas;
import logica.CrediGasId;


/**
 * Clase que permite realizar acciones sobre los creditos 
 * sacados con el recio de gas
 * @author LEIDY
 *
 */
public class CrediGasDao{  

	/**
	 * Método que permite almacenar un nuevo recibo de credigas
	 * @param crediGas
	 * @return
	 */
	public boolean guardaCrediGas(CrediGas crediGas){

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO credi_gas VALUES(?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, crediGas.getId().getContratoGas());
			ppStm.setInt(2, crediGas.getValorArticulo());
			ppStm.setString(3, crediGas.getDetalleContratogas());
			ppStm.setInt(4, crediGas.getId().getEGasNReciboGas());

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
	 * Método que permite actualizar la informacion 
	 * del credito de gas
	 * @param crediGas
	 * @return
	 */
	public boolean actualizaCrediGas(CrediGas crediGas){

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE credi_gas SET"
					+ " Detalle_contratogas = ?, E_Gas_N_Recibo_Gas = ? "
					+ "WHERE Contrato_Gas= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setString(1, crediGas.getDetalleContratogas());
			ppStm.setInt(2, crediGas.getId().getEGasNReciboGas());
			ppStm.setInt(3, crediGas.getId().getContratoGas());

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
	 * Método que permite eliminar la informacion de crediGas
	 * @param crediGas
	 * @return
	 */
	public boolean eliminaCrediGas(CrediGas crediGas){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM credi_gas "
					+ "WHERE Contrato_Gas = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, crediGas.getId().getContratoGas());

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
	 * Método que permite obtener la informacion de credigas
	 * @param id
	 * @return
	 */
	public CrediGas obtenCrediGas(CrediGasId id){ 
		CrediGas crediGas = null;  
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM credi_gas "
					+ "WHERE Contrato_Gas = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getContratoGas());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				crediGas = new CrediGas();
				crediGas.setId(new CrediGasId(resultSet.getInt(1), 
						resultSet.getInt(4)));
				crediGas.setValorArticulo(resultSet.getInt(2));
				crediGas.setDetalleContratogas(resultSet.getString(3));

			}else{
				return crediGas;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return crediGas; 
	}  

	public List<CrediGas> obtenListaCrediGas(){ 
		List<CrediGas> listaCrediGas = null;  
		return listaCrediGas; 
	}  

	//	public static void main(String[] args) {
	//
	//		GasDao daog = new GasDao();
	//		CrediGasDao daocg = new CrediGasDao();
	//		// Agregar  
	//		//  daocg.guardaCrediGas(new CrediGas(new CrediGasId(8612035, 98745852), 450000, "Chimenea"));
	//		// Actualizar
	//		//  daocg.actualizaCrediGas(new CrediGas(new CrediGasId(8612035, 98745852), 1200000,"chimenea a gas natural"));
	//		// Eliminar
	//		//  daocg.eliminaCrediGas(new CrediGas(new CrediGasId(8612035, 98745852), 0, null));
	//	}
}
