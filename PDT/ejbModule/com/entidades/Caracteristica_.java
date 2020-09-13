package com.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-09-13T17:31:23.565-0300")
@StaticMetamodel(Caracteristica.class)
public class Caracteristica_ {
	public static volatile SingularAttribute<Caracteristica, Long> id;
	public static volatile SingularAttribute<Caracteristica, String> nombre;
	public static volatile SingularAttribute<Caracteristica, String> etiqueta;
	public static volatile SingularAttribute<Caracteristica, String> tipoDato;
	public static volatile SingularAttribute<Caracteristica, Fenomeno> fenomeno;
}
