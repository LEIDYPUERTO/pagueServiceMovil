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

import com.sun.org.apache.regexp.internal.recompile;

import Conexion.ConexionBD;
import logica.Soat;
import logica.Telefonia;
import logica.TelefoniaId;

/**
 * Clase que permite realizar acciones sobre la entidad de la
 * base de datos
 * @author LEIDY
 *
 */
public class TelefoniaDao{  

	/**
	 * MÈtodo que permite ingresar un nuevo recibo de telefonia
	 * @param telefonia
	 * @return
	 */
	public boolean guardaTelefonia(Telefonia telefonia){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO telefonia VALUES(?,?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, telefonia.getId().getReciboTelefono());
			ppStm.setDate(2, (java.sql.Date) telefonia.getFechaPagoTelefonia());
			ppStm.setInt(3, telefonia.getValorTelefonia());
			ppStm.setString(4, telefonia.getDetalleTelefonia());
			ppStm.setInt(5, telefonia.getId().getClienteCedula());

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
	 * MÈtodo que permite actualizar la informacion en la 
	 * base de datos
	 * @param telefonia
	 * @return
	 */
	public boolean actualizaTelefonia(Telefonia telefonia){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE telefonia SET"
					+ " Fecha_Pago_Telefonia = ?, Valor_Telefonia= ?,"
					+ " Detalle_Telefonia = ? WHERE Recibo_Telefono = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDate(1, (java.sql.Date) telefonia.getFechaPagoTelefonia());
			ppStm.setDouble(2, telefonia.getValorTelefonia());
			ppStm.setString(3, telefonia.getDetalleTelefonia());
			ppStm.setInt(4, telefonia.getId().getReciboTelefono());

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
	 * MÈtodo que permite eliminar un recio de la luz
	 * @param telefonia
	 * @return
	 */
	public boolean eliminarTelefonia(Telefonia telefonia){ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM telefonia "
					+ "WHERE Recibo_Telefono = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, telefonia.getId().getReciboTelefono());

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
	 * MÈtodo que permite obtener informacion del recibo
	 * de telefonia de la base de datos
	 * @param id
	 * @return
	 */
	public Telefonia obtenTelefonia(TelefoniaId id){ 
		Telefonia telefonia = null;  

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM telefonia "
					+ "WHERE Recibo_Telefono = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getReciboTelefono());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){

				telefonia = new Telefonia();
				telefonia.setId(new TelefoniaId(resultSet.getInt(1), 
						resultSet.getInt(5)));
				telefonia.setFechaPagoTelefonia(resultSet.getDate(2));
				telefonia.setValorTelefonia(resultSet.getInt(3));
				telefonia.setDetalleTelefonia(resultSet.getString(4));
			}else{
				return telefonia;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return telefonia; 
	}  

	public List<Telefonia> obtenListaTelefonia(){ 
		List<Telefonia> listaTelefonia = null;  
		return listaTelefonia; 
	}  

	//       public static void main(String[] args) {
	//           //mes dia a√±o
	//        String fecha = "04/23/2015";
	//        String[] strings = fecha.split("/");
	//        Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//       
	//          TelefoniaDao daot = new TelefoniaDao();
	//          ClienteDao daoc = new ClienteDao();
	//        // Agregar
	//          daot.guardaTelefonia(new Telefonia(new TelefoniaId(654258, daoc.obtenCliente(108796548).getCedula()), fechaV, 12000,"Prueba"));
	//        // Actualizar
	//        //  daot.actualizaTelefonia(new Telefonia(new TelefoniaId(654258, daoc.obtenCliente(108796548).getCedula()), fechaV, 15000, "Comuna 13"));
	//        // Eliminar
	//        //  daot.eliminaTelefonia(new Telefonia(new TelefoniaId(654258, daoc.obtenCliente(108796548).getCedula()), fechaV, 0, fecha));
	//        //  daoi.eliminaInternetv(new InternetTv(new InternetTvId(77585, 108796548), fechaV, 0, fecha));
	//          
	//    }
}