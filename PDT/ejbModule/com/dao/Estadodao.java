package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.entidades.Estado;

@Stateless
public class Estadodao {
	
	
	@PersistenceContext
	private EntityManager em;

	//Obtengo el estado por el nombree
	  public Estado obtenerEstadonombre(String nombre) {
		  
		  TypedQuery<Estado> query = em.createQuery("SELECT e FROM Estado e where e.nombre LIKE : nombre",Estado.class).setParameter("nombre",nombre);
			return query.getSingleResult();
		}
	  
	//Obtengo la lista de estadosss
    public List<Estado> obtenerTodasEstados() 
    {
		TypedQuery<Estado> query = this.em.createQuery("select e from Estado e", Estado.class);
		List<Estado> estados = query.getResultList();
		return estados;
	}

}
