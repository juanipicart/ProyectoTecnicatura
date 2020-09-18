package com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Remote.ObservacionBeanRemote;
import com.entidades.Observacion;

@Path("/observaciones")
public class ObservacionesRest {
	
	@EJB ObservacionBeanRemote observacionBean;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Observacion> getUsuarios() {
		return observacionBean.obtenerTodasObservaciones();
	}
}
