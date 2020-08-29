
package com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TELEFONO")
public class Telefono implements Serializable{

    public Telefono() {
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="ID_TEL")
    private long id;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="NUMERO", length=20, nullable=true)
    private String numero;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Telefono(long id, String nombre, String numero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numero = numero;
	}
	

}
