package com.target.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aluno
 *
 */
@Entity
@PrimaryKeyJoinColumn (name="PESSOA_ID")
public class Aluno extends Cliente implements Serializable {

	   
	@Override
	public String toString() {
		return "Aluno [apelido=" + apelido 
				     + ", Nome=" + getNome()
					 + ", CNPJ=" + getCnpj() 
					   + ", ID=" + getId() 
					   + ", RG=" + getRg()
					   + "]";
	}

	@Column(length=60)
	private String apelido;
	private static final long serialVersionUID = 1L;

	public Aluno() {
		super();
	}   
	
	public Aluno(String apelido) {
		super();
		this.apelido = apelido;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String nome) {
		this.apelido = nome;
	}
   
}
