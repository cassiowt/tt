package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PESSOAS")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PESSOA_ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "RG")
	private String rg;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "DATA_NASC")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNasc;

	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "PESSOA_ENDERECO", joinColumns = 
			{ @JoinColumn(name = "PESSOA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ENDERECO_ID") })
	private Collection<Endereco> enderecos;

	public Pessoa() {
	}

	public Pessoa(String nome, String rg, String cpf, Date dataNasc, EstadoCivil estadoCivil,
			Collection<Endereco> enderecos) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.estadoCivil = estadoCivil;
		this.enderecos = enderecos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", dataNasc=" + dataNasc
				+ ", estadoCivil=" + estadoCivil + ", enderecos=" + enderecos + "]";
	}

}
