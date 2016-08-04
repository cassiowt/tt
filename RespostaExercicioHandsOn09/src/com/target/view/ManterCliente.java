package com.target.view;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import com.target.model.*;
import com.target.repository.*;
import com.target.control.*;

public class ManterCliente {
	private static final Scanner LER = new Scanner(System.in);
	static EntityManager fabrica = JpaUtil.getFactory();

	public static void main(String[] args) {

		System.out
				.println("Digite: \n S - Para Salvar um cliente"
						+ "\n L - Para listar os clientes"
						+ "\n D - Para deletar um cliente"
						+ "\n A - Para alterar um cliente"
						+ "\n LN - Para listar Nome e CNPJ"
						+ "\n T - Para listar o total clientes");
		String opcao = LER.next();
		switch (opcao) {
		case "S":
			salvacliente();
			break;
		case "L":
			listaclientes();
			break;
		case "LS":
			System.out.println("Digite valor do cliente para a lista");
			int s = LER.nextInt();
			listaClientes(s);
			break;
		case "D":
			System.out
					.println("Digite o codigo do cliente para ser deletado");
			int c = LER.nextInt();
			deletacliente(c);
			break;
		case "A":
			alteracliente();
			break;
		case "T":
			totalclientees();
			break;
		case "LN":
			listaClientesNomeCnpj();
		default:
			System.out.println("Nenuma opção valida foi selecionada");
			break;
		}

	}

	private static void listaClientesNomeCnpj() {
		ClienteRepository cli = new ClienteRepository(fabrica);
		List<Cliente> clientes = cli.getCountClientesNomeCnpj();
		for (Cliente c : clientes) {
			System.out.println(" cliente: " + c.getNome() + "CNPJ: " + c.getCnpj());
		}		
	}

	private static void alteracliente() {
		ClienteRepository cli= new ClienteRepository(fabrica);
		System.out.println("O codigo do cliente a ser alterado o seu nome");
		int c = LER.nextInt();
		Cliente cliente = cli.busca(c);
		System.out.println("Digite o novo nome para o cliente "
				+ cliente.getNome());
		String nome = LER.next();
		cliente.setNome(nome);
		cli.altera(cliente);

	}

	private static void deletacliente(int codigo) {

		ClienteRepository cli= new ClienteRepository(fabrica);
		Cliente cliente = cli.busca(codigo);
		System.out.println("Sera removido o cliente " + cliente.getNome()
				+ "\n (digite SIM para comirmar) ");
		String resposta = LER.next();
		if (resposta.contains("SIM")) {
			cli.remove(cli.busca(codigo));
		} else {
			System.out.println("Não foi removido o cliente "
					+ cliente.getNome());
		}
	}

	private static void listaclientes() {

		ClienteRepository cli= new ClienteRepository(fabrica);
		List<Cliente> clientes = cli.getClientes();
		for (Cliente p : clientes) {
			System.out.println("( " + p.getId() + " ) cliente: "
					+ p.getNome());

			List<Endereco> end = p.getEnderecos();
			for (Endereco e : end) {
				System.out.println("Endereço: " + e.getEndereco());

			}
		}

	}

	private static void listaClientes(int salario) {

		ClienteRepository cli = new ClienteRepository(fabrica);
		List<Cliente> clientes = cli.getClientes(salario);
		System.out.println("Os clientes que tem salario acima de R$ "
				+ salario + " são:");
		for (Cliente c : clientes) {

			System.out.println("( " + c.getId() + " ) cliente: "
					+ c.getNome());

		}
	}

	private static void totalclientees() {

		ClienteRepository cli = new ClienteRepository(fabrica);
		System.out.println("O total de clientees é: "
				+ cli.getCountClientes());

	}

	private static void salvacliente() {
/*
		// --------- Telefones------------------------
		Telefone t = new Telefone(393939, TipoTelefone.COMERCIAL);
		Telefone t1 = new Telefone(969696, TipoTelefone.COMERCIAL);
		Collection<Telefone> tel = new ArrayList<>();
		tel.add(t);
		tel.add(t1);

		// --------- Endereços ------------------------
		Endereco e = new Endereco("São Francisco da California, 23");
		List<Endereco> end = new ArrayList<>();
		end.add(e);

		Cliente cliente = new Cliente("1254", "TargetTrust Tecnologia e Educação", tel,	end, "12581854/0001-01");

		ClienteRepository cli= new ClienteRepository(fabrica);
		cli.save(cliente);
*/
		//Cliente2
		// --------- Telefones------------------------
		Telefone t2 = new Telefone(393939, TipoTelefone.COMERCIAL);
		Telefone t3 = new Telefone(969696, TipoTelefone.COMERCIAL);
		Collection<Telefone> tel1 = new ArrayList<>();
		tel1.add(t2);
		tel1.add(t3);

		// --------- Endereços ------------------------
		Endereco e1 = new Endereco("Avenida Ipiranga, 500");
		Endereco e2 = new Endereco("Avenida Ipiranga, 2500");
		List<Endereco> end1 = new ArrayList<>();
		end1.add(e1);
		end1.add(e2);

		Cliente cliente1 = new Cliente("3587", "TZaffari Supermercados", tel1,	end1, "98552144000101");

		ClienteRepository cli1 = new ClienteRepository(fabrica);
		cli1.save(cliente1);

		}

}
