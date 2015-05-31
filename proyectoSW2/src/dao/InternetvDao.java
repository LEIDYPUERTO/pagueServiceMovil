/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Date;

import logica.InternetTv;
import logica.InternetTvId;

/**
 *
 * @author user
 */
public class InternetvDao{  

	public boolean guardaInternetv(InternetTv internetTv){ 

		return true; 

	}  

	public void actualizaInternetv(InternetTv internetTv){ 

	}  

	public void eliminaInternetv(InternetTv internetTv){ 

	}  

	public InternetTv obtenInternetv(InternetTvId id){ 
		InternetTv internetTv = null;  
		return internetTv; 
	}  

	public List<InternetTv> obtenListaInternetv(){ 
		List<InternetTv> listaInternetv = null;  
		return listaInternetv; 
	}  

	//	public static void main(String[] args) {
	//		//mes dia año
	//		String fecha = "03/25/2015";
	//		String[] strings = fecha.split("/");
	//		Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//
	//		InternetvDao daoi = new InternetvDao();
	//		ClienteDao daoc = new ClienteDao();
	//		// Agregar  
	//		daoi.guardaInternetv(new InternetTv(new InternetTvId(77585,daoc.obtenCliente(108796548).getCedula()), fechaV, 35000, "calle sur 45-48"));
	//		// Actualizar
	//		//  daoi.actualizaInternetv(new InternetTv(new InternetTvId(77585, daoc.obtenCliente(108796548).getCedula()), fechaV, 12000, "comuna 12 3-85"));
	//		// Eliminar
	//		//  daoi.eliminaInternetv(new InternetTv(new InternetTvId(77585, 108796548), fechaV, 0, fecha));
	//
	//	}
}