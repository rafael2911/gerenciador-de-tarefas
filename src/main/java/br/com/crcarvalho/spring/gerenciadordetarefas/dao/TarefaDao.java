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
	
	public List<Tarefa> findByStatus(Status status){
		return manager.createQuery("from Tarefa t where t.status = :status", Tarefa.class)
					.setParameter("status", status)
					.getResultList();
	}
	
	public List<Tarefa> findByDataAbertura(LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("from Tarefa t where t.dataAbertura between :dataInicial and :dataFinal", Tarefa.class)
					.setParameter("dataInicial", dataInicial)
					.setParameter("dataFinal", dataFinal)
					.getResultList();
	}
	
	public List<Tarefa> findByDataEncerramento(LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("from Tarefa t where t.dataEncerramento between :dataInicial and :dataFinal", Tarefa.class)
					.setParameter("dataInicial", dataInicial)
					.setParameter("dataFinal", dataFinal)
					.getResultList();
	}
	
	public List<Tarefa> findByStatusAndDataAbertura(Status status, LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("from Tarefa t where t.status = :status and (t.dataAbertura between :dataInicial and :dataFinal)", Tarefa.class)
					.setParameter("status", status)
					.setParameter("dataInicial", dataInicial)
					.setParameter("dataFinal", dataFinal)
					.getResultList();
	}
	
	public List<Tarefa> findByStatusAndDataEncerramento(Status status, LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("from Tarefa t where t.status = :status and (t.dataEncerramento between :dataInicial and :dataFinal)", Tarefa.class)
					.setParameter("status", status)
					.setParameter("dataInicial", dataInicial)
					.setParameter("dataFinal", dataFinal)
					.getResultList();
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
