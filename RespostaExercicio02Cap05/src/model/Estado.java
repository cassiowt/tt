package model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estado
 * 
 */
@Entity
@Table(name = "ESTADOS")
public class Estado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ESTADO_ID")
	private int id;

	@OneToMany(mappedBy = "estado")
	private Collection<Cidade> cidades = new ArrayList<Cidade>();

	@ManyToOne
	@JoinColumn(name = "PAIS_ID")
	private Pais pais;

	@Column(length = 100)
	private String nome;

	@Column(length = 2)
	private String sigla;

	private static final long serialVersionUID = 1L;

	public Estado() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
