package com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CARACTERISTICAS")
public class Caracteristica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Caracteristica() {
        
    }
	
			@Id
			@SequenceGenerator(name="secuenciacaracteristica",sequenceName="SEQ_CARACTERISTICASID", initialValue=1, allocationSize=100)
		    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuenciacaracteristica")
			@Column(name="ID_CARACT")
		    private long id;
			@Column(name="NOMBRE", length=50, nullable=true)
		    private String nombre;
		    @Column(name="ETIQUETA", length=50, nullable=true)
		    private String etiqueta;
		    @Column(name="TIPODATO", length=50, nullable=true)
		    private String tipoDato;
		    
		    @ManyToOne (optional=false)
		    @JoinColumn (name="CODIGO_FEN")
		    private Fenomeno fenomeno;
		    
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
			public String getEtiqueta() {
				return etiqueta;
			}
			public void setEtiqueta(String etiqueta) {
				this.etiqueta = etiqueta;
			}
			public String getTipoDato() {
				return tipoDato;
			}
			public void setTipoDato(String tipoDato) {
				this.tipoDato = tipoDato;
			}
			
			public Fenomeno getFenomenos() {
				return fenomeno;
			}
			public void setFenomenos(Fenomeno fenomenos) {
				this.fenomeno = fenomenos;
			}
			
			public Fenomeno getFenomeno() {
				return fenomeno;
			}
			public void setFenomeno(Fenomeno fenomeno) {
				this.fenomeno = fenomeno;
			}
			
			public Caracteristica(long id, Fenomeno fenomeno, String nombre, String etiqueta, String tipoDato) {
				super();
				this.id = id;
				this.fenomeno = fenomeno;
				this.nombre = nombre;
				this.etiqueta = etiqueta;
				this.tipoDato = tipoDato;
			}
}