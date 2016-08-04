package model.a;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa1 implements Serializable {

	@Id
	private String rg;
	private String nome;
	private String telefone;
	private String endereco;
	private static final long serialVersionUID = 1L;

	public Pessoa1() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa1(String rg, String nome, String telefone, String endereco) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Pessoa1( String nome, String telefone, String endereco) {
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
