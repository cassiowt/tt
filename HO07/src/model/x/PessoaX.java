package model.x;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaX implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String rg;
	private String nome;
	private String telefone;
	private String endereco;
	private static final long serialVersionUID = 1L;

	public PessoaX() {
		// TODO Auto-generated constructor stub
	}

	public PessoaX(String rg, String nome, String telefone, String endereco) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public PessoaX( String nome, String telefone, String endereco) {
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
