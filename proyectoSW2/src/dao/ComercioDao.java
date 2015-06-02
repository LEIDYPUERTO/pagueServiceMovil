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
import logica.Banco;
import logica.BancoId;
import logica.CamaraComercio;


/**
 * Clase que permite realizar acciones sobre la entidad 
 * Comercio que se ecnuentra en la base de datos
 * @author LEIDY
 *
 */
public class ComercioDao{  

	/**
	 * MÈtodo que permite alacenar nueva informacion de 
	 * camara de comercio en la base de datos
	 * @param camaraComercio
	 * @return
	 */
	public boolean guardaComercio(CamaraComercio camaraComercio){

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO camara_comercio VALUES(?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, camaraComercio.getNitComercio());
			ppStm.setInt(2, camaraComercio.getValorNegocio());
			ppStm.setDate(3, (java.sql.Date) camaraComercio.getFechaPagoComercio());
			ppStm.setDouble(4, camaraComercio.getPagoCamaraComercio());

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
	 * MÈtodo que permite actualizar la informacion almacenada
	 * de la camara de comercio
	 * @param camaraComercio
	 * @return
	 */
	public boolean actualizaComercio(CamaraComercio camaraComercio){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE camara_comercio SET"
					+ " Valor_Negocio = ?, Fecha_Pago_Comercio = ?,"
					+ " pago_Camara_Comercio = ? WHERE Nit_Comercio= ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setInt(1, camaraComercio.getValorNegocio());
			ppStm.setDate(2, (java.sql.Date) camaraComercio.getFechaPagoComercio());
			ppStm.setDouble(3, camaraComercio.getPagoCamaraComercio());
			ppStm.setInt(4, camaraComercio.getNitComercio());

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
	 * MÈtodo que permite eliminar la informacion de la camara de comercio
	 * @param camaraComercio
	 */
	public boolean eliminaComercio(CamaraComercio camaraComercio){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM camara_comercio "
					+ "WHERE Nit_Comercio = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, camaraComercio.getNitComercio());

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
	 * MÈtodo que permite obtener la informacion de la camara de comercio
	 * @param id
	 * @return
	 */
	public CamaraComercio obtenComercio(int id)	{ 
		CamaraComercio camaraComercio = null;

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM camara_comercio "
					+ "WHERE Nit_Comercio = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id);

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				camaraComercio = new CamaraComercio();
				camaraComercio.setNitComercio(resultSet.getInt(1));
				camaraComercio.setValorNegocio(resultSet.getInt(2));
				camaraComercio.setFechaPagoComercio(resultSet.getDate(3));
				camaraComercio.setPagoCamaraComercio(resultSet.getDouble(4));

			}else{
				return camaraComercio;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return camaraComercio; 
	}  

	public List<CamaraComercio> obtenListaComercio(){ 
		List<CamaraComercio> listaComercio = null;  
		return listaComercio; 
	}  
	//	public static void main(String[] args) {
	//		//mes dia a√±o
	//		String fecha = "03/22/2015";
	//		String[] strings = fecha.split("/");
	//		Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//
	//		ComercioDao daoco = new ComercioDao();
	//		// guardar
	//		// daoco.guardaComercio(new CamaraComercio(987426523, 70000000, fechaV, 35000));
	//		// actualizar
	//		// daoco.actualizaComercio(new CamaraComercio(987426523, 70000000, fechaV, 350000));
	//		// Borrar
	//		// daoco.eliminaComercio(new CamaraComercio(987426523, 0, fechaV, 350000));
	//
	//	}
}