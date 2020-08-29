package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.Remote.TIpoUsuarioBeanRemote;
import com.dao.TipoUsuariodao;
import com.entidades.TipoUsuario;

@Stateless
@LocalBean
public class TIpoUsuarioBean implements TIpoUsuarioBeanRemote{

	@EJB 
	private TipoUsuariodao tipousuariodao;
	
	public TIpoUsuarioBean()
	{}
	@Override
	public List<TipoUsuario> obtenerTodoslosTipos(){

		List <TipoUsuario> TP = tipousuariodao.obtenerTodoslosTipos();
		
		return TP;
	}
}
