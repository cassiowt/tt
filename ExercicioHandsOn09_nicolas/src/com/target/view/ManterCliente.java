package com.target.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.target.control.JpaUtil;
import com.target.model.Cliente;
import com.target.model.Endereco;
import com.target.model.Telefone;
import com.target.model.TipoTelefone;
import com.target.repository.ClienteRepository;

public class ManterCliente {
	private static final Scanner LER = new Scanner(System.in);
	static EntityManager fabrica = JpaUtil.getFactory();

	public static void main(String[] args) {

		while (true) {
			System.out.println("Digite: \n 0 - Sair" + "\n S - Para Salvar um cliente"
					+ "\n L - Para listar os clientes" 
					+ "\n LNC - Para listar os nomes dos clientes e seus CNPJs" 
					+ "\n LT - Para listar os telefones dos clientes conforme o tipo passado" 
					+ "\n D - Para deletar um cliente" + "\n A - Para alterar um cliente"
					+ "\n T - Para listar o total clientes");
			String opcao = LER.next();
			switch (opcao) {
			case "0":
				JpaUtil.closeFactory();
				System.exit(0);
				break;
			case "S":
				salvaCliente();
				break;
			case "L":
				listaClientes();
				break;
			case "LNC":
				listaClientesNomeCnpj();
				break;
			case "LT":
				listaTelefonesPorTipo();
				break;
			case "D":
				System.out.println("Digite o codigo do cliente para ser deletado");
				int c = LER.nextInt();
				deletaCliente(c);
				break;
			case "A":
				alteraCliente();
				break;
			case "T":
				totalClientes();
				break;
			default:
				System.out.println("Nenuma opção valida foi selecionada");
				break;
			}
		}

	}

	private static void alteraCliente() {
		ClienteRepository pr = new ClienteRepository(fabrica);
		System.out.println("O codigo do Cliente a ser alterado o seu nome");
		int c = LER.nextInt();
		Cliente cliente = pr.busca(c);
		System.out.println("Digite o novo nome para o cliente " + cliente.getNome());
		String nome = LER.next();
		cliente.setNome(nome);
		pr.altera(cliente);

	}

	private static void deletaCliente(int codigo) {

		ClienteRepository pr = new ClienteRepository(fabrica);
		Cliente cliente = pr.busca(codigo);
		System.out.println("Sera removido o Cliente " + cliente.getNome() + "\n (digite SIM para comirmar) ");
		String resposta = LER.next();
		if (resposta.contains("SIM")) {
			pr.remove(pr.busca(codigo));
		} else {
			System.out.println("Não foi removido o Cliente " + cliente.getNome());
		}
	}

	private static void listaClientes() {

		ClienteRepository pr = new ClienteRepository(fabrica);
		List<Cliente> clientes = pr.getClientes();
		for (Cliente p : clientes) {
			System.out.println("( " + p.getId() + " ) Cliente: " + p.getNome());

			List<Endereco> end = p.getEnderecos();
			for (Endereco e : end) {
				System.out.println("Endereço: " + e.getEndereco());

			}
		}

	}

	private static void listaTelefonesPorTipo() {
		
		ClienteRepository pr = new ClienteRepository(fabrica);
		
		System.out.println("Digite CEL para celular, R para residencial e COM para comercial");
		String tipo = LER.next();
		TipoTelefone tipoTelefone;
		switch(tipo) {
		case "CEL":
			tipoTelefone = TipoTelefone.CELULAR;
			break;
		case "R":
			tipoTelefone = TipoTelefone.RESIDENCIAL;
			break;
		default:
			tipoTelefone = TipoTelefone.COMERCIAL;
			break;
		}
		
		List<Cliente> clientes = pr.listaTelefonesPorTipo(tipoTelefone);
		for (Cliente p : clientes) {
			System.out.println("Cliente: ( " + p.getId() + " )");
			System.out.println("	NOME: " + p.getNome());
			System.out.println("	Telefones: " );
			for (Telefone tel : p.getTelefones()) {
				if (tel.getTipo().equals(tipoTelefone))
					System.out.println("		" + tel.getNumero());
			}
		
		}
		
	}

	private static void listaClientesNomeCnpj() {
		ClienteRepository pr = new ClienteRepository(fabrica);
		List<Cliente> clientes = pr.getClientes();
		for (Cliente p : clientes) {
			System.out.println("Cliente: ( " + p.getId() + " )");
			System.out.println("	NOME: " + p.getNome());
			System.out.println("	CNPJ: " + p.getCnpj());
		}

	}

	private static void totalClientes() {

		ClienteRepository pr = new ClienteRepository(fabrica);
		System.out.println("O total de Clientes é: " + pr.getCountClientes());

	}

	private static void salvaCliente() {

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

		Cliente prof = new Cliente("9046133063", "Asfalto Trindade", tel, end, "128.125.698.32");

		ClienteRepository pr = new ClienteRepository(fabrica);
		pr.save(prof);

	}

}
