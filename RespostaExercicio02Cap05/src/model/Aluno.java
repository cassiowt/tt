package model;
 
import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aluno
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ALUNOS", uniqueConstraints = @UniqueConstraint(columnNames = { "CPF" }))
@AttributeOverride(name = "id", column = @Column(name = "ALUNO_ID"))
public class Aluno extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 20)
	private String apelido;

	@Column(length = 11)
	private String cpf;

	public Aluno() {
		super();
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}
