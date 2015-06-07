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
import logica.Cliente;

/**
 * @author LEIDY
 * DAO que permite acceder al cliente y realizar las operaciones en 
 * la base de datos desde el servicio web
 *
 */

public class ClienteDao{  

	/**
	 * Método que permite almacenar el cliente en la base de datos,
	 * como parametros recibe un objeto de tipo Cliente
	 * @param cliente
	 * @return
	 */
	public boolean guardaCliente(Cliente cliente){ 
		try {
			Connection conn = ConexionBD.obtenerConexion();

			String queryInsertar = "INSERT INTO cliente VALUES(?,?,?,?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInsertar);
			ppStm.setInt(1, cliente.getCedula());
			ppStm.setString(2, cliente.getNombre());
			ppStm.setString(3, cliente.getGenero());
			ppStm.setString(4, cliente.getContrasena());

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
	 * Método que permite actualizar la información de un cliente
	 * @param cliente
	 * @return
	 */
	public boolean actualizacliente(Cliente cliente){
		
		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryUpdate = "UPDATE cliente SET Nombre = ?, Contrasena = ? "
					+ "WHERE Cedula = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);
			ppStm.setString(1, cliente.getNombre());
			ppStm.setString(2, cliente.getContrasena());
			ppStm.setInt(3, cliente.getCedula());

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
	 * Método que permite eliminar un cliente de la base de datos
	 * @param cliente
	 * @return
	 */
	public boolean eliminaCliente(Cliente cliente)	{ 

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String queryDelete = "DELETE * FROM cliente WHERE Cedula = ?";

			PreparedStatement ppStm = conn.prepareStatement(queryDelete);
			ppStm.setInt(1, cliente.getCedula());

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
	 * Método que permite obtener la información de un cliente teniendo 
	 * encuenta el número de documento
	 * @param id
	 * @return
	 */
	public Cliente obtenCliente(int id){ 
		Cliente cliente = null;

		try {
			Connection conn = ConexionBD.obtenerConexion();
			String querySearch = "SELECT * FROM cliente WHERE Cedula = ?";

			PreparedStatement ppStm = conn.prepareStatement(querySearch);
			ppStm.setInt(1, id);

			ResultSet resultSet = ppStm.executeQuery();

			if(resultSet.next()){
				cliente = new Cliente();
				cliente.setCedula(resultSet.getInt(1));
				cliente.setNombre(resultSet.getString(2));
				cliente.setGenero(resultSet.getString(3));
				cliente.setContrasena(resultSet.getString(4));
			}else{
				return cliente;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return cliente; 
	}  

	public List<Cliente> obtenListaClientes(){ 
		List<Cliente> listaClientes = null;  
		return listaClientes; 
	}  
	
	//	public static void main(String[] args) {
	//		ClienteDao dao = new ClienteDao();
	//		// Borrar 
	//		//  dao.eliminaCliente(new Cliente(1077852654, null, null, null));
	//		// actualizar
	//		// dao.actualizacliente(new Cliente(1077852654, "Juana", "F", "Pera"));
	//		// guardar
	//		dao.guardaCliente(new Cliente(108554, "Pedro llll","M", "Manzana"));
	//	}

}
