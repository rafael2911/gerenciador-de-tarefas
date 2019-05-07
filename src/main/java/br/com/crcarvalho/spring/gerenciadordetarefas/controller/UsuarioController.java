package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.UsuarioDao;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping("list")
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("usuario/lista");
		
		modelAndView.addObject("usuarios", usuarioDao.findAll());
		
		return modelAndView;
	}
	
}
