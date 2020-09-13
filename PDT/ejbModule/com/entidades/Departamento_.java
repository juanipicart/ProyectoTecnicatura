package com.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-09-13T17:31:23.597-0300")
@StaticMetamodel(Departamento.class)
public class Departamento_ {
	public static volatile SingularAttribute<Departamento, Long> id;
	public static volatile SingularAttribute<Departamento, String> nombreDep;
	public static volatile SingularAttribute<Departamento, Zona> zona;
}
