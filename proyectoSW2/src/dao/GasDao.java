/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Date;

import logica.EGas;
import logica.EGasId;

/**
 *
 * @author user
 */
public class GasDao{  

	public boolean guardaGas(EGas eGas){ 
		return true;
	}  

	public void actualizaGas(EGas eGas){ 

	}  

	public void eliminaGas(EGas eGas){ 

	}  

	public EGas obtenGas(EGasId id){ 
		EGas eGas = null;  
		return eGas; 
	}  

	public List<EGas> obtenListaGas(){ 
		List<EGas> listaGas = null;  
		return listaGas; 
	}  

	//	public static void main(String[] args) {
	//		//mes dia año
	//		String fecha = "03/25/2016";
	//		String[] strings = fecha.split("/");
	//		Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//
	//		//  LuzDao daol = new LuzDao();
	//		GasDao daog = new GasDao();
	//		ClienteDao daoc = new ClienteDao();
	//		daog.guardaGas(new EGas(new EGasId(98745852, daoc.obtenCliente(108796548).getCedula()), fechaV, 120000,"calle 98-98-0"));
	//		//  daol.guardaLuz(new ELuz(new ELuzId(8745685, daoc.obtenCliente(108796548).getCedula()), fechaV, 50000, "calle 87 # 78-45"));
	//
	//
	//	}
}
