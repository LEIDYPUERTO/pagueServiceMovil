/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Date;

import logica.Soat;


/**
 *
 * 
 */
public class SoatDao{  

	public boolean guardaSoat(Soat soat){
		return true;

	}  

	public void actualizaSoat(Soat soat){ 

	}  

	public void eliminaSoat(Soat soat){ 

	}  

	public Soat obtenSoat(String id){ 
		Soat soat = null;  
		return soat; 
	}  

	public List<Soat> obtenListaSoat(){ 
		List<Soat> listaSoat = null;  
		return listaSoat; 
	}  

	//    public static void main(String[] args) {
		//           //mes dia año
	//        String fecha = "04/05/2016";
	//        String[] strings = fecha.split("/");
	//        Date fechaV= new Date(Integer.parseInt(strings[2])-1900, Integer.parseInt(strings[0])-1, Integer.parseInt(strings[1]));
	//        
	//        SoatDao daos = new SoatDao();
	//       // guardar
	//       //   daos.guardaSoat(new Soat("rft458", 150000000, fechaV, 1500000));
	//       // actualizar
	//       //   daos.actualizaSoat(new Soat("rft458", 200000000, fechaV, 2000000));
	//       // Borrar
	//       //   daos.eliminaSoat(new Soat("rft458", 0, fechaV, 0));
	//     
	//    }
}
