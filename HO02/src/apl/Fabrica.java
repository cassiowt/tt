package apl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CartaoCredito;
import model.Cliente;


public class Fabrica {
	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			CartaoCredito  cc = new CartaoCredito("1111222233334444", "Master");
			Cliente c = new Cliente(cc, "Joelho", "de Ferro", "Das Coisa", "POA", "90952151", new Date());

			
		//	Cliente c1 = new Cliente( "Mão", "D\'Ouro", "Das Coisa", "POA", "90481250", new Date());
		//	CartaoCredito  cc1 = new CartaoCredito(c1,"9999555599994444", "Visa");
		
		//	Cliente c2 = new Cliente( new CartaoCredito("1", "Visa")	,"Pes ", "e Mao", "Das Coisa", "POA", "90481250", new Date());
			
			em.getTransaction().begin();
			em.persist(c);
		//	em.persist(cc1);
		//	em.persist(c2);
	 		em.getTransaction().commit();
			em.close();

			System.out.println("ok  !!!!!!!!!!!! ; )");


		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}

	}

}
