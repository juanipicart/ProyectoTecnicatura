package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

		if (!(usuarios.isEmpty())) 
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
}
