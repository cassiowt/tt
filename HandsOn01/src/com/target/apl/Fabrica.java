package com.target.apl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.target.model.Endereco;
import com.target.model.Instrutor;

public class Fabrica {

	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		try {
			factory = Persistence.createEntityManagerFactory("jpa");
			EntityManager em = factory.createEntityManager();
			
			Endereco endereco = new Endereco();
			endereco.setRua( "São Francisco da Califórnia" );
			endereco.setNumero( 23 );
			endereco.setBairro( "Higienópolis" );
			endereco.setCidade( "Porto Alegre" );
			
			Instrutor instrutor = new Instrutor();
			instrutor.setNome("Paulo Silva");
			instrutor.setEndereco( endereco );
			
			em.getTransaction().begin();
			em.persist( instrutor );
			em.getTransaction().commit();
			
			System.out.println("Fabricado com Sucesso ; )");
			em.close();

		} catch (RuntimeException e) {
			System.out.println("TRACE_____________________:");
			e.printStackTrace();
		}

	}

}
