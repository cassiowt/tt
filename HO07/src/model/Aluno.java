package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Aluno extends Cliente implements Serializable {
	@Column(length=25)
	private String apelido;
	private static final long serialVersionUID = -1L;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(String rg, String nome, String telefone, String endereco,
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
