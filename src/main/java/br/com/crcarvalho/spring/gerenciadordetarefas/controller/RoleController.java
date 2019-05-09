package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.RoleDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Role;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleDao roleDao;
	
	@GetMapping("form")
	public ModelAndView form(Role role) {
		return new ModelAndView("role/form");
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView cadastrar(Role role, RedirectAttributes attr) {
		ModelAndView modelAndView = new ModelAndView("redirect:/tarefa/");
		
		roleDao.save(role);
		attr.addFlashAttribute("message", "Role cadastrada com sucesso");
		
		return modelAndView;
	}
	
}
