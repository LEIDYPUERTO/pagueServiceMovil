/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import javax.jws.WebService;

import logica.Banco;
import logica.BancoId;
/**
 *
 * @author user
 */

public class BancoDao{  

	public boolean guardaBanco(Banco banco){ 
		return true; 
	}  

	public void actualizaBanco(Banco banco){ 

	}  

	public void eliminaBanco(Banco banco){ 

	}  

	public Banco obtenBanco(BancoId id){ 
		Banco banco = null;  
		return banco; 
	}  

	public List<Banco> obtenListaBanco(){ 
		List<Banco> listaBanco = null;  
		return listaBanco; 
	}  

	//	public static void main(String[] args) {
	//
	//		BancoDao daob = new BancoDao();
	//		ClienteDao daoc = new ClienteDao();
	//		daob.guardaBanco(new Banco(new BancoId(7845692,daoc.obtenCliente(108796548).getCedula()), 80000,"Bancolombia"));
	//
	//	}
}