package model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cidade
 * 
 */
@Entity
@Table(name = "CIDADES")
public class Cidade implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CIDADE_ID")
	private int id;

	@OneToMany(mappedBy = "cidade")
	private Collection<Bairro> bairros = new ArrayList<Bairro>();

	@Column(length=120)
	private String nome;

	@ManyToMany(mappedBy = "cidades")
	private Collection<CodigoPostal> codigoPostals = new ArrayList<CodigoPostal>();

	@ManyToOne
	@JoinColumn(name = "ESTADO_ID")
	private Estado estado;

	private static final long serialVersionUID = 1L;

	public Cidade() {
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

	public Collection<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(Collection<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Collection<CodigoPostal> getCodigoPostals() {
		return codigoPostals;
	}

	public void setCodigoPostals(Collection<CodigoPostal> codigoPostals) {
		this.codigoPostals = codigoPostals;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
