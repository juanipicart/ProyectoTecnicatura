package com.models;

public class ObservacionDTO {
	
	private long id;
	private String codigo;
	private String descripcion;
	private float latitud;
	private float altitud;
	private float longitud;
	private String localidad;
	private String fenomeno;
	private String estado;
	private String usuario;
	private String fecha;
	
	public ObservacionDTO(long id, String codigo, String descripcion, float latitud, float altitud, float longitud,
			String localidad, String fenomeno, String estado, String usuario, String fecha) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.altitud = altitud;
		this.longitud = longitud;
		this.localidad = localidad;
		this.fenomeno = fenomeno;
		this.estado = estado;
		this.usuario = usuario;
		this.fecha = fecha;
	}
		
	public ObservacionDTO(String codigo, String descripcion, float latitud, float altitud, float longitud,
			String localidad, String fenomeno, String estado, String usuario, String fecha) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.altitud = altitud;
		this.longitud = longitud;
		this.localidad = localidad;
		this.fenomeno = fenomeno;
		this.estado = estado;
		this.usuario = usuario;
		this.fecha = fecha;
	}



	public ObservacionDTO() {
		super();
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getAltitud() {
		return altitud;
	}
	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getFenomeno() {
		return fenomeno;
	}
	public void setFenomeno(String fenomeno) {
		this.fenomeno = fenomeno;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
