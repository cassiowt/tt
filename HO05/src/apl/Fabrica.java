package apl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.*;

public class Fabrica {
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		gravaAluno();
	
	}
	private static void gravaAluno() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();

			Curso c = new Curso("JPA");
			Aluno a = new Aluno("Fagner");
			
			InteresseCurso ic = new InteresseCurso(c, new Date(), new Date(),Periodo.MANHA,a);
			InteresseCurso ic2 = new InteresseCurso(c, new Date(), new Date(),Periodo.NOITE,a);
			
			
			a.getInteresses().add(ic);
			a.getInteresses().add(ic2);
			
			em.getTransaction().begin();
			em.persist(ic);
			em.persist(ic2);
			em.getTransaction().commit();
     		em.close();

			System.out.println("OK)");

		} catch (Exception e) {
						System.out.println(e.getMessage());
		}

	}

}
