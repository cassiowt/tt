package com.target.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.target.control.JpaUtil;
import com.target.model.Aluno;
import com.target.model.Endereco;
import com.target.model.Telefone;
import com.target.model.TipoTelefone;
import com.target.repository.AlunoRepository;

public class ManterAluno {
	private static final Scanner LER = new Scanner(System.in);
	static EntityManager fabrica = JpaUtil.getFactory();

	public static void main(String[] args) {
		while (true) {
			System.out.println("Digite: \n 0 - Sair" + "\n S - Para Salvar um aluno" + "\n L - Para listar os alunos"
					+ "\n D - Para deletar um aluno" + "\n A - Para alterar um aluno"
					+ "\n LA - Para listar apelidos dos alunos ordenados de A a Z"
					+ "\n T - Para listar o total alunos");
			String opcao = LER.next();
			switch (opcao) {
			case "0":
				JpaUtil.closeFactory();
				System.exit(0);
				break;
			case "S":
				salvaAluno();
				break;
			case "L":
				listaAlunos();
				break;
			case "LA":
				listaAlunosApelidos();
				break;
			case "D":
				System.out.println("Digite o codigo do aluno para ser deletado");
				int c = LER.nextInt();
				deletaAluno(c);
				break;
			case "A":
				alteraAluno();
				break;
			case "T":
				totalAlunos();
				break;
			default:
				System.out.println("Nenuma opção valida foi selecionada");
				break;
			}
		}
	}

	private static void alteraAluno() {
		AlunoRepository pr = new AlunoRepository(fabrica);
		System.out.println("O codigo do Aluno a ser alterado o seu nome");
		int c = LER.nextInt();
		Aluno a = pr.busca(c);
		System.out.println("Digite o novo nome para o aluno " + a.getNome());
		String nome = LER.next();
		a.setNome(nome);
		a.setApelido(nome);
		pr.altera(a);

	}

	private static void deletaAluno(int codigo) {

		AlunoRepository pr = new AlunoRepository(fabrica);
		Aluno professor = pr.busca(codigo);
		System.out.println("Sera removido o Aluno " + professor.getNome() + "\n (digite SIM para comirmar) ");
		String resposta = LER.next();
		if (resposta.contains("SIM")) {
			pr.remove(pr.busca(codigo));
		} else {
			System.out.println("Não foi removido o Aluno " + professor.getNome());
		}
	}

	private static void listaAlunos() {

		AlunoRepository pr = new AlunoRepository(fabrica);
		List<Aluno> professores = pr.getAlunos();
		for (Aluno p : professores) {
			System.out.println("( " + p.getId() + " ) Aluno: " + p.getNome());

			List<Endereco> end = p.getEnderecos();
			for (Endereco e : end) {
				System.out.println("Endereço: " + e.getEndereco());

			}
		}

	}

	private static void listaAlunosApelidos() {

		AlunoRepository pr = new AlunoRepository(fabrica);
		List<String> alunos = pr.getApelidos();
		for (String p : alunos) {

			System.out.println("Aluno: " + p);

		}
	}

	private static void totalAlunos() {

		AlunoRepository pr = new AlunoRepository(fabrica);
		System.out.println("O total de Alunos é: " + pr.getCountAlunos());

	}

	private static void salvaAluno() {

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

		Aluno a = new Aluno("9046133063", "Asfalto Trindade", tel, end, "128.125.698.32", "Apelido");

		AlunoRepository pr = new AlunoRepository(fabrica);
		pr.save(a);

	}

}
