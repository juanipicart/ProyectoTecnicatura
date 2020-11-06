package com.servicios;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.Remote.ObservacionBeanRemote;
import com.dao.*;
import com.entidades.*;
import com.exception.ServiciosException;


@Stateless
@LocalBean
public class ObservacionBean implements ObservacionBeanRemote {


	@EJB
	private Observaciondao obsDao;
	Observacion obs = new Observacion();
	@EJB
	private Usuariodao usuDao;
	Usuario usu = new Usuario();
	@EJB
	private Localidaddao locDao;
	Localidad loc = new Localidad();
	@EJB
	private Estadodao estDao;
	Estado est = new Estado();
	@EJB
	private Fenomenodao fenDao;
	Fenomeno fen = new Fenomeno();
	
	
	
    public ObservacionBean() 
    {}
    
	@Override
    public boolean CrearObservacion(String CodOBS, String usuario, String fenomeno, String localidad, 
    		String descripcion,  byte[] imagen, float latitud, float longitud, float altitud, String estado, Date fecha) throws ServiciosException
    {
    	boolean pudeCrear;
    	
    	Usuario usu = this.usuDao.obtenerUsuario(usuario);
    	Fenomeno fen = this.fenDao.obtenerNombreFen(fenomeno);
		Localidad loc = this.locDao.obtenerLocalidad(localidad);
		Estado est = this.estDao.obtenerEstadonombre(estado);
    	
    	obs = new Observacion(CodOBS, usu, fen, loc, descripcion, imagen, latitud ,longitud, altitud, est, fecha);
    	
    	try {
    		
    		this.obsDao.AgregarObservacion(obs);
    		pudeCrear = true;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		pudeCrear = false;
    	}
    	
    	return pudeCrear;	
    }
	
	@Override
    public boolean ModificarObservacion(Long id, String CodOBS, String usuario, String fenomeno, String localidad, 
    		String descripcion,  byte[] imagen, float latitud, float longitud, float altitud, String estado, Date fecha) throws ServiciosException
    {		
    	boolean pudeModificar;
    	
    	Usuario usu = this.usuDao.obtenerUsuario(usuario);
		Fenomeno fen = this.fenDao.obtenerNombreFen(fenomeno);
		Localidad loc = this.locDao.obtenerLocalidad(localidad);
		Estado est = this.estDao.obtenerEstadonombre(estado);
    	
    	
    	obs.setCodigo_OBS(CodOBS);
    	obs.setId(id); 
    	obs.setUsuario(usu);
    	obs.setFenomeno(fen);
    	obs.setLocalidad(loc);
    	obs.setDescripcion(descripcion);
    	obs.setImagen(imagen);
    	obs.setLatitud(latitud);
    	obs.setLongitud(longitud);
    	obs.setAltitud(altitud);
    	obs.setEstado(est);
    	obs.setFecha(fecha);
    	
    	
    	try {
    		this.obsDao.ModificarObservacion(obs);
    		pudeModificar = true;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		pudeModificar = false;
    	}
    	
    	return pudeModificar;	
    }
	
	@Override
	public boolean EliminarObservacion(long id) throws ServiciosException{
    	boolean pudeEliminar;
		try {
			this.obsDao.EliminarObservacion(id);
			pudeEliminar=true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			pudeEliminar=false;
		}
		return pudeEliminar;
	}
	
	@Override
	public List<Observacion> obtenerTodasObservaciones(){

		 List <Observacion> observaciones = this.obsDao.obtenerTodasObservaciones();		
		 return observaciones;
	}
	
	
	@Override
	public List<Observacion> obtenerObservacionFechaZona(Date desde, Date hasta, String zona){
		
		List<Observacion> observaciones = this.obsDao.obtenerObservacionFechaZona(desde, hasta, zona);
		return observaciones;
	}
	
	
	@Override
	public boolean validarDescripcion(Observacion obs, List<String> palabras) {
		boolean estaLimpia = true; 
		int i = 0;
		
		while(estaLimpia && i < palabras.size()) {
			if(obs.getDescripcion().contains(palabras.get(i)))
				estaLimpia = false;
		}
		
		return estaLimpia;		
	}
	
	@Override
	public boolean revisarObservacion(long usuario, long id_observacion, Date fecha, String estado, String comentarios) {
		boolean pudeRevisar = false;
		try {
			PK_ExRevisaObs revisaPk = new PK_ExRevisaObs(usuario, id_observacion, fecha);
			ExRevisaObs revisa = new ExRevisaObs(revisaPk, estado, comentarios);
			obsDao.revisarObservación(revisa);
			pudeRevisar = true;
		} catch (Exception e){
			e.getMessage();
		}
		
		return pudeRevisar;
		
	}

	@Override
	public List<Observacion> existeObservacion(String identificacion){
		List <Observacion> observaciones = this.obsDao.existeObservacion(identificacion);		
		 return observaciones;
	}
	
	@Override
	public Observacion obtenerObservacionPorId(long id) {
		Observacion observacion = obsDao.obtenerObservacionPorId(id);
		 
		return observacion;
	}

	@Override
	public List<Observacion> obtenerTodasObservacionesPendientes(Estado pendiente) {
		List<Observacion> obs = obsDao.obtenerTodasObservacionesPendientes(pendiente);
		return obs;
	}

	@Override
	public List<Observacion> obtenerObservacionesPorUsuario(Usuario usuario) {
		Estado estado = estDao.obtenerEstadonombre("ELIMINADA");
		List<Observacion> obs = obsDao.obtenerObservacionesUsuario(usuario, estado);
		return obs;
	}

	@Override
	public Observacion obtenerObservacionPorCodigo(String codigo) {
		Observacion observacion = obsDao.obtenerObservacionPorCodigo(codigo);
		return observacion;
	}
	
	
	
}
