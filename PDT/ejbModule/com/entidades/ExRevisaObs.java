package com.entidades;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "REVISA")
public class ExRevisaObs implements Serializable {
	private static final long serialVersionUID = 1L;

	//Esta es una PK compuesta que esta definida en la entity PK_ExRevisaObs
	@EmbeddedId
	private PK_ExRevisaObs pkRevisa;
	
	
	@Column(name="FIABILIDAD", nullable=true)
	private String Fiabilidad;
	
	@Column(name="COMENTARIOS")
	private String Comentarios;
	
	
	public PK_ExRevisaObs getPkRevisa() {
		return pkRevisa;
	}

	public void setPkRevisa(PK_ExRevisaObs pkRevisa) {
		this.pkRevisa = pkRevisa;
	}
	
	public String getFiabilidad() {
		return Fiabilidad;
	}

	public void setFiabilidad(String fiabilidad) {
		Fiabilidad = fiabilidad;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}



	
	public ExRevisaObs(PK_ExRevisaObs pkRevisa, String fiabilidad, String comentarios) {
		super();
		this.pkRevisa = pkRevisa;
		Fiabilidad = fiabilidad;
		Comentarios = comentarios;
	}

	public ExRevisaObs() {
		super();
	}
	
	
}
