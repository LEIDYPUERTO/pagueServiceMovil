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
import logica.ELuz;
import logica.ELuzId;
import logica.ImpuestoPredial;


/**
 * Clase que permite realizar acciones sobre el recibo
 * del impuesto predial
 * @author LEIDY
 *
 */
public class PredialDao{  

	/**
	 * MÈtodo que permite ingresar un nuevo registro del impuesto predial
	 * @param impuestoPredial
	 * @return
	 */
	public boolean guardarPredial(ImpuestoPredial impuestoPredial){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO impuesto_predial VALUES(?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, impuestoPredial.getNPredio());
			ppStm.setDate(2, (java.sql.Date) impuestoPredial.getFechaPagoPredial());
			ppStm.setDouble(3, impuestoPredial.getValorPredio());
			ppStm.setDouble(5, impuestoPredial.getImpuestoPredio());

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
	 * del impuesto predial en la base de datos
	 * @param impuestoPredial
	 * @return 
	 */
	public boolean actualizarPredial(ImpuestoPredial impuestoPredial){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE impuesto_predial SET"
					+ " Fecha_Pago_Predial = ?, Valor_Predio = ?, Impuesto_Predio "
					+ "= ? WHERE N_Predio = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDate(1, (java.sql.Date) impuestoPredial.getFechaPagoPredial());
			ppStm.setDouble(2, impuestoPredial.getValorPredio());
			ppStm.setDouble(3, impuestoPredial.getImpuestoPredio());
			ppStm.setInt(4, impuestoPredial.getNPredio());

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
	 * MÈtodo que permite eliminar el recibo de impuesto predial
	 * @param impuestoPredial
	 * @return
	 */
	public boolean eliminarPredial(ImpuestoPredial impuestoPredial){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM impuesto_predial "
					+ "WHERE N_Predio = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, impuestoPredial.getNPredio());

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
	 * MÈtodo que permite obtener informacion de un recibo de impuesto
	 * predial
	 * @param id
	 * @return
	 */
	public ImpuestoPredial obtenerPredial(int id){ 
		ImpuestoPredial impuestoPredial = null;  

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT * FROM impuesto_predial "
					+ "WHERE N_Predio = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id);

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				impuestoPredial = new ImpuestoPredial();
				impuestoPredial.setNPredio(resultSet.getInt(1));
				impuestoPredial.setFechaPagoPredial(resultSet.getDate(2));
				impuestoPredial.setValorPredio(resultSet.getDouble(3));
				impuestoPredial.setImpuestoPredio(resultSet.getDouble(4));

			}else{
				return impuestoPredial;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return impuestoPredial; 
	}  

	public List<ImpuestoPredial> obtenListaPredial(){ 
		List<ImpuestoPredial> listaPredial = null;  
		return listaPredial; 
	}  

	//    public static void main(String[] args) {
	//           //mes dia a√±o
	//        String fecha = "03/22/2015";
	//        String[] strings = fecha.split("/");
	//        Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//        
	//        PredialDao daop = new PredialDao();
	//       // guardar
	//        daop.guardaPredial(new ImpuestoPredial(846259, fechaV, 900000000, 9000000));
	//       // actualizar
	//        daop.actualizaPredial(new ImpuestoPredial(846259, fechaV, 500000000, 5000000));
	//       // Borrar
	//       // daop.eliminaPredial(new ImpuestoPredial(846259, fechaV, 0, 0));
	//     
	//    }
}
