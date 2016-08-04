package com.operacoes.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static  EntityManager em;
	private static  EntityManagerFactory factory;

	static {
		try {
			 factory = Persistence.createEntityManagerFactory("hjpa");
			 em = factory.createEntityManager();
			 
		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}
	}

	public static EntityManager getFactory() {
		return em;
	}

}
