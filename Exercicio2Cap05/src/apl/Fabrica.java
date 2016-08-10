package apl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Endereco;
import model.Pessoa;
import model.Usuario;

public class Fabrica {
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();
			System.out.println("Fabricado com Sucesso");

			Usuario u = new Usuario();
			u.setNome("Tony Stark");
			u.setCpf("1251564165416");
			u.setEndereco(new Endereco("14th", "1", "Centro", "New York", "NY"));
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();

			Pessoa p = new Pessoa();
			p.setNome("Tony Stark");
			p.setCpf("1251564165416");
			
			p.setEnderecos(new ArrayList<Endereco>());
			p.getEnderecos().add(new Endereco("10th", "1", "Centro", "New York", "NY"));
			
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			
			em.close();

			System.out.println("OK_________________");
		} catch (RuntimeException e) {
			System.out.println("TRACE_____________________:");
			e.printStackTrace();
		}
		System.exit(0);
	}
}