package com.target.view;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import com.target.model.*;
import com.target.repository.*;
import com.target.control.*;

public class ManterProfessor {
	private static final Scanner LER = new Scanner(System.in);
	static EntityManager fabrica = JpaUtil.getFactory();

	public static void main(String[] args) {
		String continua="S";
		while (continua.equals("S")) {
			System.out
					.println("Digite: \n S - Para Salvar um prfessor"
							+ "\n L - Para listar os professores"
							+ "\n D - Para deletar um professor"
							+ "\n A - Para alterar um professor"
							+ "\n LS - Para listar os professores com salarios acima de um valor"
							+ "\n T - Para listar o total professores");
			String opcao = LER.next();
			switch (opcao) {
			case "S":
				salvaProfessor();
				break;
			case "L":
				listaProfessores();
				break;
			case "LS":
				System.out.println("Digite valor do professor para a lista");
				int s = LER.nextInt();
				listaProfessores(s);
				break;
			case "D":
				System.out
						.println("Digite o codigo do professor para ser deletado");
				int c = LER.nextInt();
				deletaProfessor(c);
				break;
			case "A":
				alteraProfessor();
			case "T":
				totalProfessores();
				break;
			default:
				System.out.println("Nenuma opção valida foi selecionada");
				break;
			}
			continua = LER.next();
		}
	}

	private static void alteraProfessor() {
		ProfessorRepository pr = new ProfessorRepository(fabrica);
		System.out.println("O codigo do Professor a ser alterado o seu nome");
		int c = LER.nextInt();
		Professor professor = pr.busca(c);
		System.out.println("Digite o novo nome para o professor "
				+ professor.getNome());
		String nome = LER.next();
		professor.setNome(nome);
		pr.altera(professor);

	}

	private static void deletaProfessor(int codigo) {

		ProfessorRepository pr = new ProfessorRepository(fabrica);
		Professor professor = pr.busca(codigo);
		System.out.println("Sera removido o Professor " + professor.getNome()
				+ "\n (digite SIM para comirmar) ");
		String resposta = LER.next();
		if (resposta.contains("SIM")) {
			pr.remove(pr.busca(codigo));
		} else {
			System.out.println("Não foi removido o Professor "
					+ professor.getNome());
		}
	}

	private static void listaProfessores() {

		ProfessorRepository pr = new ProfessorRepository(fabrica);
		List<Professor> professores = pr.getProfessores();
		for (Professor p : professores) {
			System.out.println("( " + p.getId() + " ) Professor: "
					+ p.getNome());

			List<Endereco> end = p.getEnderecos();
			for (Endereco e : end) {
				System.out.println("Endereço: " + e.getEndereco());

			}
		}

	}

	private static void listaProfessores(int salario) {

		ProfessorRepository pr = new ProfessorRepository(fabrica);
		List<Professor> professores = pr.getProfessores(salario);
		System.out.println("Os professores que tem salario acima de R$ "
				+ salario + " são:");
		for (Professor p : professores) {

			System.out.println("( " + p.getId() + " ) Professor: "
					+ p.getNome());

		}
	}

	private static void totalProfessores() {

		ProfessorRepository pr = new ProfessorRepository(fabrica);
		System.out.println("O total de Professores é: "
				+ pr.getCountProfessores());

	}

	private static void salvaProfessor() {

		// --------- Telefones------------------------
		Telefone t = new Telefone(25396548, TipoTelefone.RESIDENCIAL);
		Telefone t1 = new Telefone(88887239, TipoTelefone.CELULAR);
		Telefone t2 = new Telefone(26185184, TipoTelefone.COMERCIAL);

		Collection<Telefone> tel = new ArrayList<>();
		tel.add(t);
		tel.add(t1);
		tel.add(t2);

		// --------- Endereços ------------------------
		Endereco e = new Endereco("Rua Frei Clemente, 06");
		Endereco e1 = new Endereco("Rua das Flores , 004");

		List<Endereco> end = new ArrayList<>();
		end.add(e);
		end.add(e1);

		Professor prof = new Professor("9046133063", "Cássio Trindade", tel,
				end, "128.125.698.32", 1000);

		ProfessorRepository pr = new ProfessorRepository(fabrica);
		pr.save(prof);

	}

}
