package com.Remote;

import java.util.List;
import javax.ejb.Remote;

import com.entidades.Departamento;
import com.entidades.Localidad;

@Remote
public interface LocalidadBeanRemote {

	List <Localidad> obtenerTodasLocalidades();
	
	List <Departamento> obtenerDepartamentos();
	
	List <Localidad> obtenerLocalidadesPorDepto(String depto);
	
	Localidad obtenerLocalidad(String localidad);
	
}
