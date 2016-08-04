package model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pais
 * 
 */
@Entity
@Table(name = "PAISES")

public class Pais implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PAIS_ID")
	private int id;
	
	@Column(length=2)
	private String sigla;
	
	@Column(length=120)
	private String nome;

	@OneToMany(mappedBy = "pais")
	private Collection<Estado> estados = new ArrayList<Estado>();

	private static final long serialVersionUID = 1L;

	public Pais() {
		super();
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Estado> getEstados() {
		return estados;
	}

	public void setEstados(Collection<Estado> estados) {
		this.estados = estados;
	}

}
