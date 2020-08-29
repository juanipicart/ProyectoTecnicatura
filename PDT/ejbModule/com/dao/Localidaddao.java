package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.Localidad;

@Stateless
public class Localidaddao {
	
	
	@PersistenceContext
	private EntityManager em;

	
	//Obtener localidad por nombre
	  public Localidad obtenerLocalidad(String localidad) {
		  
		  TypedQuery<Localidad> query = em.createQuery("SELECT l FROM Localidad l where l.nombreLoc LIKE : localidad",Localidad.class).setParameter("localidad",localidad);
			return query.getSingleResult();
		  
		}
	    

	 //Listar todas las localidades
	  public List<Localidad> obtenerTodasLocalidades() 
	    {
			TypedQuery<Localidad> query = this.em.createQuery("select l from Localidad l", Localidad.class);
			List<Localidad> localidades = query.getResultList();
			return localidades;
		}
	      
	    

}
