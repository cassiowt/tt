package com.target.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.target.model.Cliente;
import com.target.model.Professor;

public class ClienteRepository {

	private EntityManager entityManager;
	 
    public ClienteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    public void save(Cliente cliente) {
    	this.entityManager.getTransaction().begin();
        this.entityManager.persist(cliente);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    public Cliente  busca(int codigo){
        return this.entityManager.find(Cliente.class, codigo);
    }
    
    public void altera(Cliente cliente) {
    	this.entityManager.getTransaction().begin();
        this.entityManager.merge(cliente);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    public void remove(Cliente cliente) {
      
    	this.entityManager.getTransaction().begin();
        this.entityManager.remove(cliente);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
 
    public List<Cliente> getClientes() {
        return this.entityManager.createNamedQuery("cliente.list")
                .getResultList();
    }
    
    public List<Cliente> getClientes(int salario) {
      
    	return this.entityManager.createNamedQuery("clienter.salario").setParameter("v", salario).getResultList();
    }
 
     public Long getCountClientes() {
        return (Long) this.entityManager.createNamedQuery("cliente.count")
                .getSingleResult();
    }
     
     public List<Cliente> getCountClientesNomeCnpj() {
         return this.entityManager.createNamedQuery("cliente.list.nome.cnpj").getResultList();
     }
     
     //****************************************************************************
     public List<Professor> getClientesNomes(int valor) {
         
     	return this.entityManager.createNamedQuery("cliente.nome").setParameter("v", valor).getResultList();
     }
}