package com.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-09-13T17:31:23.621-0300")
@StaticMetamodel(Fenomeno.class)
public class Fenomeno_ {
	public static volatile SingularAttribute<Fenomeno, Long> id;
	public static volatile SingularAttribute<Fenomeno, String> codigo;
	public static volatile SingularAttribute<Fenomeno, String> nombreFen;
	public static volatile SingularAttribute<Fenomeno, String> estado;
	public static volatile SingularAttribute<Fenomeno, String> descripcion;
	public static volatile SingularAttribute<Fenomeno, Telefono> telefonos;
}
