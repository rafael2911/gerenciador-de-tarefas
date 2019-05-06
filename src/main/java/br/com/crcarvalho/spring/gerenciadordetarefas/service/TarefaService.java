package br.com.crcarvalho.spring.gerenciadordetarefas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.TarefaDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Status;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.TarefaBeanParam;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaDao tarefaDao;
	
	public List<Tarefa> findAll(){
		return tarefaDao.findAll();
	}
	
	public List<Tarefa> findByStatusOrDataAberturaOrDataEncerramento(TarefaBeanParam beanParam){
		if(beanParam.getStatus() != null) {
			return tarefaDao.findByStatus(beanParam.getStatus());
		}
		
		if(!beanParam.getTipoData().isEmpty() && beanParam.getTipoData().equals("dataAbertura")) {
			return findByDataAbertura(beanParam.getDtInicial(), beanParam.getDtFinal());
		}
		
		if(!beanParam.getTipoData().isEmpty() && beanParam.getTipoData().equals("dataEncerramento")) {
			return findByDataEncerramento(beanParam.getDtInicial(), beanParam.getDtFinal());
		}
		
		return tarefaDao.findAll();
	}
	
	public List<Tarefa> findByDataAbertura(LocalDate dataInicial, LocalDate dataFinal){
		if(dataFinal == null) {
			dataFinal = dataInicial;
		}
		
		return tarefaDao.findByDataAbertura(dataInicial, dataFinal);
	}
	
	public List<Tarefa> findByDataEncerramento(LocalDate dataInicial, LocalDate dataFinal){
		if(dataFinal == null) {
			dataFinal = dataInicial;
		}
		
		return tarefaDao.findByDataEncerramento(dataInicial, dataFinal);
	}

	public Tarefa save(Tarefa tarefa) {
		return tarefaDao.save(tarefa);
	}

	public Tarefa alteraStatus(Long idTarefa, Status status) {
		return tarefaDao.alteraStatus(idTarefa, status);
	}
	
}
