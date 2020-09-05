package org.catalogue.dao.Metier;

import java.util.List;

import org.catalogue.dao.Dao.Produit;

public interface InterfaceMetier {
	public void addProduit(Produit p);
	public List<Produit> getAllProduits();
	public List<Produit> getProduitParMC(String mc);
	public Produit getProduit(String ref);
	public void deleteProduit(String ref);
	public void updateProduit(Produit p);
}
