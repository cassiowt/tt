package apl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.*;

public class Fabrica {
	private static EntityManagerFactory factory;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		gravaReserva();

	}

	private static void gravaReserva() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			Cliente cli1 = new Cliente(CartaoCredito.MASTER, "xYZ", "Rua",
					new Date());

			Reserva r = new Reserva(sdf.parse("12/03/2014"));
			r.getClientes().add(cli1);

			Reserva r1 = new Reserva(sdf.parse("13/03/2014"));
			r1.getClientes().add(cli1);

			em.getTransaction().begin();
			em.persist(r);
			em.persist(r1);
			//em.persist(cli1);
			em.getTransaction().commit();
			em.close();

			System.out.println("OK");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
