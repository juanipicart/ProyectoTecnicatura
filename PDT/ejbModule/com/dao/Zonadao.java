package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.Localidad;
import com.entidades.Zona;

@Stateless
public class Zonadao {
	
	
	@PersistenceContext
	private EntityManager em;

	
	//Obtener zona por nombre
	  public Zona obtenerZona(String zona) {
		  
		  TypedQuery<Zona> query = em.createQuery("SELECT z FROM Zona z where z.nombre_zona LIKE : zona",Zona.class).setParameter("zona",zona);
			return query.getSingleResult();
		  
		}
	    

	 //Listar todas las localidades
	  public List<Zona> obtenerTodasZonas() 
	    {
			TypedQuery<Zona> query = this.em.createQuery("select z from Zona z", Zona.class);
			List<Zona> zonas = query.getResultList();
			return zonas;
		}
	      
	    

}
