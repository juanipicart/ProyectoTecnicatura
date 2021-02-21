package com.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import javax.validation.constraints.Size;

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
import com.exception.ServiciosException;
import com.sun.prism.Image;
import com.sun.xml.internal.ws.client.RequestContext;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.expression.impl.ThisExpressionResolver;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
	    private List<Observacion> observacionesPendientes=new ArrayList<Observacion>();
	    private List<Observacion> observacionesFiltradas=new ArrayList<Observacion>();    
		private Observacion observacionSeleccionada = new Observacion();
		boolean modo1 = true;
		private List<Fenomeno> fenomenos;
		private List<Localidad> localidades;
		private List<Zona> zonas;
		private  String encoded2;
		private String zona;
		private Date hasta;
		private Date desde;
		private List<Estado> estados;
		private String estadoStr;
		private int totalPen;
		private String rechazados;
		private String aprobados;
		 
		//Propiedades
		
		
		
		
		public boolean isModo1() {
			return modo1;
		}
		
		
		
		public String getAprobados() {
			return aprobados;
		}



		public void setAprobados(String aprobados) {
			this.aprobados = aprobados;
		}



		public String getRechazados() {
			return rechazados;
		}
		public void setRechazados(String rechazados) {
			this.rechazados = rechazados;
		}
		public int getTotalPen() {
			return totalPen;
		}
		public void setTotalPen(int totalPen) {
			this.totalPen = totalPen;
		}
		public String getEstadoStr() {
			return estadoStr;
		}
		public void setEstadoStr(String estadoStr) {
			this.estadoStr = estadoStr;
		}
		public void setModo1(boolean modo1) {
			this.modo1 = modo1;
		}
		
		public List<Fenomeno> getFenomenos() {
			return fenomenos;
		}

		public List<Estado> getEstados() {
			return estados;
		}

		public void setEstados(List<Estado> estados) {
			this.estados = estados;
		}

		public List<Observacion> getObservacionesFiltradas() {
			return observacionesFiltradas;
		}

		public void setObservacionesFiltradas(List<Observacion> observacionesFiltradas) {
			this.observacionesFiltradas = observacionesFiltradas;
		}

		public List<Observacion> getObservacionesPendientes() {
			return observacionesPendientes;
		}

		public void setObservacionesPendientes(List<Observacion> observacionesPendientes) {
			this.observacionesPendientes = observacionesPendientes;
		}

		public Date getHasta() {
			return hasta;
		}

		public void setHasta(Date hasta) {
			this.hasta = hasta;
		}

		public Date getDesde() {
			return desde;
		}

		public void setDesde(Date desde) {
			this.desde = desde;
		}

		public String getZona() {
			return zona;
		}

		public void setZona(String zona) {
			this.zona = zona;
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

		//contructor por defecto
		public ObservacionBean() {
		}
		
		//contructor completo
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
		
		@Override
		public String toString() {
		return "Observacion{" +
		"mCodigo='" + this.codigo_OBS + '\'' +
		", mFenomeno='" + this.fenomeno + '\'' +
		", mLocalidad='" + this.localidad +
		", mFecha='" + this.fecha +
		'}';
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
		public void actualizarObservacion(Observacion observacion){
			try{
				
				Observacion aux = observacionBeanRemote.obtenerObservacionPorId(id);
				
				Localidad l = localidadBeanRemote.obtenerLocalidad(localidad.getNombreLoc());
				Fenomeno f = fenomenoBeanRemote.ObtenerFenomeno(fenomeno.getNombreFen());
				
				observacion.setLocalidad(l);
				observacion.setFenomeno(f);
				observacion.setUsuario(aux.getUsuario());
				observacion.setImagen(aux.getImagen());
				observacion.setEstado(aux.getEstado());
				observacion.setId(aux.getId());
				observacion.setCodigo_OBS(aux.getCodigo_OBS());
				
				if (observacion.getAltitud() > 520 || observacion.getAltitud()<0)
				{
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"La altitud ingresada no es válida, desde 0 mts a 520 mts", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				}
				
				else if (observacion.getLongitud() > 60 || observacion.getLongitud()<-60)
				{
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"La longitud ingresada no es válida, desde -60° a 60°", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				}
				
				else if (observacion.getLatitud() > 60 || observacion.getLatitud()<-60)
				{
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"La latitud ingresada no es válida, desde -60° a 60°", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				}
				
				else
				{
				observacionBeanRemote.ModificarObservacion(observacion.getId(), observacion.getCodigo_OBS(), 
						observacion.getUsuario().getUsuario(), observacion.getFenomeno().getNombreFen(), 
						observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), 
						observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), 
						observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
				//mensaje de actualizacion correcta
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Se actualizó la observación. ", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				}
			}catch(Exception e){
			e.getMessage();
			}
		}
		
		public String aprobarObservacion(Observacion observacion) {
			
			try {
			observacion = observacionBeanRemote.obtenerObservacionPorId(id);
			Estado estado = estadoBeanRemote.ObtenerEstado("APROBADA");
			observacion.setEstado(estado);
			totalPen = totalPen-1;
		    
			
			observacionBeanRemote.ModificarObservacion(observacion.getId(), observacion.getCodigo_OBS(), 
					observacion.getUsuario().getUsuario(), observacion.getFenomeno().getNombreFen(), 
					observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), 
					observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), 
					observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
			
			Estado e = estadoBeanRemote.ObtenerEstado("PENDIENTE");
			List<Observacion>observacionesP = observacionBeanRemote.obtenerTodasObservacionesPendientes(e);
			observacionesPendientes = observacionesP;
			
			//mensaje de actualizacion correcta
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Se aprobó la observación. ", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			
			
			observacionBeanRemote.revisarObservacion(observacion.getUsuario().getId(), observacion.getId(), 
					date, observacion.getEstado().getNombre(), aprobados);
			
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usu);
			return "ListadoObservaciones.xhtml";
			}
			catch(Exception ex)
			{
				ex.getMessage();
				return "Error al aprobar la observación";
			}
			}
		
		public String rechazarObservacion(Observacion observacion) {
			
			try {
			observacion = observacionBeanRemote.obtenerObservacionPorId(id);
			Estado estado = estadoBeanRemote.ObtenerEstado("RECHAZADA");
			observacion.setEstado(estado);
			totalPen = totalPen-1;
			
			observacionBeanRemote.ModificarObservacion(observacion.getId(), observacion.getCodigo_OBS(), 
					observacion.getUsuario().getUsuario(), observacion.getFenomeno().getNombreFen(), 
					observacion.getLocalidad().getNombreLoc(), observacion.getDescripcion(), 
					observacion.getImagen(), observacion.getLatitud(), observacion.getLongitud(), 
					observacion.getAltitud(), observacion.getEstado().getNombre(), observacion.getFecha());
			
			Estado e = estadoBeanRemote.ObtenerEstado("PENDIENTE");
			List<Observacion>observacionesP = observacionBeanRemote.obtenerTodasObservacionesPendientes(e);
			observacionesPendientes = observacionesP;
			
			//mensaje de actualizacion correcta
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Se rechazo la observación. ", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			
			
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			
			
			observacionBeanRemote.revisarObservacion(observacion.getUsuario().getId(), observacion.getId(), 
					date, observacion.getEstado().getNombre(), rechazados);
			return "ListadoObservaciones.xhtml";
			}
			catch (Exception ex)
			{
				ex.getMessage();
				return "Error al rechazar la observación";
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
		    Estado e = estadoBeanRemote.ObtenerEstado("PENDIENTE");
		    observacionesPendientes=observacionBeanRemote.obtenerTodasObservacionesPendientes(e);
		    totalPen = observacionesPendientes.size();
		    observacionesFiltradas = observacionBeanRemote.obtenerTodasObservaciones();
		    estados = estadoBeanRemote.obtenerTodosEstados();
		}
		
		public void onDateSelect(SelectEvent event) {  
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");  
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));  
			}  
		
		public boolean VerificarTipo(String tipoEnviado) {
			boolean tipo = true;
			Usuario tipoUsu = usuarioBeanRemote.obtenerUsuario(tipoEnviado);
			if ((tipoUsu.getTipousuario().getNombre() == "EXPERTO" || tipoUsu.getTipousuario().getId() == 2))		
			{
				tipo = false;
			}
			return tipo;
		}

		public boolean VerificarEstado(long id) {
			boolean bandera = false;
			Observacion o = observacionBeanRemote.obtenerObservacionPorId(id);
			String estado = o.getEstado().getNombre(); 
			
			if (estado.equals("PENDIENTE"))
			{
				bandera = true;
			}
			return bandera;
		}
		
		public String codificar()
		{
			try {
			if ( observacionSeleccionada.getImagen() != null) {	
				encoded2 = Base64.getEncoder().encodeToString(observacionSeleccionada.getImagen());
				return ("data:image/jpg;base64,"+encoded2);
			}
			else
				return ("");
			}
			catch (Exception ex)
			{
				ex.getMessage();
				return ("Error al cargar imagen");
			}
		}
		
		public String ImagenTxt() {
			if (codificar() == "")
			{
				return "No hay imagen disponible";
			}
			else 
				return "";
		}
		
		public List<Observacion>seleccionarObservacionesLista(String zona, Date hasta, Date desde, String estadoStr)
		{
			try {
				List <Observacion> filtradas = new ArrayList<Observacion>();
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				//java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
				
				if (hasta !=null && desde != null && hasta.before(desde))
				{
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"La fecha Hasta no puede ser anterior a la fecha Desde", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				}
				
				else if (hasta !=null && hasta.after(date))
				{
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"La fecha no puede ser posterior al dia de hoy", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				}
				
				else 
				{
					observacionesFiltradas = observacionBeanRemote.obtenerTodasObservaciones();
					for (Observacion o : observacionesFiltradas)
					{
						if(
								(zona == null || zona.isEmpty() || o.getLocalidad().getDepartamento().getZona().getNombre_zona().equals(zona))  
								&& (estadoStr == null || estadoStr.isEmpty() || o.getEstado().getNombre().equals(estadoStr))  
								&& (hasta == null || hasta.toString().isEmpty() || o.getFecha().before(hasta) || (o.getFecha().compareTo(hasta)==0)) 
								&& (desde == null || desde.toString().isEmpty() || o.getFecha().after(desde) || (o.getFecha().compareTo(desde)==0))
						)
								{
									filtradas.add(o);
								}
					}
				}
				return filtradas;
			}
			catch (Exception ex)
			{
				ex.getMessage();
				return null;
			}
		}
		
		public String SinObservaciones()
		{
			if (totalPen == 0)
			{
				return "Por el momento no hay mas observaciones pendientes";
			}
			return "";
		}

		public String seleccionarObservaciones() {
			observacionesFiltradas = seleccionarObservacionesLista(zona, hasta, desde, estadoStr); 
			return "";
		}
		
		public void handleClose(CloseEvent event) {
	        addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
	    }
	     
	    public void handleMove(MoveEvent event) {
	        addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
	    }
	     
	    public void RechazoModal() {
	        addMessage("Observacion Rechazada", "La observacion se rechazó correctamente");
	    }
	    
	    public void ApruebaModal() {
	        addMessage("Observacion Aprobada", "La observacion se aprobó correctamente");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
}	