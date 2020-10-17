package com.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpSession;

import com.Remote.UsuarioBeanRemote;
import com.entidades.Usuario;

@ManagedBean(name="login")
@SessionScoped
public class Login implements Serializable {
	
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
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "Login";
	}
	
	public static boolean authenticateJndi (String username, String password)
	{
		// obtenemos el dominio en base al email provisto
		//Integer corteString = username.indexOf("@");
		String nombreUsuario = username;
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		//props.put(Context.PROVIDER_URL, "ldap://192.168.210.100:389");
		props.put(Context.PROVIDER_URL, "ldap://serv404notfound.greenplace.utec.edu.uy:389");

		// login con cuenta con usuario provisto
		props.put(Context.SECURITY_PRINCIPAL, username);

		props.put(Context.SECURITY_CREDENTIALS, password);
		
		
		
		
		// CONEXION AL AD


	try {
		InitialDirContext context;	
								context = new InitialDirContext(props);
								
		SearchControls ctrls = new SearchControls();
		ctrls.setReturningAttributes(new String[] { "sn", "parametroBuscado", "otroParametro" });
		ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		
		NamingEnumeration<javax.naming.directory.SearchResult> answers;
		
		answers = context.search("CN=Users,DC=greenplace,DC=utec,DC=edu,DC=uy",
		//answers = context.search(",DC=greenplace,DC=utec,DC=edu,DC=uy",
			   "sAMAccountName=" + nombreUsuario, ctrls);
	 
		SearchResult result = answers.nextElement();

		Attributes attributes = result.getAttributes();
		Attribute atributoSipa = attributes.get("sipaUser");

		
		// VALIDAMOS LA PRESENCIA DEL ATRIBUTO



			if (atributoSipa != null) {
					//Controla que el usuario este habilitado para sipa
						if (atributoSipa.get().equals("TRUE")) {
								return true;
						}
			}
			return false;

		} catch (Exception e) {
				e.printStackTrace();
						System.out.println("error");
				}
		return false;
		}	
}
