package model.b;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Cliente2 extends Pessoa2 implements Serializable {

	private String cnpj;
	private static final long serialVersionUID = 1L;

	public Cliente2() {
		// TODO Auto-generated constructor stub
	}

	public Cliente2(String rg, String nome, String telefone, String endereco,
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
