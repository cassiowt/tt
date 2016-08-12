package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "RESERVAS")
public class Reserva {

	@ManyToMany (cascade=CascadeType.PERSIST)
	@JoinTable(name = "RESERVA_CLIENTE", 
						joinColumns = { @JoinColumn(name = "RESERVA_ID") }, 
						inverseJoinColumns = { @JoinColumn(name = "CLIENTE_ID") })
	private Collection<Cliente> clientes  = new ArrayList<Cliente>();

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

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
