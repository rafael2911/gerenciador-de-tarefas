package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.RoleDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.dao.UsuarioDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@GetMapping("list")
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("usuario/lista");
		
		modelAndView.addObject("usuarios", usuarioDao.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/form");
		
		modelAndView.addObject("roles", roleDao.findAll());
		
		return modelAndView;
	}
	
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuario/list");
		
		System.out.println(usuario);
		
//		usuarioDao.save(usuario);
//		
//		attr.addFlashAttribute("message", "Usuário " + usuario.getEmail() + " cadastrado com sucesso.");
		
		return modelAndView;
	}
	
}
