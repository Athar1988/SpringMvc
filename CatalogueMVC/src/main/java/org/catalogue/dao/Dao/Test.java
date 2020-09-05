package org.catalogue.dao.Dao;

import java.util.List;

import javax.servlet.ServletException;

public class Test {

	public static void main(String[] args) throws ServletException{
		// TODO Auto-generated method stub

		
		InterfaceDao ID=new ImplDaoCatalogue();
		//ID.addProduit(new Produit("12","HP 125", 123.33, 23));
        List<Produit> P=ID.getAllProduits();
        for(int i=0; i<P.size(); i++)
            System.out.println(P.get(i).getIdProduit());
	}

}
