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

import javax.jws.WebService;

import Conexion.ConexionBD;
import logica.Banco;
import logica.BancoId;
import logica.EAgua;
import logica.EAguaId;

/**
 * Clase que permite realizar operaciones sobre el banco en la base de datos
 * @author LEIDY
 *
 */
public class BancoDao{  

	/**
	 * Método que permite ingresar informacion de un nuevo banco a la 
	 * base de datos
	 * @param banco
	 * @return
	 */
	public boolean guardaBanco(Banco banco){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO banco VALUES(?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);

			ppStm.setInt(1, banco.getId().getNumeroCuenta());
			ppStm.setDouble(2, banco.getSaldo());
			ppStm.setString(3, banco.getNombreBanco());
			ppStm.setInt(4, banco.getId().getClienteCedula());

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
	 * Método que permite actualizar la informacion del banco 
	 * en la base de datos
	 * @param banco
	 * @return
	 */
	public boolean actualizaBanco(Banco banco){

		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryUpdate = "UPDATE banco SET"
					+ " Saldo = ? WHERE Numero_Cuenta= ?";


			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);

			ppStm.setDouble(1, banco.getSaldo());
			ppStm.setInt(2, banco.getId().getNumeroCuenta());

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
	 * Método que permite eliminar la informacion del banco
	 * @param banco
	 * @return
	 */
	public boolean eliminaBanco(Banco banco){

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE FROM banco WHERE Numero_Cuenta = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, banco.getId().getNumeroCuenta());

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
	 * Método que permite retorna la informacion de un banco
	 * que se encuentra almacenado en la base de datos
	 * @param id
	 * @return
	 */
	public Banco obtenBanco(BancoId id){ 
		Banco banco = null;  

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT FROM banco WHERE Numero_Cuenta = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id.getNumeroCuenta());

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){
				banco = new Banco();
				banco.setId(new BancoId(resultSet.getInt(1),resultSet.getInt(4)));
				banco.setSaldo(resultSet.getDouble(2));
				banco.setNombreBanco(resultSet.getString(3));

			}else{
				return banco;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return banco; 
	}  

	public List<Banco> obtenListaBanco(){ 
		List<Banco> listaBanco = null;		
		return listaBanco; 
	}  

	//	public static void main(String[] args) {
	//
	//		BancoDao daob = new BancoDao();
	//		ClienteDao daoc = new ClienteDao();
	//		daob.guardaBanco(new Banco(new BancoId(7845692,daoc.obtenCliente(108796548).getCedula()), 80000,"Bancolombia"));
	//
	//	}
}