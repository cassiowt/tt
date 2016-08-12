package model;

import javax.persistence.*;


@Entity
public class CartaoCredito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CARTAO_CREDITO_ID")
	private int id;

	@OneToOne(mappedBy = "cartaoCredito")
	private Cliente cliente;
/*
     @OneToOne(cascade={CascadeType.PERSIST})  
   	 @JoinColumn(name = "CLIENTE_ID")
   	 private Cliente cliente;
*/
	@Column(name="NUMERO")
	private String numeroCartaoCredito;
	
	private String bandeira;

	public CartaoCredito() {
	}

	public CartaoCredito(Cliente cliente, String numeroCartaoCredito,
			String bandeira) {
		super();
		this.cliente = cliente;
		this.numeroCartaoCredito = numeroCartaoCredito;
		this.bandeira = bandeira;
	}

	public CartaoCredito( String numeroCartaoCredito,
			String bandeira) {
		super();
		this.numeroCartaoCredito = numeroCartaoCredito;
		this.bandeira = bandeira;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumeroCartaoCredito() {
		return numeroCartaoCredito;
	}

	public void setNumeroCartaoCredito(String numeroCartaoCredito) {
		this.numeroCartaoCredito = numeroCartaoCredito;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

}
