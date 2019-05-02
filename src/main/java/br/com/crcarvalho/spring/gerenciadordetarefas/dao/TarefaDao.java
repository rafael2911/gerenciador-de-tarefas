package br.com.crcarvalho.spring.gerenciadordetarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;

@Repository
public class TarefaDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Tarefa> findAll(){
		return manager.createQuery("from Tarefa t", Tarefa.class).getResultList();
	}
	
}
