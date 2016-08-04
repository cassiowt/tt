package model.a;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Cliente1 extends Pessoa1 implements Serializable {

	private String cnpj;
	private static final long serialVersionUID = 1L;

	public Cliente1() {
		// TODO Auto-generated constructor stub
	}

	public Cliente1(String rg, String nome, String telefone, String endereco,
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
