package com.target.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="TELEFONES")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="TELEFONE_ID")
	private int id;
	
	@Column (name="NUMERO_TELEFONE")
	private int numero;
	
	@Column (name = "TIPO_TELEFONE")
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipo;

	public Telefone() {
		// TODO Auto-generated constructor stub
	}
	
	public Telefone(int numero, TipoTelefone tipo) {
	  this.numero = numero;
	  this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}
	
	

}
