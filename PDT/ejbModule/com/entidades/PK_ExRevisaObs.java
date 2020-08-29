package com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;




@Embeddable
public class PK_ExRevisaObs  implements Serializable{
	
    private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO")
	private long usuario;
	
	@Column(name="ID_OBSERVACION")
	private long observacion;
	
	@Column(name="FECHAYHORA")
	private Date fecha;

	


	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	public long getObservacion() {
		return observacion;
	}

	public void setObservacion(long observacion) {
		this.observacion = observacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public PK_ExRevisaObs ()
	{}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (observacion ^ (observacion >>> 32));
		result = prime * result + (int) (usuario ^ (usuario >>> 32));
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
		PK_ExRevisaObs other = (PK_ExRevisaObs) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (observacion != other.observacion)
			return false;
		if (usuario != other.usuario)
			return false;
		return true;
	}

	public PK_ExRevisaObs(long usuario, long observacion, Date fecha) {
		super();
		this.usuario = usuario;
		this.observacion = observacion;
		this.fecha = fecha;
	}

	
	
	

}
