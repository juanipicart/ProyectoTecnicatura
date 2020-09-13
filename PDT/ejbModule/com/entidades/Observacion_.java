package com.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-09-13T17:31:23.633-0300")
@StaticMetamodel(Observacion.class)
public class Observacion_ {
	public static volatile SingularAttribute<Observacion, Long> id;
	public static volatile SingularAttribute<Observacion, String> codigo_OBS;
	public static volatile SingularAttribute<Observacion, Usuario> usuario;
	public static volatile SingularAttribute<Observacion, Fenomeno> fenomeno;
	public static volatile SingularAttribute<Observacion, Localidad> localidad;
	public static volatile SingularAttribute<Observacion, String> descripcion;
	public static volatile SingularAttribute<Observacion, byte[]> imagen;
	public static volatile SingularAttribute<Observacion, Float> latitud;
	public static volatile SingularAttribute<Observacion, Float> longitud;
	public static volatile SingularAttribute<Observacion, Float> altitud;
	public static volatile SingularAttribute<Observacion, Estado> estado;
	public static volatile SingularAttribute<Observacion, Date> fecha;
}
