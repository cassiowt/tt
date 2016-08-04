package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PESSOA_HIERARQUIA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINADOR", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
public class Pessoa implements Serializable {

	@Id
	private String rg;
	private String nome;
	private String telefone;
	private String endereco;
	private static final long serialVersionUID = 1L;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String rg, String nome, String telefone, String endereco) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Pessoa( String nome, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
