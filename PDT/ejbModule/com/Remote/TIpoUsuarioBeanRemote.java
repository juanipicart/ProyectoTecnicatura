package com.Remote;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.TipoUsuario;

@Remote
public interface TIpoUsuarioBeanRemote {

	List <TipoUsuario> obtenerTodoslosTipos();

}
