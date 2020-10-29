package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "LOCALIDAD")
public class Localidad implements Serializable {


	public Localidad() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="secuencialoc",sequenceName="SEQ_IDLOCALIDADID", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuencialoc")
	@Column(name="ID_LOCALIDAD")
	private long id_localidad;
	@ManyToOne (optional=false)
    @JoinColumn (name="ID_DEPARTAMENTO")
	private Departamento departamento; 
	@Column(name="NOMBRE_LOC",length=(40),nullable=false)
	private String nombreLoc;
	@Column(name="LATITUD",length=(50),nullable=false)
	private float latitud;
	@Column(name="LONGITUD",length=(50),nullable=false)
	private float longitud;
	@Column(name="ALTITUD",length=(50),nullable=false)
	private float altitud;

	public long getId_Localidad() {
		return id_localidad;
	}
	public void setId(long id) {
		this.id_localidad = id;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getNombreLoc() {
		return nombreLoc;
	}
	public void setNombreLoc(String nombreLoc) {
		this.nombreLoc = nombreLoc;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public float getAltitud() {
		return altitud;
	}
	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}
	public Localidad(long id, Departamento departamento, String nombreLoc, float latitud, float longitud,
			float altitud) {
		super();
		this.id_localidad = id;
		this.departamento = departamento;
		this.nombreLoc = nombreLoc;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
	}
	
	public Localidad(long id, String nombre, float latitud, float altitud, float longitud) {
		this.id_localidad = id;
		this.nombreLoc = nombre;
		this.latitud = latitud;
		this.altitud = altitud;
		this.longitud = longitud;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altitud);
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + (int) (id_localidad ^ (id_localidad >>> 32));
		result = prime * result + Float.floatToIntBits(latitud);
		result = prime * result + Float.floatToIntBits(longitud);
		result = prime * result + ((nombreLoc == null) ? 0 : nombreLoc.hashCode());
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
		Localidad other = (Localidad) obj;
		if (Float.floatToIntBits(altitud) != Float.floatToIntBits(other.altitud))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (id_localidad != other.id_localidad)
			return false;
		if (Float.floatToIntBits(latitud) != Float.floatToIntBits(other.latitud))
			return false;
		if (Float.floatToIntBits(longitud) != Float.floatToIntBits(other.longitud))
			return false;
		if (nombreLoc == null) {
			if (other.nombreLoc != null)
				return false;
		} else if (!nombreLoc.equals(other.nombreLoc))
			return false;
		return true;
	}
	
	@Override
	  public String toString() {
	      return String.format("%s[id=%d]", getClass().getSimpleName(), getId_Localidad());
	  }
	

}


