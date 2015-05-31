/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Date;

import logica.Telefonia;
import logica.TelefoniaId;

/**
 *
 * @author user
 */
public class TelefoniaDao{  

	public boolean guardaTelefonia(Telefonia telefonia){ 
		return true; 

	}  

	public void actualizaTelefonia(Telefonia telefonia){ 

	}  

	public void eliminaTelefonia(Telefonia telefonia){ 

	}  

	public Telefonia obtenTelefonia(TelefoniaId id){ 
		Telefonia telefonia = null;  
		return telefonia; 
	}  

	public List<Telefonia> obtenListaTelefonia(){ 
		List<Telefonia> listaTelefonia = null;  
		return listaTelefonia; 
	}  

	//       public static void main(String[] args) {
		//           //mes dia año
	//        String fecha = "04/23/2015";
	//        String[] strings = fecha.split("/");
	//        Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//       
	//          TelefoniaDao daot = new TelefoniaDao();
	//          ClienteDao daoc = new ClienteDao();
	//        // Agregar
	//          daot.guardaTelefonia(new Telefonia(new TelefoniaId(654258, daoc.obtenCliente(108796548).getCedula()), fechaV, 12000,"Prueba"));
	//        // Actualizar
	//        //  daot.actualizaTelefonia(new Telefonia(new TelefoniaId(654258, daoc.obtenCliente(108796548).getCedula()), fechaV, 15000, "Comuna 13"));
	//        // Eliminar
	//        //  daot.eliminaTelefonia(new Telefonia(new TelefoniaId(654258, daoc.obtenCliente(108796548).getCedula()), fechaV, 0, fecha));
	//        //  daoi.eliminaInternetv(new InternetTv(new InternetTvId(77585, 108796548), fechaV, 0, fecha));
	//          
	//    }
}