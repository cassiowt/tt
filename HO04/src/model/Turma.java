package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Turma implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8594073264742865093L;
	@Id
	@Column(name = "TURMA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String nome;
	
	private int totalAlunos;
	
	@ManyToOne
	@JoinColumn(name = "SALA_ID")
	private Sala sala;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalAlunos() {
		return totalAlunos;
	}

	public void setTotalAlunos(int totalAlunos) {
		this.totalAlunos = totalAlunos;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
