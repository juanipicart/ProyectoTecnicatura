package com.servicios;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.Remote.LocalidadBeanRemote;
import com.dao.Localidaddao;
import com.entidades.Departamento;
import com.entidades.Localidad;

@Stateless
@LocalBean
public class LocalidadBean implements LocalidadBeanRemote{

	@EJB 
	private Localidaddao locdao;
	
	public LocalidadBean()
	{}
	@Override
	public List<Localidad> obtenerTodasLocalidades(){

		List <Localidad> localidades = locdao.obtenerTodasLocalidades();
		
		return localidades;
	}
	
	public Localidad obtenerLocalidad(String loc) {
		
		Localidad localidad = this.locdao.obtenerLocalidad(loc);
	   	 return localidad;
		
	}
	@Override
	public List<Departamento> obtenerDepartamentos() {
		List<Departamento> deptos = locdao.obtenerDepartamentos();
		return deptos;
	}
	
	@Override
	public List<Localidad> obtenerLocalidadesPorDepto(String depto) {
		List<Localidad> localidades = locdao.obtenerLocalidadesPorDepto(depto);
		return localidades;
	}
}
