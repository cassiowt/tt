package apl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.a.*;

public class PessoaVariasTabelas {
	private static EntityManagerFactory factory;


	public static void main(String[] args) {
		persistePessoa();
		persisteCliente();
		persisteAluno();
		persisteProfessor();

	}

	private static void persistePessoa() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			Pessoa1 p = new Pessoa1("9046131031", "Pessoa Homem", "996772839",
					"Rua São Pedro, 06");

			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			em.close();

			System.out.println("OK");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void persisteCliente() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			Cliente1 c = new Cliente1("1", "Cliente Procergs", "32184184",
					"Praça Açorianos", "616.452.096/0001-02");

			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();

			System.out.println("OK");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void persisteAluno() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			Aluno1 a = new Aluno1("9415783054", "Aluno Senhor W", "99999999",
					"Avenida A", null, "Senhor W");

			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			em.close();

			System.out.println("OK");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void persisteProfessor() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();
			Professor1 pr = new Professor1("9046133063", "Professor Cássio Trindade",
					"33396848", "Frei Clemente, 22", "12812345687", 10);

			em.getTransaction().begin();
			em.persist(pr);
			em.getTransaction().commit();
			em.close();

			System.out.println("OK");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
