package br.com.crcarvalho.spring.gerenciadordetarefas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.crcarvalho.spring.gerenciadordetarefas.model.Status;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;

@Repository
public class TarefaDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Tarefa> findAll(){
		return manager.createQuery("from Tarefa t", Tarefa.class).getResultList();
	}
	
	@Transactional
	public Tarefa save(Tarefa tarefa) {
		tarefa.setDataAbertura(LocalDate.now());
		tarefa.setStatus(Status.ABERTO);
		
		manager.persist(tarefa);
		
		return tarefa;
	}
	
}
