/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Date;

import logica.ELuz;
import logica.ELuzId;

/**
 *
 * @author user
 */
public class LuzDao{  

	public boolean guardaLuz(ELuz eLuz){ 
		return true; 

	}  

	public void actualizaLuz(ELuz eLuz){ 

	}  

	public void eliminaLuz(ELuz eLuz){ 

	}  

	public ELuz obtenLuz(ELuzId id){ 
		ELuz eLuz = null;  
		return eLuz; 
	}  

	public List<ELuz> obtenListaLuz(){ 
		List<ELuz> listaLuz = null;  
		return listaLuz; 
	}  

	//	public static void main(String[] args) {
	//		//mes dia año
	//		String fecha = "03/25/2016";
	//		String[] strings = fecha.split("/");
	//		Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//
	//		LuzDao daol = new LuzDao();
	//		ClienteDao daoc = new ClienteDao();
	//		daol.guardaLuz(new ELuz(new ELuzId(8745685, daoc.obtenCliente(108796548).getCedula()), fechaV, 50000, "calle 87 # 78-45"));
	//		//daoa.guardaAgua(new EAgua(new EAguaId(98756424,daoc.obtenCliente(108796548).getCedula()), fechaV, 7655977, "calle 5 # 3-45"));
	//
	//
	//	}
}