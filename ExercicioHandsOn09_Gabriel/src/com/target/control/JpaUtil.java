package com.target.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.target.model.Professor;

public class JpaUtil {
	private static EntityManager em;
	private static EntityManagerFactory factory;

	static {
		abrir();
	}

	public static void abrir() {
		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			em = factory.createEntityManager();

		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}
	}

	public static EntityManager getFactory() {
		return em;
	}

	public static void persistir(Object obj) {
		if (!em.isOpen())
			abrir();
		em.getTransaction().begin();
		em.persist(obj);
		em.flush();
		em.getTransaction().commit();

		System.out.println("Objeto Gravado com Sucesso - " + ((Object) obj).toString());
		em.close();
	}

	public static List buscarQuery(String query) {
		if (!em.isOpen())
			abrir();
		em.getTransaction().begin();
		List<Object> result = em.createNamedQuery(query).getResultList();
		// em.getTransaction().commit();
		em.close();
		return result;
	}

	public static Object buscar(Class classe, int id) {
		if (!em.isOpen())
			abrir();
		em.getTransaction().begin();
		// Busca o cliente, recebendo o Codigo como parametro
		Object obj = em.find(classe, id);
		em.getTransaction().commit();
		em.close();
		return obj;
	}

	public static void altera(Object obj) {
		if (!em.isOpen())
			abrir();
		em.getTransaction().begin();
		em.merge(obj);
		em.flush();

		// em.getTransaction().commit();
		// em.close();
		persistir(obj);
	}

	public static void atualizar(Class classe, int id) {
		if (!em.isOpen())
			abrir();
		Object obj = buscar(classe, id);
		System.out.println("Cliente Atual___________________________________");
		System.out.println(obj);
		// c.setNome("NOME do CLIENTE ATUALIZADO");
		altera(obj);
		// persistir(c);
		Object obj1 = buscar(classe, id);
		System.out.println("Cliente Atualizado_______________________________");
		System.out.println(obj1);
	}

	public static void remover(Class classe, int Codigo) {
		if (!em.isOpen())
			abrir();
		Object obj = buscar(classe, Codigo);
		System.out.println("Objecto a ser Removido_________________");
		System.out.println(obj);
		remover(obj);
	}

	public static void remover(Object obj) {
		if (!em.isOpen())
			abrir();
		em.getTransaction().begin();
		em.remove(obj);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}
