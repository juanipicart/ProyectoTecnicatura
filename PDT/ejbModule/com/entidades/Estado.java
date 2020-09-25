package com.entidades;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ESTADO_OBSERV")
public class Estado implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Estado() {
		super();
	}
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="ID_ESTADO")
    private long id;
	@Column(name="NOMBRE", length=50, nullable=true)
    private String nombre;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Estado(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
    public String toString() {
        return String.format("Estado[%d, %s]", id, nombre);
    }
	
   
}
