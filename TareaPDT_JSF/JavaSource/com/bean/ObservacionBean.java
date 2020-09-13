package com.bean;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.swing.ImageIcon;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.Remote.EstadoBeanRemote;
import com.Remote.FenomenoBeanRemote;
import com.Remote.LocalidadBeanRemote;
import com.Remote.ObservacionBeanRemote;
import com.Remote.UsuarioBeanRemote;
import com.Remote.ZonaBeanRemote;
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
import com.entidades.Zona;
import com.sun.prism.Image;
import com.sun.xml.internal.ws.client.RequestContext;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;  
import javax.faces.context.FacesContext;  
import org.primefaces.event.SelectEvent;
import org.primefaces.expression.impl.ThisExpressionResolver;  


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
		@EJB
		private ZonaBeanRemote zonaBeanRemote;
		Zona zon = new Zona();
		
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
		private List<Fenomeno> fenomenos;
		private List<Localidad> localidades;
		private List<Zona> zonas;
		private  String encoded2;
		
		//Propiedades
		
		public List<Fenomeno> getFenomenos() {
			return fenomenos;
		}

		public String getEncoded2() {
			return encoded2;
		}

		public void setEncoded2(String encoded2) {
			this.encoded2 = encoded2;
		}

		public List<Zona> getZonas() {
			return zonas;
		}

		public void setZonas(List<Zona> zonas) {
			this.zonas = zonas;
		}

		public void setFenomenos(List<Fenomeno> fenomenos) {
			this.fenomenos = fenomenos;
		}
		
		public List<Localidad> getLocalidades() {
			return localidades;
		}

		public void setLocalidades(List<Localidad> localidades) {
			this.localidades = localidades;
		}

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
		
		/***************METODOS******************/
		
		
		//Renderizar
		public void preRenderViewListener() {
			modo1 = true;
			if (id != 0) {
				observacionSeleccionada = observacionBeanRemote.obtenerObservacionPorId(id);
			} 
		}
		
		//Actualizar
		public String actualizarObservacion(Observacion observacion){
			try{
				observacionBeanRemote.ModificarObservacion(observacion.getId(), observacion.getCodigo_OBS(), 
						observacion.getUsuario().getUsuario(), observacion.getFenomeno().getNombreFen(), 
						observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), 
						observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), 
						observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
				//mensaje de actualizacion correcta
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Se actualizo la observacion. ", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				return "";
			}catch(Exception e){
				return null;
			}
		}
		
		//Transformar Fecha
		public String NuevaFecha(Date fecha)
		{
			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		     String today = formatter.format(fecha);
		     return today;
		}
		
		//Luego del Constructor
		@PostConstruct
		public void init() {
		    fenomenos = fenomenoBeanRemote.Obtenertodoslosfenomenos();
		    localidades = localidadBeanRemote.obtenerTodasLocalidades();
		    zonas = zonaBeanRemote.obtenerTodasZonas();
		    observacionesSeleccionadas=observacionBeanRemote.obtenerTodasObservaciones();
		}
		
		public void onDateSelect(SelectEvent event) {  
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");  
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));  
			}  
		
		public boolean VerificarTipo() {
			boolean tipo = false; 
			if (observacionSeleccionada.getUsuario().getTipousuario().getNombre() != "EXPERTO")		
			{
				tipo = true;
			}
			return tipo;
		}
		
		public String codificar()
		{
			try {
			if ( observacionSeleccionada.getImagen() != null) {	
			return (encoded2 = Base64.getEncoder().encodeToString(observacionSeleccionada.getImagen()));
			}
			else
				return ("No hay imagen disponible");
			}
			catch (Exception ex)
			{
				ex.getMessage();
				return ("Error al cargar imagen");
			}
		}
		
		public List<Observacion>seleccionarObservaciones(Date desde, Date hasta, String zona){
			
			try {
			observacionesSeleccionadas=observacionBeanRemote.obtenerTodasObservaciones();
			List<Observacion> filtradas = new ArrayList<Observacion>();
			
			for (Observacion o : observacionesSeleccionadas)
			{
				//si la zona es la misma que el objeto y la fecha se encuentra en el rango lo agrego a la lista
				if (zona == o.getLocalidad().getDepartamento().getZona().getNombre_zona() &&
					(o.getFecha().after(desde) && o.getFecha().before(hasta)))
				
				filtradas.add(o);
			}
			
			return filtradas;	
		}
			catch (Exception ex)
			{
				ex.getMessage();
				return null;
			}
		}
}	