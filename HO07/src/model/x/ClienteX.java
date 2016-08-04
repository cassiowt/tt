package model.x;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class ClienteX extends PessoaX implements Serializable {

	private String cnpj;
	private static final long serialVersionUID = 1L;

	public ClienteX() {
		// TODO Auto-generated constructor stub
	}

	public ClienteX(String rg, String nome, String telefone, String endereco,
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
