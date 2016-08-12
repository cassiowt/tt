package com.target.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.target.model.Aluno;
import com.target.model.Cliente;
import com.target.model.Endereco;
import com.target.model.Telefone;
import com.target.model.TipoTelefone;
import com.target.repository.AlunoRepository;
import com.target.repository.ClienteRepository;

public class ManterAluno {

	private static final Scanner LER = new Scanner(System.in);

	public static void main(String[] args) {

		menu();

	}

	private static void menu () {
		String opcao = " ";
		do {
		System.out.println("Digite: "
				+ "\n S - Para Salvar um Aluno" 
				+ "\n L - Para listar os Alunos"
				+ "\n D - Para deletar um Aluno" 
				+ "\n A - Para alterar um Aluno"
				+ "\n O - Para listar apelidos ordenados" 
				+ "\n T - Para listar o total clientes"
				+ "\n E - Para sair");
		opcao = LER.next();
		testarOpcao(opcao);
		} while (!opcao.equals("E"));
	}

	private static void testarOpcao(String opcao) {
		switch (opcao) {
		case "S":
			salvaAluno();
			break;
		case "L":
			listaAlunos();
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
		case "O":
			listaOrdenadaAlunos();
			break;
		case "E":
			System.out.println("Saindo...");
			break;
		default:
			System.out.println("Nenuma opção valida foi selecionada");
			break;
		}
	}

	private static void listaOrdenadaAlunos() {
		AlunoRepository aluRepo = new AlunoRepository();
		List<Aluno> alunos = aluRepo.getByApelido();
		for (Aluno aluno : alunos) {
			System.out.println("\n" + aluno.getId() + " apelido = " + aluno.getApelido());
		}
	}

	private static void alteraAluno() {
		AlunoRepository aluRepo = new AlunoRepository();
		System.out.println("O codigo do aluno a ser alterado");
		int c = LER.nextInt();
		Aluno aluno = (Aluno) aluRepo.busca(Aluno.class, c);
		System.out.println("Digite o novo nome para o aluno " + aluno.getNome());
		String nome = LER.next();
		aluno.setNome(nome);
		aluRepo.altera(aluno);

	}

	private static void deletaAluno(int codigo) {
		AlunoRepository aluRepo = new AlunoRepository();
		Aluno aluno = (Aluno) aluRepo.busca(Aluno.class, codigo);
		System.out.println("Sera removido o aluno " + aluno.getNome() + "\n (digite SIM para comfirmar) ");
		String resposta = LER.next();
		if (resposta.contains("SIM")) {
			aluRepo.remove(aluRepo.busca(Aluno.class, codigo));
		} else {
			System.out.println("Não foi removido o aluno " + aluno.getNome());
		}
	}

	private static void listaAlunos() {
		AlunoRepository aluRepo = new AlunoRepository();
		List<Object> alunos = aluRepo.getAll();
		for (Object p : alunos) {
			System.out.println(p);
		}

	}

	private static void salvaAluno() {
		Collection<Aluno> alunos = new ArrayList<Aluno>();
		Aluno a1 = new Aluno("arara");
		alunos.add(a1);
		Aluno a2 = new Aluno("bebado");
		alunos.add(a2);
		Aluno a3 = new Aluno("zezinho");
		alunos.add(a3);
		Aluno a4 = new Aluno("carlos");
		alunos.add(a4);

		AlunoRepository aluRep = new AlunoRepository();
		for (Aluno aluno : alunos) {
			aluRep.save(aluno);
		}

	}

	private static void totalAlunos() {
		AlunoRepository aluRep = new AlunoRepository();
		System.out.println("O total de Alunos é: " + aluRep.getCountAlunos());
	}
}
