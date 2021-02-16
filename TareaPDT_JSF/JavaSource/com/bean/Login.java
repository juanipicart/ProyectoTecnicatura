package com.bean;

import java.io.Serializable;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpSession;

import com.Remote.UsuarioBeanRemote;
import com.entidades.Usuario;

@ManagedBean(name="login")
@SessionScoped
public class Login implements Serializable {
	
	static final String LDAP_URL = "ldap://serv404notfound.greenplace.utec.edu.uy:389/DC=greenplace,DC=utec,DC=edu,DC=uy";
	static final String passError = "[LDAP: error code 49 - 80090308: LdapErr: DSID-0C0903C5, comment: AcceptSecurityContext error, data 52e, v2580";
	private String pass;
	private String username;
	private Usuario usuario;
	@EJB
	private UsuarioBeanRemote usuarioBeanRemote;
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String ValidarLogin (){
		username = username.toUpperCase();
		boolean valid = false;
		List <Usuario> usuarios = usuarioBeanRemote.Login(username, pass);
		Usuario usu = new Usuario();

		if (!(usuarios.isEmpty()) && usuarios.get(0).getEstado().equalsIgnoreCase("ACTIVO")) 
			{
				valid = true;
				usu = usuarios.get(0);
			}
		
		
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usu);
			return "Index";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuario o Password incorrecta",
							"Por favor verifique los datos ingresados"));
			return "Login";
		}
	}
	
	

	//logout
	public void logout  () {
		try { 
		 ExternalContext con = FacesContext.getCurrentInstance().getExternalContext();
		 HttpSession session = (HttpSession) con.getSession(false);
		 session.invalidate();
		 FacesContext.getCurrentInstance().getExternalContext().redirect("../GestionUsuarios/Login.xhtml");
		}catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	
	public String loginLDAP(String username, String password) {
		
		String usuMayus = username.toUpperCase();
		Usuario usu = new Usuario();
		Properties env = new Properties();

		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

		env.put(Context.PROVIDER_URL, LDAP_URL);

		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		env.put(Context.SECURITY_PRINCIPAL, usuMayus+"@greenplace.utec.edu.uy");
		
		env.put(Context.SECURITY_CREDENTIALS, password);

		try {

			DirContext ctx = new InitialDirContext(env);
			try {
				usu = usuarioBeanRemote.obtenerUsuario(usuMayus);
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", usu);
				return "Index";
			}
			
			catch (Exception ex){	
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Usuario no existente en la base de datos",
					"Por favor ingrese el usuario tambien en la base"));
				return "LoginLDAP";		    
				
			}
		} 
		catch (Exception ex) {
					String error = ex.getMessage();
					
				 if (error == passError)
					{
					FacesContext.getCurrentInstance().addMessage(null,
		     				new FacesMessage(FacesMessage.SEVERITY_WARN,
		     						"Usuario o Password incorrecta",
		     						"Por favor verifique los datos ingresados"));
					}
				 else
					{
						FacesContext.getCurrentInstance().addMessage(null,
			     				new FacesMessage(FacesMessage.SEVERITY_WARN,
			     						"Ocurrio un error con el servidor",
			     						"Por favor contactese con el Administrador de Red"));
					}	 
				return "LoginLDAP";	
         }	    
	}
}
