package org.catalogue.dao.Dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="PRODUIT")
public class Produit implements Serializable{
	@Id
	@Column(name="reference")
	@NotEmpty
	@Size(min=4,max=12)
	private String reference;
	@Column(name="designation")
	@NotEmpty
	private String designation;
	@Column(name="prix")
	@DecimalMin(value="100")
	private double prix;
	@Column(name="quantite")
   private int quantite;
	public String getIdProduit() {
		return reference;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String ref,String designation, double prix, int quantite) {
		super();
		this.reference = ref;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setIdProduit(String ref) {
		this.reference = ref;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
