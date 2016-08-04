package apl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.c.*;

public class PessoaMappedSuperTabelas {
	private static EntityManagerFactory factory;


	public static void main(String[] args) {

		persisteCliente();
		persisteAluno();
		persisteProfessor();

	}


	private static void persisteCliente() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			Cliente3 c = new Cliente3("1", "Procergs", "32184184",
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

			Aluno3 a = new Aluno3("9415783054", "Senhor W", "99999999",
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
			Professor3 pr = new Professor3("9046133063", "Cássio Trindade",
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
