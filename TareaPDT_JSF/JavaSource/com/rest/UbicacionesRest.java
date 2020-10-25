package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Remote.FenomenoBeanRemote;
import com.Remote.LocalidadBeanRemote;
import com.Remote.ZonaBeanRemote;
import com.entidades.Fenomeno;
import com.entidades.Localidad;
import com.entidades.Zona;

@Path("/ubicaciones")
public class UbicacionesRest {
	
	@EJB LocalidadBeanRemote localidadBean;
	@EJB ZonaBeanRemote zonaBean;
	@EJB FenomenoBeanRemote fenomenoBean;
	
	@GET
	@Path("/localidades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Localidad> getLocalidades() {
		return localidadBean.obtenerTodasLocalidades();
	}
	
	@GET
	@Path("/zonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Zona> getZonas() {
		return zonaBean.obtenerTodasZonas();
	}

	@GET
	@Path("/fenomenos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fenomeno> getFenomenos() {
		List<Fenomeno> fenomenos = fenomenoBean.Obtenertodoslosfenomenos();
		List<Fenomeno> response = new ArrayList<Fenomeno>();
		for (int i=0; i<fenomenos.size(); i++) {
			long id = fenomenos.get(i).getId();
			String codigo = fenomenos.get(i).getCodigo();
			String nombre = fenomenos.get(i).getNombreFen();
			Fenomeno fenomeno = new Fenomeno(id, codigo, nombre);
			response.add(fenomeno);
		}
		
		return response;
	}
}
