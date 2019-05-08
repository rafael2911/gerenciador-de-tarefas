package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.RoleDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.dao.UsuarioDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Role;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@InitBinder("usuario")
	public void initBinder(WebDataBinder binder) throws Exception {
		// DataBinder para converter o select multiplo em uma lista de Roles
		CustomCollectionEditor rolesCollector = new CustomCollectionEditor(List.class) {
			@Override
            protected Object convertElement(Object element) {
				if (element instanceof String) {
					Role role = new Role();
					role.setNome((String) element);
					
					return role;
				}
				throw new RuntimeException("Spring says: Não sei o que fazer com esse elemento: " + element);
			}
		};
		
		binder.registerCustomEditor(List.class, "roles", rolesCollector);
	}
	
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
	@Transactional
	public ModelAndView cadastrar(Usuario usuario, RedirectAttributes attr) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuario/list");
		
		usuarioDao.save(usuario);
		
		attr.addFlashAttribute("message", "Usuário " + usuario.getEmail() + " cadastrado com sucesso.");
		
		return modelAndView;
	}
	
}
