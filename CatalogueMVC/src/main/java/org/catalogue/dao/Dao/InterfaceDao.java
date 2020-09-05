package org.catalogue.dao.Dao;

import java.util.List;


public interface InterfaceDao {
	public void addProduit(Produit p);
	public List<Produit> getAllProduits();
	public List<Produit> getProduitParMC(String mc);
	public Produit getProduit(String ref);
	public void deleteProduit(String ref);
	public void updateProduit(Produit p);
}
