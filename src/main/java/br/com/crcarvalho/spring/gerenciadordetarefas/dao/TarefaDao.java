package br.com.crcarvalho.spring.gerenciadordetarefas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.crcarvalho.spring.gerenciadordetarefas.config.TarefaFinalizadaException;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Status;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Usuario;

@Repository
public class TarefaDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Tarefa> findAll(Usuario usuario){
		return manager.createQuery("from Tarefa t join fetch t.usuario u where u.email = :email", Tarefa.class)
				.setParameter("email", usuario.getEmail())
				.getResultList();
	}
	
	public List<Tarefa> findByStatus(Usuario usuario, Status status){
		return manager.createQuery("from Tarefa t join fetch t.usuario u where u.email = :email and t.status = :status", Tarefa.class)
					.setParameter("email", usuario.getEmail())
					.setParameter("status", status)
					.getResultList();
	}
	
	public List<Tarefa> findByDataAbertura(Usuario usuario, LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("select t from Tarefa t join fetch t.usuario u where u.email = :email and t.dataAbertura between :dataInicial and :dataFinal", Tarefa.class)
					.setParameter("email", usuario.getEmail())
					.setParameter("dataInicial", dataInicial)
					.setParameter("dataFinal", dataFinal)
					.getResultList();
	}
	
	public List<Tarefa> findByDataEncerramento(Usuario usuario, LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("from Tarefa t join fetch t.usuario u where u.email = :email and t.dataEncerramento between :dataInicial and :dataFinal", Tarefa.class)
					.setParameter("email", usuario.getEmail())
					.setParameter("dataInicial", dataInicial)
					.setParameter("dataFinal", dataFinal)
					.getResultList();
	}
	
	public List<Tarefa> findByStatusAndDataAbertura(Usuario usuario, Status status, LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("from Tarefa t join fetch t.usuario u where u.email = :email and t.status = :status and (t.dataAbertura between :dataInicial and :dataFinal)", Tarefa.class)
					.setParameter("email", usuario.getEmail())
					.setParameter("status", status)
					.setParameter("dataInicial", dataInicial)
					.setParameter("dataFinal", dataFinal)
					.getResultList();
	}
	
	public List<Tarefa> findByStatusAndDataEncerramento(Usuario usuario, Status status, LocalDate dataInicial, LocalDate dataFinal){
		return manager.createQuery("from Tarefa t join fetch t.usuario u where u.email = :email and t.status = :status and (t.dataEncerramento between :dataInicial and :dataFinal)", Tarefa.class)
					.setParameter("email", usuario.getEmail())
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
	public Tarefa alteraStatus(Usuario usuario, Long idTarefa, Status status) {
		try {
			Tarefa tarefa = findById(idTarefa);
			
			if(!tarefa.getUsuario().getEmail().equals(usuario.getEmail())) {
				throw new AccessDeniedException("O usuario não tem permissão para encerrar/concluir essa tarefa.");
			}
			
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

	public Tarefa findById(Long idTarefa) {
		
		return manager.find(Tarefa.class, idTarefa);
	}
	
}
