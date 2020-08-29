package com.Remote;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import com.entidades.*;
import com.exception.ServiciosException;

@Remote
public interface ObservacionBeanRemote {

	boolean CrearObservacion (String CodOBS, String usuario, String fenomeno, String localidad, 
    		String descripcion,  byte[] imagen, float latitud, float longitud, float altitud, String estado, Date fecha) throws ServiciosException;
	
	boolean ModificarObservacion(Long id, String CodOBS, String usuario, String fenomeno, String localidad, 
    		String descripcion,  byte[] imagen, float latitud, float longitud, float altitud, String estado, Date fecha) throws ServiciosException;
	 
	boolean EliminarObservacion(long id) throws ServiciosException;
		
	List <Observacion> obtenerTodasObservaciones();
		
	boolean validarDescripcion(Observacion obs, List<String> palabras);
		
	List<Observacion> existeObservacion(String identificacion);
	
}
