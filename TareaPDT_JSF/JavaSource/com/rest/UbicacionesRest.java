package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Remote.FenomenoBeanRemote;
import com.Remote.LocalidadBeanRemote;
import com.Remote.ZonaBeanRemote;
import com.entidades.Departamento;
import com.entidades.Fenomeno;
import com.entidades.Localidad;
import com.entidades.Zona;
import com.models.DepartamentoDTO;
import com.models.LocalidadDTO;

@Path("/ubicaciones")
public class UbicacionesRest {
	
	@EJB LocalidadBeanRemote localidadBean;
	@EJB ZonaBeanRemote zonaBean;
	@EJB FenomenoBeanRemote fenomenoBean;
	
	@GET
	@Path("/localidades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LocalidadDTO> getLocalidades() {
		List<Localidad> localidades = localidadBean.obtenerTodasLocalidades();
		List<LocalidadDTO> response = new ArrayList<LocalidadDTO>();
		for (int i=0; i<localidades.size();i++) {
			long id = localidades.get(i).getId_Localidad();
			String nombre = localidades.get(i).getNombreLoc();
			LocalidadDTO localidad = new LocalidadDTO(id, nombre);
			response.add(localidad);
		}
		return response;
	}
	
	@GET
	@Path("/zonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Zona> getZonas() {
	
		return zonaBean.obtenerTodasZonas();
	}
	
	@GET
	@Path("/departamentos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DepartamentoDTO> getDepartamentos() {
		List<Departamento> departamentos = localidadBean.obtenerDepartamentos();
		List<DepartamentoDTO> response = new ArrayList<DepartamentoDTO>();
		for (int i=0; i<departamentos.size(); i++) {
			long id = departamentos.get(i).getId_Departamento();
			String nombre = departamentos.get(i).getNombreDep();
			DepartamentoDTO depto = new DepartamentoDTO(id, nombre);
			response.add(depto);
		}
		return response;
	}
	
	@GET
	@Path("/localidades/{depto}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LocalidadDTO> getLocalidadByDepto(@PathParam("depto") String depto) {
		List<Localidad> localidades = localidadBean.obtenerLocalidadesPorDepto(depto);
		List<LocalidadDTO> response = new ArrayList<LocalidadDTO>();
		if (localidades.isEmpty()) {
			
		} else {
		for (int i=0; i<localidades.size(); i++) {
			long id = localidades.get(i).getId_Localidad();
			String nombre = localidades.get(i).getNombreLoc();
			LocalidadDTO localidad = new LocalidadDTO(id, nombre);
			response.add(localidad);
		}
		}
		return response;
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
