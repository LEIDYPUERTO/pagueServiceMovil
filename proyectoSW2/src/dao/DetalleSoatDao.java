/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import logica.DetalleSoat;
import logica.DetalleSoatId;

/**
 *
 * @author user
 */
public class DetalleSoatDao{  

	public boolean guardaDetalleSoat(DetalleSoat detalleSoat){ 

		return true; 

	}  

	public void actualizaDetalleSoat(DetalleSoat detalleSoat){ 

	}  

	public void eliminaDetalleSoat(DetalleSoat detalleSoat){ 

	}  

	public DetalleSoat obtenDetalleSoat(DetalleSoatId id){ 
		DetalleSoat detalleSoat = null;  
		return detalleSoat; 
	}  

	public List<DetalleSoat> obtenListaDetalleSoat(){ 
		List<DetalleSoat> listaDetalleSoat = null;  
		return listaDetalleSoat; 
	}  

	//       public static void main(String[] args) {
		//           
		//        DetalleSoatDao daods = new DetalleSoatDao();
	//        ClienteDao daoc = new ClienteDao();
	//        SoatDao daos = new SoatDao();
	//        // Guardar
	//        //daods.guardaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"),"Carro"));
	//        // Actualizar
	//        //daods.actualizaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"), "Ferrary Modelo 2014"));
	//        //Borrar
	//        //daods.eliminaDetalleSoat(new DetalleSoat(new DetalleSoatId(108796548, "rft458"), null));
	//    }
}