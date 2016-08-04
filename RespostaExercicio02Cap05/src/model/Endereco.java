package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Endereco
 * 
 */
@Entity
@Table(name = "ENDERECOS")
public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ENDERECO_ID")
	private int id;

	@Column(length=120)
	private String rua;
	
	@Column(length=5)
	private int numero;

	@Column(length=5)
	private int complemento;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "NUMERO_ID")
	private CodigoPostal codigoPostal;

	@OneToOne
	@JoinColumn(name = "BAIRRO_ID")
	private Bairro bairro;

	private static final long serialVersionUID = 1L;

	public Endereco() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getComplemento() {
		return complemento;
	}

	public void setComplemento(int complemento) {
		this.complemento = complemento;
	}

	public CodigoPostal getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(CodigoPostal codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}
