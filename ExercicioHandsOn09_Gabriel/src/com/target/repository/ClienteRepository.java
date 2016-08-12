package com.target.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.target.control.JpaUtil;
import com.target.model.Cliente;
import com.target.model.Professor;

public class ClienteRepository implements Repository{

	private JpaUtil jpa;

	public ClienteRepository() {
		jpa.abrir();
	}

	@Override
	public void save(Object obj) {
		jpa.persistir(obj);

	}

	@Override
	public Object busca(Class classe, int codigo) {
		return jpa.buscar(classe, codigo);
	}

	@Override
	public void altera(Object obj) {
		jpa.altera(obj);

	}

	@Override
	public void remove(Object obj) {
		jpa.remover(obj);

	}
	@Override
	public void remove(Class classe, int Codigo) {
		jpa.remover(classe, Codigo);
		
	}

	@Override
	public List<Object> getAll() {
		 return jpa.getFactory().createNamedQuery("cliente.list")
	                .getResultList();
	}
    
    public List<Cliente> getClientes(int salario) {
      
    	return jpa.getFactory().createNamedQuery("clienter.salario").setParameter("v", salario).getResultList();
    }
 
     public Long getCountClientes() {
        return (Long) jpa.getFactory().createNamedQuery("cliente.count")
                .getSingleResult();
    }
     
     public List<Cliente> getCountClientesNomeCnpj() {
         return jpa.getFactory().createNamedQuery("cliente.list.nome.cnpj").getResultList();
     }
     public List<Cliente> getTelefoneTipo(String tipo) {
         return jpa.getFactory().createNamedQuery("cliente.telefone.byTipo").setParameter("tipo", tipo).getResultList();
     }
     
     //****************************************************************************
     public List<Professor> getClientesNomes(int valor) {
         
     	return jpa.getFactory().createNamedQuery("cliente.nome").setParameter("v", valor).getResultList();
     }

	
}