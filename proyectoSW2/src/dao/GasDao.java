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
import logica.DetalleSoat;
import logica.DetalleSoatId;
import logica.EGas;
import logica.EGasId;

/**
 * Clase que permite realizar diversas acciones sobre 
 * la empresa Gas en la base de datos
 * @author LEIDY
 *
 */
public class GasDao{  

	/**
	 * MÈtodo que permite ingresar una empresa de gas
	 * @param eGas
	 * @return
	 */
	public boolean guardarGas(EGas eGas){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO e_gas VALUES(?,?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, eGas.getId().getReciboGas());
			ppStm.setDate(2, (java.sql.Date) eGas.getFechaPagoGas());
			ppStm.setDouble(3, eGas.getValorGas());
			ppStm.setString(4, eGas.getDetalleGas());
			ppStm.setInt(5, eGas.getId().getClienteCedula());

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
	 * @param eGas
	 * @return
	 */
	public boolean actualizarGas(EGas eGas){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE e_gas SET"
					+ " Fecha_Pago_Gas = ?, Valor_Gas = ?, Detalle_Gas = ? WHERE "
					+ "Recibo_Gas= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDate(1, (java.sql.Date) eGas.getFechaPagoGas());
			ppStm.setDouble(2, eGas.getValorGas());
			ppStm.setString(3, eGas.getDetalleGas());
			ppStm.setInt(4, eGas.getId().getReciboGas());

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
	 * MÈtodo que permite eliminar la informacion de la empresa de gas
	 * de la base de datos
	 * @param eGas
	 * @return
	 */
	public boolean eliminarGas(EGas eGas){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM e_gas "
					+ "WHERE Recibo_Gas = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, eGas.getId().getReciboGas());

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
	 * MÈtodo que permite obtner la informacion de la empresa de gas
	 * @param id
	 * @return
	 */
	public EGas obtenerGas(int id){ 
		EGas eGas = null;  
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT * FROM e_gas "
					+ "WHERE Cliente_Cedula = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id);

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				eGas = new EGas();
				eGas.setId(new EGasId(resultSet.getInt(1), resultSet.getInt(5)));
				eGas.setFechaPagoGas(resultSet.getDate(2));
				eGas.setValorGas(resultSet.getDouble(3));
				eGas.setDetalleGas(resultSet.getString(4));

			}else{
				return eGas;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return eGas; 
	}  

	public List<EGas> obtenListaGas(){ 
		List<EGas> listaGas = null;  
		return listaGas; 
	}  

	//	public static void main(String[] args) {
	//		//mes dia a√±o
	//		String fecha = "03/25/2016";
	//		String[] strings = fecha.split("/");
	//		Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//
	//		//  LuzDao daol = new LuzDao();
	//		GasDao daog = new GasDao();
	//		ClienteDao daoc = new ClienteDao();
	//		daog.guardaGas(new EGas(new EGasId(98745852, daoc.obtenCliente(108796548).getCedula()), fechaV, 120000,"calle 98-98-0"));
	//		//  daol.guardaLuz(new ELuz(new ELuzId(8745685, daoc.obtenCliente(108796548).getCedula()), fechaV, 50000, "calle 87 # 78-45"));
	//
	//
	//	}
}
