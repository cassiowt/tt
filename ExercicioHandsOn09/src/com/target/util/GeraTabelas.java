package com.target.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {
	public static void main(String[] args) {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();
			System.out.println("Tabelas Geradas");
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
