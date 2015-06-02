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
import logica.ELuz;
import logica.ELuzId;


/**
 * Clase que permite realizar acciones sobre la entidad de 
 * luz en la base de datos
 * @author LEIDY
 *
 */
public class LuzDao{  

	/**
	 * MÈtodo que permite almacenar un recibo de la luz en
	 * la base de datos
	 * @param eLuz
	 * @return
	 */
	public boolean guardarLuz(ELuz eLuz){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO e_luz VALUES(?,?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, eLuz.getId().getReciboLuz());
			ppStm.setDate(2, (java.sql.Date) eLuz.getFechaPagoLuz());
			ppStm.setDouble(3, eLuz.getValorLuz());
			ppStm.setString(4, eLuz.getDetallerLuz());
			ppStm.setInt(5, eLuz.getId().getClienteCedula());

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
	 * MÈtodo que permite actualizar la informacion 
	 * del recibo de la luz en la base de datos
	 * @param eLuz
	 * @return
	 */
	public boolean actualizarLuz(ELuz eLuz){ 
		
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE e_luz SET"
					+ " Fecha_Pago_Luz = ?, Valor_Luz = ?, Detaller_Luz = ? WHERE "
					+ "Recibo_Luz = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDate(1, (java.sql.Date) eLuz.getFechaPagoLuz());
			ppStm.setDouble(2, eLuz.getValorLuz());
			ppStm.setString(3, eLuz.getDetallerLuz());
			ppStm.setInt(4, eLuz.getId().getReciboLuz());

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
	 * MÈtodo que permite eliminar la informacion del recibo de la luz
	 * @param eLuz
	 * @return
	 */
	public boolean eliminarLuz(ELuz eLuz){ 
		
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM e_luz "
					+ "WHERE Recibo_Luz = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, eLuz.getId().getReciboLuz());

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
	 * MÈtodo que permite obtener la informacion del recibo de la luz
	 * @param id
	 * @return
	 */
	public ELuz obtenLuz(ELuzId id){ 
		ELuz eLuz = null;  
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM e_luz "
					+ "WHERE Recibo_Luz = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getReciboLuz());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				eLuz = new ELuz();
				eLuz.setId(new ELuzId(resultSet.getInt(1), resultSet.getInt(5)));
				eLuz.setFechaPagoLuz(resultSet.getDate(2));
				eLuz.setValorLuz(resultSet.getDouble(3));
				eLuz.setDetallerLuz(resultSet.getString(4));
			}else{
				return eLuz;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return eLuz; 
	}  

	public List<ELuz> obtenListaLuz(){ 
		List<ELuz> listaLuz = null;
		return listaLuz; 
	}  

	//	public static void main(String[] args) {
	//		//mes dia a√±o
	//		String fecha = "03/25/2016";
	//		String[] strings = fecha.split("/");
	//		Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//
	//		LuzDao daol = new LuzDao();
	//		ClienteDao daoc = new ClienteDao();
	//		daol.guardaLuz(new ELuz(new ELuzId(8745685, daoc.obtenCliente(108796548).getCedula()), fechaV, 50000, "calle 87 # 78-45"));
	//		//daoa.guardaAgua(new EAgua(new EAguaId(98756424,daoc.obtenCliente(108796548).getCedula()), fechaV, 7655977, "calle 5 # 3-45"));
	//
	//
	//	}
}