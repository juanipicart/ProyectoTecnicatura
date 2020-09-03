package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.Remote.EstadoBeanRemote;
import com.Remote.FenomenoBeanRemote;
import com.Remote.LocalidadBeanRemote;
import com.Remote.ObservacionBeanRemote;
import com.Remote.UsuarioBeanRemote;
import com.dao.Estadodao;
import com.dao.Fenomenodao;
import com.dao.Localidaddao;
import com.dao.Observaciondao;
import com.dao.Usuariodao;
import com.entidades.Estado;
import com.entidades.Fenomeno;
import com.entidades.Localidad;
import com.entidades.Observacion;
import com.entidades.Usuario;

@ManagedBean(name="observacion")
@SessionScoped
public class ObservacionBean implements Serializable{
	
		private static final long serialVersionUID = 1L;
		
		@EJB
		private ObservacionBeanRemote observacionBeanRemote;
		@EJB
		private UsuarioBeanRemote usuarioBeanRemote;
		Usuario usu = new Usuario();
		@EJB
		private LocalidadBeanRemote localidadBeanRemote;
		Localidad loc = new Localidad();
		@EJB
		private EstadoBeanRemote estadoBeanRemote;
		Estado est = new Estado();
		@EJB
		private FenomenoBeanRemote fenomenoBeanRemote;
		Fenomeno fen = new Fenomeno();
		
		//Atributos
	    private long id;
	    private String codigo_OBS;
		private Usuario usuario; 
	    private Fenomeno fenomeno; 
	    private Localidad localidad; 
	    private String descripcion;
	    private byte[] imagen;
	    private float latitud;
		private float longitud;
		private float altitud;
		private Estado estado;
	    private Date fecha;
	    private List<Observacion> observacionesSeleccionadas=new ArrayList<Observacion>();    
		private Observacion observacionSeleccionada = new Observacion();
		boolean modo1 = true;
	    
		//Propiedades
		
		public Observacion getObservacionSeleccionada() {
			return observacionSeleccionada;
		}

		public void setObservacionSeleccionada(Observacion observacionSeleccionada) {
			this.observacionSeleccionada = observacionSeleccionada;
		}


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
		
		public List<Observacion> getObservacionesSeleccionadas() {
			return observacionesSeleccionadas;
		}

		public void setObservacionesSeleccionadas(List<Observacion> observacionesSeleccionadas) {
			this.observacionesSeleccionadas = observacionesSeleccionadas;
		}

		//contructor por defecto
		public ObservacionBean() {
		}
		
		//contructor comppleto
		public ObservacionBean(String codigo_OBS, Usuario usuario, Fenomeno fenomeno, Localidad localidad,
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
		
		//Metodos
		
		public String seleccionarObservaciones() {
			observacionesSeleccionadas=observacionBeanRemote.obtenerTodasObservaciones();
			return "";
		}
		
		public void preRenderViewListener() {
			modo1 = true;
			if (id != 0) {
				observacionSeleccionada = observacionBeanRemote.obtenerObservacionPorId(id);
			} 
		}
		
		
}
