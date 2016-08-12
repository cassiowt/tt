package apl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.*;

public class PessoaUnicaTabela {
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

			Pessoa p = new Pessoa("9046131031", "Homem", "996772839",
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

			Cliente c = new Cliente("1112", "Procergs", "32184184",
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

			Aluno a = new Aluno("9415783054", "Senhor W", "99999999",
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
			Professor pr = new Professor("9046133063", "Cássio Trindade",
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
