package com.target.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.List;

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
		
	public Aluno(String rg, String nome, Collection<Telefone> telefones, List<Endereco> enderecos, String cnpj, String apelido) {
		super(rg, nome, telefones, enderecos, cnpj);
		this.apelido = apelido;
	}



	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String nome) {
		this.apelido = nome;
	}
   
}
