package com.operacoes.model;

import javax.persistence.*;


@Entity
@NamedQueries({
	@NamedQuery(name = "Endereco.listAll", query = "SELECT e FROM Endereco e"),
	@NamedQuery(name="query", query="SELECT e FROM Endereco e")})
@Table(name = "ENDERECOS")
public class Endereco {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column (name = "ENDERECO_ID")
	private Long Id;
	
	
	public Long getId() {
		return Id;
	}

	private String endereco;
	
	public Endereco() {
	}

	public Endereco(String endereco) {
		super();
		this.endereco = endereco;
	}


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
