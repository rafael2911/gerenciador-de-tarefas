package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.TarefaDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaDao tarefaDao;
	
	@GetMapping
	public ModelAndView listarTodas() {
		ModelAndView modelAndView = new ModelAndView("tarefa/lista");
		
		System.out.println(tarefaDao.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("form")
	public ModelAndView formCadastro(Tarefa tarefa) {
		ModelAndView modelAndView = new ModelAndView("tarefa/form");
		
		return modelAndView;
	}
	
}
