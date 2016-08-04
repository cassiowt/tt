package model;

import javax.persistence.*;

@Entity
@Table(name="CURSOS")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CURSO_ID")
	private int id;
	
	private String nome;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

}
