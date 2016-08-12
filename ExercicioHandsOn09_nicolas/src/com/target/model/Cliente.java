package com.target.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente extends Pessoa implements Serializable {

	@Column(length=24)
	private String cnpj;
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}

	
	public Cliente(String rg, String nome, Collection<Telefone> telefones,
			List<Endereco> enderecos, String cnpj) {
		super(rg, nome, telefones, enderecos);
		this.cnpj = cnpj;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
   
	
	
}
