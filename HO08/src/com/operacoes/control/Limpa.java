package com.operacoes.control;

import javax.persistence.EntityManager;

public class Limpa {
	static EntityManager fabrica = JpaUtil.getFactory();


	public static void main(String[] args) {
	
		try {
			fabrica.close();
			System.out.println("OK");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
