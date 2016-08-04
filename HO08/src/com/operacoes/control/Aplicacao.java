package com.operacoes.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.operacoes.model.*;

@SuppressWarnings("unused")
public class Aplicacao {
	static EntityManager fabrica = JpaUtil.getFactory();

	public static void main(String[] args) {
		// insereCliente();
		// buscaCliente( 3);
		// buscaClienteQ();
		// findContatoRapido();
		//atualizaCliente(3l);
		removeCliente(1l);

	}

	private static void insereCliente() {
		try {

			Cliente cliente = new Cliente("Pedro Trindade");

			Endereco e = new Endereco("Rua Guaiba Guria");
			Endereco e1 = new Endereco("Rua Das Deusas, 666");

			List<Endereco> end = new ArrayList<>();
			end.add(e);
			end.add(e1);

			cliente.setEnderecos(end);

			cliente.getTelefones().add(
					new Telefone(12345, TipoTelefone.CELULAR));
			cliente.getTelefones().add(
					new Telefone(99999, TipoTelefone.RESIDENCIAL));

			fabrica.getTransaction().begin();
			fabrica.persist(cliente);
			fabrica.getTransaction().commit();

			System.out.println("Cliente Gravado com Sucesso - "
					+ cliente.getNome());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void buscaCliente(long Codigo) {
		fabrica.getTransaction().begin();
		// Busca o cliente, recebendo o Codigo como parametro
		Cliente c = fabrica.find(Cliente.class, Codigo);
		System.out.println("o Cliente codigo " + c.getId() + " é: "
				+ c.getNome());
		System.out.println("_____________________________________________");
		fabrica.getTransaction().commit();
		fabrica.close();
	}

	private static void buscaClienteQ() {
		// Busca Endereço, utilizando query pré definida
		Query query = fabrica.createNamedQuery("Cliente.ListAll");

		List<Cliente> clientes = query.getResultList();
		for (Cliente cliente : clientes) {
			System.out.println("Endereco cliente: "
					+ cliente.getEnderecos().get(1).getEndereco());
		}

		/*
		 * List<Endereco> enderecos = query.getResultList(); for (Endereco e :
		 * enderecos) { System.out.println("Enderero: " + e.getEndereco()); }
		 */
	}

	private static void findContatoRapido() {
		Query query = fabrica.createNamedQuery("Cliente.contatoRapido");
		List<Object[]> list = query.getResultList();
		System.out.println("Contatos rápidos:");
		for (Object[] o : list) {
			Telefone t = (Telefone) o[1];
			System.out.println("\t" + o[0] + ": " + t.getTipo() + " "
					+ t.getNumero() + ", " + o[2]);
		}
		System.out.println("---");
	}

	public static void atualizaCliente(Long Codigo) {
		fabrica.getTransaction().begin();

		Cliente c = fabrica.find(Cliente.class, Codigo);

		System.out.println("Cliente Atual___________________________________");
		System.out.println("o Cliente codigo " + c.getId() + " é: "
				+ c.getNome());
		c.setNome("NOME do CLIENTE ATUALIZADO");

		fabrica.flush();
		fabrica.merge(c);
		fabrica.persist(c);

		Cliente c1 = fabrica.find(Cliente.class, Codigo);
		System.out.println("Cliente Atualizado_______________________________");
		System.out.println("o Cliente codigo " + c1.getId() + " é: "
				+ c1.getNome());

		fabrica.getTransaction().commit();
		fabrica.close();
	}

	public static void removeCliente(long Codigo) {
		fabrica.getTransaction().begin();
		Cliente c = fabrica.find(Cliente.class, Codigo);
		System.out.println("Cliente a ser Removido_________________");
		System.out.println("Codigo: " + c.getId() + " Nome: " + c.getNome());
		fabrica.remove(c);
		fabrica.getTransaction().commit();
		fabrica.close();
	}
}
