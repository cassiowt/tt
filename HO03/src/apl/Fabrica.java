package apl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;
import model.Telefone;

public class Fabrica {
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		gravaCliente();
		// excluiCliente();
		// excluiTelefone();

	}

	private static void excluiCliente() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			em.getTransaction().begin();

			Cliente c = em.find(Cliente.class, 2);
			System.out
					.println("Cliente a ser Removido_____________________________________________________");
			System.out.println("Codigo: " + c.getId() + " Nome: "
					+ c.getPrimeiroNome());

			em.remove(c);

			em.getTransaction().commit();
			em.close();

			// remove da coleção de telefones em Cliente

			// cliente.getTelefones().remove(fone);
		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}

	}

	private static void excluiTelefone() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			em.getTransaction().begin();

			Telefone t = em.find(Telefone.class, 2);
			System.out.println("Numero do Telefone a ser Removido é:");
			System.out.println(t.getNumeroTelefone());

			em.remove(t);

			em.getTransaction().commit();
			em.close();

			// remove da coleção de telefones em Cliente

			// cliente.getTelefones().remove(fone);
		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}

	}

	private static void gravaCliente() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();
			
			Cliente cliente = new Cliente("616420964185", "Casssio", "Trindade", "Frei Cliente", "POA", "900000", new Date());
			
			cliente.getTelefones().add(new Telefone("3969845"));
			cliente.getTelefones().add(new Telefone("9966984"));
			
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			em.close();

			System.out.println("ok  !!!!!!!!!!!! ; )");

		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}

	}

}
