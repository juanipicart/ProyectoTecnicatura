
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
@Table(name = "FENOMENO")
public class Fenomeno implements Serializable{

    public Fenomeno() {
        
    }
    
    private static final long serialVersionUID = 1L;
 
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuenciafenomeno")
    @SequenceGenerator(name="secuenciafenomeno",sequenceName="SEQ_CODIGOFENOMENO", allocationSize=1)
	@Column(name="CODIGO_FEN",updatable = false)
    private long id;
    @Column(name="CODIGO",length=50, nullable=true)
    private String codigo;
    @Column(name="NOMBRE_FEN", length=50, nullable=true)
    private String nombreFen;
    @Column(name="ESTADO", length=50, nullable=true)
    private String estado;
    @Column(name="DESCRIPCION", length=100, nullable=true)
    private String descripcion;  
    
    @ManyToOne (optional=false)
    @JoinColumn (name="ID_TEL")
    private Telefono telefonos;
    
    
 
    




	public Fenomeno(String codigo, String nombreFen, String estado, String descripcion, Telefono telefonos) {
		super();
		
		this.codigo = codigo;
		this.nombreFen = nombreFen;
		this.estado = estado;
		this.descripcion = descripcion;
		this.telefonos = telefonos;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreFen() {
		return nombreFen;
	}
	public void setNombreFen(String nombreFen) {
		this.nombreFen = nombreFen;
	}


	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Telefono getTelefonos() {
		return telefonos;
	}


	public void setTelefonos(Telefono telefonos) {
		this.telefonos = telefonos;
	}



}
