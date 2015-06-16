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
import logica.ImpuestoPredial;
import logica.Soat;

/**
 * Clase que permite realizar acciones sobre la entidad SOAT
 * de la base de datos
 * @author LEIDY
 *
 */
public class SoatDao{  

	/**
	 * MÈtodo que permite ingresar un nuevo recibo del SOAT 
	 * a la base de datos
	 * @param soat
	 * @return
	 */
	public boolean guardarSoat(Soat soat){

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO soat VALUES(?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setString(1, soat.getNPlaca());
			ppStm.setDouble(2, soat.getValorVehiculo());
			ppStm.setDate(3, (java.sql.Date) soat.getFechaPagoSoat());
			ppStm.setDouble(4, soat.getPagoSoat());

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
	 * MÈtodo que permite actualizar la informacion del SOAT
	 * en la base de datos
	 * @param soat
	 * @return
	 */
	public boolean actualizarSoat(Soat soat){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE soat SET"
					+ " Valor_Vehiculo = ?, Fecha_Pago_Soat= ?,"
					+ " Pago_Soat = ? WHERE N_Placa = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDouble(1, soat.getValorVehiculo());
			ppStm.setDate(2, (java.sql.Date) soat.getFechaPagoSoat());
			ppStm.setDouble(3, soat.getPagoSoat());
			ppStm.setString(4, soat.getNPlaca());

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
	 * MÈtodo que permite eliminar la informacion del soat
	 * de la base de datos
	 * @param soat
	 * @return
	 */
	public boolean eliminarSoat(Soat soat){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM soat "
					+ "WHERE N_Placa = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setString(1, soat.getNPlaca());

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
	 * MÈtodo que permite obtener el recibo del SOAT
	 * de la base de datos
	 * @param id
	 * @return
	 */
	public Soat obtenerSoat(String id){ 
		Soat soat = null; 
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT * FROM soat "
					+ "WHERE N_Placa = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setString(1, id);

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				soat = new Soat();
				soat.setNPlaca(resultSet.getString(1));
				soat.setValorVehiculo(resultSet.getDouble(2));
				soat.setFechaPagoSoat(resultSet.getDate(3));
				soat.setPagoSoat(resultSet.getDouble(4));

			}else{
				return soat;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return soat; 
	}  

	public List<Soat> obtenListaSoat(){ 
		List<Soat> listaSoat = null;  
		return listaSoat; 
	}  

	//    public static void main(String[] args) {
	//           //mes dia a√±o
	//        String fecha = "04/05/2016";
	//        String[] strings = fecha.split("/");
	//        Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//        
	//        SoatDao daos = new SoatDao();
	//       // guardar
	//       //   daos.guardaSoat(new Soat("rft458", 150000000, fechaV, 1500000));
	//       // actualizar
	//       //   daos.actualizaSoat(new Soat("rft458", 200000000, fechaV, 2000000));
	//       // Borrar
	//       //   daos.eliminaSoat(new Soat("rft458", 0, fechaV, 0));
	//     
	//    }
}
