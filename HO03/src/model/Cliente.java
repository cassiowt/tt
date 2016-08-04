package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="CLIENTES")
public class Cliente {
	@Id
	@Column(name="CLIENTE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="CPF")
	private String cpf;
	private String primeiroNome;
	private String ultimoNome;
	private String rua;
	private String cidade;
	private String cep;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtualizacao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CLIENTE_ID")
	private Collection<Telefone> telefones = new ArrayList<Telefone>();
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String cpf, String primeiroNome, String ultimoNome,
			String rua, String cidade, String cep, Date dataAtualizacao,
			Collection<Telefone> telefones) {
		super();
		this.cpf = cpf;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
		this.dataAtualizacao = dataAtualizacao;
		this.telefones = telefones;
	}

	public Cliente(String cpf, String primeiroNome, String ultimoNome,
			String rua, String cidade, String cep, Date dataAtualizacao)	{
		super();
		this.cpf = cpf;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
		this.dataAtualizacao = dataAtualizacao;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getPrimeiroNome() {
		return primeiroNome;
	}


	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}


	public String getUltimoNome() {
		return ultimoNome;
	}


	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}


	public Collection<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
	}


	public int getId() {
		return id;
	}

}
