package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
public class Cliente extends Pessoa implements Serializable {

	private String cnpj;
	private static final long serialVersionUID = 1L;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String rg, String nome, String telefone, String endereco,
			String cnpj) {
		super(rg, nome, telefone, endereco);
		this.cnpj = cnpj;
	}



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
