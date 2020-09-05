package org.catalogue.dao.Controlers;

import javax.validation.Valid;

import org.catalogue.dao.Dao.Produit;
import org.catalogue.dao.Metier.InterfaceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogueControleur {
	@Autowired
	private InterfaceMetier IM;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", IM.getAllProduits());
		return "produits";
	}

	@RequestMapping(value = "/saveProduit" )
	public String saveProduit(@Valid Produit p,BindingResult br,Model model ) {
		if(br.hasErrors()) {
			model.addAttribute("produits", IM.getAllProduits());
			return "produits";

		}
	/*	if(action.equals("Update")) {
			IM.updateProduit(p);
			model.addAttribute("produits", IM.getAllProduits());
		}
		else {*/
			IM.addProduit(p);
			model.addAttribute("produit", new Produit());
			model.addAttribute("produits", IM.getAllProduits());
	//	}

		return "produits";
	}
	
	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "ref") String ref, Model model) {
		IM.deleteProduit(ref);
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", IM.getAllProduits());
		return "produits";
	}

	@RequestMapping(value = "/modifier")
	public String modifier(@RequestParam(value = "ref") String refprod, Model model) {
		model.addAttribute("reference", refprod);
		//model.addAttribute("produit", new Produit());
		//Produit P = IM.getProduit(refprod);
		//IM.updateProduit(P);
		//model.addAttribute("produit", IM.getProduit(refprod));
		model.addAttribute("produit", IM.getProduit(refprod));
		model.addAttribute("produits", IM.getAllProduits());

		return "produits";
	}
}
