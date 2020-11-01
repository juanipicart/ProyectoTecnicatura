package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.Departamento;
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
	  
	  //Listar todos los departamentos
	  public List<Departamento> obtenerDepartamentos() {
		  TypedQuery<Departamento> query = this.em.createQuery("select d from Departamento d ORDER BY d.nombreDep ASC", Departamento.class);
			List<Departamento> departamento = query.getResultList();
			return departamento;
	  }
	  
	  public Departamento obtenerDepartamentoPorId(String depto) {
		  TypedQuery<Departamento> query = this.em.createQuery("select d from Departamento d WHERE d.nombreDep LIKE :depto", Departamento.class)
				  .setParameter("depto", depto);
			Departamento departamento = query.getSingleResult();
			return departamento;
	  }
	  
	  public List<Localidad> obtenerLocalidadesPorDepto(String depto) {
		  Departamento departamento = obtenerDepartamentoPorId(depto);
		  TypedQuery<Localidad> query = em.createQuery("SELECT l FROM Localidad l WHERE l.departamento LIKE : departamento", Localidad.class)
				  .setParameter("departamento", departamento);
		  return query.getResultList();
	  }
	      
	    

}
