package model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bairros
 * 
 */
@Entity
@Table(name = "BAIRROS")
public class Bairro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BAIRRO_ID")
	private int id;
	
	@Column(length=60)
	private String nome;

	@OneToMany(mappedBy = "bairro")
	private Collection<Endereco> endereco = new ArrayList<Endereco>();

	@ManyToOne
	@JoinColumn(name = "CIDADE_ID",nullable=false)
	private Cidade cidade;

	private static final long serialVersionUID = 1L;

	public Bairro() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(Collection<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
