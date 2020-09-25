package com.servicios;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.Remote.EstadoBeanRemote;
import com.dao.Estadodao;
import com.entidades.Estado;

@Stateless
@LocalBean
public class EstadoBean implements EstadoBeanRemote{
	@EJB 
	private Estadodao estdao;
	
	public EstadoBean()
	{}
	
	
	@Override
	public List<Estado> obtenerTodosEstados(){

		 List <Estado> estados = this.estdao.obtenerTodasEstados();		
		 return estados;
	}


	@Override
	public Estado ObtenerEstado(String nombre) {
		Estado estado = this.estdao.obtenerEstadonombre(nombre);
		return estado;
	}

}
