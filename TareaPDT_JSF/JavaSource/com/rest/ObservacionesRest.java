package com.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.Remote.UsuarioBeanRemote;
import com.entidades.Estado;
import com.entidades.Observacion;
import com.entidades.Usuario;
import com.models.ObservacionDTO;

@Path("/observaciones")
public class ObservacionesRest {
	
	@EJB ObservacionBeanRemote observacionBean;
	@EJB EstadoBeanRemote estadoBean;
	@EJB UsuarioBeanRemote usuarioBean;
	
	//Todas las observaciones
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ObservacionDTO> getObservaciones() {
		List<Observacion> observaciones = observacionBean.obtenerTodasObservaciones();
		List<ObservacionDTO> response = new ArrayList<ObservacionDTO>();
		for (Observacion observacion: observaciones) {
			long id = observacion.getId();
			String codigo = observacion.getCodigo_OBS();
			String descripcion = observacion.getDescripcion();
			float latitud = observacion.getLatitud();
			float altitud = observacion.getAltitud();
			float longitud = observacion.getLongitud();
			String localidad = observacion.getLocalidad().getNombreLoc();
			String departamento = observacion.getLocalidad().getDepartamento().getNombreDep();
			String fenomeno = observacion.getFenomeno().getNombreFen();
			String estado = observacion.getEstado().getNombre();
			String usuario = observacion.getUsuario().getUsuario();
			String fecha = observacion.getFecha().toString();
		
			ObservacionDTO nuevaObs = new ObservacionDTO(id, codigo, descripcion, latitud, altitud, longitud, localidad, departamento, 
					fenomeno, estado, usuario, formatoFecha(fecha));
			response.add(nuevaObs);
		}
		return response;
	}
	
	//Observacion por Id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ObservacionDTO getObservacionById(@PathParam("id") Long id) {
		Observacion observacion = observacionBean.obtenerObservacionPorId(id);
		ObservacionDTO response = new ObservacionDTO();
		response.setId(observacion.getId());
		response.setCodigo(observacion.getCodigo_OBS());
		response.setDescripcion(observacion.getDescripcion());
		response.setFenomeno(observacion.getFenomeno().getNombreFen());
		response.setLongitud(observacion.getLongitud());
		response.setLatitud(observacion.getLatitud());
		response.setAltitud(observacion.getAltitud());
		response.setEstado(observacion.getEstado().getNombre());
		response.setFecha(formatoFecha(observacion.getFecha().toString()));
		response.setLocalidad(observacion.getLocalidad().getNombreLoc());
		response.setDepartamento(observacion.getLocalidad().getDepartamento().getNombreDep());
		response.setUsuario(observacion.getUsuario().getUsuario());
		return response;
	}
	
	//Observacion por usuario
		@GET
		@Path("/usuario/{username}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<ObservacionDTO> getObservacionById(@PathParam("username") String username) {
			Usuario usuario = usuarioBean.obtenerUsuario(username);
			List<Observacion> observaciones = observacionBean.obtenerObservacionesPorUsuario(usuario);
			List<ObservacionDTO> obsResponse = new ArrayList<ObservacionDTO>();
			for (int i=0; i < observaciones.size(); i++) {
			ObservacionDTO response = new ObservacionDTO();
			response.setId(observaciones.get(i).getId());
			response.setCodigo(observaciones.get(i).getCodigo_OBS());
			response.setDescripcion(observaciones.get(i).getDescripcion());
			response.setFenomeno(observaciones.get(i).getFenomeno().getNombreFen());
			response.setLongitud(observaciones.get(i).getLongitud());
			response.setLatitud(observaciones.get(i).getLatitud());
			response.setAltitud(observaciones.get(i).getAltitud());
			response.setEstado(observaciones.get(i).getEstado().getNombre());
			response.setFecha(formatoFecha(observaciones.get(i).getFecha().toString()));
			response.setLocalidad(observaciones.get(i).getLocalidad().getNombreLoc());
			response.setDepartamento(observaciones.get(i).getLocalidad().getDepartamento().getNombreDep());
			response.setUsuario(observaciones.get(i).getUsuario().getUsuario());
			obsResponse.add(response);
			}
			return obsResponse;
		}
	
	//Agregar observacion
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response addObservacion(ObservacionDTO observacion) {
	try {
		List <Observacion> existe = observacionBean.existeObservacion(observacion.getCodigo());
		if (existe.size() == 0)
		{
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Date date = format.parse(observacion.getFecha());
			if (observacionBean.CrearObservacion(observacion.getCodigo(),observacion.getUsuario(),observacion.getFenomeno(),observacion.getLocalidad(), 
					observacion.getDescripcion(), null, observacion.getLatitud(), observacion.getLongitud(), observacion.getAltitud(), 
					observacion.getEstado(), date)) { 
				
				return Response.ok().entity("{\"message\":\"Alta de observacion exitosa\"}").build(); } else {
					
				return Response.status(Response.Status.BAD_REQUEST).entity("{\"id\": 2, \"message\": \"Datos invalidos\"}").build();
		}
		}
		else {
		return	Response.status(Response.Status.BAD_REQUEST).entity("{\"id\": 1, \"message\": \"Codigo de observacion repetido\"}").build();
		}
		}catch(Exception e)
		{
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).entity("{\"id\": 2, \"message\": \"Datos invalidos\"}").build();
		}
	}
	
	//Modificar observacion
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response updateObservacion(@PathParam("id") Long id, ObservacionDTO observacion) {
		Observacion observacionPorID = observacionBean.obtenerObservacionPorId(id);
		List<Observacion> existe = observacionBean.existeObservacion(observacion.getCodigo());
	try {
		if (observacionPorID == null) {
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"No se encontró una observacion para el id ingresado.\"}").build();
		} else if (existe.size() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"El código ingresado en el body no pertenece a ninguna observacion\"}").build();
		} else if (id == existe.get(0).getId()) {
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Date date = format.parse(observacion.getFecha());
		observacionBean.ModificarObservacion(id,observacion.getCodigo(),observacion.getUsuario(),observacion.getFenomeno(),observacion.getLocalidad(), observacion.getDescripcion(), null, observacion.getLatitud(), observacion.getLongitud(), observacion.getAltitud(), observacion.getEstado(), date);
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
	
	public String formatoFecha(String fecha) {
		String[] soloFecha = fecha.split(" ");
		String[] parseFecha = soloFecha[0].split("-");
		String nuevaFecha = parseFecha[2] + "/" + parseFecha[1] + "/" + parseFecha[0];
		return nuevaFecha;
		
	}
}
