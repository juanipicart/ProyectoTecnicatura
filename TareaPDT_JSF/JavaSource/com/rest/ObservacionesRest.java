package com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Remote.ObservacionBeanRemote;
import com.entidades.Observacion;
import com.entidades.Usuario;

@Path("/observaciones")
public class ObservacionesRest {
	
	@EJB ObservacionBeanRemote observacionBean;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Observacion> getUsuarios() {
		return observacionBean.obtenerTodasObservaciones();
	}
	
	@POST
	@Path("/AddObservacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response addobservacion(Observacion observacion) {
	try {
		List <Observacion> existe = observacionBean.existeObservacion(observacion.getCodigo_OBS());
		if (existe.size() == 0)
		{
		observacionBean.CrearObservacion(observacion.getCodigo_OBS(),observacion.getUsuario().getUsuario(),observacion.getFenomeno().getNombreFen(),observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha()); 
		return Response.ok().entity("{\"message\":\"Alta de observacion exitosa\"}").build();
		}
		else {
		return	Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"Codgo de observacion repetido\"}").build();
		}
		}catch(Exception e)
		{
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"Datos invalidos\"}").build();
		}
	}
	
	@PUT
	@Path("/UpdateObservacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response updateObservacion(Observacion observacion) {
	try {

		observacionBean.ModificarObservacion(observacion.getId(),observacion.getCodigo_OBS(),observacion.getUsuario().getUsuario(),observacion.getFenomeno().getNombreFen(),observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
		return Response.ok().entity("{\"message\":\"Modificacion de observacion exitosa\"}").build();
				
	}catch (Exception e) 
	{
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"Error al querer modificar datos de la observacion.\"}").build();
	}
	}
	
	@PUT
	@Path("/DeleteObservacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response deleteObservacion(Observacion observacion) {
	try {
		observacionBean.ModificarObservacion(observacion.getId(),observacion.getCodigo_OBS(),observacion.getUsuario().getUsuario(),observacion.getFenomeno().getNombreFen(),observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
		return Response.ok().entity("{\"message\":\"Eliminacion de observacion exitosa\"}").build();
				
	}catch (Exception e) 
	{
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"Error al querer eliminar la observacion.\"}").build();
	}
	}
	
}
