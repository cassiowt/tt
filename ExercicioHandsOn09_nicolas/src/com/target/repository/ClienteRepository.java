package com.target.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.target.model.Cliente;
import com.target.model.Telefone;
import com.target.model.TipoTelefone;

public class ClienteRepository {

	private EntityManager entityManager;

	/*
	 * Recebe o objeto EntityManager
	 */
	public ClienteRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Salva um cliente
	 * 
	 * @param Cliente
	 */
	public void save(Cliente cliente) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(cliente);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();
	}

	/**
	 * Busca um cliente
	 * 
	 * @param codigo
	 *            Id do Cliente
	 * @return Objeto Cliente
	 */
	public Cliente busca(int codigo) {
		return this.entityManager.find(Cliente.class, codigo);
	}

	/**
	 * Altera o Cliente
	 * 
	 * @param cliente
	 */
	public void altera(Cliente cliente) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(cliente);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();
	}

	/**
	 * Deleta um cliente
	 * 
	 * @param cliente
	 */
	public void remove(Cliente cliente) {
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(cliente);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();
	}

	/**
	 * 
	 * @return lista dos clientes.
	 */
	public List<Cliente> getClientes() {
		return this.entityManager.createNamedQuery("cliente.list").getResultList();
	}

	/**
	 * 
	 * @return Total de clientes
	 */
	public Long getCountClientes() {
		return (Long) this.entityManager.createNamedQuery("cliente.count").getSingleResult();
	}

	public List<Cliente> listaTelefonesPorTipo(TipoTelefone tipo) {
		return this.entityManager.createNamedQuery("cliente.telefone.byTipo").setParameter("tipoTelefone", tipo).getResultList();
	}
}