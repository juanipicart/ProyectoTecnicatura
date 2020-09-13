package com.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-09-13T17:31:23.626-0300")
@StaticMetamodel(Localidad.class)
public class Localidad_ {
	public static volatile SingularAttribute<Localidad, Long> id;
	public static volatile SingularAttribute<Localidad, Departamento> departamento;
	public static volatile SingularAttribute<Localidad, String> nombreLoc;
	public static volatile SingularAttribute<Localidad, Float> latitud;
	public static volatile SingularAttribute<Localidad, Float> longitud;
	public static volatile SingularAttribute<Localidad, Float> altitud;
}
