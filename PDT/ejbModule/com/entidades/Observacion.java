package com.entidades;

import java.io.Serializable;
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

    
    
}
