package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TELEFONE_ID")
	private int codigo;
	private String numeroTelefone;
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public Telefone(String numeroTelefone) {
		super();
		this.numeroTelefone = numeroTelefone;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
}
