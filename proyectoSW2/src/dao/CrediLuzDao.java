/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import java.util.Date;

import logica.CreditoLuz;
import logica.CreditoLuzId;

/**
 *
 * @author user
 */
public class CrediLuzDao{  


	public boolean guardaCrediLuz(CreditoLuz creditoLuz){ 
		return true; 

	}  

	public void actualizaCrediLuz(CreditoLuz creditoLuz){ 

	}  

	public void eliminaCrediLuz(CreditoLuz creditoLuz){ 

	}  

	public CreditoLuz obtenCrediLuz(CreditoLuzId id){ 
		CreditoLuz creditoLuz = null;  
		return creditoLuz; 
	}  

	public List<CreditoLuz> obtenListaCrediLuz(){ 
		List<CreditoLuz> listaCrediLuz = null;  
		return listaCrediLuz; 
	}  

//	public static void main(String[] args) {
//
//		LuzDao daol = new LuzDao();
//		CrediLuzDao daocr = new CrediLuzDao();
//		// Agregar  
//		//  daocr.guardaCrediLuz(new CreditoLuz(new CreditoLuzId(6235847, 8745685), 800000, "televisor"));
//		// Actualizar
//		//  daocr.actualizaCrediLuz(new CreditoLuz(new CreditoLuzId(6235847, 8745685), 950000, "Televisor LCD"));
//		// Eliminar
//		//  daocr.eliminaCrediLuz(new CreditoLuz(new CreditoLuzId(6235847, 8745685), 0, fecha));
//	}
}