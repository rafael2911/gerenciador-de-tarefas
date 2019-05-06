package br.com.crcarvalho.spring.gerenciadordetarefas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.TarefaDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Status;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.TarefaBeanParam;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Usuario;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaDao tarefaDao;
	
	public List<Tarefa> findAll(Usuario usuario){
		return tarefaDao.findAll(usuario);
	}
	
	public List<Tarefa> findByStatusOrDataAberturaOrDataEncerramento(Usuario usuario, TarefaBeanParam beanParam){
		if(beanParam.getStatus() != null) {
			return tarefaDao.findByStatus(usuario, beanParam.getStatus());
		}
		
		if(!beanParam.getTipoData().isEmpty() && beanParam.getTipoData().equals("dataAbertura")) {
			return findByDataAbertura(usuario, beanParam.getDtInicial(), beanParam.getDtFinal());
		}
		
		if(!beanParam.getTipoData().isEmpty() && beanParam.getTipoData().equals("dataEncerramento")) {
			return findByDataEncerramento(usuario, beanParam.getDtInicial(), beanParam.getDtFinal());
		}
		
		return tarefaDao.findAll(usuario);
	}
	
	public List<Tarefa> findByDataAbertura(Usuario usuario, LocalDate dataInicial, LocalDate dataFinal){
		if(dataFinal == null) {
			dataFinal = dataInicial;
		}
		
		return tarefaDao.findByDataAbertura(usuario, dataInicial, dataFinal);
	}
	
	public List<Tarefa> findByDataEncerramento(Usuario usuario, LocalDate dataInicial, LocalDate dataFinal){
		if(dataFinal == null) {
			dataFinal = dataInicial;
		}
		
		return tarefaDao.findByDataEncerramento(usuario, dataInicial, dataFinal);
	}

	public Tarefa save(Tarefa tarefa) {
		return tarefaDao.save(tarefa);
	}

	public Tarefa alteraStatus(Long idTarefa, Status status) {
		return tarefaDao.alteraStatus(idTarefa, status);
	}
	
}
