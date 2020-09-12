//UsuarioBean
package com.servicios;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import com.entidades.*;
import com.exception.ServiciosException;
import com.Remote.LocalidadBeanRemote;
import com.Remote.UsuarioBeanRemote;
import com.Remote.ZonaBeanRemote;
import com.dao.Localidaddao;
import com.dao.TipoUsuariodao;
import com.dao.Usuariodao;
import com.dao.Zonadao;


@Stateless
@LocalBean
public class ZonaBean implements ZonaBeanRemote{

	@EJB 
	private Zonadao zondao;
	
	public ZonaBean()
	{}
	@Override
	public List<Zona> obtenerTodasZonas(){

		List <Zona> zonas = zondao.obtenerTodasZonas();
		
		return zonas;
	}
	
	public Zona obtenerZona(String zon) {
		
		Zona zona = this.zondao.obtenerZona(zon);
	   	 return zona;
		
	}
}
