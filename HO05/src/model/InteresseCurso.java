package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="INTERESSE_CURSOS")
public class InteresseCurso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@OneToOne (cascade = CascadeType.PERSIST)
	private Curso curso;
	
	@Temporal(TemporalType.DATE)
	private Date dataPreferencial;
	
	@Temporal(TemporalType.DATE)
	private Date dataLimite;
	
	@Enumerated(EnumType.STRING)
	private Periodo periodoPreferencial;

	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ALUNO_ID")
	private Aluno aluno;

	public InteresseCurso() {
		// TODO Auto-generated constructor stub
	}

	public InteresseCurso(Curso curso, Date dataPreferencial, Date dataLimite,
			Periodo periodoPreferencial) {
		super();
		this.curso = curso;
		this.dataPreferencial = dataPreferencial;
		this.dataLimite = dataLimite;
		this.periodoPreferencial = periodoPreferencial;
	}

	public InteresseCurso(Curso curso, Date dataPreferencial, Date dataLimite,
			Periodo periodoPreferencial, Aluno aluno) {
		super();
		this.curso = curso;
		this.dataPreferencial = dataPreferencial;
		this.dataLimite = dataLimite;
		this.periodoPreferencial = periodoPreferencial;
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDataPreferencial() {
		return dataPreferencial;
	}

	public void setDataPreferencial(Date dataPreferencial) {
		this.dataPreferencial = dataPreferencial;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Periodo getPeriodoPreferencial() {
		return periodoPreferencial;
	}

	public void setPeriodoPreferencial(Periodo periodoPreferencial) {
		this.periodoPreferencial = periodoPreferencial;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getId() {
		return id;
	}

}
