package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.TarefaDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Status;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.TarefaBeanParam;
import br.com.crcarvalho.spring.gerenciadordetarefas.validator.TarefaValidador;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaDao tarefaDao;
	
	/* Registra o validador criado para a classe tarefa */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new TarefaValidador());
	}
	
	@GetMapping
	public ModelAndView listarTodas(TarefaBeanParam tarefaBeanParam) {
		
		ModelAndView modelAndView = new ModelAndView("tarefa/lista");
		
		List<Tarefa> tarefas = tarefaDao.findAll();
		
		modelAndView.addObject("tarefas", tarefas);
		modelAndView.addObject("status", Status.values());
		
		return modelAndView;
	}
	
	@GetMapping("busca")
	public ModelAndView buscaTarefas(TarefaBeanParam tarefaBeanParam) {
		ModelAndView modelAndView = new ModelAndView("tarefa/lista");
		
		System.out.println(tarefaBeanParam.getStatus());
		
		List<Tarefa> tarefas = tarefaDao.findByStatusOrAberturaOrEncerramento(tarefaBeanParam);
		
		modelAndView.addObject("tarefas", tarefas);
		modelAndView.addObject("status", Status.values());
		
		return modelAndView;
	}
	
	@GetMapping("form")
	public ModelAndView formCadastro(Tarefa tarefa) {
		ModelAndView modelAndView = new ModelAndView("tarefa/form");
		
		return modelAndView;
	}
	
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Tarefa tarefa, BindingResult result, RedirectAttributes attr) {
		
		/* verifica se validacao retorna erros */
		if(result.hasErrors()) {
			return formCadastro(tarefa);
		}
		
		
		ModelAndView modelAndView = new ModelAndView("redirect:/tarefa/");
		
		tarefaDao.save(tarefa);
		
		attr.addFlashAttribute("message", "Tarefa cadastrada com sucesso!");
		
		return modelAndView;
	}
	
	@GetMapping("concluir/{idTarefa}")
	public ModelAndView concluirTarefa(@PathVariable("idTarefa") Long idTarefa, RedirectAttributes attr) {
		ModelAndView modelAndView = new ModelAndView("redirect:/tarefa/");
		
		try {
			
			tarefaDao.alteraStatus(idTarefa, Status.CONCLUIDO);
			
			attr.addFlashAttribute("message", "Tarefa " + idTarefa + " Concluída conforme solicitado.");
			
		}catch (RuntimeException ex) {
			attr.addFlashAttribute("erro", ex.getMessage());
		}
			return modelAndView;
	}
	
	@GetMapping("encerrar/{idTarefa}")
	public ModelAndView encerrarTarefa(@PathVariable("idTarefa") Long idTarefa, RedirectAttributes attr) {
		ModelAndView modelAndView = new ModelAndView("redirect:/tarefa/");
		
		try {
			tarefaDao.alteraStatus(idTarefa, Status.ENCERRADO);
			
			attr.addFlashAttribute("message", "Tarefa " + idTarefa + " Encerrada conforme solicitado.");
		}catch (RuntimeException ex) {
			attr.addFlashAttribute("erro", ex.getMessage());
		}
		
		return modelAndView;
	}
	
}
