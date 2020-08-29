package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.Remote.TIpoUsuarioBeanRemote;
import com.entidades.TipoUsuario;

@ManagedBean(name="tipoUsuario")
@SessionScoped
public class TipoUsuarioBean implements Serializable {

	@EJB
	private TIpoUsuarioBeanRemote tipoUsuarioBean;
	
	private static final long serialVersionUID = 1L;

	public TipoUsuarioBean() {
		super();
	}
	
    private long idtipousu;
    private String nombre;

    
	public long getId() {
		return idtipousu;
	}
	public void setId(long idtipousu) {
		this.idtipousu = idtipousu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	public TipoUsuarioBean(long idtipousu, String nombre) {
		super();
		this.idtipousu = idtipousu;
		this.nombre = nombre;
	}

	public List<TipoUsuario> obtenerTiposUsuario() {
		try{
			return tipoUsuarioBean.obtenerTodoslosTipos();			
		}catch(Exception e){
			return null;
		}
	}
    
   
}
