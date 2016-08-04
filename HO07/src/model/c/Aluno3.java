package model.c;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="RG_ALUNO_PK")
public class Aluno3 extends Cliente3 implements Serializable {
	private String apelido;
	private static final long serialVersionUID = -1L;
	
	public Aluno3() {
		// TODO Auto-generated constructor stub
	}

	public Aluno3(String rg, String nome, String telefone, String endereco,
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
