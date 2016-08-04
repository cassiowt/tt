package model.b;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="ALUNO_PK")
public class Aluno2 extends Cliente2 implements Serializable {
	private String apelido;
	private static final long serialVersionUID = -1L;
	
	public Aluno2() {
		// TODO Auto-generated constructor stub
	}

	public Aluno2(String rg, String nome, String telefone, String endereco,
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
