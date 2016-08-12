package com.operacoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;





@Entity
@NamedQueries({
	@NamedQuery(name = "Cliente.ListAll", query = "SELECT c FROM Cliente c"),
	@NamedQuery(name = "Cliente.byNome", query = "SELECT c FROM Cliente c WHERE c.nome like :nome"),
	@NamedQuery(name ="Cliente.byEndereco", query = "SELECT c FROM Cliente c JOIN c.enderecos e WHERE e.endereco like :nome"),
	@NamedQuery(name =  "Cliente.byTelefone", query = "SELECT c FROM Cliente c JOIN c.telefones t WHERE t.numero like :telefone"),
	@NamedQuery(name = "Cliente.contatoRapido", query = 
	"SELECT distinct c.nome, t, e.endereco FROM Cliente c JOIN c.telefones t JOIN c.enderecos e "
			+ "WHERE t.id = (SELECT min(tel.id) FROM Telefone tel WHERE tel.id = t.id)"
			+ "	AND e.Id = (SELECT min(en.Id) FROM Endereco en WHERE en.Id = e.Id)")
})
@Table(name = "CLIENTES")

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTE_ID")
	private Long id;

	@Column(name = "NOME_CLIENTE")
	private String nome;

	@OneToMany(cascade =  CascadeType.PERSIST , fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENTE_ID")
	private Collection<Telefone> telefones = new ArrayList<Telefone>();

	@OneToMany (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Cliente() {
	}

	
	public Cliente(String nome, Collection<Telefone> telefones,
			List<Endereco> enderecos) {
		super();
		this.nome = nome;
		this.telefones = telefones;
		this.enderecos = enderecos;
	}

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
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
