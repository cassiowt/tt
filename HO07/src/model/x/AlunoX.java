package model.x;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="ALUNO_PK")
public class AlunoX extends ClienteX implements Serializable {
	private String apelido;
	private static final long serialVersionUID = -1L;
	
	public AlunoX() {
		// TODO Auto-generated constructor stub
	}

	public AlunoX(String rg, String nome, String telefone, String endereco,
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
