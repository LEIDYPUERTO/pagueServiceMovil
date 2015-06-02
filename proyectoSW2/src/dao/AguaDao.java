/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import Conexion.ConexionBD;
import logica.Cliente;
import logica.EAgua;
import logica.EAguaId;


/**
 * @author LEIDY
 * DAO que permite realizar operaciones sobre la empresa del
 * servicio de agua, desde el servicio web
 */
public class AguaDao{  


	/**
	 * MÈtodo que permite ingresar una nueva empresa de agua
	 * @param eAgua
	 * @return
	 */
	public boolean guardaAgua(EAgua eAgua) {

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO e_agua VALUES(?,?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, eAgua.getId().getReciboAgua());
			ppStm.setDate(2, (java.sql.Date) eAgua.getFechaPagoAgua());
			ppStm.setDouble(3, eAgua.getValorAgua());
			ppStm.setString(4, eAgua.getDetalleAgua());
			ppStm.setInt(5, eAgua.getId().getClienteCedula());

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
	 * MÈtodo que permite actualizar un recibo de agua
	 * @param eAgua
	 * @return
	 */
	public boolean actualizaAgua(EAgua eAgua){

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE e_agua SET"
					+ " Fecha_Pago_Agua = ?, Valor_Agua = ? WHERE Recibo_Agua= ?";


			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDate(1, (java.sql.Date) eAgua.getFechaPagoAgua());
			ppStm.setDouble(2, eAgua.getValorAgua());
			ppStm.setInt(3, eAgua.getId().getReciboAgua());

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
	 * MÈtodo que permite eliminar un recibo de agua
	 * @param eAgua
	 * @return
	 */
	public boolean eliminaAgua(EAgua eAgua) { 
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM e_agua WHERE Recibo_Agua = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, eAgua.getId().getReciboAgua());

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
	 * MÈtodo que permite retornar el recibo de agua
	 * @param id
	 * @return
	 */
	public EAgua obtenAgua(EAguaId id){ 
		EAgua eAgua = null;  
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM e_agua WHERE Recibo_Agua = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getReciboAgua());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){
				eAgua = new EAgua();
				eAgua.setId(new EAguaId(resultSet.getInt(1), resultSet.getInt(5)));
				eAgua.setFechaPagoAgua(resultSet.getDate(2));
				eAgua.setValorAgua(resultSet.getDouble(3));
				eAgua.setDetalleAgua(resultSet.getString(4));

			}else{
				return eAgua;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return eAgua; 
	}  

	public List<EAgua> obtenListaAgua(){ 
		List<EAgua> listaAgua = null;  

		return listaAgua; 
	}  

	//       public static void main(String[] args) {
	//           //mes dia a√±o
	//        String fecha = "03/25/2015";
	//        String[] strings = fecha.split("/");
	//        Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//       
	//          AguaDao daoa = new AguaDao();
	//          ClienteDao daoc = new ClienteDao();
	//        // Agregar  
	//          daoa.guardaAgua(new EAgua(new EAguaId(78756424,daoc.obtenCliente(108796548).getCedula()), fechaV, 7655977, "calle 78 # 13-145"));
	//        // Actualizar
	//        //  daoa.actualizaAgua(new EAgua(new EAguaId(78756424, daoc.obtenCliente(108796548).getCedula()), fechaV,120000, "calle 78 # 13-145"));
	//        // Eliminar
	//        //  daoa.eliminaAgua(new EAgua(new EAguaId(78756424, 108796548), fechaV, 0, fecha));
	//          
	//    }
}