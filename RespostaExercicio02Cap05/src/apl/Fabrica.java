package apl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {

	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		try {

			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();
			System.out.println("Fabricado com Sucesso ; )");
			em.close();

		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}

	}

}
