package com.target.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.target.model.Professor;

public class ProfessorRepository {

	private EntityManager entityManager;
	 /*
	  * Recebe o objeto EntityManager
	  */
    public ProfessorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 /**
  * Salva um professor
  * @param Professor
  */
    public void save(Professor professor) {
    	this.entityManager.getTransaction().begin();
        this.entityManager.persist(professor);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
  
    /**
   * Busca um professor
   * @param codigo Id do Profressor
   * @return Objeto Professor
   */
    public Professor  busca(int codigo){
        return this.entityManager.find(Professor.class, codigo);
    }
    /**
     * Altera o Professor
     * @param professor
     */
    public void altera(Professor professor) {
    	this.entityManager.getTransaction().begin();
        this.entityManager.merge(professor);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    /**
     * Deleta um professor
     * @param professor
     */
    public void remove(Professor professor) {
       	this.entityManager.getTransaction().begin();
        this.entityManager.remove(professor);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
	 /**
	  * 
	  * @return lista dos professores.
	  */
    public List<Professor> getProfessores() {
        return this.entityManager.createNamedQuery("professor.list")
                .getResultList();
    }
    /**
     * 
     * @param salario
     * @return lista de professores com salario superio ao parametro
     */
    public List<Professor> getProfessores(int salario) {
          	return this.entityManager.createNamedQuery("professor.salario").setParameter("v", salario).getResultList();
    }
    /**
     * 
     * @return Total de professores
     */
    public Long getCountProfessores() {
        return (Long) this.entityManager.createNamedQuery("professor.count")
                .getSingleResult();
    }
}