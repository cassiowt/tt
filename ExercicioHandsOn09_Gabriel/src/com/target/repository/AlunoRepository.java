package com.target.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.target.control.JpaUtil;

import com.target.model.Aluno;

public class AlunoRepository implements Repository {

	private JpaUtil jpa;

	public AlunoRepository() {
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
		 return jpa.getFactory().createNamedQuery("aluno.list")
	                .getResultList();
	}
	
	public List <Aluno> getByApelido () {
		return jpa.getFactory().createNamedQuery("aluno.byApelidoAsc").getResultList();
	}

	 public Long getCountAlunos() {
	        return (Long) jpa.getFactory().createNamedQuery("aluno.count")
	                .getSingleResult();
	    }
	

}
