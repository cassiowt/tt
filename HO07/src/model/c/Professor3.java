package model.c;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@AttributeOverride (name="nome", column=@Column(name="NOME_PROFESSOR"))
public class Professor3 extends Pessoa3 implements Serializable {
	
	private String pisPasep;
	private int salario;
	private static final long serialVersionUID = 1L;
	
	public Professor3() {
		// TODO Auto-generated constructor stub
	}



	public Professor3(String rg, String nome, String telefone, String endereco,
			String pisPasep, int salario) {
		super(rg, nome, telefone, endereco);
		this.pisPasep = pisPasep;
		this.salario = salario;
	}



	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
}
