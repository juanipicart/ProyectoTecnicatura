package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.entidades.TipoUsuario;

@Stateless
public class TipoUsuariodao {
	
	@PersistenceContext
	private EntityManager em;

		//Tipo de usuario por nombre
	  public TipoUsuario obtenertipousuario(String tipousuario) {
		  
		  TypedQuery<TipoUsuario> query = em.createQuery("SELECT TU FROM TipoUsuario TU where TU.nombre LIKE : tipousuario",TipoUsuario.class).setParameter("tipousuario",tipousuario);
			return query.getSingleResult();
		  
		}
	    
	    //Listar todos los tipos de usuario
	  public List<TipoUsuario> obtenerTodoslosTipos() {
	    	 TypedQuery<TipoUsuario> query = this.em.createQuery("select u FROM TipoUsuario u", TipoUsuario.class);
	  		
	    	List<TipoUsuario> tus = query.getResultList();
	    	 
	    	 return tus;	
	    }    
	    

}
