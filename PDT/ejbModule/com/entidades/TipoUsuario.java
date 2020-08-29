package com.entidades;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "TIPOSUSUARIOS")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public TipoUsuario() {
		super();
	}
	
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="ID_TIPO")
    private long idtipousu;
    @Column(name="NOMBRE", length=50, nullable=true)
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
	
	
	public TipoUsuario(long idtipousu, String nombre) {
		super();
		this.idtipousu = idtipousu;
		this.nombre = nombre;
	}

    
   
}
