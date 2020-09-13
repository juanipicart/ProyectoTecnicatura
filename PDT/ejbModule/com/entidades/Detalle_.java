package com.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-09-13T17:31:23.603-0300")
@StaticMetamodel(Detalle.class)
public class Detalle_ {
	public static volatile SingularAttribute<Detalle, PK_Detalle> pkDetalle;
	public static volatile SingularAttribute<Detalle, Integer> valorNum;
	public static volatile SingularAttribute<Detalle, String> valorText;
	public static volatile SingularAttribute<Detalle, Date> fecha;
}
