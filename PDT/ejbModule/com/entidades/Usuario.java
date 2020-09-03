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
	    
}
