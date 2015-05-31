/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Date;

import logica.CamaraComercio;

/**
 *
 * 
 */
public class ComercioDao{  

	public boolean guardaComercio(CamaraComercio camaraComercio){ 
		return true; 
	}  

	public void actualizaComercio(CamaraComercio camaraComercio){ 

	}  

	public void eliminaComercio(CamaraComercio camaraComercio){ 

	}  

	public CamaraComercio obtenComercio(int id)	{ 
		CamaraComercio camaraComercio = null;  
		return camaraComercio; 
	}  

	public List<CamaraComercio> obtenListaComercio(){ 
		List<CamaraComercio> listaComercio = null;  
		return listaComercio; 
	}  
//	public static void main(String[] args) {
//		//mes dia año
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