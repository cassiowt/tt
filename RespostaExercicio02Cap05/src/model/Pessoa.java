package model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pessoa
 * 
 */
@MappedSuperclass
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length=60)
	private String nome;
	
	@Column(length=11)
	private String fone;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ENDERECO_ID", nullable=true)
	private Endereco endereco;
	
	private static final long serialVersionUID = 1L;

	public Pessoa() {
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

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
