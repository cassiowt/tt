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

	   
	@Column(length=60)
	private String apelido;
	private static final long serialVersionUID = 1L;

	public Aluno() {
		super();
	}   
	
	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String nome) {
		this.apelido = nome;
	}
   
}
