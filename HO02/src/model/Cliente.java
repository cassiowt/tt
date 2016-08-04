package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLIENTES")
public class Cliente {
	@Id
	@Column(name="CLIENTE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CARTAO_CREDITO_ID")
	private CartaoCredito cartaoCredito;

	private String nome;
	private String sobrenome;
	private String rua;
	private String cidade;
	private String cep;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtualizacao;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(CartaoCredito cartaoCredito, String nome, String sobrenome,
			String rua, String cidade, String cep, Date dataAtualizacao) {
		super();
		this.cartaoCredito = cartaoCredito;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Cliente( String nome, String sobrenome,
			String rua, String cidade, String cep, Date dataAtualizacao) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
		this.dataAtualizacao = dataAtualizacao;
	}
	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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

	public int getId() {
		return id;
	}

}
