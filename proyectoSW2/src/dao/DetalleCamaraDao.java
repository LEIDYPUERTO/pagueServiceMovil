/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import logica.DetalleCamara;
import logica.DetalleCamaraId;

/**
 *
 * @author user
 */
public class DetalleCamaraDao{  


	public boolean guardaDetalleCamara(DetalleCamara detalleCamara){ 

		return true;
	}  

	public void actualizaDetalleComercio(DetalleCamara detalleCamara){ 

	}  

	public void eliminaDetalleCamara(DetalleCamara detalleCamara){ 

	}  

	public DetalleCamara obtenDetalleComercio(DetalleCamaraId id){ 
		DetalleCamara detalleCamara = null;  
		return detalleCamara; 
	}  

	public List<DetalleCamara> obtenListaDetalleComercio(){ 
		List<DetalleCamara> listaDetalleComercio = null;  
		return listaDetalleComercio; 
	}  

	//	public static void main(String[] args) {
	//
	//		DetalleCamaraDao daodc = new DetalleCamaraDao();
	//		ClienteDao daoc = new ClienteDao();
	//		SoatDao daos = new SoatDao();
	//		// Guardar
	//		//daodc.guardaDetalleCamara(new DetalleCamara(new DetalleCamaraId(108796548, 987426523), "Licoreia"));
	//		// Actualizar
	//		//daodc.actualizaDetalleComercio(new DetalleCamara(new DetalleCamaraId(108796548, 987426523), "Bar Aula Maxima"));
	//		//Borrar
	//		daodc.eliminaDetalleCamara(new DetalleCamara(new DetalleCamaraId(108796548, 987426523), null));
	//	}
}