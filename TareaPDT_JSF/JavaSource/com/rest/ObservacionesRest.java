package com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Remote.EstadoBeanRemote;
import com.Remote.ObservacionBeanRemote;
import com.entidades.Estado;
import com.entidades.Observacion;
import com.entidades.Usuario;

@Path("/observaciones")
public class ObservacionesRest {
	
	@EJB ObservacionBeanRemote observacionBean;
	@EJB EstadoBeanRemote estadoBean;
	
	//Todas las observaciones
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Observacion> getObservaciones() {
		return observacionBean.obtenerTodasObservaciones();
	}
	
	//Observacion por Id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Observacion getObservacionById(@PathParam("id") Long id) {
		return observacionBean.obtenerObservacionPorId(id);
	}
	
	//Agregar observacion
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response addObservacion(Observacion observacion) {
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
	
	//Modificar observacion
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response updateObservacion(@PathParam("id") Long id, Observacion observacion) {
	try {
		if (id == observacion.getId()) {
		observacionBean.ModificarObservacion(observacion.getId(),observacion.getCodigo_OBS(),observacion.getUsuario().getUsuario(),observacion.getFenomeno().getNombreFen(),observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
		return Response.ok().entity("{\"message\":\"Modificacion de observacion exitosa\"}").build();
		}
		else {
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"Error al querer modificar datos de la observacion.\"}").build();
		}
	}catch (Exception e) 
	{
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"Error al querer modificar datos de la observacion.\"}").build();
	}
	}
	
	//Eliminar observacion
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response deleteObservacion(@PathParam("id") Long id) {
	try {
		Observacion observacion = observacionBean.obtenerObservacionPorId(id);
		Estado estado = estadoBean.ObtenerEstado("ELIMINADA");
		observacion.setEstado(estado);
		observacionBean.ModificarObservacion(observacion.getId(),observacion.getCodigo_OBS(),observacion.getUsuario().getUsuario(),observacion.getFenomeno().getNombreFen(),observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
		return Response.ok().entity("{\"message\":\"Eliminacion de observacion exitosa\"}").build();
				
	}catch (Exception e) 
	{
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"Error al querer eliminar la observacion.\"}").build();
	}
	}
	
}
