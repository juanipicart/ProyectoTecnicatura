package com.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.exception.ServiciosException;
import com.entidades.*;

@Stateless
@LocalBean
public class Observaciondao {

    public Observaciondao() 
    {}
    
    @PersistenceContext
	private EntityManager em;

    public void AgregarObservacion(Observacion nuevaObs) throws ServiciosException 
	{
    	try {
			em.merge(nuevaObs);
			em.flush();
				
		}catch(PersistenceException e)
			{
				throw new ServiciosException ("Error al querer agregar la observacion.");
			}
	}

    public void ModificarObservacion(Observacion observacion) throws ServiciosException
	{
		try {
			em.merge(observacion);
			em.flush();
		}catch(PersistenceException e)
		{
			throw new ServiciosException("No se pudo modificar la observacion");		
		}
	}
        
    public void EliminarObservacion (long id) throws ServiciosException
    {
	    try {
	    	
	    	Observacion obs = em.find(Observacion.class, id);
	    	
	    	em.remove(obs);
	    	em.flush();
	    }
	    
	    catch(PersistenceException e)
	    {
	    	throw new ServiciosException("Error al intentar eliminar la observacion.");
	    }
    }
 
    //Listar todas las observaciones
    public List<Observacion> obtenerTodasObservaciones() 
    {
		TypedQuery<Observacion> query = this.em.createQuery("select o from Observacion o", Observacion.class);
		List<Observacion> observaciones = query.getResultList();
		return observaciones;
	}
   
    //Lista de observaciones por codigo
    public List<Observacion> existeObservacion(String codigo_OBS) {
  		
  		TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o WHERE o.codigo_OBS LIKE :codigo_OBS", Observacion.class).setParameter("codigo_OBS", codigo_OBS);
		
  		List<Observacion> observaciones  =  query.getResultList();
  		
  		return observaciones;
  	}
  
}
