package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import model.TipoCodigoPostal;

/**
 * Entity implementation class for Entity: CodigoPostal
 * 
 */
@Entity
public class CodigoPostal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NUMERO_ID")
	private int numero;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private TipoCodigoPostal tipo;

	@ManyToMany
	@JoinTable(name = "CIDADE_CODIGO_POSTAL",
	                    joinColumns = @JoinColumn(name = "NUMERO_ID"),
	                    inverseJoinColumns = { @JoinColumn(name = "CIDADE_ID") })
	private Set<Cidade> cidades = new HashSet<Cidade>();

	
	private static final long serialVersionUID = 1L;

	public CodigoPostal() {
		super();
	}

	public int getNumero() {
		return this.numero;
	}

	public TipoCodigoPostal getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoCodigoPostal tipo) {
		this.tipo = tipo;
	}

	public void formatar() {

	}

	public Set<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}

}
