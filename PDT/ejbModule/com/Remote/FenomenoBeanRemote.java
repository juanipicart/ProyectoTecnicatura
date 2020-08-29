package com.Remote;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Fenomeno;
import com.entidades.Telefono;
import com.exception.ServiciosException;
@Remote
public interface FenomenoBeanRemote {
	
	boolean crearFenomeno(String codigo,String estado,String nombreFen,String descripcion,String telefonos) throws ServiciosException;
	boolean modificarFenomeno(long id, String codigo,String estado, String nombreFen,String descripcion, String tel) throws ServiciosException;
	boolean EliminarFenomeno(long codigo) throws ServiciosException;
	 List<Fenomeno> existecodigo(String codigo)throws ServiciosException;
	 List<Fenomeno> Obtenertodoslosfenomenos();
	 List<Telefono> obtenerTelEmergencia();	 

}
