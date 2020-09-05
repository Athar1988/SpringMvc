package org.catalogue.dao.Dao;

import java.util.List;

import javax.persistence.Query;

import org.catalogue.dao.Metier.ImpMetierCatalogue;
import org.catalogue.dao.util.HibernateUtil;
import org.hibernate.Session;

import com.sun.istack.logging.Logger;



public class ImplDaoCatalogue implements InterfaceDao{
	Logger logger= Logger.getLogger(ImplDaoCatalogue.class);

	@Override
	public void addProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
        session.save(p);
        logger.info("ajouter des produit");
        }catch(Exception e){
        	session.getTransaction().rollback();
        	e.printStackTrace();
        }
        session.getTransaction().commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduits() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query req=session.createQuery("select p from Produit p");
        List<Produit>  prods=req.getResultList();
        session.getTransaction().commit();
        return prods;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getProduitParMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query req=session.createQuery("select p from Produit p where p.designation like :x");
		req.setParameter("x", "%"+mc+"%");
		List<Produit>  prods=req.getResultList();
        session.getTransaction().commit();
        return prods;
	}

	@Override
	public Produit getProduit(String ref) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object o=session.get(Produit.class, ref);
        if(o==null) throw new RuntimeException("Produit introuvable");
        session.getTransaction().commit();

        return (Produit)o;
	}

	@Override
	public void deleteProduit(String ref) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object o=session.get(Produit.class, ref);
        if(o==null) throw new RuntimeException("Produit introuvable");
        session.delete(o);
        session.getTransaction().commit();
		
	}

	@Override
	public void updateProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();	
        session.update(p);
        session.getTransaction().commit();
		
	}

}
