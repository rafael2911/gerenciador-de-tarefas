package br.com.crcarvalho.spring.gerenciadordetarefas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.crcarvalho.spring.gerenciadordetarefas.config.TarefaFinalizadaException;
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
	
	@Transactional
	public Tarefa alteraStatus(Long idTarefa, Status status) {
		try {
			Tarefa tarefa = manager.find(Tarefa.class, idTarefa);
			
			if(tarefa.getStatus() != Status.ABERTO) {
				throw new TarefaFinalizadaException("Tarefa já foi Encerrada/Concluída anteriormente.");
			}
			
			tarefa.setStatus(status);
			tarefa.setDataEncerramento(LocalDate.now());
			
			return tarefa;
		}catch (NullPointerException ex) {
			throw new RuntimeException("Tarefa não localizada para o id " + idTarefa);
		}
	}
	
}
