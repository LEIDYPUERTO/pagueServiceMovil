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
import logica.CrediGas;
import logica.CrediGasId;
import logica.CreditoLuz;
import logica.CreditoLuzId;


/**
 * Clase que permite realizar acciones sobre creditos que se hayan
 * sacado con recibo de la luz
 * @author LEIDY
 *
 */
public class CrediLuzDao{  


	/**
	 * Método que permite agregar un nuevo credito de la luz
	 * @param creditoLuz
	 * @return
	 */
	public boolean guardaCrediLuz(CreditoLuz creditoLuz){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO credito_luz VALUES(?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, creditoLuz.getId().getContratoLuz());
			ppStm.setDouble(2, creditoLuz.getValorElectro());
			ppStm.setString(3, creditoLuz.getDetalleContratoluz());
			ppStm.setInt(4, creditoLuz.getId().getELuzNReciboLuz());

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
	 * Método que permite actualizar la informacion del 
	 * credito de la luz
	 * @param creditoLuz
	 * @return
	 */
	public boolean actualizaCrediLuz(CreditoLuz creditoLuz){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE credito_luz SET"
					+ " Detalle_contratoluz = ?, E_Gas_N_Recio_Luz = ? "
					+ "WHERE Contrato_Luz= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setString(1, creditoLuz.getDetalleContratoluz());
			ppStm.setInt(2, creditoLuz.getId().getELuzNReciboLuz());
			ppStm.setInt(3, creditoLuz.getId().getContratoLuz());

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
	 * Método que permite eliminar la informacion de credito de la luz
	 * @param creditoLuz
	 * @return
	 */
	public boolean eliminaCrediLuz(CreditoLuz creditoLuz){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM credito_luz "
					+ "WHERE Contrato_Luz = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, creditoLuz.getId().getContratoLuz());

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
	 * Método que permite obtener la informacion del credito de la luz
	 * @param id
	 * @return
	 */
	public CreditoLuz obtenCrediLuz(CreditoLuzId id){ 
		CreditoLuz creditoLuz = null;  

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM credito_luz "
					+ "WHERE Contrato_Luz = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getContratoLuz());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				creditoLuz = new CreditoLuz();
				creditoLuz.setId(new CreditoLuzId(resultSet.getInt(1),resultSet.getInt(4)));
				creditoLuz.setValorElectro(resultSet.getDouble(2));
				creditoLuz.setDetalleContratoluz(resultSet.getString(3));

			}else{
				return creditoLuz;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return creditoLuz; 
	}  

	public List<CreditoLuz> obtenListaCrediLuz(){ 
		List<CreditoLuz> listaCrediLuz = null;  
		return listaCrediLuz; 
	}  

	//	public static void main(String[] args) {
	//
	//		LuzDao daol = new LuzDao();
	//		CrediLuzDao daocr = new CrediLuzDao();
	//		// Agregar  
	//		//  daocr.guardaCrediLuz(new CreditoLuz(new CreditoLuzId(6235847, 8745685), 800000, "televisor"));
	//		// Actualizar
	//		//  daocr.actualizaCrediLuz(new CreditoLuz(new CreditoLuzId(6235847, 8745685), 950000, "Televisor LCD"));
	//		// Eliminar
	//		//  daocr.eliminaCrediLuz(new CreditoLuz(new CreditoLuzId(6235847, 8745685), 0, fecha));
	//	}
}