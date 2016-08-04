package com.target.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Professor
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Professor extends Pessoa implements Serializable {

	
	private String pisPasep;
	private int salario;
	private static final long serialVersionUID = 1L;
	
public Professor() {
}


	public Professor(String rg, String nome, Collection<Telefone> telefones,
		List<Endereco> enderecos, String pisPasep, int salario) {
	super(rg, nome, telefones, enderecos);
	this.pisPasep = pisPasep;
	this.salario = salario;
}


	public String getPis_pasep() {
		return this.pisPasep;
	}

	public void setPis_pasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}   
	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
   
}
