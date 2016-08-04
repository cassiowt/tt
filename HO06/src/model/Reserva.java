package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import javax.persistence.*;

@Entity
@Table(name = "RESERVAS")
public class Reserva {

	@ManyToMany (cascade=CascadeType.PERSIST)
	@JoinTable(name = "RESERVA_CLIENTE", 
						joinColumns = { @JoinColumn(name = "RESERVA_ID") }, 
						inverseJoinColumns = { @JoinColumn(name = "CLIENTE_ID") })
	private zl<Cliente> clientes  = new ArrayList<Cliente>();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "RESERVA_ID")
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dataReserva;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(Date dataReserva) {
		super();
		this.dataReserva = dataReserva;
	}

   public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getId() {
		return id;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
