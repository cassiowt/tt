package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="CLIENTES")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTE_ID")
	private long custId;

	@ManyToMany(mappedBy = "clientes")
	private Collection<Reserva> reservas = new ArrayList<Reserva>();
	
	@Enumerated(EnumType.STRING)
	private CartaoCredito cartCred;
	private String nome;
	private String endereco;
	@Temporal(TemporalType.DATE)
	private Date updatedTime;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente( CartaoCredito cartCred,
			String nome, String endereco, Date updatedTime) {
		super();
		this.cartCred = cartCred;
		this.nome = nome;
		this.endereco = endereco;
		this.updatedTime = updatedTime;
	}
	
	public Cliente(Collection<Reserva> reservas, CartaoCredito cartCred,
			String nome, String endereco, Date updatedTime) {
		super();
		this.reservas = reservas;
		this.cartCred = cartCred;
		this.nome = nome;
		this.endereco = endereco;
		this.updatedTime = updatedTime;
	}

	public Collection<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}

	public CartaoCredito getCartCred() {
		return cartCred;
	}

	public void setCartCred(CartaoCredito cartCred) {
		this.cartCred = cartCred;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public long getCustId() {
		return custId;
	}
	
}
