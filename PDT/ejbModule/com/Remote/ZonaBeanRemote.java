package com.Remote;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Localidad;
import com.entidades.Zona;

@Remote
public interface ZonaBeanRemote {

	List <Zona> obtenerTodasZonas();
	
	Zona obtenerZona(String zona);
	
}
