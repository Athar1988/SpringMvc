package org.catalogue.dao.Metier;

import java.util.List;

import org.catalogue.dao.Dao.InterfaceDao;
import org.catalogue.dao.Dao.Produit;

import com.sun.istack.logging.Logger;

public class ImpMetierCatalogue implements InterfaceMetier {
	InterfaceDao ID;
//setter pour injection des dependence
	public void setID(InterfaceDao iD) {
		ID = iD;
	}

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
		ID.addProduit(p);
	}

	@Override
	public List<Produit> getAllProduits() {
		List<Produit> P = ID.getAllProduits();
		return P;
	}

	@Override
	public List<Produit> getProduitParMC(String mc) {
		List<Produit> P = ID.getProduitParMC(mc);
		return null;
	}

	@Override
	public Produit getProduit(String ref) {
		Produit P = ID.getProduit(ref);
		return null;
	}

	@Override
	public void deleteProduit(String ref) {
		ID.deleteProduit(ref);
	}

	@Override
	public void updateProduit(Produit p) {
		ID.updateProduit(p);
	}

}
