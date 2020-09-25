
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombreFen == null) ? 0 : nombreFen.hashCode());
		result = prime * result + ((telefonos == null) ? 0 : telefonos.hashCode());
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
		Fenomeno other = (Fenomeno) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id != other.id)
			return false;
		if (nombreFen == null) {
			if (other.nombreFen != null)
				return false;
		} else if (!nombreFen.equals(other.nombreFen))
			return false;
		if (telefonos == null) {
			if (other.telefonos != null)
				return false;
		} else if (!telefonos.equals(other.telefonos))
			return false;
		return true;
	}

	
	
	
	@Override
	  public String toString() {
	      return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	  }

	

}
