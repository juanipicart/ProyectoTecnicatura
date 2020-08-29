package com.Remote;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Estado;

@Remote
public interface EstadoBeanRemote {

	List <Estado> obtenerTodosEstados();
	
}
