package com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PK_Detalle implements Serializable{

    private static final long serialVersionUID = 1L;

    
    @Column(name="ID_CARACT")    
    private long caracteristica;
    @Column(name="ID_OBSERVACION")
    private long observacion;
   	
	
	public PK_Detalle()
	{}
	
	
	
	public long getCaracteristica() {
		return caracteristica;
	}



	public void setCaracteristica(long caracteristica) {
		this.caracteristica = caracteristica;
	}



	public long getObservacion() {
		return observacion;
	}



	public void setObservacion(long observacion) {
		this.observacion = observacion;
	}
	
	
	
	
	public PK_Detalle(long caracteristica, long observacion) {
		super();
		this.caracteristica = caracteristica;
		this.observacion = observacion;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (caracteristica ^ (caracteristica >>> 32));
		result = prime * result + (int) (observacion ^ (observacion >>> 32));
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
		PK_Detalle other = (PK_Detalle) obj;
		if (caracteristica != other.caracteristica)
			return false;
		if (observacion != other.observacion)
			return false;
		return true;
	}
	
	
	
	
}
