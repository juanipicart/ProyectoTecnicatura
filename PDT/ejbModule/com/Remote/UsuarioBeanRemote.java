package com.Remote;

import java.util.List;
import javax.ejb.Remote;
import com.entidades.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {
	
	boolean CrearUsuario( String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, String tipousuario)throws ServiciosException;

	boolean EliminarUsuario(Long usuario) throws ServiciosException;
	
	boolean ModificarUsuario(Long id, String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, String tipousuario)throws ServiciosException;
	
    List<Usuario> Login (String usuario, String pass);
    
	List<Usuario> existeUsuario(String usu)throws ServiciosException;

	List<Usuario> obtenerUsuarios();

	Usuario obtenerUsuarioPorId(long id);

	List<Usuario> obtenerUsuarioActivos();

	Usuario obtenerUsuario(String usuario); 


}
