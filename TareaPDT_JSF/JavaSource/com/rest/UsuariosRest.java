package com.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Remote.UsuarioBeanRemote;
import com.entidades.TipoUsuario;
import com.entidades.Usuario;
import com.dao.TipoUsuariodao;

@Path("usuarios")
public class UsuariosRest {
	
	@EJB
	private UsuarioBeanRemote usuarioBeanRemote;
	
	TipoUsuariodao tipousuariodao;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		return usuarioBeanRemote.obtenerUsuarios();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response loginUsuario(Usuario usuario){
		if (usuarioBeanRemote.Login(usuario.getUsuario(), usuario.getPass()).size() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\":\"Datos invalidos\"}").build();
		} else {
			return Response.ok().entity("{\"message\":\"Login exitoso\"}").build();
		}
	}
	
	@POST
	@Path("/AddUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response adduser(Usuario usuario) {
	try {
		TipoUsuario tipousu=tipousuariodao.obtenertipousuario(usuario.getTipousuario().getNombre());
	usuarioBeanRemote.CrearUsuario(usuario.getPass(),usuario.getUsuario(),usuario.getNombre(),
			usuario.getApellido(),usuario.getEstado(),usuario.getTipodoc(),usuario.getNumerodoc(),
			usuario.getDireccion(),usuario.getMail(),tipousu.getNombre());
	return Response.ok().entity("{\"message\":\"Alta Usuario exitosa\"}").build();
	}catch(Exception e)
		{
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\": \"No se puede realizar el alta datos invalidos.\"}").build();
		}
}
	
	
	
}
