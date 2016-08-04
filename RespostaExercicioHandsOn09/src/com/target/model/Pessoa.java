package com.target.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Pessoa
 * 
 */
@MappedSuperclass
@NamedQueries 
({
//	@NamedQuery(name = "pessoa.list", query = "select p from Pessoa p "),
//	@NamedQuery(name = "pessoa.count", query = "select count(p) from Pessoa p"),
	@NamedQuery(name = "aluno.list", query = "select a from Aluno a "),
	@NamedQuery(name = "aluno.count", query = "select count(a) from Aluno a"),
	@NamedQuery(name = "professor.list", query = "select pf from Professor pf"),
	@NamedQuery(name = "professor.salario", query = "select pf from Professor pf where pf.salario >  :v"),
	@NamedQuery(name = "professor.count", query = "select count(p) from Professor p"),
	@NamedQuery(name = "cliente.list", query = "select c from Cliente c order by c.id "),
	@NamedQuery(name = "cliente.list.nome.cnpj", query = "select c.nome, c.cnpj from Cliente c order by c.id "),
	@NamedQuery(name = "cliente.count", query = "select count(c) from Cliente c")
})
public abstract class  Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PESSOA_ID")
	private int id;

	private String rg;
	private String nome;

	@OneToMany(cascade = { CascadeType.PERSIST }, fetch=FetchType.LAZY)
	private Collection<Telefone> telefones = new ArrayList<Telefone>();

	@OneToMany (cascade = {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	private static final long serialVersionUID = 1L;

	public Pessoa() {
		super();
	}

	
	public Pessoa(String rg, String nome, Collection<Telefone> telefones,
			List<Endereco> enderecos) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.telefones = telefones;
		this.enderecos = enderecos;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}



}
