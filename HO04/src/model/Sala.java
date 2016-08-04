package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Sala implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4458718539417497685L;
	
	@Id
	@Column(name="SALA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
