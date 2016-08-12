package com.target.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.target.model.Aluno;

public class AlunoRepository {

	private EntityManager entityManager;
	 /*
	  * Recebe o objeto EntityManager
	  */
    public AlunoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 /**
  * Salva um aluno
  * @param Aluno
  */
    public void save(Aluno aluno) {
    	this.entityManager.getTransaction().begin();
        this.entityManager.persist(aluno);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }
  
    /**
   * Busca um aluno
   * @param codigo Id do Profressor
   * @return Objeto Aluno
   */
    public Aluno  busca(int codigo){
        return this.entityManager.find(Aluno.class, codigo);
    }
    /**
     * Altera o Aluno
     * @param aluno
     */
    public void altera(Aluno aluno) {
    	this.entityManager.getTransaction().begin();
        this.entityManager.merge(aluno);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }
    /**
     * Deleta um aluno
     * @param aluno
     */
    public void remove(Aluno aluno) {
       	this.entityManager.getTransaction().begin();
        this.entityManager.remove(aluno);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }
	 /**
	  * 
	  * @return lista dos alunos.
	  */
    public List<Aluno> getAlunos() {
        return this.entityManager.createNamedQuery("aluno.list")
                .getResultList();
    }
    /**
     * 
     * @return lista dos alunos.
     */
    public List<String> getApelidos() {
    	return this.entityManager.createNamedQuery("aluno.list.apelidos")
    			.getResultList();
    }
    /**
     * 
     * @return Total de alunos
     */
    public Long getCountAlunos() {
        return (Long) this.entityManager.createNamedQuery("aluno.count")
                .getSingleResult();
    }
}