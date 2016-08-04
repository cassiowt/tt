package model.a;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Aluno1 extends Cliente1 implements Serializable {
	private String apelido;
	private static final long serialVersionUID = -1L;
	
	public Aluno1() {
		// TODO Auto-generated constructor stub
	}

	public Aluno1(String rg, String nome, String telefone, String endereco,
			String cnpj, String apelido) {
		super(rg, nome, telefone, endereco, cnpj);
		this.apelido = apelido;
	}



	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}
