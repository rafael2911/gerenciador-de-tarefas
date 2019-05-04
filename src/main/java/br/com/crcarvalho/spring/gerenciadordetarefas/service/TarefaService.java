package br.com.crcarvalho.spring.gerenciadordetarefas.service;

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
			return tarefaDao.findByDataAbertura(beanParam.getDtInicial(), beanParam.getDtFinal());
		}
		
		if(!beanParam.getTipoData().isEmpty() && beanParam.getTipoData().equals("dataEncerramento")) {
			return tarefaDao.findByDataEncerramento(beanParam.getDtInicial(), beanParam.getDtFinal());
		}
		
		return tarefaDao.findAll();
	}

	public Tarefa save(Tarefa tarefa) {
		return tarefaDao.save(tarefa);
	}

	public Tarefa alteraStatus(Long idTarefa, Status status) {
		return tarefaDao.alteraStatus(idTarefa, status);
	}
	
}
