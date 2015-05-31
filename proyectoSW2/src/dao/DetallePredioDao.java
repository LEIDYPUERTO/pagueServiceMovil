/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import logica.DetallePredio;
import logica.DetallePredioId;

/**
 *
 * @author user
 */
public class DetallePredioDao{  

	public boolean guardaDetallePredio(DetallePredio detallePredio){ 

		return true;       
	}  

	public void actualizaDetallePredio(DetallePredio detallePredio){ 

	}  

	public void eliminaDetallePredio(DetallePredio detallePredio){ 

	}  

	public DetallePredio obtenDetallePredio(DetallePredioId id){ 
		DetallePredio detallePredio = null;  
		return detallePredio; 
	}  

	public List<DetallePredio> obtenListaDetallePredio(){ 
		List<DetallePredio> listaDetallePredio = null;  
		return listaDetallePredio; 
	}  

	//       public static void main(String[] args) {
		//           
		//        DetallePredioDao daodp = new DetallePredioDao();
	//        ClienteDao daoc = new ClienteDao();
	//        SoatDao daos = new SoatDao();
	//        // Guardar
	//        //daodp.guardaDetallePredio(new DetallePredio(new DetallePredioId(108796548, 846259), "Finca Duitama"));
	//        // Actualizar
	//        //daodp.actualizaDetallePredio(new DetallePredio(new DetallePredioId(108796548, 846259), "Finca Sogamoso"));
	//        //Borrar
	//        daodp.eliminaDetallePredio(new DetallePredio(new DetallePredioId(108796548, 846259), null));
	//        //daods.eliminaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"), null));
	//    }
}