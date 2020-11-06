package com.models;

public class ObservacionDTO {
	
	private long id;
	private String codigo;
	private String descripcion;
	private float latitud;
	private float altitud;
	private float longitud;
	private String localidad;
	private String departamento;
	private String fenomeno;
	private String estado;
	private String usuario;
	private String fecha;
	private String imagen;
	
	public ObservacionDTO(long id, String codigo, String descripcion, float latitud, float altitud, float longitud,
			String localidad, String departamento, String fenomeno, String estado, String usuario, String fecha, String imagen) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.altitud = altitud;
		this.longitud = longitud;
		this.localidad = localidad;
		this.departamento = departamento;
		this.fenomeno = fenomeno;
		this.estado = estado;
		this.usuario = usuario;
		this.fecha = fecha;
		this.setImagen(imagen);
	}
		
	public ObservacionDTO(String codigo, String descripcion, float latitud, float altitud, float longitud,
			String localidad, String departamento, String fenomeno, String estado, String usuario, String fecha, String imagen) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.altitud = altitud;
		this.longitud = longitud;
		this.localidad = localidad;
		this.departamento = departamento;
		this.fenomeno = fenomeno;
		this.estado = estado;
		this.usuario = usuario;
		this.fecha = fecha;
		this.imagen = imagen;
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
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
