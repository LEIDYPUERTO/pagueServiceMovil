/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Date;

import logica.ImpuestoPredial;


/**
 *
 * 
 */
public class PredialDao{  

	public boolean guardaPredial(ImpuestoPredial impuestoPredial){ 

		return true; 
	}  

	public void actualizaPredial(ImpuestoPredial impuestoPredial){ 

	}  

	public void eliminaPredial(ImpuestoPredial impuestoPredial){ 

	}  

	public ImpuestoPredial obtenPredial(int id){ 
		ImpuestoPredial impuestoPredial = null;  
		return impuestoPredial; 
	}  

	public List<ImpuestoPredial> obtenListaPredial(){ 
		List<ImpuestoPredial> listaPredial = null;  
		return listaPredial; 
	}  

	//    public static void main(String[] args) {
		//           //mes dia año
	//        String fecha = "03/22/2015";
	//        String[] strings = fecha.split("/");
	//        Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//        
	//        PredialDao daop = new PredialDao();
	//       // guardar
	//        daop.guardaPredial(new ImpuestoPredial(846259, fechaV, 900000000, 9000000));
	//       // actualizar
	//        daop.actualizaPredial(new ImpuestoPredial(846259, fechaV, 500000000, 5000000));
	//       // Borrar
	//       // daop.eliminaPredial(new ImpuestoPredial(846259, fechaV, 0, 0));
	//     
	//    }
}
