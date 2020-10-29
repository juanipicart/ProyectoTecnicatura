package com.dao;

import java.util.Date;
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
    
    public void revisarObservación(ExRevisaObs revision) throws ServiciosException {
    	
    	try {
    		em.merge(revision);
    		em.flush();
    	} catch(PersistenceException e) {
    		throw new ServiciosException("Error al ingresar la revisión de la observacion.");
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
   
    //Listar todas las observaciones pendientes
    public List<Observacion> obtenerTodasObservacionesPendientes(Estado pendiente) 
    {
		TypedQuery<Observacion> query = this.em.createQuery("select o from Observacion o where o.estado LIKE :estado", Observacion.class).setParameter("estado", pendiente);
		List<Observacion> observaciones = query.getResultList();
		return observaciones;
	}
    
    //Lista de observaciones por codigo
    public List<Observacion> existeObservacion(String codigo_OBS) {
  		
  		TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o WHERE o.codigo_OBS LIKE :codigo_OBS", Observacion.class).setParameter("codigo_OBS", codigo_OBS);
		
  		List<Observacion> observaciones  =  query.getResultList();
  		
  		return observaciones;
  	}
  
    //Obtener observacion por id
  	public Observacion obtenerObservacionPorId(long id) {

	    	TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o where o.id LIKE : id",Observacion.class).setParameter("id",id);
			return query.getSingleResult();

		} 

  	//Obtener Obs por fecha y zona
  	public List<Observacion> obtenerObservacionFechaZona(Date desde, Date hasta, String zona)
  	{
  		TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o where o.nombre_zona LIKE : zona "
  				+ "and o.fecha BETWEEN desde AND hasta",Observacion.class)
  				.setParameter("nombre_zona",zona)
  				.setParameter("fecha", desde)
  				.setParameter("fecha", hasta);
  		List<Observacion> observaciones = query.getResultList();
		return observaciones;
  	}

	public List<Observacion> obtenerObservacionesUsuario(Usuario usuario) {
		TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o where o.usuario LIKE : usuario ",Observacion.class)
  				.setParameter("usuario",usuario);
  		List<Observacion> observaciones = query.getResultList();
		return observaciones;
	}
    
}
