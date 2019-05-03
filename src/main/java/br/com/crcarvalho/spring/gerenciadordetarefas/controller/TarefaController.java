package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		List<Tarefa> tarefas = tarefaDao.findAll();
		
		modelAndView.addObject("tarefas", tarefas);
		
		return modelAndView;
	}
	
	@GetMapping("form")
	public ModelAndView formCadastro(Tarefa tarefa) {
		ModelAndView modelAndView = new ModelAndView("tarefa/form");
		
		return modelAndView;
	}
	
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(Tarefa tarefa, RedirectAttributes attr) {
		ModelAndView modelAndView = new ModelAndView("redirect:/tarefa/");
		
		tarefaDao.save(tarefa);
		
		attr.addFlashAttribute("message", "Tarefa cadastrada com sucesso!");
		
		return modelAndView;
	}
	
}
