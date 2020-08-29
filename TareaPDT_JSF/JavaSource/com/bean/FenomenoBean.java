package com.bean;

import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.inject.Named;


import com.Remote.FenomenoBeanRemote;
import com.entidades.Fenomeno;
import com.entidades.Telefono;

@ManagedBean(name="fenomeno")
@SessionScoped
public class FenomenoBean implements Serializable{
		
		private static final long serialVersionUID1 = 1L;

		@EJB
		private FenomenoBeanRemote fenomenoBeanRemote;
		
	    public FenomenoBean() {
	        
	    }
	    
	 
	 
	    
	    private long id;
	    private String codigo;
	    private String nombreFen;
	    private String estado;
	    private String descripcion;  
	    private String telefonos;
	    private List<Fenomeno> ListaFenomenos=new ArrayList<Fenomeno>();
	    private Fenomeno fenomenoseleccionado = new Fenomeno();
	    
	 

		public Fenomeno getFenomenoseleccionado() {
			return fenomenoseleccionado;
		}


		public void setFenomenoseleccionado(Fenomeno fenomenoseleccionado) {
			this.fenomenoseleccionado = fenomenoseleccionado;
		}


		public FenomenoBean(String codigo, String nombreFen, String estado, String descripcion, String telefonos) {
			super();
			
			this.codigo = codigo;
			this.nombreFen = nombreFen;
			this.estado = estado;
			this.descripcion = descripcion;
			this.telefonos = telefonos;
		}


		public String getEstado() {
			return estado;
		}


		public void setEstado(String estado) {
			this.estado = estado;
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
		public String getNombreFen() {
			return nombreFen;
		}
		public void setNombreFen(String nombreFen) {
			this.nombreFen = nombreFen;
		}


		public String getDescripcion() {
			return descripcion;
		}



		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public String getTelefonos() {
			return telefonos;
		}


		public void setTelefonos(String telefonos) {
			this.telefonos = telefonos;
		}
		   public List<Fenomeno> getListaFenomenos() {
				return ListaFenomenos;
			}


			public void setListaFenomenos(List<Fenomeno> ListaFenomenos) {
				this.ListaFenomenos = ListaFenomenos;
			}
			


		public String CrearFenomeno (Fenomeno fenomeno)
		{
			try 
			{
				fenomenoBeanRemote.crearFenomeno(codigo, estado, nombreFen, descripcion, telefonos);
				// Mensaje de alta
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Se creo el fenomeno: ", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				return "";
			}catch(Exception e)
			{
				return null;
			}
		}
		public String ObtenerFenomenos() 
		{
			ListaFenomenos= fenomenoBeanRemote.Obtenertodoslosfenomenos();
			return "";
		}
		
		

}
