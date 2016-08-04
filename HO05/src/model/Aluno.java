 package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="ALUNOS")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALUNO_ID")
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy = "aluno")
	private Collection<InteresseCurso> interesses = new ArrayList<InteresseCurso>();

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<InteresseCurso> getInteresses() {
		return interesses;
	}

	public void setInteresses(Collection<InteresseCurso> interesses) {
		this.interesses = interesses;
	}

	public int getId() {
		return id;
	}

}
