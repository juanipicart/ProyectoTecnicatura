package com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "DETALLE")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;
	
    //Esta es una PK compuesta que esta definida en la entity PK_Detalle
	@EmbeddedId
	private PK_Detalle pkDetalle;
	
	    @Column(name="VALORNUM", length=10, nullable=true)
	    private int valorNum;
	    
	    @Column(name="VALORTEXTO", length=40, nullable=true)
	    private String valorText;

	    @Column(name="FECHORA")
		private Date fecha;
		
		

			public PK_Detalle getPkDetalle() {
			return pkDetalle;
		}

		public void setPkDetalle(PK_Detalle pkDetalle) {
			this.pkDetalle = pkDetalle;
		}

			public int getValorNum() {
			return valorNum;
		}

		public void setValorNum(int valorNum) {
			this.valorNum = valorNum;
		}

		public String getValorText() {
			return valorText;
		}

		public void setValorText(String valorText) {
			this.valorText = valorText;
		}
		
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		
		
		
		public Detalle(PK_Detalle pkDetalle, int valorNum, String valorText, Date fecha) {
			super();
			this.pkDetalle = pkDetalle;
			this.valorNum = valorNum;
			this.valorText = valorText;
			this.fecha = fecha;
		}

		public Detalle() {
			super();
		}		
	
}
