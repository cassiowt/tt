package model.b;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Professor2 extends Pessoa2 implements Serializable {
	
	private String pisPasep;
	private int salario;
	private static final long serialVersionUID = 1L;
	
	public Professor2() {
		// TODO Auto-generated constructor stub
	}



	public Professor2(String rg, String nome, String telefone, String endereco,
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
