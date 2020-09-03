package com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Remote.UsuarioBeanRemote;
import com.entidades.Usuario;

@Path("/usuarios")
public class UsuariosRest {
	
	@EJB
	private UsuarioBeanRemote usuarioBeanRemote;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		return usuarioBeanRemote.obtenerUsuarios();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginUsuario(Usuario usuario){
		if (usuarioBeanRemote.Login(usuario.getUsuario(), usuario.getPass()).size() == 0) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Datos invalidos").build();
		} else {
			return Response.ok().entity("Login exitoso").build();
		}
	}
}
