package com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	
    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuenciausuario"  )
    @SequenceGenerator(name="secuenciausuario",sequenceName="SEQ_USUARIOID",allocationSize=1)
    @Column(name="ID_USUARIO",updatable = false)
    private long id;
    @Column(name="PASS", length=50, nullable=true)
    private String pass;
    @Column(name="USUARIO", length=80, nullable=true)
    private String usuario;
    @Column(name="NOMBRE", length=50, nullable=true)
    private String nombre;
    @Column(name="APELLIDO", length=50, nullable=true)
    private String apellido;
    @Column(name="ESTADO", length=50, nullable=true)
    private String estado;
    @Column(name="TIPODOC", length=50, nullable=true)
    private String tipodoc;
    @Column(name="NUMERODOC", length=50, nullable=true)
    private String numerodoc;
    @Column(name="DIRECCION", length=50, nullable=true)
    private String direccion;
    @Column(name="MAIL", length=50, nullable=true)
    private String mail;
        
    @ManyToOne (optional=false)
    @JoinColumn (name="ID_TIPO")
    private TipoUsuario tiposusuario;
    
	public Usuario( String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario) {
		super();
		
		this.pass = pass;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
		this.tipodoc = tipodoc;
		this.numerodoc = numerodoc;
		this.direccion = direccion;
		this.mail = mail;
		this.tiposusuario = tipousuario;
	}

	public Usuario(String usuario, String pass) {
		this.usuario=usuario;
		this.pass=pass;
	}
	
	
	
	
	public TipoUsuario getTipousuario() {
		return tiposusuario;
	}
	public void setTipousuario(TipoUsuario tipousuario) {
		this.tiposusuario = tipousuario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}
	public String getNumerodoc() {
		return numerodoc;
	}
	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	 public String toString() {
	      return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	  }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numerodoc == null) ? 0 : numerodoc.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((tipodoc == null) ? 0 : tipodoc.hashCode());
		result = prime * result + ((tiposusuario == null) ? 0 : tiposusuario.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id != other.id)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numerodoc == null) {
			if (other.numerodoc != null)
				return false;
		} else if (!numerodoc.equals(other.numerodoc))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (tipodoc == null) {
			if (other.tipodoc != null)
				return false;
		} else if (!tipodoc.equals(other.tipodoc))
			return false;
		if (tiposusuario == null) {
			if (other.tiposusuario != null)
				return false;
		} else if (!tiposusuario.equals(other.tiposusuario))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	    
}
