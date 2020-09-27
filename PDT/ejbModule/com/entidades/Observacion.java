package com.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "OBSERVACIONES")
public class Observacion implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public Observacion() {
		super();
	}
	
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator="secuenciaObservacion" )
    @SequenceGenerator(name="secuenciaObservacion",sequenceName="SEQ_OBSERVACIONID", allocationSize=1)
    @Column(name="ID_OBSERVACION")
    private long id;
    @Column(name="CODIGO_OBS")
    private String codigo_OBS;
  

	@ManyToOne (optional=false)
    @JoinColumn (name="ID_USUARIO")
	private Usuario usuario; 
    @ManyToOne (optional=false)
    @JoinColumn (name="CODIGO_FEN")
    private Fenomeno fenomeno; 
    @ManyToOne (optional=false)
    @JoinColumn (name="ID_LOCALIDAD")
    private Localidad localidad; 
    @Column(name="DESCRIPCION", length=(50), nullable=false)
	private String descripcion;
    @Lob
	private byte[] imagen;
    @Column(name="LATITUD",length=(50),nullable=false)
	private float latitud;
	@Column(name="LONGITUD",length=(50),nullable=false)
	private float longitud;
	@Column(name="ALTITUD",length=(50),nullable=false)
	private float altitud;
	@ManyToOne (optional=false)
    @JoinColumn (name="ID_ESTADO")
	private Estado estado;
    @Column(name="FECHAHORA", nullable=true)
    private Date fecha;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	  public String getCodigo_OBS() {
			return codigo_OBS;
		}
		public void setCodigo_OBS(String codigo_OBS) {
			this.codigo_OBS = codigo_OBS;
		}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Fenomeno getFenomeno() {
		return fenomeno;
	}
	public void setFenomeno(Fenomeno fenomeno) {
		this.fenomeno = fenomeno;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

	public Observacion(String codigo_OBS, Usuario usuario, Fenomeno fenomeno, Localidad localidad,
			String descripcion, byte[] imagen, float latitud, float longitud, float altitud, Estado estado, Date fecha) {
		super();
		this.codigo_OBS = codigo_OBS;
		this.usuario = usuario;
		this.fenomeno = fenomeno;
		this.localidad = localidad;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.estado = estado;
		this.fecha = fecha;
	}

	@Override
	  public String toString() {
	      return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	  }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altitud);
		result = prime * result + ((codigo_OBS == null) ? 0 : codigo_OBS.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((fenomeno == null) ? 0 : fenomeno.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Arrays.hashCode(imagen);
		result = prime * result + Float.floatToIntBits(latitud);
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + Float.floatToIntBits(longitud);
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
		Observacion other = (Observacion) obj;
		if (Float.floatToIntBits(altitud) != Float.floatToIntBits(other.altitud))
			return false;
		if (codigo_OBS == null) {
			if (other.codigo_OBS != null)
				return false;
		} else if (!codigo_OBS.equals(other.codigo_OBS))
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
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (fenomeno == null) {
			if (other.fenomeno != null)
				return false;
		} else if (!fenomeno.equals(other.fenomeno))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(imagen, other.imagen))
			return false;
		if (Float.floatToIntBits(latitud) != Float.floatToIntBits(other.latitud))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (Float.floatToIntBits(longitud) != Float.floatToIntBits(other.longitud))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
    
	
	
}
