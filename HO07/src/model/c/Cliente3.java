package model.c;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@AttributeOverride (name="nome", column=@Column(name="NOME_CLIENTE"))
public class Cliente3 extends Pessoa3 implements Serializable {

	private String cnpj;
	private static final long serialVersionUID = 1L;

	public Cliente3() {
		// TODO Auto-generated constructor stub
	}

	public Cliente3(String rg, String nome, String telefone, String endereco,
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
