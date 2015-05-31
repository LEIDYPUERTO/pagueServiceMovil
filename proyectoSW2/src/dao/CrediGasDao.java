/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import logica.CrediGas;
import logica.CrediGasId;

/**
 *
 * @author user
 */
public class CrediGasDao{  

	public boolean guardaCrediGas(CrediGas crediGas){ 
		return true;       
	}  

	public void actualizaCrediGas(CrediGas crediGas){ 

	}  

	public void eliminaCrediGas(CrediGas crediGas){ 

	}  

	public CrediGas obtenCrediGas(CrediGasId id){ 
		CrediGas crediGas = null;  
		return crediGas; 
	}  

	public List<CrediGas> obtenListaCrediGas(){ 
		List<CrediGas> listaCrediGas = null;  
		return listaCrediGas; 
	}  

//	public static void main(String[] args) {
//
//		GasDao daog = new GasDao();
//		CrediGasDao daocg = new CrediGasDao();
//		// Agregar  
//		//  daocg.guardaCrediGas(new CrediGas(new CrediGasId(8612035, 98745852), 450000, "Chimenea"));
//		// Actualizar
//		//  daocg.actualizaCrediGas(new CrediGas(new CrediGasId(8612035, 98745852), 1200000,"chimenea a gas natural"));
//		// Eliminar
//		//  daocg.eliminaCrediGas(new CrediGas(new CrediGasId(8612035, 98745852), 0, null));
//	}
}
